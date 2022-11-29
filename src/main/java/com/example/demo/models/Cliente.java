package com.example.demo.models;

import java.util.List;

import jakarta.persistence.Entity;
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
	
	@Setter(value = AccessLevel.PRIVATE) private Long id;
	
	private String contrato;
	
	private List<Contacto> contactos;
	
	private Oportunidad oportunidad;
	
	
	//Helpers
	
	public void addContacto(Contacto contacto) {
		this.contactos.add(contacto);
		contacto.setClienteId(this.getId());
	}
}
