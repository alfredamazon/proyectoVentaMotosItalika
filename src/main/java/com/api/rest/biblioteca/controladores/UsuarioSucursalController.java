	package com.api.rest.biblioteca.controladores;


import java.util.Collection;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.rest.biblioteca.entidades.Sucursal;
import com.api.rest.biblioteca.repositorios.SucursalesRepository;

@RestController
@RequestMapping("/api/sucursales")
public class UsuarioSucursalController {

	@Autowired
	private SucursalesRepository sucursalRepository;
	
	@GetMapping
	public ResponseEntity<Collection<Sucursal>>listarFiestas(){
		return new ResponseEntity<>(sucursalRepository.findAll(),HttpStatus.OK);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Sucursal>obtenerSucursal(@PathVariable long id){
		Sucursal sucursal = sucursalRepository.findById(id).orElseThrow();
		
		if(sucursal !=null)
		{
			return new ResponseEntity<>(sucursalRepository.findById(id).orElseThrow(),HttpStatus.OK);
		} 
		else
		{
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping
	public ResponseEntity<?> guardarPersona(@Valid @RequestBody Sucursal sucursal){
		return new ResponseEntity<>(sucursalRepository.save(sucursal),HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>eliminarFiesta(@PathVariable long id){
		sucursalRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
