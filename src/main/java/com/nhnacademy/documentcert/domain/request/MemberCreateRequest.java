package com.nhnacademy.documentcert.domain.request;

import lombok.Data;

@Data
public class MemberCreateRequest {
    private String id;
    private String name;
    private String pwd;
    private String authority;
}
