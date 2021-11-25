package br.com.petlove.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurituConfig extends WebSecurityConfigurerAdapter {
	
@Autowired
private UserDetailsService userDetailsService;

@Autowired
private jwtUtil jwtUtil;
private static final String[] PUBLIC_MATCHERS = {
		"/login/**",
"/cadastrouser/**",
"/quemsomos/**",
"/cuidados/**",
"/Contato/**",
"/animais/**",
"/usuarios/**",
"/Login/**"

};
private static final String[] PUBLIC_MATCHERS_GET = {
		"/login/**",
"/cadastrouser/**",
"/quemsomos/**",
"/cuidados/**",
"/Contato/**",
"/animais/**",
"/usuarios/**",
"/Login/**"


};

@Override
 protected void configure(HttpSecurity http) throws Exception{
	http.cors().and().csrf().disable();
	http.authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll().antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll().anyRequest().authenticated();
	http.addFilter(new jwtAutenticador(authenticationManager() , jwtUtil));
	http.addFilter(new jwtAutenticadorFiltro(authenticationManager() , jwtUtil, userDetailsService));

	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	System.out.println(http);
}
@Override
public void configure(AuthenticationManagerBuilder auth) throws Exception {
	
 	auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder()) ;
}

@Bean
public BCryptPasswordEncoder bCryptPasswordEncoder() {
	return new BCryptPasswordEncoder();
}
}
