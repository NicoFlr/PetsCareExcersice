package com.data.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "breed")
public class Breed {
    @Id
    @Access(AccessType.PROPERTY)
    @Size(max = 36)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Size(max = 150)
    @Column(name = "name", length = 150)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "species_id", insertable = false, updatable = false)
    private com.data.models.Species species;

    @Size(max = 36)
    @Column(name="species_id")
    private String speciesId;

    @OneToMany(mappedBy = "breed")
    private Set<com.data.models.Pet> pets = new LinkedHashSet<>();

}