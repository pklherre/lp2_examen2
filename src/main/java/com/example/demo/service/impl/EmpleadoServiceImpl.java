package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmpleadoEntity;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<EmpleadoEntity> listarTodo() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
	public EmpleadoEntity buscarPorId(String id) {
	
		return empleadoRepository.findById(id).get();
	}

	@Override
	public EmpleadoEntity crearEmpleado(EmpleadoEntity empleadoEntity) {
		// TODO Auto-generated method stub
		return empleadoRepository.save(empleadoEntity);
	}

	@Override
	public EmpleadoEntity actualizarEmpleado(EmpleadoEntity empleadoEntity) {
		EmpleadoEntity empleadoBuscado = buscarPorId(empleadoEntity.getDniEmpleado());
		if(empleadoBuscado != null) { // Si ya existe, tiene que actualizar
			empleadoBuscado.setApellidoEmpleado(empleadoEntity.getApellidoEmpleado());
			empleadoBuscado.setArea(empleadoEntity.getArea());
			empleadoBuscado.setDireccion(empleadoEntity.getDireccion());
			empleadoBuscado.setFechaNacimiento(empleadoEntity.getFechaNacimiento());
			empleadoBuscado.setNombreEmpleado(empleadoEntity.getNombreEmpleado());
			return empleadoRepository.save(empleadoBuscado);
		}
		return null;
		
	}

	@Override
	public void eliminarEmpleado(String id) {
		empleadoRepository.deleteById(id);
		
	}

}
