package com.crud.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.h2.dto.Empleado;
import com.crud.h2.dto.Trabajos;
import com.crud.h2.service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;

	// Metodo Listar todos los Empleados
	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados() {
		return empleadoServiceImpl.listarEmpleados();
	}

	// Metodo Listar Empleado por nombre
	@GetMapping("/empleados/nombre/{nombre}")
	public List<Empleado> listarEmpleadoNombre(@PathVariable(name = "nombre") String nombre) {
		return empleadoServiceImpl.listarEmpleadoNombre(nombre);
	}

	// Metodo Listar Empleado por trabajo
	@GetMapping("/empleados/trabajo/{trabajo}")
	public List<Empleado> listarEmpleadoTrabajo(@PathVariable(name = "trabajo") Trabajos trabajo) {
		return empleadoServiceImpl.listarEmpleadoTrabajo(trabajo);
	}

	// Metodo insertar Empleado
	@PostMapping("/empleados")
	public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
		String tr;
		
		tr = empleado.getTrabajo().toString();
		
		switch (tr) {
		case "PROGRAMADOR":
			empleado.setSalario(2200.0);
			break;
		case "DISEÑADOR":
			empleado.setSalario(2100.0);
			break;
		case "ASISTENTE":
			empleado.setSalario(1000.0);
			break;

		default:
			empleado.setSalario(0.0);
			break;
		}
		
		return empleadoServiceImpl.guardarEmpleado(empleado);
	}

	// Metodo actualizar Empleado
	@GetMapping("/empleados/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name = "id") Long id, @RequestBody Empleado empleado) {
		Empleado empleado_selec = new Empleado();
		Empleado empleado_actu = new Empleado();
		String tr;

		empleado_selec = empleadoServiceImpl.empleadoXID(id);

		empleado_selec.setNombre(empleado.getNombre());
		empleado_selec.setTrabajo(empleado.getTrabajo());
		
		tr = empleado.getTrabajo().toString().toUpperCase();

		switch (tr) {
		case "PROGRAMADOR":
			empleado_selec.setSalario(2200.0);
			break;
		case "DISEÑADOR":
			empleado_selec.setSalario(2100.0);
			break;
		case "ASISTENTE":
			empleado_selec.setSalario(1000.0);
			break;

		default:
			empleado_selec.setSalario(0.0);
			break;
		}

		empleado_actu = empleadoServiceImpl.actualizarEmpleado(empleado_selec);

		System.out.println("Empleado actualizado: " + empleado_actu);

		return empleado_actu;
	}

	// Metodo eliminar Empleado
	@DeleteMapping("/empleados/{id}")
	public void eliminarEmpleado(@PathVariable(name = "id") Long id) {
		empleadoServiceImpl.eliminarEmpleado(id);
	}

}
