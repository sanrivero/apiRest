package com.example.api.services;

import com.example.api.entities.Cliente;
import com.example.api.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClienteServiceImpl implements IClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
