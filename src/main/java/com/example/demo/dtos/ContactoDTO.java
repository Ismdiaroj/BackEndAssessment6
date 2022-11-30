package com.example.demo.dtos;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.models.Cliente;
import com.example.demo.models.Oportunidad;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Accessors(fluent = true)
public class ContactoDTO {
	

	private long id;
	
	private String canal;
	
	@NotNull(message = "Debe completar el campo fecha de inicio")
	@FutureOrPresent(message = "La fecha de inicio no puede ser anterior a la actual")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fecha;
	
	private String mensaje;
	
	private Long oportunidad_id;
	
	private Long cliente_id;

}
