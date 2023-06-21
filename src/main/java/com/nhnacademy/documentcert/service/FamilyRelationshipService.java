package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.entity.FamilyRelationship;

import java.util.List;

public interface FamilyRelationshipService {
    FamilyRelationship saveFamilyRelationship(FamilyRelationship familyRelationship);

    FamilyRelationship putFamilyRelationship(FamilyRelationship familyRelationship);
    List<FamilyRelationship> getAllFamilyRelationship(int serialNumber);
    void deleteFamilyRelationship(int baseResidentSerialNumber, int familyResidentSerialNumber);
}
