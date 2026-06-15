package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_role_permission")
public class SysRolePermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "object_id")
    private Long objectId;

    @Column(name = "operation_id")
    private Long operationId;

    @Column(nullable = false)
    private Byte status;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}
