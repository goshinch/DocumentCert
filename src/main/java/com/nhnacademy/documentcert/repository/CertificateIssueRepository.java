package com.nhnacademy.documentcert.repository;

import com.nhnacademy.documentcert.entity.CertificateIssue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateIssueRepository extends JpaRepository<CertificateIssue, Long>, CertificateIssueRepositoryCustom{
}
