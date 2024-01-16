package com.github.gsalesc.apialuguelcarros.service.aluguel.validations.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelNovoDTO;
import com.github.gsalesc.apialuguelcarros.service.aluguel.validations.ValidarAluguel;


@Component
public class ValidarSeADataDoAluguelEhAnteriorDaAtual implements ValidarAluguel {

	@Override
	public void validarAluguel(AluguelNovoDTO dto) {
		LocalDateTime atual = LocalDateTime.now();
		
		if(dto.dataInicio().isBefore(atual)) {
			throw new RuntimeException("A data do aluguel não pode ser anterior a atual");
		}
	}

}
