package com.formatoweb.relacionesunounoyunomuchos.converter;

import com.formatoweb.relacionesunounoyunomuchos.entity.Cliente;
import com.formatoweb.relacionesunounoyunomuchos.models.ClienteModel;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter {
    public ClienteModel entityToModel(Cliente cliente){
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setId(cliente.getId());
        clienteModel.setNombre(cliente.getNombre());
        clienteModel.setApellido(cliente.getApellido());
        clienteModel.setEdad(cliente.getEdad());
        clienteModel.setEdad(cliente.getEdad());
        clienteModel.setEmail(cliente.getEmail());
        return clienteModel;
    }
}
