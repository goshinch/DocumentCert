package com.nhnacademy.documentcert.controller.rest;

import com.nhnacademy.documentcert.domain.request.HouseholdRequest;
import com.nhnacademy.documentcert.entity.Household;
import com.nhnacademy.documentcert.entity.Resident;
import com.nhnacademy.documentcert.service.HouseholdService;
import com.nhnacademy.documentcert.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/household")
public class HouseholdRestController {
    private final HouseholdService householdService;
    private final ResidentService residentService;

    public HouseholdRestController(HouseholdService householdService, ResidentService residentService) {
        this.householdService = householdService;
        this.residentService = residentService;
    }

    @PostMapping
    public ResponseEntity<Household> createHousehold(@RequestBody HouseholdRequest householdRequest) {
        Resident resident = residentService.getResidentById(householdRequest.getHouseholdResidentSerialNumber());

        Household household = new Household();
        household.setHouseholdResidentSerialNumber(resident);
        household.setHouseholdCompositionDate(householdRequest.getHouseholdCompositionDate());
        household.setHouseholdSerialNumber(householdRequest.getHouseholdSerialNumber());
        household.setCurrentHouseMovementAddress(householdRequest.getCurrentHouseMovementAddress());
        household.setHouseholdCompositionReasonCode(householdRequest.getHouseholdCompositionReasonCode());

        Household createdHousehold = householdService.createHousehold(household);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHousehold);
    }

    @GetMapping("/{serialNumber}")
    public Household getHouseholdBySerialNumber(@PathVariable int serialNumber) {
        return householdService.getHouseholdBySerialNumber(serialNumber);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Household>> getAllHouseholds() {
        List<Household> households = householdService.getAllHouseholds();
        return ResponseEntity.ok(households);
    }

    @PutMapping("/{serialNumber}")
    public ResponseEntity<Household> updateHousehold(
            @PathVariable int serialNumber,
            @RequestBody HouseholdRequest householdRequest
    ) {
        Resident resident = residentService.getResidentById(householdRequest.getHouseholdResidentSerialNumber());

        Household updatedHousehold = new Household();
        updatedHousehold.setHouseholdResidentSerialNumber(resident);
        updatedHousehold.setHouseholdCompositionDate(householdRequest.getHouseholdCompositionDate());
        updatedHousehold.setHouseholdSerialNumber(householdRequest.getHouseholdSerialNumber());
        updatedHousehold.setCurrentHouseMovementAddress(householdRequest.getCurrentHouseMovementAddress());
        updatedHousehold.setHouseholdCompositionReasonCode(householdRequest.getHouseholdCompositionReasonCode());

        Household household = householdService.getHouseholdBySerialNumber(serialNumber);
        if (household != null) {
            Household updatedHouseholdResult = householdService.updateHousehold(updatedHousehold);
            return ResponseEntity.ok(updatedHouseholdResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{serialNumber}")
    public ResponseEntity<Void> deleteHousehold(@PathVariable int serialNumber) {
        Household household = householdService.getHouseholdBySerialNumber(serialNumber);
        if (household != null) {
            householdService.deleteHousehold(serialNumber);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
