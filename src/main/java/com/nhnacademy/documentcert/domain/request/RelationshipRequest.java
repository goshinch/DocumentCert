package com.nhnacademy.documentcert.domain.request;

import lombok.Data;

@Data
public class RelationshipRequest {
    private int familyResidentSerialNumber;
    private String familyRelationshipCode;
}
