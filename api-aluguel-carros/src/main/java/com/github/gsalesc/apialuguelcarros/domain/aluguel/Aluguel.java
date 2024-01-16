package com.github.gsalesc.apialuguelcarros.domain.aluguel;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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

@Entity(name = "aluguel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Aluguel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Carro carro;

	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataInicio;
	private double precoDia;
	private double qtdDias;
	private double precoTotal;
	
	@Column(name = "situacao_aluguel")
	private SituacaoAluguel situacao;
	
	public Aluguel(AluguelNovoDTO dto) {
		this.cliente = new Cliente();
		this.dataInicio = dto.dataInicio();
		this.precoDia = dto.precoDia();
		this.qtdDias = dto.qtdDias();
		this.situacao = SituacaoAluguel.AGENDADO;
	}
}
