package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Contacto;

public interface ContactoService {

	public Contacto findContactoById(Long id);
	
	public List<Contacto> getAllContactos();
	
	public Contacto insertarContacto(Contacto contacto);
	
	public Contacto actualizarContacto(Contacto contacto);
	
	public boolean borrarContacto(Contacto contacto); 
}
