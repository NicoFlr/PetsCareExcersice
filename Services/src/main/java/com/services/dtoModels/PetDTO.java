package com.services.dtoModels;

import java.time.LocalDate;
import java.util.UUID;

public class PetDTO {
    public String name;
    public LocalDate dateOfBirth;
    public UUID speciesId;
    public UUID breedId;
    public String notes;
    public UUID ownerId;
}
