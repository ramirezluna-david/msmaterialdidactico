package com.msmaterialdidactico.msmaterialdidactico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msmaterialdidactico.msmaterialdidactico.model.Material;
import com.msmaterialdidactico.msmaterialdidactico.service.MaterialService;

@RestController
@RequestMapping("/api/v1/materiales")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public ResponseEntity<List<Material>> listarMateriales() {
        List<Material> materiales = materialService.findAll();
        if(materiales.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(materiales, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Material> createMaterial(@RequestBody Material material) {
        Material nuevoMaterial = materialService.save(material);
        return new ResponseEntity<>(nuevoMaterial, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{idMaterial}")
    public ResponseEntity<Material> readMaterial(@PathVariable int idMaterial) {
        try {
            Material material = materialService.findById(idMaterial);
            return new ResponseEntity<>(material, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
