package com.nhnacademy.documentcert.repository;

import com.nhnacademy.documentcert.entity.FamilyRelationship;
import com.nhnacademy.documentcert.entity.QFamilyRelationship;
import com.nhnacademy.documentcert.entity.QResident;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class FamilyRelationshipRepositoryImpl extends QuerydslRepositorySupport implements FamilyRelationshipRepositoryCustom {
    public FamilyRelationshipRepositoryImpl() {
        super(FamilyRelationship.class);
    }

    @Override
    public List<FamilyRelationship> getFamilyAll(int serialNumber) {
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;
        QResident resident = QResident.resident;
        return from(familyRelationship)
                .innerJoin(familyRelationship.familyResident, resident).fetchJoin()
                .where(familyRelationship.baseResident.residentSerialNumber.eq(serialNumber))
                .fetch();
    }

    @Override
    public boolean existFamilyRelationship(FamilyRelationship relationship) {
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;

        FamilyRelationship tmp = from(familyRelationship)
                .where(
                        familyRelationship.baseResident.residentSerialNumber.in(relationship.getBaseResident().getResidentSerialNumber())
                                .and(familyRelationship.familyResident.residentSerialNumber.in(relationship.getFamilyResident().getResidentSerialNumber()))
                ).fetchFirst();

        return getFamily(relationship.getBaseResident().getResidentSerialNumber(), relationship.getFamilyResident().getResidentSerialNumber()) != null;
    }

    @Override
    public FamilyRelationship getFamily(int baseResidentSerialNumber, int familyResidentSerialNumber) {
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;

        return from(familyRelationship)
                .where(
                        familyRelationship.pk.baseResidentSerialNumber.eq(baseResidentSerialNumber)
                                .and(familyRelationship.pk.familyResidentSerialNumber.eq(familyResidentSerialNumber)))
                .fetchFirst();
    }
}
