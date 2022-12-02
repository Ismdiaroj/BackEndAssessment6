package com.example.demo.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

public class OportunidadDTO {

	
	private Long id;
	
	@NotNull(message="El Nombre no debe ser nulo")
	@NotEmpty(message="El Nombre no debe estar vacío")
	private String name;
	
	@NotNull(message="El Email no debe ser nulo")
	@Email(message="No es un formato email")
	@NotEmpty(message="El Email no debe estar vacío")
	private String email;
	
	@NotNull(message="El Teléfono no debe ser nulo")
	@NotEmpty(message="El Teléfono no debe estar vacío")
	private String telefono;
	
	private String descripcion;
	
	private Boolean aprobada;
	
	private Long cliente_id;

	public OportunidadDTO() {
	}

	public OportunidadDTO(Long id,
			String name,
			String email,
			String telefono,
			String descripcion, 
			Boolean aprobada) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.telefono = telefono;
		this.descripcion = descripcion;
		this.aprobada = aprobada;
	}
	
	public OportunidadDTO(
			Long id,
			String name,
			String email,
			String telefono,
			String descripcion, 
			Boolean aprobada,
			Long cliente_id) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.telefono = telefono;
		this.descripcion = descripcion;
		this.aprobada = aprobada;
		this.cliente_id = cliente_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getAprobada() {
		return aprobada;
	}

	public void setAprobada(Boolean aprobada) {
		this.aprobada = aprobada;
	}

	public Long getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}
	
	

	


	
	
	
	
}
