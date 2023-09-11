package com.services.managers.petCardex;

import com.data.exceptions.CustomException;
import com.data.exceptions.ErrorResults;
import com.data.models.PetCardex;
import com.data.models.Species;
import com.data.repositories.PetCardexRepository;
import com.services.Mapper;
import com.services.dtoModels.PetCardexDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            Optional<PetCardex> foundPetCardex = petCardexRepository.findById(id);

            foundPetCardex.get().setVisitDate(updatedPetCardex.getVisitDate());
            foundPetCardex.get().setDescription(updatedPetCardex.getDescription());
            foundPetCardex.get().setMedication(updatedPetCardex.getMedication());

            petCardexRepository.save(foundPetCardex.get());

            PetCardexDTO petCardexDTO = Mapper.PetCardexToDto(foundPetCardex.get());
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

        List<PetCardex> allPetCardexs =  petCardexRepository.findAll();

        List<PetCardexDTO> allPetCardexsDTOs = Mapper.PetCardexToDTOList(allPetCardexs);

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
