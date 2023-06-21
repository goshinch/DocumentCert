package com.nhnacademy.documentcert.repository;

import com.nhnacademy.documentcert.entity.HouseholdMovementAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseholdMovementAddressRepository extends JpaRepository<HouseholdMovementAddress, HouseholdMovementAddress.PK> {
    List<HouseholdMovementAddress> findByIdHouseholdSerialNumber(int householdSerialNumber);
}