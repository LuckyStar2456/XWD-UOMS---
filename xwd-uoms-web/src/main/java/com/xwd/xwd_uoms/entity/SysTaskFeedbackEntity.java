package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_task_feedback")
public class SysTaskFeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_id", nullable = false)
    private Long taskId;

    @Column(name = "feedback_user_id", nullable = false)
    private Long feedbackUserId;

    @Column(name = "feedback_content", length = 1000)
    private String feedbackContent;

    @Column(name = "feedback_time")
    private LocalDate feedbackTime;

    @Column(name = "review_user_id")
    private Long reviewUserId;

    @Column(name = "review_content", length = 1000)
    private String reviewContent;

    @Column(name = "review_status", nullable = false)
    private Byte reviewStatus;

    @Column(name = "review_time")
    private LocalDate reviewTime;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}