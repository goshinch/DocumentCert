package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.domain.dto.ResidentDto;
import com.nhnacademy.documentcert.entity.Resident;

import java.util.List;

public interface ResidentService {
    ResidentDto saveResident(Resident resident);

    ResidentDto updateResident(Resident resident);
    Resident getResidentById(int residentId);
    List<Resident> getAllResidents();
    void deleteResident(int residentId);
}
