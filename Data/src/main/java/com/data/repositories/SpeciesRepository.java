package com.data.repositories;

import com.data.models.Species;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin
@Hidden
//@Repository
public interface SpeciesRepository extends CustomJPARepository<Species,String> {
    /*@Modifying
    @Query("update species s set s.name = ?1, where s.id = ?3")
    void updateSpeciesById(String name, String speciesId);*/
}