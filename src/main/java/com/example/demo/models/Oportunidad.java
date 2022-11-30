package com.example.demo.models;

import java.util.List;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name="oportunidad")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Accessors(fluent = true) 
public class Oportunidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@OneToOne
	@JoinColumn(name="oportunidad_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "oportunidad")
	private List<Contacto> contactos;
	
	
	
	
	
	public void addContacto(Contacto contacto) {
		this.contactos.add(contacto);
		contacto.oportunidad(this);
	}

	

	public Oportunidad(long id, String name, String email, String telefono, String descripcion, Boolean aprobada,
			Cliente cliente) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.telefono = telefono;
		this.descripcion = descripcion;
		this.aprobada = aprobada;
		this.cliente = cliente;
	}



	public Oportunidad(long id, String name, String email, String telefono, String descripcion, Boolean aprobada) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.telefono = telefono;
		this.descripcion = descripcion;
		this.aprobada = aprobada;
	}
	
	
}
