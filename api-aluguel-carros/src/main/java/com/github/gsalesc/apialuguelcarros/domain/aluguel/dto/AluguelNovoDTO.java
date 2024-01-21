package com.github.gsalesc.apialuguelcarros.domain.aluguel.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.Aluguel;
import com.github.gsalesc.apialuguelcarros.domain.cliente.Cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AluguelNovoDTO(
		 @NotNull
		 Long carroId,
		 
		 @NotNull
		 Cliente cliente,
		 
		 @NotNull
		 @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
		 LocalDateTime dataInicio,
		 
		 @NotNull
		 @Positive
		 double precoDia,
		 
		 @NotNull
		 @Positive
		 double qtdDias) 
{}
