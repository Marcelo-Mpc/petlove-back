package br.com.petlove.controle;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.PostUpdate;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.petlove.dao.daoUsuarios;
import br.com.petlove.modelo.Usuario;
import br.com.petlove.repositorio.UsuarioRepositorio;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ControleUsuarios {
	UsuarioRepositorio repositorio;
	
	@GetMapping("/usuarios")
	public List<Usuario> getTodosUsuarios() throws ClassNotFoundException, SQLException{
		daoUsuarios dao = new daoUsuarios();

		
		return dao.listarUsuarios();
		
	}
	
	@GetMapping("/usuarios/{email}")
	public Usuario getUsuario(@PathVariable String email) throws ClassNotFoundException, SQLException {
		daoUsuarios dao = new daoUsuarios();
		
		return dao.getUsuario(email);
	}
	@GetMapping("/login/{email}")
	public Usuario loginUsuario(@PathVariable String email,@PathVariable String senha) throws ClassNotFoundException, SQLException {
		daoUsuarios dao = new daoUsuarios();
		
		return dao.getUsuario(email);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public boolean deleteUsuario(@PathVariable Integer id) throws ClassNotFoundException, SQLException {
		daoUsuarios dao = new daoUsuarios();
		dao.ExcluirUsuario(id);
		return true;
	}
	
	@PostMapping("/usuarios")
	public boolean adicionarUsuario(@RequestBody Usuario usuario) throws ClassNotFoundException, SQLException {
		daoUsuarios dao = new daoUsuarios();
	return dao.AdicionarUsuario(usuario);
	}
	
	@PutMapping("/usuarios/{id}")
	public boolean updateUsuario(@PathVariable("id") Integer id,@RequestBody Usuario usuario) throws ClassNotFoundException, SQLException {
		daoUsuarios dao = new daoUsuarios();

		
		return dao.updateUsuario(usuario);
		
		
	
}
}
