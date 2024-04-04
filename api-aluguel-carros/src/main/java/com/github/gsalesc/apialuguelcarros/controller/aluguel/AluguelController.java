package com.github.gsalesc.apialuguelcarros.controller.aluguel;

import java.net.URI;
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
import org.springframework.web.util.UriComponentsBuilder;

import com.github.gsalesc.apialuguelcarros.domain.aluguel.Aluguel;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelAtualizarDTO;
import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelIdDTO;
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
	public ResponseEntity<AluguelIdDTO> novo(@Valid @RequestBody AluguelNovoDTO dto,
						UriComponentsBuilder uriComponentsBuiler){
		Aluguel novo = aluguelService.inserir(dto);
		
		URI uri = uriComponentsBuiler.path("/api/aluguel/{id}").buildAndExpand(novo.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new AluguelIdDTO(novo.getId()));
	}
	
	@GetMapping("/{cpf}")
	public ResponseEntity<List<AluguelListarDTO>> listarCliente(@PathVariable String cpf){
		
		List<AluguelListarDTO> listaDeAlugueisPorCliente = aluguelService.listarAlugueisPorCliente(cpf).stream().map(AluguelListarDTO::new)
				.toList();
		
		return ResponseEntity.ok(listaDeAlugueisPorCliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AluguelListarDTO> atualizar(@PathVariable Long id, AluguelAtualizarDTO dto){
		Aluguel atualizado  = aluguelService.atualizarAluguel(id, dto);
		return ResponseEntity.ok(new AluguelListarDTO(atualizado));
	}
}
