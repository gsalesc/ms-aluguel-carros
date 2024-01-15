package com.github.gsalesc.apialuguelcarros.domain.aluguel.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.gsalesc.apialuguelcarros.domain.cliente.Cliente;

public record AluguelNovoDTO(
		 Long carroId,
		 Cliente cliente,
		 @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
		 LocalDateTime dataInicio,
		 double precoDia,
		 double qtdDias) 
{}
