package com.services.dtoModels;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

public class PetCardexDTO implements Serializable {
    private final String id;
    private final LocalDate visitDate;
    private final String petId;
    private final String description;
    private final String medication;


    public PetCardexDTO(String id, LocalDate visitDate, String petId, String description, String medication) {
        this.id = id;
        this.visitDate = visitDate;
        this.petId = petId;
        this.description = description;
        this.medication = medication;
    }

    public String getId() {
        return id;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public String getDescription() {
        return description;
    }

    public String getMedication() {
        return medication;
    }

    public String getPetId() {return petId;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetCardexDTO entity = (PetCardexDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.visitDate, entity.visitDate) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.medication, entity.medication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, visitDate, description, medication);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "visitDate = " + visitDate + ", " +
                "description = " + description + ", " +
                "medication = " + medication + ")";
    }
}