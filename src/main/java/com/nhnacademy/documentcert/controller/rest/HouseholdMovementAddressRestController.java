package com.nhnacademy.documentcert.controller.rest;

import com.nhnacademy.documentcert.entity.HouseholdMovementAddress;
import com.nhnacademy.documentcert.service.HouseholdMovementAddressService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/household-movement-address")
public class HouseholdMovementAddressRestController {
    private final HouseholdMovementAddressService householdMovementAddressService;

    public HouseholdMovementAddressRestController(HouseholdMovementAddressService householdMovementAddressService) {
        this.householdMovementAddressService = householdMovementAddressService;
    }

    @PostMapping
    public ResponseEntity<HouseholdMovementAddress> createHouseholdMovementAddress(@RequestBody HouseholdMovementAddress householdMovementAddress) {
        HouseholdMovementAddress createdAddress = householdMovementAddressService.saveHouseholdMovementAddress(householdMovementAddress);
        return ResponseEntity.ok(createdAddress);
    }

    @DeleteMapping("/{householdSerialNumber}/{houseMovementReportDate}")
    public ResponseEntity<String> deleteHouseholdMovementAddress(@PathVariable int householdSerialNumber, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate houseMovementReportDate) {
        householdMovementAddressService.deleteHouseholdMovementAddress(householdSerialNumber, houseMovementReportDate);
        return ResponseEntity.ok("Household movement address deleted successfully");
    }

    @GetMapping("/household/{householdSerialNumber}")
    public ResponseEntity<List<HouseholdMovementAddress>> getHouseholdMovementAddressesByHouseholdSerialNumber(@PathVariable int householdSerialNumber) {
        List<HouseholdMovementAddress> movementAddresses = householdMovementAddressService.getHouseholdMovementAddressesByHouseholdSerialNumber(householdSerialNumber);
        return ResponseEntity.ok(movementAddresses);
    }
}
