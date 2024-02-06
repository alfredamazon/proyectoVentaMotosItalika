package com.api.rest.biblioteca.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private long id;
   
    @NotNull(message = "El nombre no puede ser nulo")
	private String nombre;
  
    @NotNull(message = "La edad no puede ser nulo")
	private Integer edad;

	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	private Set<PerfilHabilidad> habilidades=   new HashSet<>();
	
	@ManyToMany

	@JoinTable(name="usuarios_sucursales",
		joinColumns= @JoinColumn(name="usuario_id",referencedColumnName="usuario_id"),
		inverseJoinColumns=@JoinColumn(name="sucursal_id", referencedColumnName="sucursal_id"))
	private Set<Sucursal> sucursales =   new HashSet<>();




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Set<PerfilHabilidad> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(Set<PerfilHabilidad> habilidades) {
		this.habilidades = habilidades;
	}

	public Set<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(Set<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}








	
}
