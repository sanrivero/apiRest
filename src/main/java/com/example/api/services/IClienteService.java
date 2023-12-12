package com.example.api.services;

import com.example.api.dto.response.ClienteResponseDTO;
import com.example.api.entities.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> listClientes();

    public Cliente saveCliente(Cliente cliente);

    public ClienteResponseDTO getClienteById(Long id);

    public void deleteCliente(Long id);


}
