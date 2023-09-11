package com.services.dtoModels;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class PetDTO implements Serializable {
    private final String id;
    private final String name;
    private final LocalDate dateOfBirth;
    private final String speciesId;
    private final String breedId;
    private final String notes;
    private final String ownerId;

    private String speciesName;
    private String breedName;
    private String ownerName;

    private String newSpeciesName;
    private String newBreedName;
    private String newOwnerName;

    public PetDTO(String id, String name, LocalDate dateOfBirth, String speciesId, String breedId, String notes, String ownerId) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.speciesId = speciesId;
        this.breedId = breedId;
        this.notes = notes;
        this.ownerId = ownerId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSpeciesId() {
        return speciesId;
    }

    public String getBreedId() {
        return breedId;
    }

    public String getNotes() {
        return notes;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getNewSpeciesName() {
        return newSpeciesName;
    }

    public void setNewSpeciesName(String newSpeciesName) {
        this.newSpeciesName = newSpeciesName;
    }

    public String getNewBreedName() {
        return newBreedName;
    }

    public void setNewBreedName(String newBreedName) {
        this.newBreedName = newBreedName;
    }

    public String getNewOwnerName() {
        return newOwnerName;
    }

    public void setNewOwnerName(String newOwnerName) {
        this.newOwnerName = newOwnerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetDTO entity = (PetDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.dateOfBirth, entity.dateOfBirth) &&
                Objects.equals(this.speciesId, entity.speciesId) &&
                Objects.equals(this.breedId, entity.breedId) &&
                Objects.equals(this.notes, entity.notes) &&
                Objects.equals(this.ownerId, entity.ownerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfBirth, speciesId, breedId, notes, ownerId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "dateOfBirth = " + dateOfBirth + ", " +
                "speciesId = " + speciesId + ", " +
                "breedId = " + breedId + ", " +
                "notes = " + notes + ", " +
                "ownerId = " + ownerId + ")";
    }
}