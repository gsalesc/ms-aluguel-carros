package com.github.gsalesc.apialuguelcarros.controller.carro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gsalesc.apialuguelcarros.domain.carro.dto.CarroListarDTO;
import com.github.gsalesc.apialuguelcarros.service.carro.CarroService;

@RestController
@RequestMapping("/api/carros")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@GetMapping
	public ResponseEntity<List<CarroListarDTO>> listar(){
		return ResponseEntity.ok().body(carroService.listarCarros().stream().map(CarroListarDTO::new).toList());
	}
}
