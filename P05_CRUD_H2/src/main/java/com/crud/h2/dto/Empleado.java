package com.crud.h2.dto;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.crud.h2.dao.TrabajoJpaConverter;

@Entity
@Table(name = "empleado")
public class Empleado {

	//Atributos entidad empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Convert(converter = TrabajoJpaConverter.class)
	private Trabajos trabajo;
	
	@Column(name = "salario")
	private double salario;
	
	//---------------------CONSTRUCTORES------------------------
	
	public Empleado() {
		
	}
	
	public Empleado(Long id, String nombre, Trabajos trabajo, double salario) {
		//super();
		this.id = id;
		this.nombre = nombre;
		this.trabajo = trabajo;
		this.salario = salario;
	}

	//-----------------------GETTERS Y SETTERS------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Trabajos getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajos trabajo) {
		this.trabajo = trabajo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	//--------------------TOSTRING---------------------
	
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", trabajo=" + trabajo.toString() + ", salario=" + salario + "]";
	}

}
