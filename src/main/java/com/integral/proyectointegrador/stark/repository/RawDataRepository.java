package com.integral.proyectointegrador.stark.repository;

import com.integral.proyectointegrador.stark.model.RawDataRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawDataRepository extends JpaRepository<RawDataRecord, Long> {

}

