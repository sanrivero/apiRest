package com.example.api.controllers;

import com.example.api.entities.Cliente;
import com.example.api.services.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    ClienteServiceImpl clienteService;

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return clienteService.listClientes();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
        Cliente cliente1 = clienteService.saveCliente(cliente);
        return new ResponseEntity<>(cliente1, HttpStatus.CREATED);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
        Cliente cliente1 = clienteService.getClienteById(id);
        return ResponseEntity.ok(cliente1);
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        Cliente cliente1 = clienteService.getClienteById(id);
        cliente1.setNombre(cliente.getNombre());
        cliente1.setApellido(cliente.getApellido());
        cliente1.setEmail(cliente.getEmail());

        Cliente clienteUpd = clienteService.saveCliente(cliente1);
        return new ResponseEntity<>(clienteUpd,HttpStatus.CREATED);
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<HashMap<String, Boolean>> deleteCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);

        HashMap<String, Boolean> estadoCliente = new HashMap<>();
        estadoCliente.put("eliminado", true);

        return ResponseEntity.ok(estadoCliente);
    }

}
