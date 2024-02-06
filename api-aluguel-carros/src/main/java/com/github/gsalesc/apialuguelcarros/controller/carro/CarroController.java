package com.github.gsalesc.apialuguelcarros.controller.carro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gsalesc.apialuguelcarros.domain.carro.dto.CarroListarDTO;
import com.github.gsalesc.apialuguelcarros.service.carro.CarroService;

@RestController
@RequestMapping("/carros")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	public List<CarroListarDTO> listar(){
		return carroService.listarCarros().stream().map(CarroListarDTO::new).toList();
	}
}
