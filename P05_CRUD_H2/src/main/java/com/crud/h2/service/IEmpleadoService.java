package com.crud.h2.service;

import java.util.List;

import com.crud.h2.dto.Empleado;
import com.crud.h2.dto.Trabajos;

public interface IEmpleadoService {

	// Metodos CRUD
	// CREATE: Guardamos un nuevo empleado
	public Empleado guardarEmpleado(Empleado empleado);
	
	// READ: Leemos los datos de un empleado por Id
	public Empleado empleadoXID(Long id);
	
	// UPDATE: Actualizar los datos de un empleado
	public Empleado actualizarEmpleado(Empleado empleado);
	
	// DELETE: Eliminar un empleado
	public void eliminarEmpleado(Long id);
	
	// Listamos a todos los empleados
	public List<Empleado> listarEmpleados();
	
	// Listamos a los empleados por nombre
	public List<Empleado> listarEmpleadoNombre(String nombre);
	
	// Listamos a los empleados por trabajo
	public List<Empleado> listarEmpleadoTrabajo(Trabajos trabajo);
	
}
