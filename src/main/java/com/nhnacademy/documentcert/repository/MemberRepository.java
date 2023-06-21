package com.nhnacademy.documentcert.repository;

import com.nhnacademy.documentcert.domain.dto.MemberDto;
import com.nhnacademy.documentcert.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    MemberDto findByMemberId(String memberId);
}
