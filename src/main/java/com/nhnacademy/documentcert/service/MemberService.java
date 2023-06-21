package com.nhnacademy.documentcert.service;


import com.nhnacademy.documentcert.domain.dto.MemberDto;
import com.nhnacademy.documentcert.entity.Member;

public interface MemberService {
    MemberDto createMember(Member member);
    MemberDto modifyMember(Member member);
    Member getMember(String memberId);
}
