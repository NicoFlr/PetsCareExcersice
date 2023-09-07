package com.services;

import com.data.models.Breed;
import com.data.models.Owner;
import com.services.dtoModels.BreedDTO;
import com.services.dtoModels.OwnerDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Component
public class Mapper {
    public static BreedDTO BreedToDto(Breed breed) {
        BreedDTO breedDTO = new BreedDTO(
                breed.getId(),
                breed.getName(),
                breed.getSpeciesId()
        );

        return breedDTO;
    }

    public static Breed DTOtoBreed(BreedDTO breedDTO) {
        Breed breed = new Breed();

        breed.setId(String.valueOf(UUID.randomUUID()));
        breed.setName(breedDTO.getName());
        breed.setSpeciesId(breedDTO.getSpeciesId());

        return breed;
    }

    public static List<BreedDTO> BreedToDTOList(List<Breed> breedList) {
        List<BreedDTO> breedDTOList = new ArrayList<BreedDTO>();

        for (Breed breed : breedList) {
            BreedDTO breedDTOToInsert = BreedToDto(breed);
            breedDTOList.add(breedDTOToInsert);
        }
        return breedDTOList;
    }

    public static OwnerDTO OwnerToDto(Owner owner) {
        OwnerDTO ownerDTO = new OwnerDTO(
                owner.getId(),
                owner.getOwnerId(),
                owner.getAddressLine1(),
                owner.getAddressLine2(),
                owner.getBirthDate(),
                owner.getCountryCode(),
                owner.getFirstName(),
                owner.getLastName(),
                owner.getFullName(),
                owner.getPhoneNumber()
        );

        return ownerDTO;
    }

    public static Owner DTOtoOwner(OwnerDTO ownerDTO) {
        Owner owner = new Owner();

        owner.setId(String.valueOf(UUID.randomUUID()));
        owner.setOwnerId(ownerDTO.getOwnerId());
        owner.setAddressLine1(ownerDTO.getAddressLine1());
        owner.setAddressLine2(ownerDTO.getAddressLine2());
        owner.setBirthDate(ownerDTO.getBirthDate());
        owner.setCountryCode(ownerDTO.getCountryCode());
        owner.setFirstName(ownerDTO.getFirstName());
        owner.setLastName(ownerDTO.getLastName());

        owner.setPhoneNumber(ownerDTO.getPhoneNumber());

        return owner;
    }
}
