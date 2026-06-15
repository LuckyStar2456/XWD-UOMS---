package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_object", uniqueConstraints = {
        @UniqueConstraint(name = "uk_sys_object_code", columnNames = "code")
})
public class SysObjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50, nullable = false)
    private String code;

    @Column(name = "object_desc", length = 500)
    private String objectDesc;

    @Column(nullable = false)
    private Byte status;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}