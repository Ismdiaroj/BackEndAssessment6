package com.example.demo.dtos;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.demo.models.Contacto;
import com.example.demo.models.Oportunidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

public class ClienteDTO {

	
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
	
	private String contrato;
	
	private Long oportunidad_id;

	public ClienteDTO() {
	}

	public ClienteDTO(
			Long id,
			String name,
			String email,
			String telefono,
			String contrato) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.telefono = telefono;
		this.contrato = contrato;
	}
		
		public ClienteDTO(Long id,
				String name,
				String email,
				String telefono,
				String contrato,
				Long oportunidad_id) {
			this.id = id;
			this.name = name;
			this.email = email;
			this.telefono = telefono;
			this.contrato = contrato;
			this.oportunidad_id= oportunidad_id;
			
			
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

		public String getContrato() {
			return contrato;
		}

		public void setContrato(String contrato) {
			this.contrato = contrato;
		}

		public Long getOportunidad_id() {
			return oportunidad_id;
		}

		public void setOportunidad_id(Long oportunidad_id) {
			this.oportunidad_id = oportunidad_id;
		}
	
	
	
	
	
}
