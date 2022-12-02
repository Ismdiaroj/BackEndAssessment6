package com.example.demo.models;

import java.util.List;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name="oportunidad")
public class Oportunidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "aprobada")
	private Boolean aprobada;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "oportunidad")
	private List<Contacto> contactos;
	
	
	
	
	
	public Oportunidad() {
	}



	public void addContacto(Contacto contacto) {
		this.contactos.add(contacto);
		contacto.setOportunidad(this);
	}

	

	public Oportunidad(String name, String email, String telefono, String descripcion, Boolean aprobada,Cliente cliente
			) {
		this.name = name;
		this.email = email;
		this.telefono = telefono;
		this.descripcion = descripcion;
		this.aprobada = aprobada;
		this.cliente = cliente;
	}



	public Oportunidad(String name, String email, String telefono, String descripcion, Boolean aprobada) {
		this.name = name;
		this.email = email;
		this.telefono = telefono;
		this.descripcion = descripcion;
		this.aprobada = aprobada;
	}
	
	



	public Oportunidad(Long id, String name, String email, String telefono, String descripcion, Boolean aprobada,
			List<Contacto> contactos) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.telefono = telefono;
		this.descripcion = descripcion;
		this.aprobada = aprobada;
		this.contactos = contactos;
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



	public List<Contacto> getContactos() {
		return contactos;
	}



	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}
