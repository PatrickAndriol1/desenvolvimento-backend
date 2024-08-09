package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping("/app")
public class Ex02Application {

	@GetMapping("/{km}")
	public String converterValor(@PathVariable("km") String km) {
		double quilometros = Double.parseDouble(km);
		double valor = quilometros*25;
		return String.format("O preco final de sua expedicao eh: %s pratas", valor);
	}

	public static void main(String[] args) {
		SpringApplication.run(Ex02Application.class, args);
	}

}
