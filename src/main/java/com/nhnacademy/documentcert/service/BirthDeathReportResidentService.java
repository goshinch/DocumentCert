package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.entity.BirthDeathReportResident;

import java.util.List;

public interface BirthDeathReportResidentService {
    BirthDeathReportResident saveBirthDeathReportResident(BirthDeathReportResident reportResident);
    List<BirthDeathReportResident> getAllBirthDeathReportResidents();
    void deleteBirthDeathReportResident(BirthDeathReportResident.PK id);
}
