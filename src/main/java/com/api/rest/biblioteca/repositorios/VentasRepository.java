package com.api.rest.biblioteca.repositorios;

import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.api.rest.biblioteca.entidades.Sucursal;
import com.api.rest.biblioteca.entidades.Venta;
@Repository
public interface VentasRepository extends CrudRepository<Venta, Long>{
	Collection<Venta> findAll();
}
