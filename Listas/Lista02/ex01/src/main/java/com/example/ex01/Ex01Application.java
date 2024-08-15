package com.example.ex01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/app")
public class Ex01Application {

	private static List<IlhaDeCalor> ilhasLista = new ArrayList<>();

	@GetMapping("/ilhas-de-calor")
	public List<IlhaDeCalor> listarIlhasDeCalor() {
		return ilhasLista;
	}

	@PostMapping("/ilhas-de-calor")
	public String adicionarIlhaDeCalor(@RequestBody IlhaDeCalor ilha) {
		for(IlhaDeCalor ilhaAdicionada : ilhasLista) {
			if(ilha.getId() == ilhaAdicionada.getId()) {
				return "Ilha já existe";
			}
		}
		ilhasLista.add(ilha);
		return "Ilha de calor " + ilha.getBairro() + " adicionada com sucesso!";
	}

	public static void main(String[] args) {
		SpringApplication.run(Ex01Application.class, args);
	}

}
