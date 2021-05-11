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
        datosFiscales.setBandera(datosFiscalesModel.getId());
        return datosFiscales;
    }

    public DatosFiscalesModel entityToModel(DatosFiscales datosFiscales){
        DatosFiscalesModel datosFiscalesModel = new DatosFiscalesModel();
        datosFiscalesModel.setId(datosFiscales.getId());
        datosFiscalesModel.setCurp(datosFiscales.getCurp());
        datosFiscalesModel.setRfc(datosFiscales.getRfc());
        datosFiscalesModel.setBandera(datosFiscales.getId());
        return datosFiscalesModel;
    }
}
