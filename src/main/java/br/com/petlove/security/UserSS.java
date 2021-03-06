package br.com.petlove.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.petlove.enums.Perfil;

public class UserSS implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;
	
	public Integer getID() {
		return id;
	}
	
	public UserSS() {
		
	}
	
	public UserSS(Integer id, String email, String senha,Set<Perfil> set) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.authorities = set.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList()); 
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public boolean hashRole(Perfil perfil) {
		
		return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
	}

}
