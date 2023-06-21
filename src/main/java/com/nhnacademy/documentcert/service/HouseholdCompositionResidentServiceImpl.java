package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.entity.HouseholdCompositionResident;
import com.nhnacademy.documentcert.repository.HouseholdCompositionResidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("householdCompositionResidentService")
public class HouseholdCompositionResidentServiceImpl implements HouseholdCompositionResidentService {
    private final HouseholdCompositionResidentRepository householdCompositionResidentRepository;

    public HouseholdCompositionResidentServiceImpl(HouseholdCompositionResidentRepository householdCompositionResidentRepository) {
        this.householdCompositionResidentRepository = householdCompositionResidentRepository;
    }

    @Override
    public HouseholdCompositionResident createHouseholdCompositionResident(HouseholdCompositionResident householdCompositionResident) {
        return householdCompositionResidentRepository.save(householdCompositionResident);
    }

    @Override
    public HouseholdCompositionResident getHouseholdCompositionResidentById(int householdSerialNumber, int residentSerialNumber) {
        HouseholdCompositionResident.PK pk = new HouseholdCompositionResident.PK();
        pk.setHouseholdSerialNumber(householdSerialNumber);
        pk.setResidentSerialNumber(residentSerialNumber);
        return householdCompositionResidentRepository.findById(pk).orElse(null);
    }

    @Override
    public List<HouseholdCompositionResident> getAllHouseholdCompositionResidents() {
        return householdCompositionResidentRepository.findAll();
    }

    @Override
    public HouseholdCompositionResident updateHouseholdCompositionResident(HouseholdCompositionResident householdCompositionResident) {
        return householdCompositionResidentRepository.save(householdCompositionResident);
    }

    @Override
    public void deleteHouseholdCompositionResident(int householdSerialNumber, int residentSerialNumber) {
        HouseholdCompositionResident.PK pk = new HouseholdCompositionResident.PK();
        pk.setHouseholdSerialNumber(householdSerialNumber);
        pk.setResidentSerialNumber(residentSerialNumber);
        householdCompositionResidentRepository.deleteById(pk);
    }
}
