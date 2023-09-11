package com.services.managers.owner;

import com.data.exceptions.CustomException;
import com.data.exceptions.ErrorResults;
import com.data.models.Breed;
import com.data.models.Owner;
import com.data.models.Owner;
import com.data.models.Owner;
import com.data.repositories.OwnerRepository;
import com.services.Mapper;
import com.services.dtoModels.BreedDTO;
import com.services.dtoModels.OwnerDTO;
import com.services.dtoModels.OwnerDTO;
import com.services.dtoModels.OwnerDTO;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OwnerManager implements IOwnerManager {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }


    public OwnerDTO Get(String id) {
        try
        {
            Owner foundOwner = ownerRepository.getReferenceById(id);
            OwnerDTO ownerDTO = Mapper.OwnerToDto(foundOwner);
            return ownerDTO;
        }
        catch (Exception exception){
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "Owner not found!");
        }
    }

    @Transactional
    public OwnerDTO Create(OwnerDTO newOwner)
    {
        try
        {
            Owner owner = Mapper.DTOtoOwner(newOwner);

            boolean ownerIdAlreadyExists = OwnerIdExists(newOwner.getOwnerId());
            if(!ownerIdAlreadyExists)
            {
                ownerRepository.save(owner);

                OwnerDTO ownerDTO = Mapper.OwnerToDto(owner);
                return ownerDTO;
            }
            else
            {
                throw new CustomException(ErrorResults.INVALID_VALUE, "Owner could not be created, another owner with" +
                                                        " the same owner_id already exists, owner_id should be unique");
            }
        }
        catch (Exception exception)
        {
            throw new CustomException(ErrorResults.UNEXPECTED_ERROR, "unexpected error!");
        }
    }

    private boolean OwnerIdExists(String owner_id)
    {
        boolean answer = false;
        List<String> x = new ArrayList<String>();
        x.add(owner_id);
        List<Owner> ownersFound = ownerRepository.findAllById(x);

        if(ownersFound.size() > 1)
        {
            answer = true;
        }

        return answer;
    }

    @Transactional
    public OwnerDTO Update(OwnerDTO updatedOwner, String id)
    {
        try
        {
            Optional<Owner> foundOwner = ownerRepository.findById(id);

            foundOwner.get().setOwnerId(updatedOwner.getOwnerId());
            foundOwner.get().setFirstName(updatedOwner.getFirstName());
            foundOwner.get().setLastName(updatedOwner.getLastName());
            foundOwner.get().setCountryCode(updatedOwner.getCountryCode());
            foundOwner.get().setPhoneNumber(updatedOwner.getPhoneNumber());
            foundOwner.get().setAddressLine1(updatedOwner.getAddressLine1());
            foundOwner.get().setAddressLine2(updatedOwner.getAddressLine2());
            foundOwner.get().setBirthDate(updatedOwner.getBirthDate());

            ownerRepository.save(foundOwner.get());

            OwnerDTO ownerDTO = Mapper.OwnerToDto(foundOwner.get());
            //ownerDTO.SetSpeciesName(updatedOwner.getNewSpeciesName());
            return ownerDTO;
        }
        catch (Exception exception)
        {
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "Owner not found!");
        }
    }

    @Transactional
    public OwnerDTO Delete(String id) {
        try
        {
            Owner foundOwner = ownerRepository.getReferenceById(id);
            ownerRepository.deleteById(id);

            OwnerDTO ownerDTO = Mapper.OwnerToDto(foundOwner);
            return ownerDTO;
        }
        catch (Exception exception)
        {
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "Owner not found!");
        }
    }

    public List<OwnerDTO> GetAll() {

        List<Owner> allOwners =  ownerRepository.findAll();

        List<OwnerDTO> allOwnersDTOs = Mapper.OwnerToDTOList(allOwners);

        return allOwnersDTOs;
    }

    public List<OwnerDTO> GetAllFromIdList(List<String> idList)
    {
        List<String> uniqueIdList = idList.stream()
                .distinct()
                .collect(Collectors.toList());

        List<Owner> ownersFound = ownerRepository.findAllById(uniqueIdList);

        List<OwnerDTO> ownerDTOsFound = Mapper.OwnerToDTOList(ownersFound);

        return ownerDTOsFound;
    }
}
