package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Cliente;
import com.example.demo.models.Oportunidad;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	public Optional<Cliente> findByEmail(String email);
}
