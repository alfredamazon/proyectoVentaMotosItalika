package com.api.rest.biblioteca.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.biblioteca.entidades.PerfilHabilidad;
import com.api.rest.biblioteca.repositorios.HabilidadRepository;
@RestController
@RequestMapping("api/perfil_habilidades")
public class HabiilidadController {
	@Autowired
	private HabilidadRepository habilidadRepository;
	
	@PostMapping
	public ResponseEntity<?> guardarHabilidad(@Valid @RequestBody PerfilHabilidad habilidad){
		return new ResponseEntity<>(habilidadRepository.save(habilidad),HttpStatus.CREATED);
	}
}
