package com.nhnacademy.documentcert.service;

import com.nhnacademy.documentcert.entity.Member;
import com.nhnacademy.documentcert.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = userRepository.findById(username).orElse(null);

        return User.builder()
                .username(member.getName())
                .password(member.getPwd())
                .authorities(Collections.singleton(new SimpleGrantedAuthority(member.getAuthority().getAuthority())))
                .build();
    }
}
