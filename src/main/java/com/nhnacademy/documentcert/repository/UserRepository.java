package com.nhnacademy.documentcert.repository;

import com.nhnacademy.documentcert.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Member, String> {
}
