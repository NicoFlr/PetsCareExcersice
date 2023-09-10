package com.presentation.Controllers;

import com.services.dtoModels.BreedDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.managers.breed.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Breeds", description = "Breed APIs")
@RestController
@CrossOrigin
@RequestMapping("/api/breeds")
public class BreedController
{
    @Autowired
    private IBreedManager _breedManager;

    @Operation(summary = "Get a breed by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Breed found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BreedDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Breed not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public BreedDTO getBreedById (@PathVariable String id)
    {
        return _breedManager.Get(id);
    }

    @Operation(summary = "Get all breeds")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Breed found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BreedDTO.class)) }),
    })
    @GetMapping
    public List<BreedDTO> getAllBreeds ()
    {
        return _breedManager.GetAll();
    }


    @Operation(summary = "Creates a breed")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Breed created successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BreedDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Breed not found",
                    content = @Content)
    })
    @PostMapping
    public BreedDTO createBreed (@RequestBody BreedDTO breedDTO)
    {
        return _breedManager.Create(breedDTO);
    }

    @Operation(summary = "Updates a breed")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Breed updated successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BreedDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Breed not found",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public BreedDTO updateBreed (@RequestBody BreedDTO breedDTO, @PathVariable String id)
    {
        return _breedManager.Update(breedDTO, id);
    }

    @Operation(summary = "Deletes a breed")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Breed deleted successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BreedDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Breed not found",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public BreedDTO deleteBreed (@PathVariable String id)
    {
        return _breedManager.Delete(id);
    }
}
