package com.nhnacademy.documentcert.controller.rest;

import com.nhnacademy.documentcert.domain.dto.BirthDto;
import com.nhnacademy.documentcert.domain.request.BirthDeathReportRequest;
import com.nhnacademy.documentcert.entity.BirthDeathReportResident;
import com.nhnacademy.documentcert.service.BirthDeathReportResidentService;
import com.nhnacademy.documentcert.service.ResidentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residents")
public class BirthReportRestController {
    private final BirthDeathReportResidentService reportResidentService;
    private final ResidentService residentService;

    public BirthReportRestController(BirthDeathReportResidentService reportResidentService, ResidentService residentService) {
        this.reportResidentService = reportResidentService;
        this.residentService = residentService;
    }

    @PostMapping("/{serialNumber}/birth")
    public BirthDto addBirthReport(
            @PathVariable int serialNumber,
            @RequestBody BirthDeathReportRequest birthDeathReportRequest) {

        BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident();
        birthDeathReportResident.setBirthDeathReportDate(birthDeathReportRequest.getBirthDeathReportDate());
        birthDeathReportResident.setBirthReportQualificationsCode(birthDeathReportRequest.getBirthReportQualificationsCode());
        birthDeathReportResident.setEmailAddress(birthDeathReportRequest.getEmailAddress());
        birthDeathReportResident.setPhoneNumber(birthDeathReportRequest.getPhoneNumber());

        BirthDeathReportResident.PK pk = new BirthDeathReportResident.PK();
        pk.setResidentSerialNumber(serialNumber);
        pk.setBirthDeathTypeCode(birthDeathReportRequest.getBirthDeathTypeCode());

        birthDeathReportResident.setPk(pk);
        birthDeathReportResident.setReportResident(residentService.getResidentById(serialNumber));
        birthDeathReportResident.setResident(residentService.getResidentById(birthDeathReportRequest.getResidentSerialNumber()));

        reportResidentService.saveBirthDeathReportResident(birthDeathReportResident);
        return null;
    }
}
