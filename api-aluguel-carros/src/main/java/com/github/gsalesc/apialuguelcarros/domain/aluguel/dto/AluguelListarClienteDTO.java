package com.github.gsalesc.apialuguelcarros.domain.aluguel.dto;

import java.time.LocalDateTime;

import com.github.gsalesc.apialuguelcarros.domain.aluguel.Aluguel;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.SituacaoAluguel;
import com.github.gsalesc.apialuguelcarros.domain.carro.dto.CarroListarClienteDTO;
import com.github.gsalesc.apialuguelcarros.domain.cliente.Cliente;
import com.github.gsalesc.apialuguelcarros.domain.cliente.dto.ClienteListarDTO;

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
public class AluguelListarClienteDTO {
	 private CarroListarClienteDTO carro;
	 private ClienteListarDTO cliente;
	 private LocalDateTime dataInicio;
	 private double precoDia;
	 private double qtdDias;
	 private double precoTotal;
	 private SituacaoAluguel situacao;

	public AluguelListarClienteDTO(Aluguel novo) {
		this.carro = new CarroListarClienteDTO(novo.getCarro());
		this.cliente = new ClienteListarDTO(novo.getCliente());
		this.dataInicio = novo.getDataInicio();
		this.precoDia = novo.getPrecoDia();
		this.qtdDias = novo.getQtdDias();
		this.precoTotal = novo.getPrecoTotal();
		this.situacao = novo.getSituacao();
	}
}
