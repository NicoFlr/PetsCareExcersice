package com.services.managers.pet;

import com.data.exceptions.CustomException;
import com.data.exceptions.ErrorResults;
import com.data.models.Pet;
import com.data.repositories.PetRepository;
import com.services.Mapper;
import com.services.dtoModels.PetCardexDTO;
import com.services.dtoModels.PetDTO;
import com.services.managers.petCardex.IPetCardexManager;
import com.services.managers.petCardex.PetCardexManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetManager implements IPetManager {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private IPetCardexManager _petCardexManager;
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
            Pet petToUpdate = Mapper.DTOtoPet(updatedPet);
            petRepository.save(petToUpdate);

            PetDTO petDTO = Mapper.PetToDto(petToUpdate);
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

        List<PetDTO> allPetsDTOs = new ArrayList<PetDTO>();
        List<Pet> allPets =  petRepository.findAll();

        allPetsDTOs = Mapper.PetToDTOList(allPets);

        return allPetsDTOs;
    }

    public List<PetCardexDTO> getPetCardexesOfPet(String petId) {
       return _petCardexManager.GetAllFromPet(petId);
    }
}
