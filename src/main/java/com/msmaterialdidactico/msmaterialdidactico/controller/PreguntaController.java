package com.msmaterialdidactico.msmaterialdidactico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msmaterialdidactico.msmaterialdidactico.model.Evaluacion;
import com.msmaterialdidactico.msmaterialdidactico.model.Pregunta;
import com.msmaterialdidactico.msmaterialdidactico.service.EvaluacionService;
import com.msmaterialdidactico.msmaterialdidactico.service.PreguntaService;

@RestController
@RequestMapping("/api/v1/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping
    public ResponseEntity<List<Pregunta>> listarPreguntas() {
        List<Pregunta> preguntas = preguntaService.findAll();
        if(preguntas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(preguntas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pregunta> createPregunta(@RequestBody Pregunta pregunta) {
        int idLink = pregunta.getEvaluacion().getIdEv();
        Evaluacion evaluacion = evaluacionService.evaluacionxId(idLink);
        if(evaluacion != null) {
            pregunta.setEvaluacion(evaluacion);
        }

        Pregunta buscar = preguntaService.findById(pregunta.getIdPregunta());
        if(buscar == null) {
            Pregunta nuevaPregunta = preguntaService.save(pregunta);
            return new ResponseEntity<>(nuevaPregunta, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
