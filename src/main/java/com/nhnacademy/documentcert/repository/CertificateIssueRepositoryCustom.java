package com.nhnacademy.documentcert.repository;

import com.nhnacademy.documentcert.entity.CertificateIssue;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CertificateIssueRepositoryCustom {
    List<CertificateIssue> getIssues();
    CertificateIssue getIssue(int serialNumber, String typeCode);
}
