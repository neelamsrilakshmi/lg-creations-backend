package com.lgcreations.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    @Column(length = 3000)
    private String message;

    private String status;
}