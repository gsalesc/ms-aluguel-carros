package com.github.gsalesc.emailsender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.github.gsalesc.emailsender.model.aluguel.Aluguel;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("${email.url}")
	private String emailUrl;
	
	@Value("${email.senha}")
	private String emailSenha;
	
	public void enviarEmail(Aluguel aluguel) {
		
		SimpleMailMessage mensagem = new SimpleMailMessage();
		mensagem.setFrom(emailUrl);
		mensagem.setTo(aluguel.getCliente().getEmail());
		mensagem.setSubject("Aluguel confirmado");
		
		String text = "Aluguel do carro " + aluguel.getCarro().getNome() + " confirmada com sucesso";
		
		mensagem.setText(text);
		
		sender.send(mensagem);
	}
}
