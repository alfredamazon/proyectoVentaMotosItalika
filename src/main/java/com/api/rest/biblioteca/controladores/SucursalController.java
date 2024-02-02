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
import com.api.rest.biblioteca.repositorios.UsuarioSucursalesRepository;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {

	@Autowired
	private UsuarioSucursalesRepository usuariosucursalRepository;
	
	@GetMapping
	public ResponseEntity<Collection<Sucursal>>listarFiestas(){
		return new ResponseEntity<>(usuariosucursalRepository.findAll(),HttpStatus.OK);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Sucursal>obtenerSucursal(@PathVariable long id){
		Sucursal sucursal = usuariosucursalRepository.findById(id).orElseThrow();
		
		if(sucursal !=null)
		{
			return new ResponseEntity<>(usuariosucursalRepository.findById(id).orElseThrow(),HttpStatus.OK);
		} 
		else
		{
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping
	public ResponseEntity<?> guardarPersona(@Valid @RequestBody Sucursal sucursal){
		return new ResponseEntity<>(usuariosucursalRepository.save(sucursal),HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>eliminarFiesta(@PathVariable long id){
		usuariosucursalRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
