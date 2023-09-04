package com.data.repositories;

import com.data.models.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, String> {
}