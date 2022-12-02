package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dtos.ContactoDTO;
import com.example.demo.models.Cliente;
import com.example.demo.models.Contacto;
import com.example.demo.models.Oportunidad;
import com.example.demo.services.ClienteService;
import com.example.demo.services.ContactoService;
import com.example.demo.services.OportunidadService;

@RestController
@RequestMapping("/contacto")
public class ContactoController {

	@Autowired
	ContactoService contactoService;
	
	@Autowired
	OportunidadService oportunidadService;
	
	@Autowired
	ClienteService clienteService;
	
	
	@GetMapping(value="/get-all")
	public ResponseEntity<?> getAllContactos(){
		
		List<ContactoDTO> contactos_return = new ArrayList<>();
		List<Contacto> contactos_persistidos = contactoService.getAllContactos();
		
		for(Contacto c : contactos_persistidos) {
			ContactoDTO contactoDto = new ContactoDTO(
												c.getId(),
												c.getCanal(),
												c.getFecha(),
												c.getMensaje(),
												c.getOportunidad().getId(),
												c.getCliente().getId()
					);
			contactos_return.add(contactoDto);
		}
		
		return new ResponseEntity(contactos_return,HttpStatus.OK);
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<Object> postFactura(@RequestBody ContactoDTO contactoDto){
		
		ContactoDTO contacto_return= null;
		
		Contacto contacto_persistido = contactoService.insertarContacto(
					new Contacto(
							contactoDto.getCanal(),
							contactoDto.getFecha(),
							contactoDto.getMensaje()
							)
				);
		
		contacto_return = new ContactoDTO(
				contacto_persistido.getId(),
				contacto_persistido.getCanal(),
				contacto_persistido.getFecha(),
				contacto_persistido.getMensaje()
				);
		
		if(contactoDto.getCliente_id()!=null) {
			Cliente cliente = clienteService.findClienteById(contactoDto.getCliente_id());
			
			cliente.addContacto(contacto_persistido);
			clienteService.insertarCliente(cliente);
			contacto_return.setCliente_id(cliente.getId());
			
		}
		if(contactoDto.getOportunidad_id()!=null) {
			Oportunidad oportunidad= oportunidadService.findOportunidadById(contactoDto.getOportunidad_id());
			oportunidad.addContacto(contacto_persistido);
			oportunidadService.insertarOportunidad(oportunidad);
			contacto_return.setOportunidad_id(oportunidad.getId());
		}
		
		return new ResponseEntity<>(contacto_return,HttpStatus.OK);
	}
	
}