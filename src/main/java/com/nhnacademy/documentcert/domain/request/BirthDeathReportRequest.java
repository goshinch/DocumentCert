package com.nhnacademy.documentcert.domain.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BirthDeathReportRequest {
    private int residentSerialNumber;
    private String birthDeathTypeCode;
    private LocalDate birthDeathReportDate;
    private String birthReportQualificationsCode;
    private String emailAddress;
    private String phoneNumber;
}
