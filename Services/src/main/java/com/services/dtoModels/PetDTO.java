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