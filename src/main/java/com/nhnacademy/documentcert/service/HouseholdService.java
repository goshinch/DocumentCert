package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.entity.Household;

import java.util.List;

public interface HouseholdService {
    Household createHousehold(Household household);

    Household getHouseholdBySerialNumber(int serialNumber);

    List<Household> getAllHouseholds();

    Household updateHousehold(Household household);

    void deleteHousehold(int serialNumber);
}
