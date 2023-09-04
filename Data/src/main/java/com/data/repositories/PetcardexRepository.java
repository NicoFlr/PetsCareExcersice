package com.data.repositories;

import com.data.models.Petcardex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetcardexRepository extends JpaRepository<Petcardex, String> {
}