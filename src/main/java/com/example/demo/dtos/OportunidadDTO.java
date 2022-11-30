package com.example.demo.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Accessors(fluent = true)
public class OportunidadDTO {

	
	private long id;
	
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
	
	private Long oportunidad_id;
	
}
