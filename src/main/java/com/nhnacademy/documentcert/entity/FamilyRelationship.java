package com.nhnacademy.documentcert.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "family_relationship")
public class FamilyRelationship {
    @EmbeddedId
    private PK pk;

    @ManyToOne
    @MapsId("baseResidentSerialNumber")
    @JoinColumn(name = "base_resident_serial_number")
    private Resident baseResident;

    @ManyToOne
    @MapsId("familyResidentSerialNumber")
    @JoinColumn(name = "family_resident_serial_number")
    private Resident familyResident;

    @Column(name = "family_relationship_code", nullable = false)
    private String familyRelationshipCode;

    @NoArgsConstructor
    @Getter
    @Setter
    @Embeddable
    public static class PK implements Serializable {
        @Column(name = "base_resident_serial_number")
        private int baseResidentSerialNumber;

        @Column(name = "family_resident_serial_number")
        private int familyResidentSerialNumber;
    }
}
