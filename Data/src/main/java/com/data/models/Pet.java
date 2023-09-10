package com.data.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @Size(max = 36)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @org.hibernate.annotations.OnDelete(action = org.hibernate.annotations.OnDeleteAction.RESTRICT)
    @JoinColumn(name = "species_id", nullable = false, insertable = false, updatable = false)
    private Species species;

    @Size(max = 36)
    @Column(name = "species_id", nullable = false, length = 36)
    private String speciesId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @org.hibernate.annotations.OnDelete(action = org.hibernate.annotations.OnDeleteAction.RESTRICT)
    @JoinColumn(name = "breed_id", nullable = false, insertable = false, updatable = false)
    private Breed breed;

    @Size(max = 36)
    @Column(name = "breed_id", nullable = false, length = 36)
    private String breedId;

    @Size(max = 2500)
    @Column(name = "notes", length = 2500)
    private String notes;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @org.hibernate.annotations.OnDelete(action = org.hibernate.annotations.OnDeleteAction.RESTRICT)
    @JoinColumn(name = "owner_id", nullable = false, insertable = false, updatable = false)
    private Owner owner;

    @Size(max = 36)
    @Column(name = "owner_id", nullable = false, length = 36)
    private String ownerId;

    @OneToMany(mappedBy = "pet")
    private Set<PetCardex> petCardexes = new LinkedHashSet<>();

}