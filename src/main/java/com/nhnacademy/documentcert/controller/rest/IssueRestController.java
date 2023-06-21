package com.nhnacademy.documentcert.controller.rest;

import com.nhnacademy.documentcert.domain.dto.CertificateIssueDto;
import com.nhnacademy.documentcert.entity.CertificateIssue;
import com.nhnacademy.documentcert.service.CertificateIssueService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueRestController {
    private final CertificateIssueService certificateIssueService;

    public IssueRestController(CertificateIssueService certificateIssueService) {
        this.certificateIssueService = certificateIssueService;
    }

    @GetMapping("/all")
    public List<CertificateIssue> getIssuePage() {
        return certificateIssueService.getIssues(1, 1).getContent();
    }

    @GetMapping("/list")
    public List<CertificateIssue> getIssueList() {
        return certificateIssueService.getList();
    }
}
