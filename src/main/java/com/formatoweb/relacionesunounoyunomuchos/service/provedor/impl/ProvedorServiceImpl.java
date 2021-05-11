package com.formatoweb.relacionesunounoyunomuchos.service.provedor.impl;

import com.formatoweb.relacionesunounoyunomuchos.entity.Provedor;
import com.formatoweb.relacionesunounoyunomuchos.repository.ProvedorRepository;
import com.formatoweb.relacionesunounoyunomuchos.service.provedor.ProvedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvedorServiceImpl implements ProvedorService {
    @Autowired
    private ProvedorRepository provedorRepository;

    @Override
    public List<Provedor> provedores() {
        return provedorRepository.findAll();
    }

    @Override
    public Provedor saveProvedor(Provedor provedor) {
        return provedorRepository.save(provedor);
    }

    @Override
    public Provedor provedorById(Long id) {
        return provedorRepository.findById(id).orElse(null);
    }
}
