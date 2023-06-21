package com.nhnacademy.documentcert.controller.rest;

import com.nhnacademy.documentcert.entity.BirthDeathReportResident;
import com.nhnacademy.documentcert.service.BirthDeathReportResidentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/birth-death-report-residents")
public class BirthDeathReportResidentRestController {
    private final BirthDeathReportResidentService reportResidentService;

    public BirthDeathReportResidentRestController(BirthDeathReportResidentService reportResidentService) {
        this.reportResidentService = reportResidentService;
    }

    @PostMapping
    public BirthDeathReportResident addBirthDeathReportResident(@RequestBody BirthDeathReportResident reportResident) {
        return reportResidentService.saveBirthDeathReportResident(reportResident);
    }

    @GetMapping
    public List<BirthDeathReportResident> getAllBirthDeathReportResidents() {
        return reportResidentService.getAllBirthDeathReportResidents();
    }

    @DeleteMapping("/{residentSerialNumber}/{birthDeathTypeCode}")
    public void deleteBirthDeathReportResident(
            @PathVariable int residentSerialNumber,
            @PathVariable String birthDeathTypeCode) {
        BirthDeathReportResident.PK id = new BirthDeathReportResident.PK();
        id.setBirthDeathTypeCode(birthDeathTypeCode);
        id.setResidentSerialNumber(residentSerialNumber);
        reportResidentService.deleteBirthDeathReportResident(id);
    }
}
