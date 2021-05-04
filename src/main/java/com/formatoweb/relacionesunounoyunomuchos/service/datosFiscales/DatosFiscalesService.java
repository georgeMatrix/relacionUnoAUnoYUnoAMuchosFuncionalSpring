package com.formatoweb.relacionesunounoyunomuchos.service.datosFiscales;

import com.formatoweb.relacionesunounoyunomuchos.entity.DatosFiscales;

import java.util.List;

public interface DatosFiscalesService {
    List<DatosFiscales> datosFiscalesList();
    DatosFiscales saveDatosFiscales(DatosFiscales datosFiscales);
}
