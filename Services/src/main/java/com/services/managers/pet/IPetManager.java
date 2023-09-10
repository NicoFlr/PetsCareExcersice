package com.services.managers.pet;

import com.services.dtoModels.PetCardexDTO;
import com.services.dtoModels.PetDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPetManager {
    PetDTO Get(String id);
    PetDTO Create(PetDTO newPet);
    PetDTO Update(PetDTO updatedPet, String id);
    PetDTO Delete(String id);
    List<PetDTO> GetAll();

    List<PetCardexDTO> getPetCardexesOfPet(String petId);
}
