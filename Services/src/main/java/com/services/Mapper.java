package com.services;

import com.data.models.Breed;
import com.services.dtoModels.BreedDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Component
public class Mapper {
    public static BreedDTO BreedToDto(Breed breed) {
        BreedDTO breedDTO = new BreedDTO();
        breedDTO.name = breed.getName();
        breedDTO.id = UUID.fromString(breed.getId());
        breedDTO.speciesId = UUID.fromString(breed.getSpecies().getId());

        return breedDTO;
    }

    public static Breed DTOtoBreed(BreedDTO breedDTO) {
        Breed breed = new Breed();
        breed.setId(String.valueOf(breedDTO.id));
        breed.setName(breedDTO.name);
        breed.setSpeciesId(String.valueOf(breedDTO.speciesId));

        return breed;
    }
}
