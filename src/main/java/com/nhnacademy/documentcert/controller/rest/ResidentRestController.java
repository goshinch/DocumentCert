package com.nhnacademy.documentcert.controller.rest;

import com.nhnacademy.documentcert.domain.dto.ResidentDto;
import com.nhnacademy.documentcert.entity.Resident;
import com.nhnacademy.documentcert.service.ResidentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/residents")
@Slf4j
public class ResidentRestController {
    private ResidentService residentService;

    public ResidentRestController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @PostMapping
    public ResidentDto addResident(@RequestBody Resident resident) {
        return residentService.saveResident(resident);
    }

    @GetMapping("/{residentId}")
    public ResidentDto getResidentById(@PathVariable int residentId) {
        Resident resident = residentService.getResidentById(residentId);
        return new ResidentDto() {
            @Override
            public int getId() {
                return resident.getResidentSerialNumber();
            }

            @Override
            public String getName() {
                return resident.getName();
            }

            @Override
            public String getResidentRegistrationNumber() {
                return resident.getResidentRegistrationNumber();
            }

            @Override
            public String getGender() {
                return resident.getGenderCode();
            }

            @Override
            public LocalDateTime getBirthDate() {
                return resident.getBirthDate();
            }

            @Override
            public String getBirthPlaceCode() {
                return resident.getBirthPlaceCode();
            }

            @Override
            public String getAddress() {
                return resident.getRegistrationBaseAddress();
            }

            @Override
            public LocalDateTime getDeathDate() {
                return resident.getDeathDate();
            }

            @Override
            public String getDeathPlaceCode() {
                return resident.getDeathPlaceCode();
            }

            @Override
            public String getDeathPlaceAddress() {
                return resident.getDeathPlaceAddress();
            }
        };
    }

    @GetMapping
    public List<Resident> getAllResidents() {
        return residentService.getAllResidents();
    }

    @DeleteMapping("/{residentId}")
    public void deleteResident(@PathVariable int residentId) {
        residentService.deleteResident(residentId);
    }
}