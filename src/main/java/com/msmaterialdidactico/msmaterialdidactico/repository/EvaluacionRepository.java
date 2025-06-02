package com.msmaterialdidactico.msmaterialdidactico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msmaterialdidactico.msmaterialdidactico.model.Evaluacion;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Integer>{

    Evaluacion findById(int idEvaluacion);

    void deleteById(int idEvaluacion);

    Evaluacion getReferenceById(int idEv);
}
