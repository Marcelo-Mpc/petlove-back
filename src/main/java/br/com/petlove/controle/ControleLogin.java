package br.com.petlove.controle;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.petlove.dao.daoUsuarios;
import br.com.petlove.modelo.Login;
import br.com.petlove.modelo.Usuario;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ControleLogin {
	@PostMapping("/login/")
	public Boolean loginUsuario(@RequestBody Login login) throws ClassNotFoundException, SQLException {
		daoUsuarios dao = new daoUsuarios();
		Usuario user = dao.getUsuario(login.getEmail());
		if (user == null) {
			return false;

		} else {

			if (user.getSenha().equals(login.getSenha())) {
				return true;
			} else {
				return false;

			}
		}
	}
}
