package com.data.models;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "breed")
public class Breed {
    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "name", length = 150)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "species_id", nullable = false)
    private com.data.models.Species species;

    @Column(name="species_id",insertable=false, updatable=false)
    private String speciesId;

    @OneToMany(mappedBy = "breed")
    private Set<com.data.models.Pet> pets = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciesId() {return speciesId;}

    public void setSpeciesId(String speciesId) {this.speciesId = speciesId;}
    public com.data.models.Species getSpecies() {
        return species;
    }

    public void setSpecies(com.data.models.Species species) {
        this.species = species;
    }

    public Set<com.data.models.Pet> getPets() {
        return pets;
    }

    public void setPets(Set<com.data.models.Pet> pets) {
        this.pets = pets;
    }

}