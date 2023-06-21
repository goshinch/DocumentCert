package com.nhnacademy.documentcert.domain.dto;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

public interface ResidentDto {
    @Value("#{target.residentSerialNumber}")
    int getId();

    @Value("#{target.name}")
    String getName();

    @Value("#{target.residentRegistrationNumber}")
    String getResidentRegistrationNumber();

    @Value("#{target.genderCode}")
    String getGender();

    @Value("#{target.birthDate}")
    LocalDateTime getBirthDate();

    @Value("#{target.birthPlaceCode}")
    String getBirthPlaceCode();

    @Value("#{target.registrationBaseAddress}")
    String getAddress();

    @Value("#{target.deathDate}")
    LocalDateTime getDeathDate();

    @Value("#{target.deathPlaceCode}")
    String getDeathPlaceCode();

    @Value("#{target.deathPlaceAddress}")
    String getDeathPlaceAddress();
}
