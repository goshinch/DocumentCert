package com.nhnacademy.documentcert.repository;

import com.nhnacademy.documentcert.entity.FamilyRelationship;
import com.nhnacademy.documentcert.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.PK>, FamilyRelationshipRepositoryCustom {
}
