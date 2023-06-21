package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.entity.HouseholdMovementAddress;
import com.nhnacademy.documentcert.repository.HouseholdMovementAddressRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HouseholdMovementAddressServiceImpl implements HouseholdMovementAddressService {
    private final HouseholdMovementAddressRepository householdMovementAddressRepository;

    public HouseholdMovementAddressServiceImpl(HouseholdMovementAddressRepository householdMovementAddressRepository) {
        this.householdMovementAddressRepository = householdMovementAddressRepository;
    }

    @Override
    public HouseholdMovementAddress saveHouseholdMovementAddress(HouseholdMovementAddress householdMovementAddress) {
        return householdMovementAddressRepository.save(householdMovementAddress);
    }

    @Override
    public void deleteHouseholdMovementAddress(int householdSerialNumber, LocalDate houseMovementReportDate) {
        HouseholdMovementAddress.PK pk = new HouseholdMovementAddress.PK();
        pk.setHouseholdSerialNumber(householdSerialNumber);
        pk.setHouseMovementReportDate(houseMovementReportDate);
        householdMovementAddressRepository.deleteById(pk);
    }

    @Override
    public List<HouseholdMovementAddress> getHouseholdMovementAddressesByHouseholdSerialNumber(int householdSerialNumber) {
        return householdMovementAddressRepository.findByIdHouseholdSerialNumber(householdSerialNumber);
    }
}