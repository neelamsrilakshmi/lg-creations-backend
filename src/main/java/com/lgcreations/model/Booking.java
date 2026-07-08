
package com.lgcreations.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String location;
    private String date;
    private String packageName;
    private String shootType;

    @Column(length = 2000)
    private String message;

    private String status;
}