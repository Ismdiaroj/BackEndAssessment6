package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Oportunidad;
import com.example.demo.repositories.OportunidadRepository;

@Service
public class OportunidadServiceImpl implements OportunidadService{

	@Autowired
	OportunidadRepository oportunidadRepository;
	
	@Override
	public Oportunidad findOportunidadById(Long id) {
		return oportunidadRepository.findById(id).orElse(null);
	}

	@Override
	public List<Oportunidad> getAllOportunidades() {
		return oportunidadRepository.findAll();
	}

	@Override
	public Oportunidad insertarOportunidad(Oportunidad oportunidad) {
		if (oportunidad != null && oportunidad.id() == null && findOportunidadByEmail(oportunidad.email()) == null)
			return oportunidadRepository.save(oportunidad);			
		else
			return null;
	}

	@Override
	public Oportunidad actualizarOportunidad(Oportunidad oportunidad) {
		if (oportunidad == null || oportunidad.id() == null)
			return null;
		else
			return oportunidadRepository.save(oportunidad); 
	}

	@Override
	public boolean borrarUsuario(Oportunidad oportunidad) {
		if (oportunidad != null && oportunidad.id() != null) {
			oportunidadRepository.delete(oportunidad);
			return true;
		} else
			return false;
	}

	@Override
	public Oportunidad findOportunidadByEmail(String email) {
		return oportunidadRepository.findByEmail(email);
	}

}
