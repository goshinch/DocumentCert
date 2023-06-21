package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.entity.HouseholdCompositionResident;

import java.util.List;

public interface HouseholdCompositionResidentService {
    HouseholdCompositionResident createHouseholdCompositionResident(HouseholdCompositionResident householdCompositionResident);

    HouseholdCompositionResident getHouseholdCompositionResidentById(int householdSerialNumber, int residentSerialNumber);

    List<HouseholdCompositionResident> getAllHouseholdCompositionResidents();

    HouseholdCompositionResident updateHouseholdCompositionResident(HouseholdCompositionResident householdCompositionResident);

    void deleteHouseholdCompositionResident(int householdSerialNumber, int residentSerialNumber);
}
