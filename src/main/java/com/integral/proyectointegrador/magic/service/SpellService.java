package com.integral.proyectointegrador.magic.service;

import com.integral.proyectointegrador.magic.model.Spell;
import com.integral.proyectointegrador.magic.repository.SpellRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SpellService {
    private final SpellRepository spellRepository;
    public SpellService(SpellRepository spellRepository) {
        this.spellRepository = spellRepository;
    }
    public Spell createSpell(Spell spell) {
        return spellRepository.save(spell);
    }
    public List<Spell> getAllSpells() {
        return spellRepository.findAll();
    }
    public Optional<Spell> getSpellById(Long id) {
        return spellRepository.findById(id);
    }
}

