package com.example.demo.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name="contacto")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Accessors(fluent = true)
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String canal;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	private String mensaje;
	
	@ManyToOne
	@JoinColumn(name="oportunidad_id")
	private Oportunidad oportunidad;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	
	
	public Contacto(String canal, LocalDate fecha, String mensaje) {
		this.canal = canal;
		this.fecha = fecha;
		this.mensaje = mensaje;
	}

	public Contacto(String canal, LocalDate fecha, String mensaje, Oportunidad oportunidad) {
		this.canal = canal;
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.oportunidad = oportunidad;
	}

	public Contacto(String canal, LocalDate fecha, String mensaje, Cliente cliente) {
		this.canal = canal;
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.cliente = cliente;
	}
	
	
	
}
