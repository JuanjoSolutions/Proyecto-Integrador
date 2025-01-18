package com.integral.proyectointegrador.magic.controller;

import com.integral.proyectointegrador.magic.model.Spell;
import com.integral.proyectointegrador.magic.service.SpellService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/magic/spells")
public class SpellController {
    private final SpellService spellService;
    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }
    @PostMapping
    public ResponseEntity<Spell> createSpell(@RequestBody Spell spell) {
        Spell saved = spellService.createSpell(spell);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Spell>> getAllSpells() {
        return ResponseEntity.ok(spellService.getAllSpells());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Spell> getSpellById(@PathVariable Long id) {
        return spellService.getSpellById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
