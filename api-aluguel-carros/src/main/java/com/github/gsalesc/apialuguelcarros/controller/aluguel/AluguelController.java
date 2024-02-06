package com.github.gsalesc.apialuguelcarros.controller.aluguel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gsalesc.apialuguelcarros.domain.aluguel.Aluguel;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelAtualizarDTO;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelListarDTO;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelNovoDTO;
import com.github.gsalesc.apialuguelcarros.service.aluguel.AluguelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/aluguel")
public class AluguelController {
	
	@Autowired
	private AluguelService aluguelService;
	
	@PostMapping
	public ResponseEntity<AluguelListarDTO> novo(@Valid @RequestBody AluguelNovoDTO dto){
		Aluguel novo = aluguelService.inserir(dto);
		return ResponseEntity.ok(new AluguelListarDTO(novo));
	}
	
	@GetMapping("/{cpf}")
	public List<AluguelListarDTO> listarCliente(@PathVariable String cpf){
		return aluguelService.listarAlugueisPorCliente(cpf).stream().map(AluguelListarDTO::new)
					.toList();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AluguelListarDTO> atualizar(@PathVariable Long id, AluguelAtualizarDTO dto){
		Aluguel atualizado  = aluguelService.atualizarAluguel(id, dto);
		return ResponseEntity.ok(new AluguelListarDTO(atualizado));
	}
}
