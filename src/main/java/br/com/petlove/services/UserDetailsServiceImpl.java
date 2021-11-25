package br.com.petlove.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.petlove.controle.ControleLogin;
import br.com.petlove.enums.Perfil;
import br.com.petlove.modelo.Usuario;
import br.com.petlove.security.UserSS;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private ControleLogin login;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		try {
			Usuario user= login.getUsuario(email);
			if(user==null) {
				System.out.println("dadada");
				throw new UsernameNotFoundException(email);
			}else {
				System.out.println(user.getPerfis().size());
				
				return new UserSS(user.getId(),user.getEmail(),user.getSenha(),user.getPerfis());

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

}
