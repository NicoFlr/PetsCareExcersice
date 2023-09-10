package com.services.managers.species;

import com.data.exceptions.CustomException;
import com.data.exceptions.ErrorResults;
import com.data.models.Species;
import com.data.repositories.SpeciesRepository;
import com.services.Mapper;
import com.services.dtoModels.SpeciesDTO;
//import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpeciesManager implements ISpeciesManager{

    @Autowired
    private SpeciesRepository speciesRepository;
    
    public SpeciesDTO Get(String id) {
        try
        {
            Species foundSpecies = speciesRepository.getReferenceById(id);
            SpeciesDTO speciesDTO = Mapper.SpeciesToDto(foundSpecies);
            return speciesDTO;
        }
        catch (Exception exception){
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "Species not found!");
        }
    }

    @Transactional
    public SpeciesDTO Create(SpeciesDTO newSpecies) {
        try
        {
            Species species = Mapper.DTOtoSpecies(newSpecies);
            speciesRepository.save(species);

            SpeciesDTO speciesDTO = Mapper.SpeciesToDto(species);
            return speciesDTO;
        }
        catch (Exception exception)
        {
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "XXX not found!");
        }
    }

    @Transactional
    public SpeciesDTO Update(SpeciesDTO updatedSpecies, String id)
    {
        try
        {
            Optional<Species> foundSpecies = speciesRepository.findById(id);


            foundSpecies.get().setName(updatedSpecies.getName());

            speciesRepository.save(foundSpecies.get());

            SpeciesDTO speciesDTO = Mapper.SpeciesToDto(foundSpecies.get());
            return speciesDTO;
        }
        catch (Exception exception)
        {
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "Species not found!");
        }
    }

    @Transactional
    public SpeciesDTO Delete(String id) {
        try
        {
            Species foundSpecies = speciesRepository.getReferenceById(id);
            speciesRepository.deleteById(id);

            SpeciesDTO speciesDTO = Mapper.SpeciesToDto(foundSpecies);
            return speciesDTO;
        }
        catch (Exception exception)
        {
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "Species not found!");
        }
    }

    public List<SpeciesDTO> GetAll() {

        List<SpeciesDTO> allSpeciessDTOs = new ArrayList<SpeciesDTO>();
        List<Species> allSpeciess =  speciesRepository.findAll();

        allSpeciessDTOs = Mapper.SpeciesToDTOList(allSpeciess);

        return allSpeciessDTOs;
    }
}
