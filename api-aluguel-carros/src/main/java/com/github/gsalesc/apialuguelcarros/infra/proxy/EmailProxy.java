package com.github.gsalesc.apialuguelcarros.infra.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.gsalesc.apialuguelcarros.domain.aluguel.Aluguel;

@FeignClient(name="email-sender", url="localhost:8200")
public interface EmailProxy {
	
	@PostMapping("/api/email")
	void enviarEmail(@RequestBody Aluguel aluguel);
}
