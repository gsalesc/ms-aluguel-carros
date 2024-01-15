package com.github.gsalesc.emailsender.model.carro;

import java.time.LocalDate;

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
public class Carro {
	private Long id;
	private String nome;
	private String marca;
	private String placa;
	private Situacao situacao;
}
