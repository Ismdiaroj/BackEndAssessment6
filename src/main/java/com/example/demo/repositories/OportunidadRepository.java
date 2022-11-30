package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Oportunidad;

public interface OportunidadRepository extends JpaRepository<Oportunidad, Long> {

	public Oportunidad findByEmail(String email);
}
