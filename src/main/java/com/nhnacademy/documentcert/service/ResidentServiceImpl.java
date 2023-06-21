package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.domain.dto.ResidentDto;
import com.nhnacademy.documentcert.entity.Resident;
import com.nhnacademy.documentcert.exception.ResidentNotFoundException;
import com.nhnacademy.documentcert.repository.ResidentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("residentService")
public class ResidentServiceImpl implements ResidentService {
    private final ResidentRepository residentRepository;

    public ResidentServiceImpl(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Transactional
    @Override
    public ResidentDto saveResident(Resident resident) {
        residentRepository.save(resident);
        return residentRepository.findByResidentSerialNumber(resident.getResidentSerialNumber());
    }

    @Override
    public ResidentDto updateResident(Resident resident) {
        return null;
    }

    @Override
    public Resident getResidentById(int residentId) {
        return residentRepository.findById(residentId)
                .orElseThrow(() -> new ResidentNotFoundException("Resident not found with ID: " + residentId));
    }

    @Override
    public List<Resident> getAllResidents() {
        return residentRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteResident(int residentId) {
        residentRepository.deleteById(residentId);
    }
}
