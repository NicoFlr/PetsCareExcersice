package com.services.dtoModels;

import java.io.Serializable;
import java.util.Objects;

public class BreedDTO implements Serializable {
    private final String id;
    private final String name;
    private final String speciesId;
    private String speciesName;
    private String newSpeciesName;

    public BreedDTO(String id, String name, String speciesId){
        this.id = id;
        this.name = name;
        this.speciesId = speciesId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpeciesId() {
        return speciesId;
    }
    public String getSpeciesName() { return speciesName; }
    public void SetSpeciesName(String speciesName) {this.speciesName = speciesName;}

    public String getNewSpeciesName() { return newSpeciesName; }
    public void SetNewSpeciesName(String newSpeciesName) {this.newSpeciesName = newSpeciesName;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BreedDTO entity = (BreedDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.speciesId, entity.speciesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, speciesId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "speciesId = " + speciesId +
                "speciesName = " + speciesName + ")";
    }
}