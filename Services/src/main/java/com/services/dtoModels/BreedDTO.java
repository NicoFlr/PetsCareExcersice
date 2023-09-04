package com.services.dtoModels;

import java.util.UUID;

public class BreedDTO {

    public UUID id;
    public String name;
    public UUID speciesId;

    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public UUID getSpeciesId() { return speciesId; }
    public void setSpeciesId(UUID speciesId) {
        this.speciesId = speciesId;
    }
}
