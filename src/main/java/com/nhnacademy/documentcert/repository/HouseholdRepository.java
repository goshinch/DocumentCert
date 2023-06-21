package com.nhnacademy.documentcert.repository;

import com.nhnacademy.documentcert.entity.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface HouseholdRepository extends JpaRepository<Household, Integer> {
    Household findByHouseholdSerialNumber(int serialNumber);

    @Modifying
    @Query("DELETE FROM Household h WHERE h.householdSerialNumber = ?1")
    void deleteByHouseholdSerialNumber(int serialNumber);

}
