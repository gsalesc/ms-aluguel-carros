package com.github.gsalesc.apialuguelcarros.service.aluguel.validations.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelNovoDTO;
import com.github.gsalesc.apialuguelcarros.domain.cliente.Cliente;
import com.github.gsalesc.apialuguelcarros.repository.cliente.ClienteRepository;
import com.github.gsalesc.apialuguelcarros.service.aluguel.validations.ValidarAluguel;

@Component
public class ValidarSeOClienteExiste implements ValidarAluguel{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void validarAluguel(AluguelNovoDTO dto) {
		Cliente cliente = clienteRepository.findByCpf(dto.cliente().getCpf())
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
		
		if(cliente == null) {
			cliente = clienteRepository.save(dto.cliente());
		}		
	}

}
