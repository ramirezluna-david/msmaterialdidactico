package com.msmaterialdidactico.msmaterialdidactico.controller;

import java.util.List;
import java.util.Map;

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

import com.msmaterialdidactico.msmaterialdidactico.model.Evaluacion;
import com.msmaterialdidactico.msmaterialdidactico.service.EvaluacionService;

@RestController
@RequestMapping("/api/v1/evaluaciones")
public class EvaluacionController {
    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping
    public ResponseEntity<List<Evaluacion>> listarEvaluaciones() {
        List<Evaluacion> evaluaciones = evaluacionService.findAll();
        if(evaluaciones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(evaluaciones, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Evaluacion> createEvaluacion(@RequestBody Evaluacion evaluacion) {
        Evaluacion buscar = evaluacionService.findById(evaluacion.getIdEv());
        if(buscar == null) {
            Evaluacion nuevaEvaluacion = evaluacionService.save(evaluacion);
            return new ResponseEntity<>(nuevaEvaluacion, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{idEv}")
    public ResponseEntity<Evaluacion> readEvaluacion(@PathVariable int idEv) {
        Evaluacion buscarEv = evaluacionService.findById(idEv);
        if(buscarEv != null) {
            return new ResponseEntity<>(buscarEv, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{idEv}")
    public ResponseEntity<Evaluacion> updateEvaluacion(@PathVariable int idEv, @RequestBody Evaluacion evaluacion) {
        if(evaluacionService.update(idEv, evaluacion)) {
            return new ResponseEntity<>(evaluacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idEv}")
    public ResponseEntity<?> deleteEvaluacion(@PathVariable int idEv) {
        Evaluacion buscar = evaluacionService.findById(idEv);
        if(buscar != null) {
            evaluacionService.deleteById(idEv);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{idEv}/modificar/corregir")
    public ResponseEntity<?> corregirEvaluacion(@PathVariable int idEv, @RequestBody Map<String, String> update) {
        //Evaluacion buscarEv = evaluacionService.findById(idEv);
        String estado = update.get("estado");
        if(evaluacionService.corregirEvaluacion(idEv, estado)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
