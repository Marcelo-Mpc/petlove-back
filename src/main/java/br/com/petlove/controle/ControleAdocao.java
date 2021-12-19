package br.com.petlove.controle;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.petlove.dao.daoAdocao;
import br.com.petlove.modelo.Adocao;
import br.com.petlove.modelo.Animal;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ControleAdocao {

@PostMapping("/adotar")
public boolean adicionarAdocao(@RequestBody Adocao adocao) {
	System.out.println(adocao.getFicarsozinho());
	daoAdocao daoAdocao= new daoAdocao(); 
		try {
			daoAdocao.AdicionarAdocao(adocao);
			return true; 

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return false; 
}

@GetMapping("/adotar/{id}")
public List<Adocao> listarAdocao(@PathVariable Integer id){
	daoAdocao daoAdocao= new daoAdocao(); 
	try {
		return daoAdocao.getAdocao(id);
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return null;
}
}
