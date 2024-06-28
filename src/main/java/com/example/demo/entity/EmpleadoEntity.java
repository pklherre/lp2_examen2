package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_empleado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmpleadoEntity {
	@Id
	@Column(name = "dni_empleado", nullable = false)
	private String dniEmpleado;
	
	@Column(name = "nombre_empleado", nullable = false)
	private String nombreEmpleado;
	
	@Column(name = "apellido_empleado", nullable = false)
	private String apellidoEmpleado;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column(name = "direccion", nullable = false)
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name = "area_id")
	private AreaEntity area;
	

}
