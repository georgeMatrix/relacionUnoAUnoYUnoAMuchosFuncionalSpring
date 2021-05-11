package com.formatoweb.relacionesunounoyunomuchos.service.producto;

import com.formatoweb.relacionesunounoyunomuchos.entity.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> productos();
    Producto saveProducto(Producto producto);
    Producto getProductoById(Long id);
}
