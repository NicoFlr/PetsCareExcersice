package com.data.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "species")
public class Species {
    @Id
    @Access(AccessType.PROPERTY)
    @Size(max = 36)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Size(max = 150)
    @Column(name = "name", length = 150)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "species")
    private Set<com.data.models.Breed> breeds = new LinkedHashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "species")
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

    public Set<com.data.models.Breed> getBreeds() {
        return breeds;
    }

    public void setBreeds(Set<com.data.models.Breed> breeds) {
        this.breeds = breeds;
    }

    public Set<com.data.models.Pet> getPets() {
        return pets;
    }

    public void setPets(Set<com.data.models.Pet> pets) {
        this.pets = pets;
    }

}