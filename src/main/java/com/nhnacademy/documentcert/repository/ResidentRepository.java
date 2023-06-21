package com.nhnacademy.documentcert.repository;

import com.nhnacademy.documentcert.domain.dto.ResidentDto;
import com.nhnacademy.documentcert.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {
    ResidentDto findByResidentSerialNumber(int residentSerialNumber);

}
