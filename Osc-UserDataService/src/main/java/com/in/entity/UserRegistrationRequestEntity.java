package com.in.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "user_table")
@JsonIgnoreProperties
public class UserRegistrationRequestEntity {

    @Id
    @Column(name = "user_Id")
    private String userId;

    @Column(name = "user_Name")
    private String name;

    @Column(name =  "user_email")
    private String email;

    @Column(name = "user_dob")
    private LocalDate dateOfBirth;

    @Column(name = "user_mobileNumber")
    private String mobileNumber;

    @Column(name = "user_password")
    private String password;

    public UserRegistrationRequestEntity() {
    }

    public UserRegistrationRequestEntity(String userId, String name, String email, LocalDate dateOfBirth, String mobileNumber, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserRegistrationRequestEntity{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
