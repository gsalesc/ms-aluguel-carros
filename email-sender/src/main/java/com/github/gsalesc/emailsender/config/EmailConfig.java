package com.github.gsalesc.emailsender.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {
	
	@Value("${email.url}")
	private String emailUrl;
	
	@Value("${email.senha}")
	private String emailSenha;
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mail = new JavaMailSenderImpl();
		mail.setHost("smtp.gmail.com");
		mail.setPort(587);
		
		mail.setUsername(emailUrl);
		mail.setPassword(emailSenha);
		
		Properties props =  mail.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
		
		return mail;
	}
}
