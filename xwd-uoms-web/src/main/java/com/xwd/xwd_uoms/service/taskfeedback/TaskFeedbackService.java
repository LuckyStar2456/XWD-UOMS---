package com.xwd.xwd_uoms.service.taskfeedback;

import com.xwd.xwd_uoms.entity.SysTaskFeedbackEntity;
import org.springframework.data.domain.Page;

public interface TaskFeedbackService {
    void taskFeedbackUpdate(SysTaskFeedbackEntity taskFeedback);

    void taskFeedbackAdd(SysTaskFeedbackEntity taskFeedback);

    Page<SysTaskFeedbackEntity> showRecTaskFeedback(Long reviewUserId, Integer current, Integer size);

    Page<SysTaskFeedbackEntity> showPendTaskFeedback(Long feedbackUserId, Integer current, Integer size);

    void approveTaskFeedback(Long reviewUserId, SysTaskFeedbackEntity taskFeedback);

    SysTaskFeedbackEntity showTaskFeedback(Long taskFeedbackId);
}
