package com.services.managers.petCardex;

import com.services.dtoModels.PetCardexDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPetCardexManager {
    PetCardexDTO Get(String id);
    PetCardexDTO Create(PetCardexDTO newPetCardex);
    PetCardexDTO Update(PetCardexDTO updatedPetCardex, String id);
    PetCardexDTO Delete(String id);
    List<PetCardexDTO> GetAll();
    List<PetCardexDTO> GetAllFromPet(String petId);
}
