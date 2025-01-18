package com.integral.proyectointegrador.jurassic.repository;

import com.integral.proyectointegrador.jurassic.model.DinosaurSensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DinosaurSensorDataRepository extends JpaRepository<DinosaurSensorData, Long> {
    List<DinosaurSensorData> findByDinosaurId(String dinosaurId);
}

