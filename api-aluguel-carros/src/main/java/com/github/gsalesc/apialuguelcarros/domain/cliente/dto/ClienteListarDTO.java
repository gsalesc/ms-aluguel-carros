package com.github.gsalesc.apialuguelcarros.domain.cliente.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.gsalesc.apialuguelcarros.domain.cliente.Cliente;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteListarDTO {
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private String email;
	
	public ClienteListarDTO(Cliente cliente){
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.dataNascimento = cliente.getDataNascimento();
		this.email = cliente.getEmail();
	}
}
