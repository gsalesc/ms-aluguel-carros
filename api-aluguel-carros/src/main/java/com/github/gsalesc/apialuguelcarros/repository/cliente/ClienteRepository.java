package com.github.gsalesc.apialuguelcarros.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.gsalesc.apialuguelcarros.domain.cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Cliente findByCpf(String cpf);
}
