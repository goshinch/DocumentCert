package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.entity.FamilyRelationship;
import com.nhnacademy.documentcert.exception.ResidentNotFoundException;
import com.nhnacademy.documentcert.repository.FamilyRelationshipRepository;
import com.nhnacademy.documentcert.repository.ResidentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("familyRelationshipService")
@Slf4j
public class FamilyRelationshipServiceImpl implements FamilyRelationshipService {
    private final FamilyRelationshipRepository familyRelationshipRepository;

    public FamilyRelationshipServiceImpl(FamilyRelationshipRepository familyRelationshipRepository) {
        this.familyRelationshipRepository = familyRelationshipRepository;
    }

    @Override
    @Transactional
    public FamilyRelationship saveFamilyRelationship(FamilyRelationship familyRelationship) {
        if (!familyRelationshipRepository.existFamilyRelationship(familyRelationship))
            return familyRelationshipRepository.save(familyRelationship);
        throw new RuntimeException();
    }

    @Override
    @Transactional
    public FamilyRelationship putFamilyRelationship(FamilyRelationship familyRelationship) {
        if (familyRelationshipRepository.existFamilyRelationship(familyRelationship))
            return familyRelationshipRepository.save(familyRelationship);
        throw new RuntimeException();
    }

    @Override
    public List<FamilyRelationship> getAllFamilyRelationship(int serialNumber) {
        return familyRelationshipRepository.getFamilyAll(serialNumber);
    }

    @Override
    @Transactional
    public void deleteFamilyRelationship(int baseResidentSerialNumber, int familyResidentSerialNumber) {
        FamilyRelationship.PK pk = new FamilyRelationship.PK();
        pk.setBaseResidentSerialNumber(baseResidentSerialNumber);
        pk.setFamilyResidentSerialNumber(familyResidentSerialNumber);
        familyRelationshipRepository.deleteById(pk);
//        log.info("deleteFamilyRelationship=2={}",familyRelationshipRepository.existFamilyRelationship(familyRelationshipRepository.getFamily(baseResidentSerialNumber, familyResidentSerialNumber)));
    }
}
