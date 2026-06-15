package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_feedback")
public class SysFeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "feedback_user_id", nullable = false)
    private Long feedbackUserId;

    @Column(name = "target_object", length = 20, nullable = false)
    private String targetObject;

    @Column(name = "feedback_content", length = 5000)
    private String feedbackContent;

    @Column(name = "feedback_time")
    private LocalDate feedbackTime;

    @Column(name = "handler_user_id", nullable = false)
    private Long handlerUserId;

    @Column(name = "feedback_status", nullable = false)
    private Byte feedbackStatus;

    @Column(length = 1000)
    private String remark;

    @Column(name = "is_deleted", nullable = false)
    private Byte isDeleted;

    @Column(name = "handle_time")
    private LocalDate handleTime;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}