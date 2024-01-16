package com.github.gsalesc.apialuguelcarros.service.aluguel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.gsalesc.apialuguelcarros.domain.aluguel.Aluguel;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelNovoDTO;
import com.github.gsalesc.apialuguelcarros.domain.carro.Carro;
import com.github.gsalesc.apialuguelcarros.domain.carro.Situacao;
import com.github.gsalesc.apialuguelcarros.domain.cliente.Cliente;
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
		
		Carro carro = carroRepository.findById(dto.carroId())
					.orElseThrow(() -> new RuntimeException("Carro não encontrado"));	
		
		Cliente cliente = clienteRepository.findByCpf(dto.cliente().getCpf());
		
		if(cliente == null) {
			cliente = clienteRepository.save(dto.cliente());
		}
		
		Aluguel novo = new Aluguel(dto);
		carro.setSituacao(Situacao.ALUGADO);
		novo.setCarro(carro);
		novo.setCliente(cliente);
		novo.setPrecoTotal(novo.getQtdDias()*novo.getPrecoDia());
		
		Aluguel saved = this.aluguelRepository.save(novo);
		
		emailProxy.enviarEmail(saved);
		
		return saved;
	}
}
