package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_organization", uniqueConstraints = {
        @UniqueConstraint(name = "uk_sys_org_name_type", columnNames = {"name", "type"})
})
public class SysOrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String type;

    @Column(name = "org_desc", length = 1000)
    private String orgDesc;

    @Column(length = 255)
    private String address;

    @Column(length = 20)
    private String phone;

    @Column(nullable = false)
    private Byte status;

    @Column(name = "is_deleted", nullable = false)
    private Byte isDeleted;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}