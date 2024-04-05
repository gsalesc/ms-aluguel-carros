package com.github.gsalesc.apialuguelcarros.service.aluguel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.gsalesc.apialuguelcarros.domain.aluguel.Aluguel;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelAtualizarDTO;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelNovoDTO;
import com.github.gsalesc.apialuguelcarros.domain.carro.Carro;
import com.github.gsalesc.apialuguelcarros.domain.carro.SituacaoCarro;
import com.github.gsalesc.apialuguelcarros.domain.cliente.Cliente;
import com.github.gsalesc.apialuguelcarros.infra.exception.ValidacaoException;
import com.github.gsalesc.apialuguelcarros.infra.proxy.EmailProxy;
import com.github.gsalesc.apialuguelcarros.repository.aluguel.AluguelRepository;
import com.github.gsalesc.apialuguelcarros.repository.carro.CarroRepository;
import com.github.gsalesc.apialuguelcarros.repository.cliente.ClienteRepository;
import com.github.gsalesc.apialuguelcarros.service.aluguel.validations.ValidarAluguel;

@Service
public class AluguelService {
	
	private AluguelRepository aluguelRepository;
	private CarroRepository carroRepository;
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EmailProxy emailProxy;
	
	@Autowired
	private List<ValidarAluguel> validarAluguel;
	
	public AluguelService(AluguelRepository aluguelRepository,
							CarroRepository carroRepository,
							ClienteRepository clienteRepository) {
		this.aluguelRepository = aluguelRepository;
		this.carroRepository = carroRepository;
		this.clienteRepository = clienteRepository;
	}
	
	public Aluguel inserir(AluguelNovoDTO dto) {
		
		validarAluguel.forEach(v -> v.validarAluguel(dto));
		
		Carro carro = carroRepository.findById(dto.carroId()).get();	
		
		Cliente cliente = this.clienteAluguel(dto);
		
		Aluguel novo = new Aluguel(dto);
		carro.setSituacao(SituacaoCarro.ALUGADO);
		novo.setCarro(carro);
		novo.setCliente(cliente);
		novo.setPrecoTotal(novo.getQtdDias()*novo.getPrecoDia());
		
		Aluguel saved = this.aluguelRepository.save(novo);
		
		emailProxy.enviarEmail(saved);
		
		return saved;
	}
	
	public List<Aluguel> listar(){
		return aluguelRepository.findAll();
	}
	
	public List<Aluguel> listarAlugueisPorCliente(String cpf){
		
		Cliente cliente = clienteRepository.findByCpf(cpf)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
			
		return aluguelRepository.findByCliente(cliente);
	}
	
	
	public Aluguel atualizarAluguel(Long id, AluguelAtualizarDTO dto) {
		
		Carro carro = carroRepository.findById(dto.carroId())
				.orElseThrow(() -> new RuntimeException("Carro não encontrado"));	
		
		Cliente cliente = clienteRepository.findByCpf(dto.cliente().getCpf())
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
		
		Aluguel aluguel = aluguelRepository.findById(id)
				.orElseThrow(() -> new ValidacaoException("Aluguel não encontrado"));
		
		carro.setSituacao(SituacaoCarro.ALUGADO);
		aluguel.setCarro(carro);
		aluguel.setCliente(cliente);
		aluguel.setPrecoTotal(aluguel.getQtdDias()*aluguel.getPrecoDia());
		
		return aluguelRepository.save(aluguel);
	}
	
	public void deletar(Aluguel aluguel) {
		aluguelRepository.delete(aluguel);
	}
	
	private Cliente clienteAluguel(AluguelNovoDTO dto) {
		Optional<Cliente> opCliente = clienteRepository.findByCpf(dto.cliente().getCpf());
		
		if(opCliente.isPresent()) {
			return opCliente.get();
		}
		
		Cliente novoCliente = new Cliente();
		novoCliente.setNome(dto.cliente().getNome());
		novoCliente.setEmail(dto.cliente().getEmail());
		novoCliente.setCpf(dto.cliente().getCpf());
		novoCliente.setDataNascimento(dto.cliente().getDataNascimento());
		
		return clienteRepository.save(novoCliente);
	}
}
