package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.entity.HouseholdMovementAddress;

import java.time.LocalDate;
import java.util.List;

public interface HouseholdMovementAddressService {
    HouseholdMovementAddress saveHouseholdMovementAddress(HouseholdMovementAddress householdMovementAddress);
    void deleteHouseholdMovementAddress(int householdSerialNumber, LocalDate houseMovementReportDate);
    List<HouseholdMovementAddress> getHouseholdMovementAddressesByHouseholdSerialNumber(int householdSerialNumber);
}
