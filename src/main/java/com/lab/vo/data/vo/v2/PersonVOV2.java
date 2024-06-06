package com.lab.vo.data.vo.v2;

import java.util.Date;
import java.util.UUID;

public class PersonVOV2 {
    private UUID id;

    private String firstName;

    private String lastName;

    private String address;

    private String gender;
    private Date birthDay;

    public PersonVOV2() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonVOV2 that = (PersonVOV2) o;

        if (!id.equals(that.id)) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!address.equals(that.address)) return false;
        if (!gender.equals(that.gender)) return false;
        return birthDay.equals(that.birthDay);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + birthDay.hashCode();
        return result;
    }
}
