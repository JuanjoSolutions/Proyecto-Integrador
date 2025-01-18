package com.integral.proyectointegrador.mars.repository;

import com.integral.proyectointegrador.magic.model.Spell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarsSensorDataRepository extends JpaRepository<Spell, Long> {}
