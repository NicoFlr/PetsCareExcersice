package com.presentation.Controllers;

import com.services.dtoModels.BreedDTO;
import com.services.dtoModels.SpeciesDTO;
import com.services.managers.species.ISpeciesManager;
import com.services.managers.species.ISpeciesManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Species", description = "Species APIs")
@RestController
@CrossOrigin
@RequestMapping("/api/species")
public class SpeciesController {
    @Autowired
    private ISpeciesManager _speciesManager;

    @Operation(summary = "Get all species")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Species found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SpeciesDTO.class)) }),
    })
    @GetMapping
    public List<SpeciesDTO> getAllSpecies ()
    {
        return _speciesManager.GetAll();
    }

    @Operation(summary = "Get a species by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Species found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SpeciesDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Species not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public SpeciesDTO getSpeciesById (@PathVariable String id)
    {
        return _speciesManager.Get(id);
    }

    @Operation(summary = "Creates a species")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Species created successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SpeciesDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Species not found",
                    content = @Content)
    })
    @PostMapping
    public SpeciesDTO createSpecies (@RequestBody SpeciesDTO speciesDTO)
    {
        return _speciesManager.Create(speciesDTO);
    }

    @Operation(summary = "Updates a species")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Species updated successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SpeciesDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Species not found",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public SpeciesDTO updateSpecies (@RequestBody SpeciesDTO speciesDTO, @PathVariable String id)
    {
        return _speciesManager.Update(speciesDTO, id);
    }

    @Operation(summary = "Deletes a species")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Species deleted successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SpeciesDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Species not found",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public SpeciesDTO deleteSpecies (@PathVariable String id)
    {
        return _speciesManager.Delete(id);
    }
}
