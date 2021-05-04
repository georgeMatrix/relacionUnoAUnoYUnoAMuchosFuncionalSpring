package com.formatoweb.relacionesunounoyunomuchos.converter;

import com.formatoweb.relacionesunounoyunomuchos.entity.Cliente;
import com.formatoweb.relacionesunounoyunomuchos.entity.DatosFiscales;
import com.formatoweb.relacionesunounoyunomuchos.models.DatosFiscalesModel;
import org.springframework.stereotype.Component;

@Component
public class DatosFiscalesConverter {
    public DatosFiscales modelToEntity(DatosFiscalesModel datosFiscalesModel){
        DatosFiscales datosFiscales = new DatosFiscales();
        datosFiscales.setId(datosFiscalesModel.getId());
        datosFiscales.setRfc(datosFiscalesModel.getRfc());
        datosFiscales.setCurp(datosFiscalesModel.getCurp());
        return datosFiscales;
    }
}
