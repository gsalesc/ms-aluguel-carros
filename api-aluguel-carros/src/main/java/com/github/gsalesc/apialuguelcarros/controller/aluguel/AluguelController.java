package com.github.gsalesc.apialuguelcarros.controller.aluguel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gsalesc.apialuguelcarros.domain.aluguel.Aluguel;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelNovoDTO;
import com.github.gsalesc.apialuguelcarros.service.aluguel.AluguelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/aluguel")
public class AluguelController {
	
	@Autowired
	private AluguelService aluguelService;
	
	@PostMapping
	public ResponseEntity<Aluguel> novo(@Valid @RequestBody AluguelNovoDTO dto){
		Aluguel novo = aluguelService.inserir(dto);
		return ResponseEntity.ok(novo);
	}
}
