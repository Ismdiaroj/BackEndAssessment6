package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ContactoDTO;
import com.example.demo.dtos.OportunidadDTO;
import com.example.demo.models.Cliente;
import com.example.demo.models.Contacto;
import com.example.demo.models.Oportunidad;
import com.example.demo.services.ClienteService;
import com.example.demo.services.ContactoService;
import com.example.demo.services.OportunidadService;

@RestController
@RequestMapping("/oportunidad")
@CrossOrigin("http://localhost:3000")
public class OportunidadController {
	
	@Autowired
	ContactoService contactoService;
	
	@Autowired
	OportunidadService oportunidadService;
	
	
	@GetMapping(value="/get-all")
	public ResponseEntity<?> getAllOportunidades(){
		
		List<OportunidadDTO> oportunidades_return = new ArrayList<>();
		List<Oportunidad> oportunidades_persistidas = oportunidadService.getAllOportunidades();
		
		for(Oportunidad o : oportunidades_persistidas) {
			OportunidadDTO oportunidadDto = new OportunidadDTO(
												o.getId(),
												o.getName(),
												o.getEmail(),
												o.getTelefono(),
												o.getDescripcion(),
												o.getAprobada()
//												,o.getCliente().getId()
					);
			oportunidades_return.add(oportunidadDto);
		}
		
		return new ResponseEntity(oportunidades_return,HttpStatus.OK);
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<Object> postOportunidad(@RequestBody OportunidadDTO oportunidadDto){
		
		OportunidadDTO oportunidad_return= null;
		
		Oportunidad oportunidad_persistida = oportunidadService.insertarOportunidad(
					new Oportunidad(	
							oportunidadDto.getName(),
							oportunidadDto.getEmail(),
							oportunidadDto.getTelefono(),
							oportunidadDto.getDescripcion(),
							oportunidadDto.getAprobada()
							)
						
				);
		
		oportunidad_return = new OportunidadDTO(
				oportunidad_persistida.getId(),
				oportunidad_persistida.getName(),
				oportunidad_persistida.getEmail(),
				oportunidad_persistida.getTelefono(),
				oportunidad_persistida.getDescripcion(),
				oportunidad_persistida.getAprobada());
	
		
		return new ResponseEntity<>(oportunidad_return,HttpStatus.OK);
	}

}
