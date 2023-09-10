package com.services;

import com.data.models.*;
import com.services.dtoModels.*;
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

    public static List<OwnerDTO> OwnerToDTOList(List<Owner> ownerList) {
        List<OwnerDTO> ownerDTOList = new ArrayList<OwnerDTO>();

        for (Owner owner : ownerList) {
            OwnerDTO ownerDTOToInsert = OwnerToDto(owner);
            ownerDTOList.add(ownerDTOToInsert);
        }
        return ownerDTOList;
    }

    public static PetDTO PetToDto(Pet pet) {
        PetDTO petDTO = new PetDTO(
                pet.getId(),
                pet.getName(),
                pet.getDateOfBirth(),
                pet.getSpeciesId(),
                pet.getBreedId(),
                pet.getNotes(),
                pet.getOwnerId()
        );

        return petDTO;
    }

    public static Pet DTOtoPet(PetDTO petDTO) {
        Pet pet = new Pet();

        pet.setId(String.valueOf(UUID.randomUUID()));
        pet.setName(petDTO.getName());
        pet.setDateOfBirth(petDTO.getDateOfBirth());
        pet.setSpeciesId(petDTO.getSpeciesId());
        pet.setBreedId(petDTO.getBreedId());
        pet.setNotes(petDTO.getNotes());
        pet.setOwnerId(petDTO.getOwnerId());

        return pet;
    }

    public static List<PetDTO> PetToDTOList(List<Pet> petList) {
        List<PetDTO> petDTOList = new ArrayList<PetDTO>();

        for (Pet pet : petList) {
            PetDTO petDTOToInsert = PetToDto(pet);
            petDTOList.add(petDTOToInsert);
        }
        return petDTOList;
    }

    public static PetCardexDTO PetCardexToDto(PetCardex petCardex) {
        PetCardexDTO petCardexDTO = new PetCardexDTO(
                petCardex.getId(),
                petCardex.getVisitDate(),
                petCardex.getPetId(),
                petCardex.getDescription(),
                petCardex.getMedication()
        );

        return petCardexDTO;
    }

    public static PetCardex DTOtoPetCardex(PetCardexDTO petCardexDTO) {
        PetCardex petCardex = new PetCardex();

        petCardex.setId(String.valueOf(UUID.randomUUID()));
        petCardex.setVisitDate(petCardexDTO.getVisitDate());
        petCardex.setPetId(petCardexDTO.getPetId());
        petCardex.setDescription(petCardexDTO.getDescription());
        petCardex.setMedication(petCardexDTO.getMedication());


        return petCardex;
    }

    public static List<PetCardexDTO> PetCardexToDTOList(List<PetCardex> petCardexList) {
        List<PetCardexDTO> petCardexDTOList = new ArrayList<PetCardexDTO>();

        for (PetCardex petCardex : petCardexList) {
            PetCardexDTO petCardexDTOToInsert = PetCardexToDto(petCardex);
            petCardexDTOList.add(petCardexDTOToInsert);
        }
        return petCardexDTOList;
    }

    public static SpeciesDTO SpeciesToDto(Species species) {
        SpeciesDTO speciesDTO = new SpeciesDTO(
                species.getId(),
                species.getName()
        );

        return speciesDTO;
    }

    public static Species DTOtoSpecies(SpeciesDTO speciesDTO) {
        Species species = new Species();

        species.setId(String.valueOf(UUID.randomUUID()));
        species.setName(speciesDTO.getName());

        return species;
    }

    public static List<SpeciesDTO> SpeciesToDTOList(List<Species> speciesList) {
        List<SpeciesDTO> speciesDTOList = new ArrayList<SpeciesDTO>();

        for (Species species : speciesList) {
            SpeciesDTO speciesDTOToInsert = SpeciesToDto(species);
            speciesDTOList.add(speciesDTOToInsert);
        }
        return speciesDTOList;
    }
}
