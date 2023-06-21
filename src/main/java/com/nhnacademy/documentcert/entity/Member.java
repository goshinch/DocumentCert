package com.nhnacademy.documentcert.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "Members")
public class Member {
    @Id
    @Column(name = "member_id")
    private String memberId;
    private String name;
    private String pwd;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private Authority authority;
}

