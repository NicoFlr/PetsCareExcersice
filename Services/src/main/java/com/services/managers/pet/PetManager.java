package com.services.managers.pet;

import com.data.exceptions.CustomException;
import com.data.exceptions.ErrorResults;
import com.data.models.Owner;
import com.data.models.Pet;
import com.data.repositories.PetRepository;
import com.services.Mapper;
import com.services.dtoModels.*;
import com.services.managers.breed.IBreedManager;
import com.services.managers.owner.IOwnerManager;
import com.services.managers.petCardex.IPetCardexManager;
import com.services.managers.petCardex.PetCardexManager;
import com.services.managers.species.ISpeciesManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetManager implements IPetManager {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private IPetCardexManager _petCardexManager;
    @Autowired
    private IBreedManager _breedManager;
    @Autowired
    private IOwnerManager _ownerManager;
    public PetDTO Get(String id) {
        try
        {
            Pet foundPet = petRepository.getReferenceById(id);
            PetDTO petDTO = Mapper.PetToDto(foundPet);
            return petDTO;
        }
        catch (Exception exception){
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "Pet not found!");
        }
    }

    @Transactional
    public PetDTO Create(PetDTO newPet) {
        try
        {
            Pet pet = Mapper.DTOtoPet(newPet);
            petRepository.save(pet);

            PetDTO petDTO = Mapper.PetToDto(pet);
            petDTO.setSpeciesName(newPet.getNewSpeciesName());
            petDTO.setBreedName(newPet.getNewBreedName());
            petDTO.setOwnerName(newPet.getNewOwnerName());
            return petDTO;
        }
        catch (Exception exception)
        {
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "XXX not found!");
        }
    }

    public PetDTO Update(PetDTO updatedPet, String id)
    {
        try
        {
            Optional<Pet> foundPet = petRepository.findById(id);

            foundPet.get().setName(updatedPet.getName());
            foundPet.get().setDateOfBirth(updatedPet.getDateOfBirth());
            foundPet.get().setSpeciesId(updatedPet.getSpeciesId());
            foundPet.get().setBreedId(updatedPet.getBreedId());
            foundPet.get().setOwnerId(updatedPet.getOwnerId());
            foundPet.get().setNotes(updatedPet.getNotes());

            petRepository.save(foundPet.get());

            PetDTO petDTO = Mapper.PetToDto(foundPet.get());

            petDTO.setSpeciesName(updatedPet.getNewSpeciesName());
            petDTO.setBreedName(updatedPet.getNewBreedName());
            petDTO.setOwnerName(updatedPet.getNewOwnerName());

            //petDTO.SetSpeciesName(updatedPet.getNewSpeciesName());
            return petDTO;
        }
        catch (Exception exception)
        {
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "Pet not found!");
        }
    }

    @Transactional
    public PetDTO Delete(String id) {
        try
        {
            Pet foundPet = petRepository.getReferenceById(id);
            petRepository.deleteById(id);

            PetDTO petDTO = Mapper.PetToDto(foundPet);
            return petDTO;
        }
        catch (Exception exception)
        {
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "Pet not found!");
        }
    }

    public List<PetDTO> GetAll() {

        List<Pet> allPets =  petRepository.findAll();
        List<PetDTO> allPetsDTOs = Mapper.PetToDTOList(allPets);

        List<BreedDTO> breedDTOList = _breedManager.GetAll();
        List<OwnerDTO> ownerDTOList = _ownerManager.GetAll();


        for (PetDTO pet : allPetsDTOs) {
            BreedDTO breed = breedDTOList.stream().filter(s-> s.getId().equals(pet.getBreedId())).findFirst().get();
            OwnerDTO owner = ownerDTOList.stream().filter(s-> s.getId().equals(pet.getOwnerId())).findFirst().get();

            pet.setBreedName(breed.getName());
            pet.setSpeciesName(breed.getSpeciesName());
            pet.setOwnerName(owner.getFullName());
        }

        return allPetsDTOs;
    }

    public List<PetCardexDTO> getPetCardexesOfPet(String petId) {
       return _petCardexManager.GetAllFromPet(petId);
    }
}
