package com.services.managers.breed;

import com.services.dtoModels.BreedDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IBreedManager {
    BreedDTO Get(UUID id);
    BreedDTO Create(BreedDTO newBreed);
    BreedDTO Update(BreedDTO breed, UUID id);
    BreedDTO Delete(UUID id);
    List<BreedDTO> GetAll();
}
