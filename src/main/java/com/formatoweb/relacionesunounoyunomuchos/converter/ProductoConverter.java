package com.formatoweb.relacionesunounoyunomuchos.converter;

import com.formatoweb.relacionesunounoyunomuchos.entity.Provedor;
import com.formatoweb.relacionesunounoyunomuchos.entity.Producto;
import com.formatoweb.relacionesunounoyunomuchos.models.ProductoModel;
import org.springframework.stereotype.Component;

@Component
public class ProductoConverter {
    public Producto modelToEntity(ProductoModel productomodel){
        Producto producto = new Producto();
        producto.setId(productomodel.getId());
        producto.setClave(productomodel.getClave());
        producto.setNombre(productomodel.getNombre());
        producto.setPrecio(productomodel.getPrecio());
        Provedor provedor = new Provedor();
        provedor.setId(productomodel.getIdProvedor());
        producto.setProvedor(provedor);
        return producto;
    }
    public ProductoModel entityToModel(Producto producto){
        ProductoModel productoModel = new ProductoModel();
        productoModel.setId(producto.getId());
        productoModel.setClave(producto.getClave());
        productoModel.setNombre(producto.getNombre());
        productoModel.setPrecio(producto.getPrecio());
        productoModel.setIdProvedor(producto.getProvedor().getId());
        return productoModel;
    }
}
