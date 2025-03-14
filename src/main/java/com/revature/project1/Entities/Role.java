package com.revature.project1.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table (name = "roles")
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts = new ArrayList<>();

    public Role(){}

    public Long getId() {
        return id;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Account> getRoles() {
        return accounts;
    }

    public void setRoles(List<Account> accounts) {
        this.accounts = accounts;
    }
}