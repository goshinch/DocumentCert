package com.nhnacademy.documentcert.controller.rest;

import com.nhnacademy.documentcert.entity.HouseholdCompositionResident;
import com.nhnacademy.documentcert.service.HouseholdCompositionResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/household-composition-resident")
public class HouseholdCompositionResidentRestController {
    private final HouseholdCompositionResidentService householdCompositionResidentService;

    public HouseholdCompositionResidentRestController(HouseholdCompositionResidentService householdCompositionResidentService) {
        this.householdCompositionResidentService = householdCompositionResidentService;
    }

    @PostMapping
    public ResponseEntity<HouseholdCompositionResident> createHouseholdCompositionResident(@RequestBody HouseholdCompositionResident householdCompositionResident) {
        HouseholdCompositionResident createdHouseholdCompositionResident = householdCompositionResidentService.createHouseholdCompositionResident(householdCompositionResident);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHouseholdCompositionResident);
    }

    @GetMapping("/{householdSerialNumber}/{residentSerialNumber}")
    public ResponseEntity<HouseholdCompositionResident> getHouseholdCompositionResidentById(@PathVariable int householdSerialNumber, @PathVariable int residentSerialNumber) {
        HouseholdCompositionResident householdCompositionResident = householdCompositionResidentService.getHouseholdCompositionResidentById(householdSerialNumber, residentSerialNumber);
        if (householdCompositionResident != null) {
            return ResponseEntity.ok(householdCompositionResident);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<HouseholdCompositionResident>> getAllHouseholdCompositionResidents() {
        List<HouseholdCompositionResident> householdCompositionResidents = householdCompositionResidentService.getAllHouseholdCompositionResidents();
        return ResponseEntity.ok(householdCompositionResidents);
    }

    @PutMapping("/{householdSerialNumber}/{residentSerialNumber}")
    public ResponseEntity<HouseholdCompositionResident> updateHouseholdCompositionResident(@PathVariable int householdSerialNumber, @PathVariable int residentSerialNumber, @RequestBody HouseholdCompositionResident updatedHouseholdCompositionResident) {
        HouseholdCompositionResident householdCompositionResident = householdCompositionResidentService.getHouseholdCompositionResidentById(householdSerialNumber, residentSerialNumber);
        if (householdCompositionResident != null) {
            updatedHouseholdCompositionResident.getId().setHouseholdSerialNumber(householdSerialNumber);
            updatedHouseholdCompositionResident.getId().setResidentSerialNumber(residentSerialNumber);
            HouseholdCompositionResident updatedHouseholdCompositionResidentResult = householdCompositionResidentService.updateHouseholdCompositionResident(updatedHouseholdCompositionResident);
            return ResponseEntity.ok(updatedHouseholdCompositionResidentResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{householdSerialNumber}/{residentSerialNumber}")
    public ResponseEntity<Void> deleteHouseholdCompositionResident(@PathVariable int householdSerialNumber, @PathVariable int residentSerialNumber) {
        HouseholdCompositionResident householdCompositionResident = householdCompositionResidentService.getHouseholdCompositionResidentById(householdSerialNumber, residentSerialNumber);
        if (householdCompositionResident != null) {
            householdCompositionResidentService.deleteHouseholdCompositionResident(householdSerialNumber, residentSerialNumber);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
