package com.nhnacademy.documentcert.repository;

import com.nhnacademy.documentcert.entity.FamilyRelationship;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface FamilyRelationshipRepositoryCustom {
    List<FamilyRelationship> getFamilyAll(int serialNumber);

    boolean existFamilyRelationship(FamilyRelationship relationship);

    FamilyRelationship getFamily(int baseResidentSerialNumber, int familyResidentSerialNumber);
}
