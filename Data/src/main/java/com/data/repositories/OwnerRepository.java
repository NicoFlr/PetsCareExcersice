package com.data.repositories;

import com.data.models.Owner;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin
@Hidden
//@Repository
public interface OwnerRepository extends CustomJPARepository<Owner,String> {
}