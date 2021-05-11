package com.formatoweb.relacionesunounoyunomuchos.controller;

import com.formatoweb.relacionesunounoyunomuchos.converter.ProvedorConverter;
import com.formatoweb.relacionesunounoyunomuchos.entity.Provedor;
import com.formatoweb.relacionesunounoyunomuchos.service.provedor.ProvedorService;
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
public class ProvedorController {
    @Autowired
    private ProvedorService provedorService;

    @Autowired
    private ProvedorConverter provedorConverter;

    @GetMapping("/provedor")
    public List<Provedor> getProvedores(){
        return provedorService.provedores();
    }

    @PostMapping("/provedor")
    public ResponseEntity<?> saveProvedor(@RequestBody Provedor provedor){
        Map<String, Object> response = new HashMap<>();
        Provedor provedorNuevo;
        try{
            provedorNuevo = provedorService.saveProvedor(provedor);
        }catch (DataAccessException e){
            response.put("message", "there is a problem to save record in the database");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Record saved correctly!");
        response.put("record", provedorNuevo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/provedor/{id}")
    public ResponseEntity<?> getProvedorById(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        Provedor provedorById;
        try{
            provedorById = provedorService.provedorById(id);
        }catch (DataAccessException e){
            response.put("message", "there is a problem with the database");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(provedorById == null){
            response.put("message", "Record not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("message", "the record was found correctly");
        response.put("record", provedorConverter.entityToModel(provedorById));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/provedor/{id}")
    public ResponseEntity<?> updateProvedor(@RequestBody Provedor provedorNew, @PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        Provedor provedorOld;
        try{
            provedorOld = provedorService.provedorById(id);
            provedorOld.setId(provedorNew.getId());
            provedorOld.setNombre(provedorNew.getNombre());
            provedorOld.setApellido(provedorNew.getApellido());
            provedorOld.setEdad(provedorNew.getEdad());
            provedorOld.setEmail(provedorNew.getEmail());
            provedorService.saveProvedor(provedorOld);
            provedorConverter.entityToModel(provedorOld);
        }catch (DataAccessException e){
            response.put("message", "there is a problem with the database");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            response.put("message", "Record update!");
            response.put("record", provedorOld.getNombre());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
