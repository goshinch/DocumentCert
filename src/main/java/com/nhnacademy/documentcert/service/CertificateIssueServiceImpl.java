package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.domain.dto.CertificateIssueDto;
import com.nhnacademy.documentcert.entity.CertificateIssue;
import com.nhnacademy.documentcert.repository.CertificateIssueRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("certificateIssueService")
public class CertificateIssueServiceImpl implements CertificateIssueService {
    private final CertificateIssueRepository certificateIssueRepository;

    public CertificateIssueServiceImpl(CertificateIssueRepository certificateIssueRepository) {
        this.certificateIssueRepository = certificateIssueRepository;
    }

    @Override
    public List<CertificateIssue> getList() {
        return certificateIssueRepository.findAll();
    }

    @Override
    public long getSize() {
        return getList().size();
    }

    @Override
    public Page<CertificateIssue> getIssues(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by("certificateIssueDate").descending());

        return certificateIssueRepository.findAll(pageable);
    }
}
