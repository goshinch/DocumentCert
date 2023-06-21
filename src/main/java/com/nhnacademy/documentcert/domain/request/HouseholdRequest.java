package com.nhnacademy.documentcert.domain.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HouseholdRequest {
    private int householdSerialNumber;
    private int householdResidentSerialNumber;
    private LocalDate householdCompositionDate;
    private String householdCompositionReasonCode;
    private String currentHouseMovementAddress;
}
