package com.services.managers.breed;



import com.data.exceptions.CustomException;
import com.data.exceptions.ErrorResults;
import com.data.models.Breed;
import com.data.repositories.BreedRepository;
import com.services.Mapper;
import com.services.dtoModels.BreedDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.hibernate.SessionFactory;

import java.util.List;

@Service
public class BreedManager implements IBreedManager{

    @Autowired
    private BreedRepository breedRepository;

    /*@Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }*/

    public BreedDTO Get(String id) {
        try
        {
            Breed foundBreed = breedRepository.getReferenceById(id);
            BreedDTO breedDTO = Mapper.BreedToDto(foundBreed);
            return breedDTO;
        }
        catch (Exception exception){
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "Pet not found!");
        }
    }

    @Transactional
    public BreedDTO Create(BreedDTO newBreed) {
        try
        {
            Breed breed = Mapper.DTOtoBreed(newBreed);
            breedRepository.save(breed);
            //this.sessionFactory.getCurrentSession().persist(breed);

            BreedDTO breedDTO = Mapper.BreedToDto(breed);
            return breedDTO;
        }
        catch (Exception exception)
        {
            throw new CustomException(ErrorResults.ENTITY_NOT_FOUND, "XXX not found!");
        }
    }

    /*
    private boolean OwnerIdExists(String clientId)
    {
        boolean answer = false;
        Session session =  getSession().get(Source.class, id);
        if()
        {

        }

        return answer
    }*/


    public BreedDTO Update(BreedDTO breed, String id)
    {
        return null;
    }


    public BreedDTO Delete(String id) {
        return null;
    }


    public List<BreedDTO> GetAll() {
        return null;
    }
}
