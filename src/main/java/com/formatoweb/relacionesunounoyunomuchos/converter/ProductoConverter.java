package com.formatoweb.relacionesunounoyunomuchos.converter;

import com.formatoweb.relacionesunounoyunomuchos.entity.Cliente;
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
        Cliente cliente = new Cliente();
        cliente.setId(productomodel.getIdCliente());
        producto.setCliente(cliente);
        return producto;
    }
}