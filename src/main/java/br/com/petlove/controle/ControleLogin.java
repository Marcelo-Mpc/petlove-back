package br.com.petlove.controle;

import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.petlove.dao.daoUsuarios;
import br.com.petlove.modelo.Login;
import br.com.petlove.modelo.Usuario;
import br.com.petlove.security.jwtUtil;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ControleLogin {
	@PostMapping("/Login")
	public String login(@RequestBody Login login) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder() ;
		daoUsuarios dao = new daoUsuarios();
		try {
			
			Usuario user= dao.getUsuario(login.getEmail());
			if(user==null) {
				return "Email ou senha inválido";

			}
			if(pe.matches(login.getSenha(), user.getSenha())) {
				jwtUtil x= new jwtUtil();
				
				return x.generateToken(login.getEmail());
			}else {
				return "Email ou senha inválido";

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "Email ou senha inválido";

		}
		
		
	}
	
	public Usuario getUsuario(String email) throws ClassNotFoundException, SQLException {
		daoUsuarios dao = new daoUsuarios();
		Usuario user = dao.getUsuario(email);
		if (user == null) {
			System.out.println("dawda");
			return null;
		}
		return user;
	}
}
