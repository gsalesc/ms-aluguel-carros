package com.github.gsalesc.emailsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gsalesc.emailsender.model.aluguel.Aluguel;
import com.github.gsalesc.emailsender.service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	@PostMapping
	public ResponseEntity<String> enviarEmail(@RequestBody Aluguel aluguel){
		emailService.enviarEmail(aluguel);
		return ResponseEntity.ok().build();
	}
}
