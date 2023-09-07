package com.presentation.Controllers;

import com.services.dtoModels.BreedDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.managers.breed.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/breed")
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
    @GetMapping
    public @ResponseBody BreedDTO getBreedById (@RequestParam String breedId)
    {
        return _breedManager.Get(breedId);
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
    public @ResponseBody BreedDTO createBreed (@RequestBody BreedDTO breedDTO)
    {
        return _breedManager.Create(breedDTO);
    }
}
