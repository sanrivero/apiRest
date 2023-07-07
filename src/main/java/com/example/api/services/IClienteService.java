package com.example.api.services;

import com.example.api.entities.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> listClientes();

    public Cliente saveCliente(Cliente cliente);

    public Cliente getClienteById(Long id);

    public void deleteCliente(Long id);


}
