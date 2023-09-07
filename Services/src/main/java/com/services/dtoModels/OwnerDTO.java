package com.services.dtoModels;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class OwnerDTO implements Serializable {
    private final String id;
    private final String ownerId;
    private final String phoneNumber;
    private final String countryCode;
    private final LocalDate birthDate;
    private final String addressLine1;
    private final String addressLine2;
    private final String firstName;
    private final String lastName;
    private final String fullName;

    public OwnerDTO(String id, String ownerId, String phoneNumber, String countryCode, LocalDate birthDate, String addressLine1, String addressLine2, String firstName, String lastName, String fullName) {
        this.id = id;
        this.ownerId = ownerId;
        this.phoneNumber = phoneNumber;
        this.countryCode = countryCode;
        this.birthDate = birthDate;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerDTO entity = (OwnerDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.ownerId, entity.ownerId) &&
                Objects.equals(this.phoneNumber, entity.phoneNumber) &&
                Objects.equals(this.countryCode, entity.countryCode) &&
                Objects.equals(this.birthDate, entity.birthDate) &&
                Objects.equals(this.addressLine1, entity.addressLine1) &&
                Objects.equals(this.addressLine2, entity.addressLine2) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.fullName, entity.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerId, phoneNumber, countryCode, birthDate, addressLine1, addressLine2, firstName, lastName, fullName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "ownerId = " + ownerId + ", " +
                "phoneNumber = " + phoneNumber + ", " +
                "countryCode = " + countryCode + ", " +
                "birthDate = " + birthDate + ", " +
                "addressLine1 = " + addressLine1 + ", " +
                "addressLine2 = " + addressLine2 + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "fullName = " + fullName + ")";
    }
}