package com.msmaterialdidactico.msmaterialdidactico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
