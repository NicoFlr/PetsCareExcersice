package com.services.managers.breed;

import com.data.exceptions.CustomException;
import com.data.exceptions.ErrorResults;
import com.data.models.Breed;
import com.data.models.Species;
import com.data.repositories.BreedRepository;
import com.data.repositories.SpeciesRepository;
import com.services.Mapper;
import com.services.dtoModels.BreedDTO;
import com.services.dtoModels.SpeciesDTO;
import com.services.managers.petCardex.IPetCardexManager;
import com.services.managers.species.ISpeciesManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BreedManager implements IBreedManager{

    @Autowired
    private BreedRepository breedRepository;

    @Autowired
    private ISpeciesManager _speciesManager;

    public BreedDTO Get(String id) {
        try
        {
            Breed foundBreed = breedRepository.getReferenceById(id);
            BreedDTO breedDTO = Mapper.BreedToDto(foundBreed);
            return breedDTO;
        }
        catch (Exception exception){
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "Breed not found!");
        }
    }

    @Transactional
    public BreedDTO Create(BreedDTO newBreed) {
        try
        {
            Breed breed = Mapper.DTOtoBreed(newBreed);
            breedRepository.save(breed);

            BreedDTO breedDTO = Mapper.BreedToDto(breed);
            breedDTO.SetSpeciesName(newBreed.getNewSpeciesName());

            return breedDTO;
        }
        catch (Exception exception)
        {
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "Breed not found!");
        }
    }

    @Transactional
    public BreedDTO Update(BreedDTO updatedBreed, String id)
    {
        try
        {
            Optional<Breed> foundBreed = breedRepository.findById(id);


            foundBreed.get().setName(updatedBreed.getName());
            foundBreed.get().setSpeciesId(updatedBreed.getSpeciesId());

            breedRepository.save(foundBreed.get());

            BreedDTO breedDTO = Mapper.BreedToDto(foundBreed.get());
            breedDTO.SetSpeciesName(updatedBreed.getNewSpeciesName());
            return breedDTO;
        }
        catch (Exception exception)
        {
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "Breed not found!");
        }
    }

    @Transactional
    public BreedDTO Delete(String id) {
        try
        {
            Breed foundBreed = breedRepository.getReferenceById(id);
            breedRepository.deleteById(id);

            BreedDTO breedDTO = Mapper.BreedToDto(foundBreed);
            return breedDTO;
        }
        catch (Exception exception)
        {
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "Breed not found!");
        }
    }


    public List<BreedDTO> GetAll() {

        List<Breed> allBreeds =  breedRepository.findAll();

        List<BreedDTO> allBreedsDTOs = Mapper.BreedToDTOList(allBreeds);
        List<SpeciesDTO> speciesDTOList = _speciesManager.GetAll();
        //List<String> SpceiesIds = allBreedsDTOs.stream().map(BreedDTO::getSpeciesId).distinct().toList();

        for (BreedDTO breed : allBreedsDTOs) {
                SpeciesDTO species = speciesDTOList.stream().filter(s-> s.getId().equals(breed.getSpeciesId())).findFirst().get();

            breed.SetSpeciesName(species.getName());
        }

        return allBreedsDTOs;
    }

    public List<BreedDTO> GetAllFromIdList(List<String> idList)
    {
        List<String> uniqueIdList = idList.stream()
                .distinct()
                .collect(Collectors.toList());

        List<Breed> breedsFound = breedRepository.findAllById(uniqueIdList);

        List<BreedDTO> breedDTOsFound = Mapper.BreedToDTOList(breedsFound);

        return breedDTOsFound;
    }
}
