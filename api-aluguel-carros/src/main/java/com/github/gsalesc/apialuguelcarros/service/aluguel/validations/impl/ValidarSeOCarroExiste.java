package com.github.gsalesc.apialuguelcarros.service.aluguel.validations.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelNovoDTO;
import com.github.gsalesc.apialuguelcarros.repository.carro.CarroRepository;
import com.github.gsalesc.apialuguelcarros.service.aluguel.validations.ValidarAluguel;

@Component
public class ValidarSeOCarroExiste implements ValidarAluguel {

	@Autowired
	private CarroRepository carroRepository;
	
	@Override
	public void validarAluguel(AluguelNovoDTO dto) {
		carroRepository.findById(dto.carroId())
				.orElseThrow(() -> new RuntimeException("Carro não encontrado"));	
	}

}
