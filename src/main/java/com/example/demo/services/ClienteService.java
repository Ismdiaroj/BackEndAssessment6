package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Cliente;

public interface ClienteService {
	
	public Cliente findClienteById(Long id);
	
	public List<Cliente> getAllClientes();
	
	public Cliente findClienteByEmail(String email);
	
	public Cliente insertarCliente(Cliente cliente);
	
	public Cliente actualizarCliente(Cliente cliente);
	
	public boolean borrarCliente(Cliente cliente); 

}
