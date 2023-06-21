package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.entity.Household;
import com.nhnacademy.documentcert.repository.HouseholdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("householdService")
public class HouseholdServiceImpl implements HouseholdService {
    private final HouseholdRepository householdRepository;

    public HouseholdServiceImpl(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    @Override
    @Transactional
    public Household createHousehold(Household household) {
        return householdRepository.save(household);
    }

    @Override
    public Household getHouseholdBySerialNumber(int serialNumber) {
        return householdRepository.findByHouseholdSerialNumber(serialNumber);
    }

    @Override
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    @Override
    @Transactional
    public Household updateHousehold(Household household) {
        return householdRepository.save(household);
    }

    @Override
    @Transactional
    public void deleteHousehold(int serialNumber) {
        householdRepository.deleteById(serialNumber);
    }
}
