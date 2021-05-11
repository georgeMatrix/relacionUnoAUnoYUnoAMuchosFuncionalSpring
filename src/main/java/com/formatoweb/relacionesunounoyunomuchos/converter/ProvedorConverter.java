package com.formatoweb.relacionesunounoyunomuchos.converter;

import com.formatoweb.relacionesunounoyunomuchos.entity.Provedor;
import com.formatoweb.relacionesunounoyunomuchos.models.ProvedorModel;
import org.springframework.stereotype.Component;

@Component
public class ProvedorConverter {
    public ProvedorModel entityToModel(Provedor provedor){
        ProvedorModel provedorModel = new ProvedorModel();
        provedorModel.setId(provedor.getId());
        provedorModel.setNombre(provedor.getNombre());
        provedorModel.setApellido(provedor.getApellido());
        provedorModel.setEdad(provedor.getEdad());
        provedorModel.setEdad(provedor.getEdad());
        provedorModel.setEmail(provedor.getEmail());
        return provedorModel;
    }
}
