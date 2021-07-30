package com.gaming.worspace.models.dto.request;

import com.gaming.worspace.models.Role;
import com.gaming.worspace.models.enumerated.Gender;
import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.persistence.Column;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class UserRequestDTO {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Instant birthday;
    private String phone;
    private boolean isToBeAdmin;
    private String gender;
    private String description;
    private String image;
    private String city;
    private boolean isDelivery;



    public UserRequestDTO() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsDelivery() {
        return isDelivery;
    }

    public void setIsDelivery(boolean isDelivery) {
        this.isDelivery = isDelivery;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getBirthday() {
        return birthday;
    }

    public void setBirthday(Instant birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isToBeAdmin() {
        return isToBeAdmin;
    }

    public void setToBeAdmin(boolean toBeAdmin) {
        isToBeAdmin = toBeAdmin;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
