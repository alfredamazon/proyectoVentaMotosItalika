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
import com.api.rest.biblioteca.entidades.Usuario;
import com.api.rest.biblioteca.repositorios.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity<Collection<Usuario>>listarPersonas(){
		return new ResponseEntity<>(usuarioRepository.findAll(),HttpStatus.OK);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Usuario>obtenerPersonaPorId(@PathVariable long id){
		Usuario usuario = usuarioRepository.findById(id).orElseThrow();
		
		if(usuario !=null)
		{
			return new ResponseEntity<>(usuarioRepository.findById(id).orElseThrow(),HttpStatus.OK);
		} 
		else
		{
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping
	public ResponseEntity<?> guardarPersona(@Valid @RequestBody Usuario usuario){
		return new ResponseEntity<>(usuarioRepository.save(usuario),HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>eliminarPersona(@PathVariable long id){
		usuarioRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping("/{id}/sucursales")
	public ResponseEntity<Collection<Sucursal>> listarFiestaDeLaPersona(@PathVariable long id)
	{
		Usuario usuario = usuarioRepository.findById(id).orElseThrow();
		
		if(usuario !=null)
		{
			return new ResponseEntity<>(usuario.getSucursales(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	

}
