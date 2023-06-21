package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.entity.CertificateIssue;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CertificateIssueService {
    Page<CertificateIssue> getIssues(int pageNum, int pageSize);
    List<CertificateIssue> getList();

    long getSize();
}
