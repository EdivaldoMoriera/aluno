package com.moreira.aluno;

import java.util.Arrays;

import com.moreira.aluno.entity.Aluno;
import com.moreira.aluno.repository.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlunoApplication implements CommandLineRunner {
	@Autowired
	private AlunoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AlunoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Aluno aluno = new Aluno(null, "Pedro Marques", "pedro@gmail.com", "737.305.152-10", "Passagem uniao N° 10");
		Aluno aluno2 = new Aluno(null, "Marcos Perreira", "perreira@gmail.com", "100.120.546-20", " Rua do fio N° 1450");
		Aluno aluno3 = new Aluno(null, "Pedro Andrew Moreira", "andrew@gmail.com", "100.986.659-50", "Rua D casa N° 53");
		Aluno aluno4 = new Aluno(null, "Ezequiel Moreira", "ezequil.moreira@gmail.com", "200.321.325-80", "Passagem uniao N° 250");
		repository.saveAll(Arrays.asList(aluno, aluno2, aluno3, aluno4));
		
		
	}

}
