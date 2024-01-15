package com.github.gsalesc.apialuguelcarros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiAluguelCarrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAluguelCarrosApplication.class, args);
	}

}
