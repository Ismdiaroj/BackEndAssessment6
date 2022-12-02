package com.example.demo.dtos;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.models.Cliente;
import com.example.demo.models.Oportunidad;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

public class ContactoDTO {
	

	private Long id;
	
	private String canal;
	
	@NotNull(message = "Debe completar el campo fecha de inicio")
	@FutureOrPresent(message = "La fecha de inicio no puede ser anterior a la actual")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fecha;
	
	private String mensaje;
	
	private Long oportunidad_id;
	
	private Long cliente_id;

	
	
	
	public ContactoDTO() {
	}
	
	
	public ContactoDTO(Long id, String canal, LocalDate fecha,String mensaje) {
		this.id = id;
		this.canal = canal;
		this.fecha = fecha;
		this.mensaje = mensaje;
	}

	public ContactoDTO(Long id, String canal,LocalDate fecha, String mensaje, Long oportunidad_id) {
		this.id = id;
		this.canal = canal;
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.oportunidad_id = oportunidad_id;
	}

	public ContactoDTO(Long id, String canal,LocalDate fecha,Long cliente_id,String mensaje) {
		this.id = id;
		this.canal = canal;
		this.fecha = fecha;
		this.cliente_id = cliente_id;
		this.mensaje = mensaje;
	}
	
	
	
	

	public ContactoDTO(Long id, String canal, LocalDate fecha,String mensaje, Long oportunidad_id, Long cliente_id) {
		this.id = id;
		this.canal = canal;
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.oportunidad_id = oportunidad_id;
		this.cliente_id = cliente_id;
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

	public Long getOportunidad_id() {
		return oportunidad_id;
	}

	public void setOportunidad_id(Long oportunidad_id) {
		this.oportunidad_id = oportunidad_id;
	}

	public Long getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}
	
	
	
	
	

}
