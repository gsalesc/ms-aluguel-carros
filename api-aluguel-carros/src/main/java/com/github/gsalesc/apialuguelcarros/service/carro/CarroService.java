package com.github.gsalesc.apialuguelcarros.service.carro;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.gsalesc.apialuguelcarros.domain.carro.Carro;
import com.github.gsalesc.apialuguelcarros.repository.carro.CarroRepository;


@Service
public class CarroService {
	
	private CarroRepository carroRepository;
	
	public CarroService(CarroRepository carroRepository) {
		this.carroRepository = carroRepository;
	}
	
	
	public List<Carro> listarCarros(){
		return carroRepository.findAll();
	}
	
}
