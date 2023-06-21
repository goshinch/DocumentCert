package com.nhnacademy.documentcert.repository;

import com.nhnacademy.documentcert.entity.BirthDeathReportResident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthDeathReportResidentRepository extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.PK> {
}
