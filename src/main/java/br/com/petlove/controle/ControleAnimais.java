package br.com.petlove.controle;

import br.com.petlove.modelo.Animal;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.petlove.dao.daoAnimais;
import br.com.petlove.dao.daoUsuarios;
import br.com.petlove.modelo.Usuario;
import br.com.petlove.repositorio.UsuarioRepositorio;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ControleAnimais {
	UsuarioRepositorio repositorio;

	@GetMapping("/animais")
	public List<Animal> getTodosAnimais() throws ClassNotFoundException, SQLException {
		daoAnimais dao = new daoAnimais();

		return dao.listarAnimais();

	}

	@GetMapping("/animais/{id}")
	public Usuario getAnimal(@PathVariable Integer id) {
		return repositorio.getById(id);
	}

	@PostMapping("/animais")
	public boolean adicionarAnimais(@RequestBody Animal animal) throws ClassNotFoundException, SQLException {
		daoAnimais dao = new daoAnimais();

		return dao.AdicionarAnimais(animal);
	}

	@PutMapping("/animais/{id}")
	public boolean updateAnimal(@PathVariable Integer id, @RequestBody Animal animal)
			throws ClassNotFoundException, SQLException {
		daoAnimais dao = new daoAnimais();
		return dao.updateAnimal(animal);
	}
}
