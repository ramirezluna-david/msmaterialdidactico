package com.msmaterialdidactico.msmaterialdidactico.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "material")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMaterial;

    @Column(nullable = false)
    private int idClase;

    @Column(length = 50, nullable = false)
    private String descripcion;

    @Column(length = 50, nullable = false)
    private String tipoMaterial;

    @Column(length = 50, nullable = false)
    private String url;

    @Column(nullable = false )
    private LocalDate fechaSubida;

    @Column(length = 50, nullable = false)
    private String nombreArchivo;

    @Column(length = 50, nullable = false)
    private String tipoArchivo;

    @Column(nullable = false)
    private Boolean publicado;
}
