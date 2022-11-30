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
												c.id(),
												c.canal(),
												c.fecha(),
												c.mensaje(),
												c.oportunidad().id(),
												c.cliente().id()
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
							contactoDto.canal(),
							contactoDto.fecha(),
							contactoDto.mensaje()
							)
				);
		
		contacto_return = new ContactoDTO(
				contacto_persistido.id(),
				contacto_persistido.canal(),
				contacto_persistido.fecha(),
				contacto_persistido.mensaje(),
				contacto_persistido.cliente().id(),
				contacto_persistido.oportunidad().id()
				
				);
		
		if(contactoDto.cliente_id()!=null) {
			Cliente cliente = clienteService.findClienteById(contactoDto.cliente_id());
			
			cliente.addContacto(contacto_persistido);
			clienteService.insertarCliente(cliente);
			contacto_return.cliente_id(cliente.id());
			
		}
		if(contactoDto.oportunidad_id()!=null) {
			Oportunidad oportunidad= oportunidadService.findOportunidadById(contactoDto.oportunidad_id());
			oportunidad.addContacto(contacto_persistido);
			oportunidadService.insertarOportunidad(oportunidad);
			contacto_return.oportunidad_id(oportunidad.id());
		}
		
		return new ResponseEntity<>(contacto_return,HttpStatus.OK);
	}
	
}





















