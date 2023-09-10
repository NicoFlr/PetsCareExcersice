package com.data.repositories;

import com.data.models.Breed;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;

@Hidden
//@Repository
public interface BreedRepository extends CustomJPARepository<Breed,String> {}