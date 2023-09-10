package com.services.managers.species;

import com.services.dtoModels.SpeciesDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISpeciesManager {
    SpeciesDTO Get(String id);
    SpeciesDTO Create(SpeciesDTO newSpecies);
    SpeciesDTO Update(SpeciesDTO updatedSpecies, String id);
    SpeciesDTO Delete(String id);
    List<SpeciesDTO> GetAll();
}
