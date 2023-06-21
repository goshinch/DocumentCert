package com.nhnacademy.documentcert.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "household_movement_address")
public class HouseholdMovementAddress {
    @EmbeddedId
    private PK id;

    @ManyToOne
    @JoinColumn(name = "household_serial_number", insertable = false, updatable = false)
    private Household household;

    @Column(name = "house_movement_address")
    private String houseMovementAddress;

    @Column(name = "last_address_yn", nullable = false, columnDefinition = "varchar(1) default 'Y'")
    private String lastAddressYN;

    @NoArgsConstructor
    @Getter
    @Setter
    @Embeddable
    public static class PK implements Serializable {
        @Column(name = "household_serial_number")
        private int householdSerialNumber;

        @Column(name = "house_movement_report_date")
        private LocalDate houseMovementReportDate;
    }
}