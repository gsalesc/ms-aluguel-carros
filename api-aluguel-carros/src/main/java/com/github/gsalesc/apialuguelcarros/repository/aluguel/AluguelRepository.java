package com.github.gsalesc.apialuguelcarros.repository.aluguel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.gsalesc.apialuguelcarros.domain.aluguel.Aluguel;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.SituacaoAluguel;
import com.github.gsalesc.apialuguelcarros.domain.cliente.Cliente;

public interface AluguelRepository extends JpaRepository<Aluguel, Long>{
	Aluguel findByClienteAndSituacao(Cliente cliente, SituacaoAluguel situacao);
	List<Aluguel> findByCliente(Cliente cliente);
}
