package com.javaorm.javaorm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mahasiswa")
@Getter
@Setter
public class MhsEntity {

    @Id
    @Column(name = "nim")
    private String nim;

    @Column(name = "nama_mhs")
    private String name;

    @Column(name = "no_hp")
    private int phoneNumber;

    @Column(name = "email")
    private String email;
}
