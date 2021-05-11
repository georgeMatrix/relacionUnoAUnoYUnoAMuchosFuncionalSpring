package com.formatoweb.relacionesunounoyunomuchos.service.producto.impl;

import com.formatoweb.relacionesunounoyunomuchos.entity.Producto;
import com.formatoweb.relacionesunounoyunomuchos.repository.ProductoRepository;
import com.formatoweb.relacionesunounoyunomuchos.service.producto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> productos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }
}
