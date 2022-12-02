package com.example.demo.models;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String email;
	
	private String telefono;
	
	private String contrato;
	
	@OneToMany(mappedBy="cliente")
	private List<Contacto> contactos;
	
	@OneToOne(mappedBy="cliente")
	private Oportunidad oportunidad;
	
	
	
	
	
	
	public Cliente() {
	}
	
	

	
	public Cliente(String name, String email, String telefono, String contrato) {
		this.name = name;
		this.email = email;
		this.telefono = telefono;
		this.contrato = contrato;
	}




	public Cliente(String name, String email, String telefono, String contrato, List<Contacto> contactos,
			Oportunidad oportunidad) {
		this.name = name;
		this.email = email;
		this.telefono = telefono;
		this.contrato = contrato;
		this.contactos = contactos;
		this.oportunidad = oportunidad;
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






	public List<Contacto> getContactos() {
		return contactos;
	}






	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}






	public Oportunidad getOportunidad() {
		return oportunidad;
	}






	public void setOportunidad(Oportunidad oportunidad) {
		this.oportunidad = oportunidad;
	}






	//Helpers
	public void addContacto(Contacto contacto) {
		this.contactos.add(contacto);
		contacto.setCliente(this);
	}
	
	
}
