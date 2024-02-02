package com.api.rest.biblioteca.entidades;

import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ventas")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "venta_id")
	private long id;
	@Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaSalida;
	private String descripcion;
	


	   @ManyToMany
	    @JoinTable(name = "ventas_usuarios", 
	               joinColumns = @JoinColumn(name = "venta_id", referencedColumnName = "venta_id"), 
	               inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id"))
	    private Set<Usuario> usuarios = new HashSet<>();

	    @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(name = "ventas_sucursales", 
	               joinColumns = @JoinColumn(name = "venta_id", referencedColumnName = "venta_id"), 
	               inverseJoinColumns = @JoinColumn(name = "sucursal_id", referencedColumnName = "sucursal_id"))
	    private Set<Sucursal> sucursales = new HashSet<>();

	 
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Set<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(Set<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}








	
}
