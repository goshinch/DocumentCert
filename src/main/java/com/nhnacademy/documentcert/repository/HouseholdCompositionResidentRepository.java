package com.nhnacademy.documentcert.repository;

import com.nhnacademy.documentcert.entity.HouseholdCompositionResident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdCompositionResidentRepository extends JpaRepository<HouseholdCompositionResident, HouseholdCompositionResident.PK> {
}
