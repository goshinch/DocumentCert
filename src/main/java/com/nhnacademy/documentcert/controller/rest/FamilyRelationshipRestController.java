package com.nhnacademy.documentcert.controller.rest;

import com.nhnacademy.documentcert.domain.request.RelationshipCodeRequest;
import com.nhnacademy.documentcert.domain.request.RelationshipRequest;
import com.nhnacademy.documentcert.entity.FamilyRelationship;
import com.nhnacademy.documentcert.service.FamilyRelationshipService;
import com.nhnacademy.documentcert.service.ResidentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residents")
public class FamilyRelationshipRestController {
    private final FamilyRelationshipService familyRelationshipService;
    private final ResidentService residentService;

    public FamilyRelationshipRestController(FamilyRelationshipService familyRelationshipService, ResidentService residentService) {
        this.familyRelationshipService = familyRelationshipService;
        this.residentService = residentService;
    }

    @PostMapping("/{serialNumber}/relationship")
    public FamilyRelationship addFamilyRelationship(
            @PathVariable int serialNumber,
            @RequestBody RelationshipRequest relationshipRequest) {
        FamilyRelationship.PK pk = new FamilyRelationship.PK();
        pk.setBaseResidentSerialNumber(serialNumber);
        pk.setFamilyResidentSerialNumber(relationshipRequest.getFamilyResidentSerialNumber());

        FamilyRelationship familyRelationship = new FamilyRelationship();
        familyRelationship.setPk(pk);
        familyRelationship.setBaseResident(residentService.getResidentById(serialNumber));
        familyRelationship.setFamilyResident(residentService.getResidentById(relationshipRequest.getFamilyResidentSerialNumber()));
        familyRelationship.setFamilyRelationshipCode(relationshipRequest.getFamilyRelationshipCode());

        return familyRelationshipService.saveFamilyRelationship(familyRelationship);
    }



    @PutMapping("/{serialNumber}/relationship/{familySerialNumber}")
    public FamilyRelationship putFamilyRelationship(
            @PathVariable int serialNumber,
            @PathVariable int familySerialNumber,
            @RequestBody RelationshipCodeRequest relationshipCodeRequest
        ) {
        FamilyRelationship.PK pk = new FamilyRelationship.PK();
        pk.setFamilyResidentSerialNumber(serialNumber);
        pk.setBaseResidentSerialNumber(familySerialNumber);

        FamilyRelationship familyRelationship = new FamilyRelationship();
        familyRelationship.setPk(pk);
        familyRelationship.setBaseResident(residentService.getResidentById(serialNumber));
        familyRelationship.setFamilyResident(residentService.getResidentById(familySerialNumber));
        familyRelationship.setFamilyRelationshipCode(relationshipCodeRequest.getRelationShip());

        return familyRelationshipService.putFamilyRelationship(familyRelationship);
    }

    @DeleteMapping("/{serialNumber}/relationship/{familyResidentSerialNumber}")
    public void deleteFamilyRelationship(
            @PathVariable int serialNumber,
            @PathVariable int familyResidentSerialNumber) {
        familyRelationshipService.deleteFamilyRelationship(serialNumber, familyResidentSerialNumber);
    }
}
