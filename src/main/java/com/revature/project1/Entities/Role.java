package com.revature.project1.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Role")
public class Role{
    @Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false)
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    public Role(){}

    public Role(Long id, String roleName){
        this.id = id;
        this.roleName = roleName;
    }

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
    
}