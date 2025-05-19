package com.msmaterialdidactico.msmaterialdidactico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msmaterialdidactico.msmaterialdidactico.service.MaterialService;

@RestController
@RequestMapping("/api/v1/materiales")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    /*@GetMapping
    public ResponseEntity<List<Material>> listarMateriales() {
        List<Material> materiales = materialService.findAll();
        if(materiales.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(materiales, HttpStatus.OK);
    }*/

    @GetMapping
    public ResponseEntity<List<Material>> listarMateriales() {
        List<Material> materiales = materialService.findAll();
        if(materiales.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(materiales, HttpStatus.OK);
    }


}
