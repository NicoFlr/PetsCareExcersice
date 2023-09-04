package com.data.models;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "petcardex")
public class Petcardex {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "visit_date")
    private Instant visitDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pet_id", nullable = false)
    private com.data.models.Pet pet;

    @Lob
    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "medication")
    private String medication;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Instant visitDate) {
        this.visitDate = visitDate;
    }

    public com.data.models.Pet getPet() {
        return pet;
    }

    public void setPet(com.data.models.Pet pet) {
        this.pet = pet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

}