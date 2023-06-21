package com.nhnacademy.documentcert.controller.rest;

import com.nhnacademy.documentcert.domain.dto.MemberDto;
import com.nhnacademy.documentcert.entity.Member;
import com.nhnacademy.documentcert.service.MemberService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberSaveRestController {
    private final MemberService memberService;
    public MemberSaveRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/member/{memberId}/{pwd}")
    public MemberDto saveMember(@PathVariable("memberId") String memberId, @PathVariable("pwd") String pwd) {
        Member member = new Member();
        member.setMemberId(memberId);
        member.setName("신동민");
        member.setPwd(pwd);

        return memberService.createMember(member);
    }

}
