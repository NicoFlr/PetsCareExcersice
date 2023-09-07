package com.services.managers.owner;

import com.data.exceptions.CustomException;
import com.data.exceptions.ErrorResults;
import com.data.models.Owner;
import com.data.repositories.OwnerRepository;
import com.services.Mapper;
import com.services.dtoModels.OwnerDTO;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//import static jdk.nio.zipfs.ZipFileAttributeView.AttrID.owner;


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

    public List<OwnerDTO> GetAll() {
        List<OwnerDTO> ownerDTOList = new ArrayList<OwnerDTO>();

        return null;
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
                this.sessionFactory.getCurrentSession().persist(owner);

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
        List<Owner> ownersFound = new ArrayList<Owner>();//ownerRepository.findOwnersByOwnerId(owner_id);
        //Session session =  getSession().get(Source.class, id);
        if(ownersFound.isEmpty())
        {
            answer = true;
        }

        return answer;
    }


    public OwnerDTO Update(OwnerDTO owner, String id)
    {
        return null;
    }


    public OwnerDTO Delete(String id) {
        return null;
    }

}
