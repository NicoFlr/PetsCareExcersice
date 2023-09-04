package com.services.managers.breed;



import com.data.exceptions.CustomException;
import com.data.exceptions.ErrorResults;
import com.data.models.Breed;
import com.data.repositories.BreedRepository;

import com.services.Mapper;
import com.services.dtoModels.BreedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BreedManager implements IBreedManager{

    @Autowired
    private BreedRepository breedRepository;

    //@Autowired
    //private CustomException customException;

    public BreedDTO Get(UUID id) {
        try {
            String z = String.valueOf(id);
            Breed y = breedRepository.getReferenceById(z);

            BreedDTO x = Mapper.BreedToDto(y);
            return x;
        }
        catch (Exception a){
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "Pet not found!");
        }
    }


    public BreedDTO Create(BreedDTO newBreed) {
        return null;
    }


    public BreedDTO Update(BreedDTO breed, UUID id) {
        return null;
    }


    public BreedDTO Delete(UUID id) {
        return null;
    }


    public List<BreedDTO> GetAll() {
        return null;
    }
}
