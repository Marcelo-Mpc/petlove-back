package br.com.petlove.controle;

import java.sql.SQLException;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.licensemanager.model.AuthorizationException;

import br.com.petlove.dao.daoUsuarios;
import br.com.petlove.enums.Perfil;
import br.com.petlove.modelo.Login;
import br.com.petlove.modelo.Usuario;
import br.com.petlove.repositorio.UsuarioRepositorio;
import br.com.petlove.security.UserSS;
import br.com.petlove.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ControleUsuarios {
	UsuarioRepositorio repositorio;

	@GetMapping("/usuarios")
	public List<Usuario> getTodosUsuarios() throws ClassNotFoundException, SQLException {
		daoUsuarios dao = new daoUsuarios();
		
		return dao.listarUsuarios();

	}

	
	@GetMapping("/usuarios/{id}")
	public Usuario getUsuariounico(@PathVariable String id) throws ClassNotFoundException, SQLException {
		daoUsuarios dao = new daoUsuarios();
		UserSS user= UserService.authenticated();
		if(user==null||!user.hashRole(Perfil.ADMIN) && id.equals(user.getID())) {
			throw new AuthorizationException("Acesso Negado");
		}
		return dao.getUsuarioUnico(id.toString());
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
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder() ;
		usuario.setSenha(pe.encode(usuario.getSenha()));
		return dao.AdicionarUsuario(usuario);
	}

	@PutMapping("/usuarios/{id}")
	public boolean updateUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuario)
			throws ClassNotFoundException, SQLException {
		daoUsuarios dao = new daoUsuarios();

		return dao.updateUsuario(usuario);

	}
}
