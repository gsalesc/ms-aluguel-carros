package com.github.gsalesc.apialuguelcarros.service.aluguel.validations.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.gsalesc.apialuguelcarros.domain.aluguel.Aluguel;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.SituacaoAluguel;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelNovoDTO;
import com.github.gsalesc.apialuguelcarros.domain.cliente.Cliente;
import com.github.gsalesc.apialuguelcarros.repository.aluguel.AluguelRepository;
import com.github.gsalesc.apialuguelcarros.repository.cliente.ClienteRepository;
import com.github.gsalesc.apialuguelcarros.service.aluguel.validations.ValidarAluguel;


@Component
public class ValidarSeClienteJaEstaComCarroAlugado implements ValidarAluguel{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private AluguelRepository aluguelRepository;
	
	@Override
	public void validarAluguel(AluguelNovoDTO dto) {
		Cliente clienteBanco = clienteRepository.findByCpf(dto.cliente().getCpf())
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
		
		if(clienteBanco != null) {
			Aluguel aluguelAgendado = aluguelRepository.findByClienteAndSituacao(clienteBanco
					, SituacaoAluguel.AGENDADO);
			
			Aluguel aluguelEmAndamento = aluguelRepository.findByClienteAndSituacao(clienteBanco
					, SituacaoAluguel.EM_ANDAMENTO);
			
			if(aluguelAgendado != null || aluguelEmAndamento != null) {
				throw new RuntimeException("Cliente já possui carro alugado");
			}
		}
	}
}
