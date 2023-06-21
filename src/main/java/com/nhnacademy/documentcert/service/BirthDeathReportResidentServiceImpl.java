package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.entity.BirthDeathReportResident;
import com.nhnacademy.documentcert.repository.BirthDeathReportResidentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("birthDeathReportResidentService")
public class BirthDeathReportResidentServiceImpl implements BirthDeathReportResidentService {
    private BirthDeathReportResidentRepository reportResidentRepository;

    public BirthDeathReportResidentServiceImpl(BirthDeathReportResidentRepository reportResidentRepository) {
        this.reportResidentRepository = reportResidentRepository;
    }

    @Transactional
    @Override
    public BirthDeathReportResident saveBirthDeathReportResident(BirthDeathReportResident reportResident) {
        return reportResidentRepository.save(reportResident);
    }

    @Override
    public List<BirthDeathReportResident> getAllBirthDeathReportResidents() {
        return reportResidentRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteBirthDeathReportResident(BirthDeathReportResident.PK id) {
        reportResidentRepository.deleteById(id);
    }
}
