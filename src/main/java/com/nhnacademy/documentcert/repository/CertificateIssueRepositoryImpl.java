package com.nhnacademy.documentcert.repository;

import com.nhnacademy.documentcert.entity.CertificateIssue;
import com.nhnacademy.documentcert.entity.QCertificateIssue;
import com.nhnacademy.documentcert.entity.QResident;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CertificateIssueRepositoryImpl extends QuerydslRepositorySupport implements CertificateIssueRepositoryCustom {
    public CertificateIssueRepositoryImpl() {
        super(CertificateIssue.class);
    }

    @Override
    public List<CertificateIssue> getIssues() {
        QCertificateIssue certificateIssue = QCertificateIssue.certificateIssue;
        QResident resident = QResident.resident;
        return from(certificateIssue)
                .innerJoin(certificateIssue.residentSerialNumber, resident)
                .select(certificateIssue)
                .fetch();
//        return null;
    }

    @Override
    public CertificateIssue getIssue(int serialNumber, String typeCode) {
        QCertificateIssue certificateIssue = QCertificateIssue.certificateIssue;
        QResident resident = QResident.resident;
        return from(certificateIssue)
                .innerJoin(certificateIssue.residentSerialNumber, resident)
                .where(certificateIssue.residentSerialNumber.residentSerialNumber.eq(serialNumber).and(certificateIssue.certificateTypeCode.contains(typeCode)))
                .select(certificateIssue).fetchOne();
//        return null;
    }
}
