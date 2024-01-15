package com.github.gsalesc.apialuguelcarros.repository.carro;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.gsalesc.apialuguelcarros.domain.carro.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{

}
