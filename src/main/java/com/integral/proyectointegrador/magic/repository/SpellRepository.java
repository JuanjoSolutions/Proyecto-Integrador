package com.integral.proyectointegrador.magic.repository;

import com.integral.proyectointegrador.magic.model.Spell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellRepository extends JpaRepository<Spell, Long> {}

