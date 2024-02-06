package com.api.rest.biblioteca.repositorios;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.biblioteca.entidades.PerfilHabilidad;
@Repository
public interface HabilidadRepository extends CrudRepository<PerfilHabilidad, Long>{ 
    	Collection<PerfilHabilidad> findAll();
    	
}
