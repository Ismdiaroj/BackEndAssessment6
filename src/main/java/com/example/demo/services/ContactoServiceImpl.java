package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Contacto;
import com.example.demo.repositories.ContactoRepository;
import com.example.demo.repositories.OportunidadRepository;

@Service
public class ContactoServiceImpl implements ContactoService {

	@Autowired
	ContactoRepository contactoRepository;
	
	@Override
	public Contacto findContactoById(Long id) {
		return contactoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Contacto> getAllContactos() {
		return contactoRepository.findAll();
	}

	@Override
	public Contacto insertarContacto(Contacto contacto) {
		return contactoRepository.save(contacto);
	}

	@Override
	public Contacto actualizarContacto(Contacto contacto) {
		return contactoRepository.save(contacto);
		
	}

	@Override
	public boolean borrarContacto(Contacto contacto) {
		if (contacto != null && contacto.id() != null) {
			contactoRepository.delete(contacto);
			return true;
		} else
			return false;
	}

}
