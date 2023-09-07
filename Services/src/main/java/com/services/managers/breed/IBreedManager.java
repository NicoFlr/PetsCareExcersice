package com.services.managers.breed;

import com.services.dtoModels.BreedDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IBreedManager {
    BreedDTO Get(String id);
    BreedDTO Create(BreedDTO newBreed);
    BreedDTO Update(BreedDTO breed, String id);
    BreedDTO Delete(String id);
    List<BreedDTO> GetAll();
}
