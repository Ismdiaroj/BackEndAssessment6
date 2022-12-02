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

	
	
	
	public Contacto() {
	}

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

	public Contacto(Long id, String canal, LocalDate fecha, String mensaje, Oportunidad oportunidad, Cliente cliente) {
		this.id = id;
		this.canal = canal;
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.oportunidad = oportunidad;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Oportunidad getOportunidad() {
		return oportunidad;
	}

	public void setOportunidad(Oportunidad oportunidad) {
		this.oportunidad = oportunidad;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	
	
	
}
