package com.services.managers.petCardex;

import com.data.exceptions.CustomException;
import com.data.exceptions.ErrorResults;
import com.data.models.PetCardex;
import com.data.repositories.PetCardexRepository;
import com.services.Mapper;
import com.services.dtoModels.PetCardexDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetCardexManager implements IPetCardexManager {

    @Autowired
    private PetCardexRepository petCardexRepository;
    public PetCardexDTO Get(String id) {
        try
        {
            PetCardex foundPetCardex = petCardexRepository.getReferenceById(id);
            PetCardexDTO petCardexDTO = Mapper.PetCardexToDto(foundPetCardex);
            return petCardexDTO;
        }
        catch (Exception exception){
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "Pet not found!");
        }
    }

    @Transactional
    public PetCardexDTO Create(PetCardexDTO newPetCardex) {
        try
        {
            PetCardex petCardex = Mapper.DTOtoPetCardex(newPetCardex);
            petCardexRepository.save(petCardex);

            PetCardexDTO petCardexDTO = Mapper.PetCardexToDto(petCardex);
            return petCardexDTO;
        }
        catch (Exception exception)
        {
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "XXX not found!");
        }
    }

    @Transactional
    public PetCardexDTO Update(PetCardexDTO updatedPetCardex, String id)
    {
        try
        {
            PetCardex petCardexToUpdate = Mapper.DTOtoPetCardex(updatedPetCardex);
            petCardexRepository.save(petCardexToUpdate);

            PetCardexDTO petCardexDTO = Mapper.PetCardexToDto(petCardexToUpdate);
            return petCardexDTO;
        }
        catch (Exception exception)
        {
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "PetCardex not found!");
        }
    }

    @Transactional
    public PetCardexDTO Delete(String id) {
        try
        {
            PetCardex foundPetCardex = petCardexRepository.getReferenceById(id);
            petCardexRepository.deleteById(id);

            PetCardexDTO petCardexDTO = Mapper.PetCardexToDto(foundPetCardex);
            return petCardexDTO;
        }
        catch (Exception exception)
        {
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "PetCardex not found!");
        }
    }

    public List<PetCardexDTO> GetAll() {

        List<PetCardexDTO> allPetCardexsDTOs;
        List<PetCardex> allPetCardexs =  petCardexRepository.findAll();

        allPetCardexsDTOs = Mapper.PetCardexToDTOList(allPetCardexs);

        return allPetCardexsDTOs;
    }

    public List<PetCardexDTO> GetAllFromPet(String petId) {

        List<String> idListForSearching = new ArrayList<String>();

        idListForSearching.add(petId);
        List<PetCardexDTO> allPetCardexsDTOs;
        List<PetCardex> allPetCardexsOfPet =  petCardexRepository.findAllByPetId(petId);


        allPetCardexsDTOs = Mapper.PetCardexToDTOList(allPetCardexsOfPet);

        return allPetCardexsDTOs;
    }
}
