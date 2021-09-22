package com.example.spring_boot_jwt.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
public class Token extends BaseEntity{

    @Column(length = 1000)
    private String token;

    private Date tokenExpDate;
}
