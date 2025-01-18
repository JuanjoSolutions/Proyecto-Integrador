package com.integral.proyectointegrador.magic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "spell")
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String effect;
    private int manaCost;

    public Spell() {
    }

    public Spell(String name, String effect, int manaCost) {
        this.name = name;
        this.effect = effect;
        this.manaCost = manaCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
}

