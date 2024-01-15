package com.github.gsalesc.apialuguelcarros.repository.aluguel;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.gsalesc.apialuguelcarros.domain.aluguel.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Long>{

}
