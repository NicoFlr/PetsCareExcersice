package com.presentation.Controllers;

import com.services.dtoModels.PetCardexDTO;
import com.services.dtoModels.PetDTO;
import com.services.dtoModels.SpeciesDTO;
import com.services.managers.pet.IPetManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pets", description = "Pet APIs")
@RestController
@CrossOrigin
@RequestMapping("/api/pets")
public class PetController {
    @Autowired
    private IPetManager _petManager;

    @Operation(summary = "Get all pets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pets found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetDTO.class)) }),
    })
    @GetMapping
    public List<PetDTO> getAllPets ()
    {
        return _petManager.GetAll();
    }

    @Operation(summary = "Get a pet by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pet found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Pet not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public PetDTO getPetById (@PathVariable String id)
    {
        return _petManager.Get(id);
    }

    @Operation(summary = "Get the pet-cardex of a given pet by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pet-Cardex found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetCardexDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Pet-cardex not found",
                    content = @Content)
    })
    @GetMapping("/{id}/pet-cardexes")
    public List<PetCardexDTO> getPetCardexesByPetId (@PathVariable String id)
    {
        return _petManager.getPetCardexesOfPet(id);
    }

    @Operation(summary = "Creates a pet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pet created successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Pet not found",
                    content = @Content)
    })
    @PostMapping
    public PetDTO createPet (@RequestBody PetDTO petDTO)
    {
        return _petManager.Create(petDTO);
    }

    @Operation(summary = "Updates a pet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pet updated successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Pet not found",
                    content = @Content)
    })
    @PutMapping
    public PetDTO updatePet (@RequestBody PetDTO petDTO, @RequestParam String petId)
    {
        return _petManager.Update(petDTO, petId);
    }

    @Operation(summary = "Deletes a pet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pet deleted successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Pet not found",
                    content = @Content)
    })
    @DeleteMapping
    public PetDTO deletePet (@RequestParam String petId)
    {
        return _petManager.Delete(petId);
    }
}
