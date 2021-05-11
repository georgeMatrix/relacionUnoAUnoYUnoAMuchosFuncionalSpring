package com.formatoweb.relacionesunounoyunomuchos.controller;

import com.formatoweb.relacionesunounoyunomuchos.converter.ClienteConverter;
import com.formatoweb.relacionesunounoyunomuchos.entity.Cliente;
import com.formatoweb.relacionesunounoyunomuchos.models.ClienteModel;
import com.formatoweb.relacionesunounoyunomuchos.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteConverter clienteConverter;

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return clienteService.clientes();
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> saveCliente(@RequestBody Cliente cliente){
        Map<String, Object> response = new HashMap<>();
        Cliente clienteNuevo;
        try{
            clienteNuevo = clienteService.saveCliente(cliente);
        }catch (DataAccessException e){
            response.put("message", "there is a problem to save record in the database");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Record saved correctly!");
        response.put("record", clienteNuevo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        Cliente clienteById;
        try{
            clienteById = clienteService.clienteById(id);
        }catch (DataAccessException e){
            response.put("message", "there is a problem with the database");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(clienteById == null){
            response.put("message", "Record not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("message", "the record was found correctly");
        response.put("record", clienteConverter.entityToModel(clienteById));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> updateCliente(@RequestBody Cliente clienteNew, @PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        Cliente clienteOld;
        try{
            clienteOld = clienteService.clienteById(id);
            clienteOld.setId(clienteNew.getId());
            clienteOld.setNombre(clienteNew.getNombre());
            clienteOld.setApellido(clienteNew.getApellido());
            clienteOld.setEdad(clienteNew.getEdad());
            clienteOld.setEmail(clienteNew.getEmail());
            clienteService.saveCliente(clienteOld);
            clienteConverter.entityToModel(clienteOld);
        }catch (DataAccessException e){
            response.put("message", "there is a problem with the database");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        if (clienteOld == null){
//            response.put("message", "Record not found");
//            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//        }
            response.put("message", "Record found");
            response.put("record", clienteOld);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
