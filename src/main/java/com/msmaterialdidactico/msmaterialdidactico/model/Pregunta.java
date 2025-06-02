package com.msmaterialdidactico.msmaterialdidactico.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pregunta")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPregunta;

    @Column(length = 100, nullable = false)
    private String enunciado;

    @Column(nullable = false)
    private int puntaje;

    @ManyToOne()
    @JoinColumn(name = "idEv")
    @JsonBackReference
    private Evaluacion evaluacion;
}
