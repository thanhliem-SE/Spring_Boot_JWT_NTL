package com.example.spring_boot_jwt.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Data
@Getter
@Setter
public class Permission extends BaseEntity{
    private String permissionName;
    private String permissionKey;
}
