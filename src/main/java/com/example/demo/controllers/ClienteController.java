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

import com.example.demo.dtos.ClienteDTO;
import com.example.demo.dtos.OportunidadDTO;
import com.example.demo.models.Cliente;
import com.example.demo.models.Oportunidad;
import com.example.demo.services.ClienteService;
import com.example.demo.services.ContactoService;
import com.example.demo.services.OportunidadService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	OportunidadService oportunidadService;
	
	@Autowired
	ClienteService clienteService;
	
	
	@GetMapping(value="/get-all")
	public ResponseEntity<?> getAllClientes(){
		
		List<ClienteDTO> clientes_return = new ArrayList<>();
		List<Cliente> clientes_persistidos = clienteService.getAllClientes();
		
		for(Cliente c : clientes_persistidos) {
			ClienteDTO clienteDto = new ClienteDTO(
												c.getId(),
												c.getName(),
												c.getEmail(),
												c.getTelefono(),
												c.getContrato(),
												c.getOportunidad().getId()
					);
			clientes_return.add(clienteDto);
		}
		
		return new ResponseEntity(clientes_return,HttpStatus.OK);
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<Object> postOportunidad(@RequestBody ClienteDTO clienteDto){
		
		ClienteDTO cliente_return= null;
		
		Oportunidad oportunidad = oportunidadService.findOportunidadById(clienteDto.getOportunidad_id());
		
		Cliente cliente_persistido = clienteService.insertarCliente(
					new Cliente(
							clienteDto.getName(),
							clienteDto.getEmail(),
							clienteDto.getTelefono(),
							clienteDto.getContrato()							
							)
						
				);
		
		cliente_return = new ClienteDTO(
				cliente_persistido.getId(),
				cliente_persistido.getName(),
				cliente_persistido.getEmail(),
				cliente_persistido.getTelefono(),
				cliente_persistido.getContrato()
				);
		
		oportunidad.setCliente(cliente_persistido);
		oportunidadService.insertarOportunidad(oportunidad);
		cliente_return.setOportunidad_id(oportunidad.getId());
				
	
		
		return new ResponseEntity<>(cliente_return,HttpStatus.OK);
	}

}
