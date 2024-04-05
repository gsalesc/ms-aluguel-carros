package com.github.gsalesc.apialuguelcarros.domain.carro.dto;

import com.github.gsalesc.apialuguelcarros.domain.carro.Carro;
import com.github.gsalesc.apialuguelcarros.domain.carro.SituacaoCarro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarroListarClienteDTO {
	private String nome;
	private String marca;
	private String placa;
	private SituacaoCarro situacao;
	
	public CarroListarClienteDTO(Carro carro){
		this.nome = carro.getNome();
		this.marca = carro.getMarca();
		this.placa = carro.getPlaca();
		this.situacao = carro.getSituacao();
	}
}
