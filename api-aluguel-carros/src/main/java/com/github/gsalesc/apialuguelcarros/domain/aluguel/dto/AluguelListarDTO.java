package com.github.gsalesc.apialuguelcarros.domain.aluguel.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.Aluguel;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.SituacaoAluguel;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelNovoDTO;
import com.github.gsalesc.apialuguelcarros.domain.carro.Carro;
import com.github.gsalesc.apialuguelcarros.domain.cliente.Cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class AluguelListarDTO {
	 private Long id;
	 private Carro carro;
	 private Cliente cliente;
	 private LocalDateTime dataInicio;
	 private double precoDia;
	 private double qtdDias;
	 private double precoTotal;

	public AluguelListarDTO(Aluguel novo) {
		this.id = novo.getId();
		this.carro = novo.getCarro();
		this.cliente = novo.getCliente();
		this.dataInicio = novo.getDataInicio();
		this.precoDia = novo.getPrecoDia();
		this.qtdDias = novo.getQtdDias();
		this.precoTotal = novo.getPrecoTotal();
	}
}
