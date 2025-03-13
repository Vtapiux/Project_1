package com.revature.project1.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "roles")
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
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