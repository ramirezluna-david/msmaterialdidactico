package com.msmaterialdidactico.msmaterialdidactico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msmaterialdidactico.msmaterialdidactico.model.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {

    Pregunta save(Pregunta pregunta);

    List<Pregunta> findAll();

    Pregunta findById(int idPregunta);

    void deleteById(int idPregunta);
}
