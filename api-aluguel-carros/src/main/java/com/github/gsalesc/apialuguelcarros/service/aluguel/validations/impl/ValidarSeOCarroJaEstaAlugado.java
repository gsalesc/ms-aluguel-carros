package com.github.gsalesc.apialuguelcarros.service.aluguel.validations.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelNovoDTO;
import com.github.gsalesc.apialuguelcarros.domain.carro.Carro;
import com.github.gsalesc.apialuguelcarros.domain.carro.SituacaoCarro;
import com.github.gsalesc.apialuguelcarros.repository.carro.CarroRepository;
import com.github.gsalesc.apialuguelcarros.service.aluguel.validations.ValidarAluguel;

@Component
public class ValidarSeOCarroJaEstaAlugado implements ValidarAluguel{

	@Autowired
	private CarroRepository carroRepository;

	@Override
	public void validarAluguel(AluguelNovoDTO dto) {
		Carro carro = carroRepository.findById(dto.carroId()).get();
		
		if(carro != null && (carro.getSituacao() == SituacaoCarro.ALUGADO)) {
			throw new RuntimeException("O carro já se encontra alugado");
		}
	}

}
