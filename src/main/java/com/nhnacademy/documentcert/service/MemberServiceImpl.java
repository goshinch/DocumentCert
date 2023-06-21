package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.domain.dto.MemberDto;
import com.nhnacademy.documentcert.entity.Member;
import com.nhnacademy.documentcert.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    @Override
    public MemberDto createMember(Member member) {
        if (getMember(member.getMemberId()) == null) memberRepository.save(member);
        return memberRepository.findByMemberId(member.getMemberId());
    }

    @Transactional
    @Override
    public MemberDto modifyMember(Member member) {
        if (getMember(member.getMemberId()) != null) memberRepository.save(member);
        return memberRepository.findByMemberId(member.getMemberId());
    }

    @Override
    public Member getMember(String memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }
}
