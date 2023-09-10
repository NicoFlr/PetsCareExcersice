package com.presentation.Controllers;

import com.services.dtoModels.BreedDTO;
import com.services.dtoModels.OwnerDTO;
import com.services.managers.owner.IOwnerManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Owners", description = "Owner APIs")
@RestController
@CrossOrigin
@RequestMapping("/api/owners")
public class OwnerController {
    @Autowired
    private IOwnerManager _ownerManager;

    @Operation(summary = "Get all owners")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owners found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OwnerDTO.class)) }),
    })
    @GetMapping
    public List<OwnerDTO> getAllOwners ()
    {
        return _ownerManager.GetAll();
    }

    @Operation(summary = "Get an owner by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owner found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OwnerDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Owner not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public OwnerDTO getOwnerById (@PathVariable String id)
    {
        return _ownerManager.Get(id);
    }

    @Operation(summary = "Creates an owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owner created successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OwnerDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Owner not found",
                    content = @Content)
    })
    @PostMapping
    public OwnerDTO createOwner (@RequestBody OwnerDTO ownerDTO)
    {
        return _ownerManager.Create(ownerDTO);
    }

    @Operation(summary = "Updates an owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owner updated successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OwnerDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Owner not found",
                    content = @Content)
    })
    @PutMapping
    public OwnerDTO updateOwner (@RequestBody OwnerDTO ownerDTO, @RequestParam String ownerId)
    {
        return _ownerManager.Update(ownerDTO, ownerId);
    }

    @Operation(summary = "Deletes an owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owner deleted successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OwnerDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Owner not found",
                    content = @Content)
    })
    @DeleteMapping
    public OwnerDTO deleteOwner (@RequestParam String ownerId)
    {
        return _ownerManager.Delete(ownerId);
    }
}
