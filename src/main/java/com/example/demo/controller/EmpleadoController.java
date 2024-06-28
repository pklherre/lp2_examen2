package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.EmpleadoEntity;
import com.example.demo.repository.AreaRepository;
import com.example.demo.service.EmpleadoService;


@Controller
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@GetMapping("/")
	public String home(Model model) {
		List<EmpleadoEntity>empleados = empleadoService.listarTodo();
		model.addAttribute("empleados", empleados);
		return "lista_empleados";
	}
	
	@GetMapping("/agregar_empleado")
	public String shoAgregarEmpleado(Model model) {
		model.addAttribute("empleado", new EmpleadoEntity());
		model.addAttribute("areas", areaRepository.findAll());
		return "agregar_empleado";
	}
	
	@PostMapping("/registrar_empleado")
	public String registrarEmpleado(@DateTimeFormat(pattern = "yyyy-mm-dd") EmpleadoEntity empleadoEntity) {
		empleadoService.crearEmpleado(empleadoEntity);
		return "redirect:/";
	}
	
	@GetMapping("/editar_empleado/{dni}")
	public String showEditarEmpleado(@DateTimeFormat(pattern = "yyyy-mm-dd") @PathVariable("dni") String dni, Model model) {
		EmpleadoEntity empleadoBuscar = empleadoService.buscarPorId(dni);
		
		model.addAttribute("areas", areaRepository.findAll());
		model.addAttribute("empleado", empleadoBuscar);
		
		return "editar_empleado";
	}
	
	@PostMapping("/editar_empleado")
	public String editarEmpleado(Model model, EmpleadoEntity empleadoEntity) {
	
		empleadoService.actualizarEmpleado(empleadoEntity);
		return "redirect:/";
	}
	
	@GetMapping("/buscar/{dni}")
	public String buscarPorDni(@PathVariable("dni") String dni, Model model) {
		EmpleadoEntity empleadoEncontrado = empleadoService.buscarPorId(dni);
		model.addAttribute("empleado", empleadoEncontrado);
		return "buscar";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
