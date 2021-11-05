package br.com.petlove.repositorio;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import br.com.petlove.modelo.Usuario;
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Integer>{

	

}
