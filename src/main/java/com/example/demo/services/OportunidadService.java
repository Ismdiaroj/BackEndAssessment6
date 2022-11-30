package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Oportunidad;

public interface OportunidadService {

	public Oportunidad findOportunidadById(Long id);
	
	public Oportunidad findOportunidadByEmail(String email);
	
	public List<Oportunidad> getAllOportunidades();
	
	public Oportunidad insertarOportunidad(Oportunidad oportunidad);
	
	public Oportunidad actualizarOportunidad(Oportunidad oportunidad);
	
	public boolean borrarUsuario(Oportunidad oportunidad);
	
}
