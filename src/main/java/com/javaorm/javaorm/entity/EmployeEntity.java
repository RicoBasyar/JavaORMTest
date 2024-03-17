package com.javaorm.javaorm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="employe")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeEntity {
    @Id
    @GeneratedValue
    @Column(name = "employe_id")
    private int employeid;

    @Column(name = "employe_name")
    private String employe_name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
}
