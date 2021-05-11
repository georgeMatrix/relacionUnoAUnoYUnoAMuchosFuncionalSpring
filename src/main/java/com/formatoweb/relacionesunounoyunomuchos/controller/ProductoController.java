package com.formatoweb.relacionesunounoyunomuchos.controller;

import com.formatoweb.relacionesunounoyunomuchos.converter.ProductoConverter;
import com.formatoweb.relacionesunounoyunomuchos.entity.Provedor;
import com.formatoweb.relacionesunounoyunomuchos.entity.Producto;
import com.formatoweb.relacionesunounoyunomuchos.models.ProductoModel;
import com.formatoweb.relacionesunounoyunomuchos.service.producto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoConverter productoConverter;

    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return productoService.productos();
    }

    @PostMapping("/productos")
    public Producto saveProducto(@RequestBody ProductoModel productoModel){
        Producto producto = productoConverter.modelToEntity(productoModel);
        return productoService.saveProducto(producto);
    }

    @GetMapping("/productos/{id}")
    public ProductoModel getProductoById(@PathVariable Long id){
        return productoConverter.entityToModel(productoService.getProductoById(id));
    }

    @PutMapping("/productos/{id}")
    public ProductoModel updateProducto(@PathVariable Long id, @RequestBody ProductoModel productoModelNew){
        Producto prodcutoOld = productoService.getProductoById(id);
        prodcutoOld.setId(productoModelNew.getId());
        prodcutoOld.setNombre(productoModelNew.getNombre());
        prodcutoOld.setClave(productoModelNew.getClave());
        prodcutoOld.setPrecio(productoModelNew.getPrecio());
        Provedor provedor = new Provedor();
        provedor.setId(productoModelNew.getIdProvedor());
        prodcutoOld.setProvedor(provedor);
        productoService.saveProducto(prodcutoOld);
        return productoConverter.entityToModel(prodcutoOld);
    }
}
