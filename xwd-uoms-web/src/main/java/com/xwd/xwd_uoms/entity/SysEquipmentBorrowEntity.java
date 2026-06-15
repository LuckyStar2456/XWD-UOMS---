package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_equipment_borrow")
public class SysEquipmentBorrowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "equipment_id", nullable = false)
    private Long equipmentId;

    @Column(name = "org_id", nullable = false)
    private Long orgId;

    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "borrow_num", nullable = false)
    private Integer borrowNum;

    @Column(name = "borrower_id", nullable = false)
    private Long borrowerId;

    @Column(name = "borrow_time")
    private LocalDate borrowTime;

    @Column(name = "approver_id", nullable = false)
    private Long approverId;

    @Column(name = "approve_time")
    private LocalDate approveTime;

    @Column(name = "return_time")
    private LocalDate returnTime;

    @Column(nullable = false)
    private Byte status;

    @Column(length = 500)
    private String remark;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}