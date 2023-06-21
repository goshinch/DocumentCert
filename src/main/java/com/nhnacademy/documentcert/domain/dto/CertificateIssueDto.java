package com.nhnacademy.documentcert.domain.dto;

import java.time.LocalDate;

public interface CertificateIssueDto {
    Long getCertificateConfirmationNumber();
    String getName();
    String getCertificateTypeCode();
    LocalDate getCertificateIssueDate();
}
