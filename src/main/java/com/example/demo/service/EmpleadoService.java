package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EmpleadoEntity;

public interface EmpleadoService {
	List<EmpleadoEntity>listarTodo();
	EmpleadoEntity buscarPorId(String id);
	EmpleadoEntity crearEmpleado(EmpleadoEntity empleadoEntity);
	EmpleadoEntity actualizarEmpleado(EmpleadoEntity empleadoEntity);
	void eliminarEmpleado(String id);
}
