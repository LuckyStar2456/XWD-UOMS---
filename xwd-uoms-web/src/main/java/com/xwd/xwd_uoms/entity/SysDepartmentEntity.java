package com.xwd.xwd_uoms.entity;

import cn.hutool.core.date.DateTime;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_department", uniqueConstraints = {
        @UniqueConstraint(name = "uk_sys_dept_orgid_name", columnNames = {"org_id", "name"})
})
public class SysDepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "org_id", nullable = false)
    private Long orgId;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(name = "dept_desc", length = 1000)
    private String deptDesc;

    @Column(nullable = false)
    private Byte status;

    @Column(name = "is_deleted", nullable = false)
    private Byte isDeleted;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}
