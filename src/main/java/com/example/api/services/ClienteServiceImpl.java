package com.example.api.services;

import com.example.api.dto.mapper.ClienteMapper;
import com.example.api.dto.response.ClienteResponseDTO;
import com.example.api.entities.Cliente;
import com.example.api.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    ClienteMapper clienteMapper;

    @Override
    public List<Cliente> listClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public ClienteResponseDTO getClienteById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        return clienteMapper.mapper.clienteToResp(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
