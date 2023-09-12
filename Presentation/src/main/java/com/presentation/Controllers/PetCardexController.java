package com.presentation.Controllers;

import com.services.dtoModels.PetCardexDTO;
import com.services.dtoModels.SpeciesDTO;
import com.services.managers.petCardex.IPetCardexManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pet Cardexes", description = "Pet cardex APIs")
@RestController
@CrossOrigin
@RequestMapping("/api/pet-cardexes")
public class PetCardexController {
    @Autowired
    private IPetCardexManager _petCardexManager;

    @Operation(summary = "Get a petCardex by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PetCardex found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetCardexDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "PetCardex not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public PetCardexDTO getPetCardexById (@PathVariable String id)
    {
        return _petCardexManager.Get(id);
    }

    @Operation(summary = "Get all pet cardexes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pet cardexes found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetCardexDTO.class)) }),
    })
    @GetMapping
    public List<PetCardexDTO> getAllPetCardexes ()
    {
        return _petCardexManager.GetAll();
    }

    @Operation(summary = "Creates a petCardex")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PetCardex created successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetCardexDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "PetCardex not found",
                    content = @Content)
    })
    @PostMapping
    public PetCardexDTO createPetCardex (@RequestBody PetCardexDTO petCardexDTO)
    {
        return _petCardexManager.Create(petCardexDTO);
    }

    @Operation(summary = "Updates a petCardex")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PetCardex updated successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetCardexDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "PetCardex not found",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public PetCardexDTO updatePetCardex (@RequestBody PetCardexDTO petCardexDTO, @PathVariable String id)
    {
        return _petCardexManager.Update(petCardexDTO, id);
    }

    @Operation(summary = "Deletes a petCardex")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PetCardex deleted successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetCardexDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "PetCardex not found",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public PetCardexDTO deletePetCardex (@PathVariable String id)
    {
        return _petCardexManager.Delete(id);
    }
}
