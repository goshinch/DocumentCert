package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.domain.MemberId;
import com.nhnacademy.documentcert.domain.request.MemberCreateRequest;
import com.nhnacademy.documentcert.entity.Authority;
import com.nhnacademy.documentcert.entity.Member;
import com.nhnacademy.documentcert.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public MemberId createMember(MemberCreateRequest request) {
        Member member = new Member();
        member.setMemberId(request.getId());
        member.setName(request.getName());
        member.setPwd(passwordEncoder.encode(request.getPwd()));

        Authority authority = new Authority();
        authority.setMember(member);
        authority.setAuthority(request.getAuthority());

        member.setAuthority(authority);

        userRepository.saveAndFlush(member);

        MemberId memberId = new MemberId();
        memberId.setId(member.getMemberId());

        return memberId;
    }
}
