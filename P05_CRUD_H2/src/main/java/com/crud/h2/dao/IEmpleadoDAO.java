package com.crud.h2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.h2.dto.Empleado;
import com.crud.h2.dto.Trabajos;

public interface IEmpleadoDAO extends JpaRepository<Empleado, Long> {

	//Listar empleados por campo nombre
	public List<Empleado> findByNombre(String nombre);
	
	//Listar empleados por campo trabajo
	public List<Empleado> findByTrabajo(Trabajos trabajo);
	
}
