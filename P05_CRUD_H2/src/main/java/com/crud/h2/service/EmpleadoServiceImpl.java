package com.crud.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.dao.IEmpleadoDAO;
import com.crud.h2.dto.Empleado;
import com.crud.h2.dto.Trabajos;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	IEmpleadoDAO empleadoDAO;

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoDAO.save(empleado);
	}

	@Override
	public Empleado empleadoXID(Long id) {
		// TODO Auto-generated method stub
		return empleadoDAO.findById(id).get();
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoDAO.save(empleado);
	}

	@Override
	public void eliminarEmpleado(Long id) {
		// TODO Auto-generated method stub
		empleadoDAO.deleteById(id);
	}

	@Override
	public List<Empleado> listarEmpleados() {
		// TODO Auto-generated method stub
		return empleadoDAO.findAll();
	}

	@Override
	public List<Empleado> listarEmpleadoNombre(String nombre) {
		// TODO Auto-generated method stub
		return empleadoDAO.findByNombre(nombre);
	}

	@Override
	public List<Empleado> listarEmpleadoTrabajo(Trabajos trabajo) {
		// TODO Auto-generated method stub
		return empleadoDAO.findByTrabajo(trabajo);
	}
}
