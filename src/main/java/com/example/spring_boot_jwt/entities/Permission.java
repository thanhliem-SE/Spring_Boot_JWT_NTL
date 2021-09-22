package com.example.spring_boot_jwt.entities;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Permission extends BaseEntity{
    private String permissionName;
    private String permissionKey;
}
