package com.github.gsalesc.apialuguelcarros.service.aluguel;

import org.springframework.stereotype.Service;

import com.github.gsalesc.apialuguelcarros.domain.aluguel.Aluguel;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelNovoDTO;
import com.github.gsalesc.apialuguelcarros.domain.carro.Carro;
import com.github.gsalesc.apialuguelcarros.domain.carro.Situacao;
import com.github.gsalesc.apialuguelcarros.domain.cliente.Cliente;
import com.github.gsalesc.apialuguelcarros.repository.aluguel.AluguelRepository;
import com.github.gsalesc.apialuguelcarros.repository.carro.CarroRepository;
import com.github.gsalesc.apialuguelcarros.repository.cliente.ClienteRepository;


@Service
public class AluguelService {
	
	private AluguelRepository aluguelRepository;
	private CarroRepository carroRepository;
	private ClienteRepository clienteRepository;
	
	public AluguelService(AluguelRepository aluguelRepository,
							CarroRepository carroRepository,
							ClienteRepository clienteRepository) {
		this.aluguelRepository = aluguelRepository;
		this.carroRepository = carroRepository;
		this.clienteRepository = clienteRepository;
	}
	
	
	public Aluguel inserir(AluguelNovoDTO dto) {
		
		Carro carro = carroRepository.findById(dto.carroId())
					.orElseThrow(() -> new RuntimeException("Carro não encontrado"));	
		
		Aluguel novo = new Aluguel(dto);
		carro.setSituacao(Situacao.ALUGADO);
		novo.setCarro(carro);
		novo.setCliente(clienteRepository.save(dto.cliente()));
		novo.setPrecoTotal(novo.getQtdDias()*novo.getPrecoDia());
		
		return this.aluguelRepository.save(novo);
	}
}
