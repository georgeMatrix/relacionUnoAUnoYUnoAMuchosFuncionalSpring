package com.formatoweb.relacionesunounoyunomuchos.controller;

import com.formatoweb.relacionesunounoyunomuchos.entity.Cliente;
import com.formatoweb.relacionesunounoyunomuchos.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return clienteService.clientes();
    }

    @PostMapping("/clientes")
    public Cliente saveCliente(@RequestBody Cliente cliente){
        return clienteService.saveCliente(cliente);
    }
}
