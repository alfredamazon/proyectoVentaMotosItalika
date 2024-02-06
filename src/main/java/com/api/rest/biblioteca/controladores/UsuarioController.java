package com.api.rest.biblioteca.controladores;

import java.util.Collection;
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
import com.api.rest.biblioteca.entidades.Sucursal;
import com.api.rest.biblioteca.entidades.Usuario;
import com.api.rest.biblioteca.repositorios.UsuarioRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
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
	public ResponseEntity<Map<String,Object>> obtenerPersonaPorId(@PathVariable long id){
	    Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
	    Map<String, Object> response = new HashMap<>();

	    if (usuarioOptional.isPresent()) {
	        Usuario usuario = usuarioOptional.get();
	        // Realiza las operaciones necesarias con el objeto Usuario
	        response.put("usuario", usuario);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        response.put("mensaje", "El usuario con ID " + id + " no existe en la base de datos");
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	    }
	     


	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?>update(@RequestBody Usuario usuario, @PathVariable Long id)
	{
		Optional<Usuario> usuarioActual=usuarioRepository.findById(id);
		Usuario usuarioUpdated =null;
		
		Map <String,Object> response=new HashMap<>();
		if(usuarioActual.isEmpty()) {
			response.put("mensaje", "Error : no se pudo actualizar el cliente Id ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			if (usuarioActual.isPresent()) {			
				Usuario usuarioEncontrado = usuarioActual.get();			   
			    usuarioEncontrado.setNombre(usuario.getNombre());
			    usuarioEncontrado.setEdad(usuario.getEdad());
			    usuarioUpdated = usuarioRepository.save(usuarioEncontrado);
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
	@PostMapping
	public ResponseEntity<?> guardarPersona(@RequestBody Usuario usuario){
		
	    Usuario userinsert = null;
	    Map<String, Object> response = new HashMap<>();
	    try {
	    	userinsert=usuarioRepository.save(usuario);
	    }catch(DataAccessException e )
	    {
	    	   // Loguear el error
	        e.printStackTrace(); // Esto imprime la traza de la excepción en la consola

	        // Construir la respuesta de error
	        response.put("mensaje", "Error al insertar en la base de datos");
	        response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    response.put("mensaje","El cliente ha sido creado con exito" );
	 // Loguear la respuesta de la base de datos
	   
	    response.put("usuario",userinsert );
	    System.out.println("Respuesta de la base de datos: " + userinsert);
	    return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String,Object>> eliminarPersona(@PathVariable long id){
		Map<String,Object> response= new HashMap<>();
		
		try {
			usuarioRepository.deleteById(id);
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
