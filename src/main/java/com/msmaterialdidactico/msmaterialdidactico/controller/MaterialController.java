package com.msmaterialdidactico.msmaterialdidactico.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        Material buscar = materialService.findById(material.getIdMaterial());
        if(buscar == null) {
            Material nuevoMaterial = materialService.save(material);
            return new ResponseEntity<>(nuevoMaterial, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{idMaterial}")
    public ResponseEntity<Material> readMaterial(@PathVariable int idMaterial) {
        Material buscarMaterial = materialService.findById(idMaterial);
        if(buscarMaterial != null) {
            return new ResponseEntity<>(buscarMaterial, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{idMaterial}")
    public ResponseEntity<Material> updateMaterial(@PathVariable int idMaterial, @RequestBody Material material) {
        if(materialService.update(idMaterial, material)) {
            return new ResponseEntity<>(material, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idMaterial}")
    public ResponseEntity<?> deleteMaterial(@PathVariable int idMaterial) {
        Material buscar = materialService.findById(idMaterial);
        if(buscar != null) {
            materialService.deleteById(idMaterial);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{idMaterial}/modificar/visibilidad")
    public ResponseEntity<?> cambiarVisibilidad(@PathVariable int idMaterial) {
        if(materialService.cambiarVisibilidad(idMaterial)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{idMaterial}/activar")
    public ResponseEntity<?> cambiarEstadoActivo(@PathVariable int idMaterial) {
        if(materialService.activar(idMaterial)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
