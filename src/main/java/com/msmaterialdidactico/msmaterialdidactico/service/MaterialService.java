package com.msmaterialdidactico.msmaterialdidactico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.msmaterialdidactico.msmaterialdidactico.model.Material;
import com.msmaterialdidactico.msmaterialdidactico.repository.MaterialRepository;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public Material save(Material material) {
        return materialRepository.save(material);
    }

    public Material findById(int idMaterial) {
        return materialRepository.findById(idMaterial);
    }

    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    public void deleteById(int idMaterial) {
        materialRepository.deleteById(idMaterial);
    }

    public Boolean cambiarVisibilidad(int idMaterial) {
        Material buscarMaterial = materialRepository.findById(idMaterial);
        if(buscarMaterial != null) {
            buscarMaterial.setPublicado((!buscarMaterial.getPublicado()));
            materialRepository.save(buscarMaterial);
            return true;
        }

        return false;
    }

    public Boolean update(int idMaterial, Material material) {
        Material mat = materialRepository.findById(idMaterial);
        if(mat != null) {
            mat.setIdMaterial(idMaterial);
            mat.setIdClase(material.getIdClase());
            mat.setDescripcion(material.getDescripcion());
            mat.setTipoMaterial(material.getTipoMaterial());
            mat.setUrl(material.getUrl());
            mat.setFechaSubida(material.getFechaSubida());
            mat.setNombreArchivo(material.getNombreArchivo());
            mat.setTipoArchivo(material.getTipoArchivo());
            mat.setPublicado(material.getPublicado());

            materialRepository.save(mat);
            return true;
        } else {
            return false;
        }
    }
}
