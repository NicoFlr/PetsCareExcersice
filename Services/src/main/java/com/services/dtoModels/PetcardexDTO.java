package com.services.dtoModels;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class PetcardexDTO implements Serializable {
    private final String id;
    private final Instant visitDate;
    private final String description;
    private final String medication;

    public PetcardexDTO(String id, Instant visitDate, String description, String medication) {
        this.id = id;
        this.visitDate = visitDate;
        this.description = description;
        this.medication = medication;
    }

    public String getId() {
        return id;
    }

    public Instant getVisitDate() {
        return visitDate;
    }

    public String getDescription() {
        return description;
    }

    public String getMedication() {
        return medication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetcardexDTO entity = (PetcardexDTO) o;
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