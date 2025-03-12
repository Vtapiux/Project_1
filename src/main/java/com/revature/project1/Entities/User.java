package com.revature.project1.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long idUser;

    @Column(name = "last_name",length = 20)
    private String lastName;

    @Column(name = "email",length = 50)
    private String email;

    @Column(name = "phone",length = 13)
    private String phone;

    @Column(name = "created_ad",length = 8)
    private String createdAt;

    public User() {
    }

    public User(Long idUser, String lastName, String email, String phone, String createdAt) {
        this.idUser = idUser;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
