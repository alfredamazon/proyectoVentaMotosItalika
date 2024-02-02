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
import com.api.rest.biblioteca.entidades.Venta;
import com.api.rest.biblioteca.repositorios.VentasRepository;
@RestController
@RequestMapping("/api/ventas_sucursal_usuario")
public class VentaController {

	@Autowired
	private VentasRepository ventasRepository;
	
	@GetMapping
	public ResponseEntity<Collection<Venta>>listarFiestas(){
		return new ResponseEntity<>(ventasRepository.findAll(),HttpStatus.OK);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Venta>obtenerSucursal(@PathVariable long id){
		Venta venta = ventasRepository.findById(id).orElseThrow();
		
		if(venta !=null)
		{
			return new ResponseEntity<>(ventasRepository.findById(id).orElseThrow(),HttpStatus.OK);
		} 
		else
		{
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping
	public ResponseEntity<?> guardarPersona(@Valid @RequestBody Venta venta){
		return new ResponseEntity<>(ventasRepository.save(venta),HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>eliminarFiesta(@PathVariable long id){
		ventasRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
