package com.example.model;

import org.springframework.stereotype.Component;

@Component("contacto")
public class Contacto {
	
	private String id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String direccion;
	private int telefono;
	
	
	public Contacto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contacto(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String direccion,
			int telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellidoPaterno;
		this.apellido2 = apellidoMaterno;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellidoPaterno) {
		this.apellido1 = apellidoPaterno;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellidoMaterno) {
		this.apellido2 = apellidoMaterno;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
}
