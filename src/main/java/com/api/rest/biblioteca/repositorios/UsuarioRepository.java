package com.api.rest.biblioteca.repositorios;

import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.api.rest.biblioteca.entidades.Usuario;
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	Collection<Usuario> findAll();

	Usuario findById(Usuario usuario);
	
	
}
