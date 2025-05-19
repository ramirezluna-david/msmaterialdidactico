package com.msmaterialdidactico.msmaterialdidactico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msmaterialdidactico.msmaterialdidactico.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer>{

    Material save(Material material);

    void deleteById(int idMaterial);

    List<Material> findAll();

    Material findById(int idMaterial);
}
