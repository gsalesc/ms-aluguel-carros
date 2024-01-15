package com.github.gsalesc.emailsender.model.aluguel;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.gsalesc.emailsender.model.carro.Carro;
import com.github.gsalesc.emailsender.model.cliente.Cliente;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Aluguel{
	private Long id;
	private Carro carro;
	private Cliente cliente;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataInicio;
	private double precoDia;
	private double qtdDias;
	private double precoTotal;
	
}
