package com.data.repositories;

import com.data.models.PetCardex;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//@CrossOrigin
@Hidden
//@Repository
public interface PetCardexRepository extends CustomJPARepository<PetCardex,String> {
    @Query(value = "SELECT * FROM pet_cardex WHERE pet_id = ?1", nativeQuery = true)
    List<PetCardex> findAllByPetId(@Param(value = "pet_id") String petId);

}