package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Cliente;
import com.example.demo.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public Cliente findClienteById(Long id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public List<Cliente> getAllClientes() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public Cliente insertarCliente(Cliente cliente) {
		if (cliente != null && cliente.id() == null && findClienteByEmail(cliente.email()) == null 
				&& findClienteByEmail(cliente.email()) == null)
			return clienteRepository.save(cliente);			
		else
			return null;
	}


	@Override
	public Cliente actualizarCliente(Cliente cliente) {
		if (cliente == null || cliente.id() == null)
			return null;
		else
			return clienteRepository.save(cliente); 	
	}

	@Override
	public boolean borrarCliente(Cliente cliente) {
		if (cliente != null && cliente.id() != null) {
			clienteRepository.delete(cliente);
			return true;
		} else
			return false;
	}

	@Override
	public Cliente findClienteByEmail(String email) {
		return clienteRepository.findByEmail(email).orElse(null);
	}

}
