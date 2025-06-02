package com.msmaterialdidactico.msmaterialdidactico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msmaterialdidactico.msmaterialdidactico.model.Evaluacion;
import com.msmaterialdidactico.msmaterialdidactico.model.Evaluacion;
import com.msmaterialdidactico.msmaterialdidactico.repository.EvaluacionRepository;

@Service
public class EvaluacionService {
    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public Evaluacion save(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    public List<Evaluacion> findAll() {
        return evaluacionRepository.findAll();
    }

    public Evaluacion findById(int idEvaluacion) {
        return evaluacionRepository.findById(idEvaluacion);
    }

    public void deleteById(int idEvaluacion) {
        evaluacionRepository.deleteById(idEvaluacion);
    }

    public Boolean update(int idEv, Evaluacion evaluacion) {
        Evaluacion ev = evaluacionRepository.findById(idEv);
        if(ev != null) {
            ev.setIdEv(idEv);
            // ev.setIdClase(evaluacion.getIdClase());
            ev.setDescripcion(evaluacion.getDescripcion());
            ev.setTitulo(evaluacion.getTitulo());
            ev.setFechaCreacion(evaluacion.getFechaCreacion());
            ev.setFechaAplicacion(evaluacion.getFechaCreacion());

            evaluacionRepository.save(ev);
            return true;
        } else {
            return false;
        }
    }

    public Boolean corregirEvaluacion(int idEv, String estado) {
        Evaluacion buscarEv = evaluacionRepository.findById(idEv);
        if(buscarEv != null) {
            buscarEv.setEstado(estado);
            evaluacionRepository.save(buscarEv);
            return true;
        }

        return false;
    }
}
