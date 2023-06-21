package com.nhnacademy.documentcert.domain.dto;

import org.springframework.beans.factory.annotation.Value;

public interface MemberDto {
    @Value("#{target.memberId}")
    String getId();
    @Value("#{target.name}")
    String getName();
    @Value("#{target.pwd}")
    String getPwd();
}
