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
    public @ResponseBody BreedDTO getBreedById (@RequestParam UUID breedId)
    {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        return _breedManager.Get(breedId);
    }
}
