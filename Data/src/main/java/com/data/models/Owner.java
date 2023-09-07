package com.data.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @Access(AccessType.PROPERTY)
    @Size(max = 36)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Size(max = 15)
    @Column(name = "owner_id", nullable = false, length = 15)
    private String ownerId;

    @Size(max = 15)
    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Size(max = 6)
    @Column(name = "country_code", length = 6)
    private String countryCode;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Size(max = 75)
    @Column(name = "address_line_1", length = 75)
    private String addressLine1;

    @Size(max = 75)
    @Column(name = "address_line_2", length = 75)
    private String addressLine2;

    @Size(max = 50)
    @Column(name = "first_name", length = 50)
    private String firstName;

    @Size(max = 50)
    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "full_name", length = 101, insertable = false, updatable = false)
    private String fullName;

    @OneToMany(mappedBy = "owner")
    private Set<Pet> pets = new LinkedHashSet<>();

}