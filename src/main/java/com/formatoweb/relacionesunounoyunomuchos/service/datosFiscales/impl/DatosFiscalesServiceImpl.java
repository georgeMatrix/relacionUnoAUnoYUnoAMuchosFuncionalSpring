package com.formatoweb.relacionesunounoyunomuchos.service.datosFiscales.impl;

import com.formatoweb.relacionesunounoyunomuchos.entity.DatosFiscales;
import com.formatoweb.relacionesunounoyunomuchos.repository.DatosFiscalesRepository;
import com.formatoweb.relacionesunounoyunomuchos.service.datosFiscales.DatosFiscalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatosFiscalesServiceImpl implements DatosFiscalesService {
    @Autowired
    private DatosFiscalesRepository datosFiscalesRepository;

    @Override
    public List<DatosFiscales> datosFiscalesList() {
        return datosFiscalesRepository.findAll();
    }

    @Override
    public DatosFiscales saveDatosFiscales(DatosFiscales datosFiscales) {
        return datosFiscalesRepository.save(datosFiscales);
    }

    @Override
    public DatosFiscales getDatosFiscalesById(Long id) {
        return datosFiscalesRepository.findById(id).orElse(null);
    }
}
