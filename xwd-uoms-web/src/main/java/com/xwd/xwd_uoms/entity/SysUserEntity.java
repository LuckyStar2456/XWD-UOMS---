package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_user", uniqueConstraints = {
        @UniqueConstraint(name = "uk_sys_user_username", columnNames = "username"),
        @UniqueConstraint(name = "uk_sys_user_phone", columnNames = "phone")
})
public class SysUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String grade;

    @Column(length = 20, nullable = false)
    private String phone;

    @Column(length = 100)
    private String email;

    @Column(name = "org_id")
    private Long orgId;

    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(nullable = false)
    private Byte status;

    @Column(name = "is_deleted", nullable = false)
    private Byte isDeleted;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}