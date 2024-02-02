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
@Table(name = "sucursales")
public class Sucursal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sucursal_id")
	private long id;
	
	private String ubicacion;
	
	@Column(name = "fecha_entrada")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntrada;


    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaSalida;
	
    @ManyToMany(cascade = CascadeType.ALL)

	@JoinTable(name = "sucursal_usuarios", joinColumns = @JoinColumn(name = "sucursal_id", referencedColumnName = "sucursal_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id"))

	Set<Usuario> usuarios = new HashSet<>();
	
	@ManyToMany

	@JoinTable(name = "sucursal_ventas", joinColumns = @JoinColumn(name = "sucursal_id", referencedColumnName = "sucursal_id"), inverseJoinColumns = @JoinColumn(name = "venta_id", referencedColumnName = "venta_id"))

	Set<Venta> ventas = new HashSet<>();


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}



	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Set<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(Set<Venta> ventas) {
		this.ventas = ventas;
	}

}
