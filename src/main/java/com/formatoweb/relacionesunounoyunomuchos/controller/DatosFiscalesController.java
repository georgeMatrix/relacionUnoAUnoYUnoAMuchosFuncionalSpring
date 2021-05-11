package com.formatoweb.relacionesunounoyunomuchos.controller;

import com.formatoweb.relacionesunounoyunomuchos.converter.DatosFiscalesConverter;
import com.formatoweb.relacionesunounoyunomuchos.entity.DatosFiscales;
import com.formatoweb.relacionesunounoyunomuchos.models.DatosFiscalesModel;
import com.formatoweb.relacionesunounoyunomuchos.service.datosFiscales.DatosFiscalesService;
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
public class DatosFiscalesController {
    @Autowired
    private DatosFiscalesService datosFiscalesService;

    @Autowired
    private DatosFiscalesConverter datosFiscalesConverter;

    @GetMapping("/datos-fiscales")
    public List<DatosFiscales> getDatosFiscales(){
        return datosFiscalesService.datosFiscalesList();
    }

    @PostMapping("/datos-fiscales")
    public ResponseEntity<?> saveDatosFiscales(@RequestBody DatosFiscalesModel datosFiscalesModel){
        Map<String, Object> response = new HashMap<>();
        try{
            DatosFiscales datosFiscales = datosFiscalesConverter.modelToEntity(datosFiscalesModel);
            datosFiscalesService.saveDatosFiscales(datosFiscales);
        }catch (DataAccessException e){
            response.put("mensaje", "hubo algun error al insertar dato");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Su dato fue insertado correctamente en la base de datos");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/datos-fiscales/{id}")
    public DatosFiscalesModel getDatosFiscalesById(@PathVariable Long id){
        return datosFiscalesConverter.entityToModel(datosFiscalesService.getDatosFiscalesById(id));
    }

    @PutMapping("datos-fiscales/{id}")
    public DatosFiscalesModel updateDatosFiscales(@RequestBody DatosFiscalesModel datosFiscalesModelNew, @PathVariable Long id){
        DatosFiscales datosFiscalesOld = datosFiscalesService.getDatosFiscalesById(id);
        datosFiscalesOld.setId(datosFiscalesModelNew.getId());
        datosFiscalesOld.setRfc(datosFiscalesModelNew.getRfc());
        datosFiscalesOld.setCurp(datosFiscalesModelNew.getCurp());
        return datosFiscalesConverter.entityToModel(datosFiscalesService.saveDatosFiscales(datosFiscalesOld));
    }
}
