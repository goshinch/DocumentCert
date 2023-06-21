package com.nhnacademy.documentcert.controller;

import com.nhnacademy.documentcert.domain.dto.CertificateIssueDto;
import com.nhnacademy.documentcert.entity.CertificateIssue;
import com.nhnacademy.documentcert.service.CertificateIssueService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

@Controller
@RequestMapping("/certificate-issue")
public class IssueController {
    private final CertificateIssueService certificateIssueService;
    private final static int PAGE_SIZE = 1;

    public IssueController(CertificateIssueService certificateIssueService) {
        this.certificateIssueService = certificateIssueService;
    }

    @GetMapping("/all")
    public String getIssuePage(@RequestParam(value = "page", required = false) Long point, Model model) {
        long pageCount = certificateIssueService.getSize() / PAGE_SIZE;
        Page<CertificateIssueDto> page = certificateIssueService.getIssues(Math.toIntExact(point > pageCount? pageCount - 1 : point - 1), PAGE_SIZE).map(new Function<CertificateIssue, CertificateIssueDto>() {
            @Override
            public CertificateIssueDto apply(CertificateIssue certificateIssue) {
                return new CertificateIssueDto() {
                    @Override
                    public Long getCertificateConfirmationNumber() {
                        return certificateIssue.getCertificateConfirmationNumber();
                    }

                    @Override
                    public String getName() {
                        return certificateIssue.getResidentSerialNumber().getName();
                    }

                    @Override
                    public String getCertificateTypeCode() {
                        return certificateIssue.getCertificateTypeCode();
                    }

                    @Override
                    public LocalDate getCertificateIssueDate() {
                        return certificateIssue.getCertificateIssueDate();
                    }
                };
            }
        });
        long begin = 1 < page.getNumber() - 4? page.getNumber() - 4 : 1;
        long end = begin + 8 < page.getTotalPages()? begin + 8 : page.getTotalPages();
        model.addAttribute("page", page);
        model.addAttribute("begin", begin);
        model.addAttribute("end", end);
        model.addAttribute("posts", page.getContent());
        return "/issue.html";
    }

}
