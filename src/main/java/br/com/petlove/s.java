package br.com.petlove;

import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.petlove.dao.daoUsuarios;
import br.com.petlove.modelo.Usuario;

public class s {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	BCryptPasswordEncoder pe = new BCryptPasswordEncoder() ;
	daoUsuarios d = new daoUsuarios();
	Usuario n = new Usuario();
	n.setCidade("dw");
	n.setCpf((long) 165);
	n.setEmail("marcelo@gmail.com");
	n.setEndereco("dadad");
	n.setEstado("dad");
	n.setId(124);
	n.setNome("dada");
	n.setSenha(pe.encode("123456"));
	d.AdicionarUsuario(n);
	System.out.println(pe.matches("123css456", n.getSenha()));
	
}
}
