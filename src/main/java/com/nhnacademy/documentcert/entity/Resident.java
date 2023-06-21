package com.nhnacademy.documentcert.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


/**
 * create table resident
 * (
 *     resident_serial_number       int(11)      not null,
 *     name                         varchar(100) not null,
 *     resident_registration_number varchar(300) not null,
 *     gender_code                  varchar(20)  not null,
 *     birth_date                   datetime     not null,
 *     birth_place_code             varchar(20)  not null,
 *     registration_base_address    varchar(500) not null,
 *     death_date                   datetime     null,
 *     death_place_code             varchar(20)  null,
 *     death_place_address          varchar(500) null,
 *     primary key (resident_serial_number)
 * );
 * */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "resident")
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resident_serial_number")
    private int residentSerialNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "resident_registration_number", nullable = false)
    private String residentRegistrationNumber;

    @Column(name = "gender_code", nullable = false)
    private String genderCode;

    @Column(name = "birth_date", nullable = false)
    private LocalDateTime birthDate;

    @Column(name = "birth_place_code", nullable = false)
    private String birthPlaceCode;

    @Column(name = "registration_base_address", nullable = false)
    private String registrationBaseAddress;

    @Column(name = "death_date")
    private LocalDateTime deathDate;

    @Column(name = "death_place_code")
    private String deathPlaceCode;

    @Column(name = "death_place_address")
    private String deathPlaceAddress;
}
