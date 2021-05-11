package com.formatoweb.relacionesunounoyunomuchos.service.provedor;

import com.formatoweb.relacionesunounoyunomuchos.entity.Provedor;

import java.util.List;

public interface ProvedorService {
    List<Provedor> provedores();
    Provedor saveProvedor(Provedor provedor);
    Provedor provedorById(Long id);
}
