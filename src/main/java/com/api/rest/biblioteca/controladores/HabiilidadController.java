package com.api.rest.biblioteca.controladores;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.biblioteca.entidades.PerfilHabilidad;
import com.api.rest.biblioteca.entidades.Usuario;
import com.api.rest.biblioteca.repositorios.HabilidadRepository;
@RestController
@RequestMapping("api/perfil_habilidades")
public class HabiilidadController {
	@Autowired
	private HabilidadRepository habilidadRepository;
	//visualizar usuario
	@GetMapping
	public ResponseEntity<Collection<PerfilHabilidad>>listarPersonas(){
		return new ResponseEntity<>(habilidadRepository.findAll(),HttpStatus.OK);
	}
	//buscar usuario por id
	@GetMapping("/{id}")
	public ResponseEntity<Map<String,Object>> obtenerPersonaPorId(@PathVariable long id){
	    Optional<PerfilHabilidad> usuarioOptional = habilidadRepository.findById(id);
	    Map<String, Object> response = new HashMap<>();

	    if (usuarioOptional.isPresent()) {
	    	PerfilHabilidad usuario = usuarioOptional.get();
	        // Realiza las operaciones necesarias con el objeto Usuario
	        response.put("usuario", usuario);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        response.put("mensaje", "El usuario con ID " + id + " no existe en la base de datos");
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	    }
	}
	//crear usuarios
	@PostMapping
	public ResponseEntity<?> guardarHabilidad(@Valid @RequestBody PerfilHabilidad habilidad){
		return new ResponseEntity<>(habilidadRepository.save(habilidad),HttpStatus.CREATED);
	}
	//actualizar usuario por id
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?>update(@RequestBody PerfilHabilidad usuario, @PathVariable Long id)
	{
		Optional<PerfilHabilidad> usuarioActual=habilidadRepository.findById(id);
		Usuario usuarioUpdated =null;
		
		Map <String,Object> response=new HashMap<>();
		if(usuarioActual.isEmpty()) {
			response.put("mensaje", "Error : no se pudo actualizar el cliente Id ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			if (usuarioActual.isPresent()) {			
				PerfilHabilidad usuarioEncontrado = usuarioActual.get();			   
			    usuarioEncontrado.setNombre(usuario.getNombre());
			    usuarioEncontrado.setNivel(usuario.getNivel());
			} 
		}
		catch(DataAccessException e)
		{
			response.put("mensaje", "Error al actualizar el cliente en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "el cliente ha sido actualizado con exito!!!");
		response.put("usuario", usuarioUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);	
	}
	//eliminar un usuario
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String,Object>> eliminarPersona(@PathVariable long id){
		Map<String,Object> response= new HashMap<>();
		
		try {
			habilidadRepository.deleteById(id);
		}
		catch(DataAccessException e)
		{
			response.put("mensaje", "Error al eliminar el usuario de la base de datos");
			response.put("error", e.getMessage().concat(" :").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "el cliente ha sido eliminado con exito!");
		return new ResponseEntity<Map<String,Object>>(HttpStatus.OK);
	}

}
