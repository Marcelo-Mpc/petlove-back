package br.com.petlove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.petlove.modelo.Usuario;
import br.com.petlove.repositorio.UsuarioRepositorio;

@SpringBootApplication
public class Petlove2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Petlove2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}
