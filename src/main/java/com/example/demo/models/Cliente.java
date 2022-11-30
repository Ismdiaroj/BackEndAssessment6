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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name="cliente")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Accessors(fluent = true) 
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String email;
	
	private String telefono;
	
	private String contrato;
	
	@OneToMany(mappedBy="cliente")
	private List<Contacto> contactos;
	
	@OneToOne
	@JoinColumn(name="cliente_id")
	private Oportunidad oportunidad;
	
	
	//Helpers
	
	public void addContacto(Contacto contacto) {
		this.contactos.add(contacto);
		contacto.cliente(this);
	}
	
	
}
