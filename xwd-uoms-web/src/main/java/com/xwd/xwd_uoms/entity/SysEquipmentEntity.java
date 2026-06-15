package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_equipment", uniqueConstraints = {
        @UniqueConstraint(name = "uk_sys_equip_org_dept_name", columnNames = {"org_id", "dept_id", "name"})
})
public class SysEquipmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(name = "equipment_desc", length = 500)
    private String equipmentDesc;

    @Column(name = "org_id", nullable = false)
    private Long orgId;

    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "total_num", nullable = false)
    private Integer totalNum;

    @Column(name = "available_num", nullable = false)
    private Integer availableNum;

    @Column(nullable = false)
    private Byte status;

    @Column(name = "is_deleted", nullable = false)
    private Byte isDeleted;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}