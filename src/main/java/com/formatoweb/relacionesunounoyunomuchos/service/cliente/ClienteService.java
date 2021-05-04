package com.formatoweb.relacionesunounoyunomuchos.service.cliente;

import com.formatoweb.relacionesunounoyunomuchos.entity.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> clientes();
    Cliente saveCliente(Cliente cliente);
}
