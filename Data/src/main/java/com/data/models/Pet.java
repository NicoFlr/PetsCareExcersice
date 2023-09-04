package com.data.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "species_id", nullable = false)
    private com.data.models.Species species;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "breed_id", nullable = false)
    private com.data.models.Breed breed;

    @Column(name = "notes", length = 2500)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private com.data.models.Owner owner;

    @Column(name="owner_id",insertable=false, updatable=false)
    private String ownerId;

    @OneToMany(mappedBy = "pet")
    private Set<com.data.models.Petcardex> petcardexes = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public com.data.models.Species getSpecies() {
        return species;
    }

    public void setSpecies(com.data.models.Species species) {
        this.species = species;
    }

    public com.data.models.Breed getBreed() {
        return breed;
    }

    public void setBreed(com.data.models.Breed breed) {
        this.breed = breed;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public com.data.models.Owner getOwner() {
        return owner;
    }

    public void setOwner(com.data.models.Owner owner) {
        this.owner = owner;
    }

    public Set<com.data.models.Petcardex> getPetcardexes() {
        return petcardexes;
    }

    public void setPetcardexes(Set<com.data.models.Petcardex> petcardexes) {
        this.petcardexes = petcardexes;
    }

}