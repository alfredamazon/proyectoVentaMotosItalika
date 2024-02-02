package com.api.rest.biblioteca.repositorios;

import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.api.rest.biblioteca.entidades.Sucursal;
@Repository
public interface SucursalesRepository extends CrudRepository<Sucursal, Long>{
	Collection<Sucursal> findAll();
}
