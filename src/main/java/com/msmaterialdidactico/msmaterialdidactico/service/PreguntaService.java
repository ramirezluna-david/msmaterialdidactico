package com.msmaterialdidactico.msmaterialdidactico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msmaterialdidactico.msmaterialdidactico.model.Pregunta;
import com.msmaterialdidactico.msmaterialdidactico.repository.PreguntaRepository;

@Service
public class PreguntaService {
    @Autowired
    private PreguntaRepository preguntaRepository;

    public Pregunta save(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public List<Pregunta> findAll() {
        return preguntaRepository.findAll();
    }

    public Pregunta findById(int idPregunta) {
        return preguntaRepository.findById(idPregunta);
    }

    public void deleteById(int idPregunta) {
        preguntaRepository.deleteById(idPregunta);
    }
}
