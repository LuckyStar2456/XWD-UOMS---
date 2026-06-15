package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.Map;

@Data
@Entity
@Table(name = "sys_apply")
public class SysApplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apply_user_id", nullable = false)
    private Long applyUserId;

    @Column(name = "apply_operation_code", length = 50, nullable = false)
    private String applyOperationCode;

    @Column(name = "target_object", length = 20, nullable = false)
    private String targetObject;

    @Column(name = "apply_desc", length = 2000)
    private String applyDesc;

    @Column(name = "apply_content", nullable = false, columnDefinition = "JSON")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> applyContent;

    @Column(name = "apply_time")
    private LocalDate applyTime;

    @Column(name = "approver_user_id")
    private Long approverUserId;

    @Column(name = "apply_status", nullable = false)
    private Byte applyStatus;

    @Column(length = 1000)
    private String remark;

    @Column(name = "is_deleted", nullable = false)
    private Byte isDeleted;

    @Column(name = "approve_time")
    private LocalDate approveTime;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}