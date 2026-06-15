package com.xwd.xwd_uoms.service.feedback;

import com.xwd.xwd_uoms.entity.SysFeedbackEntity;
import org.springframework.data.domain.Page;

public interface FeedbackService {
    void feedbackUpdate(SysFeedbackEntity feedback);

    void feedbackAdd(SysFeedbackEntity feedback);

    void approveFeedback(SysFeedbackEntity feedback);

    void feedbackDeleted(Long feedbackId);

    Page<SysFeedbackEntity> showRecFeedback(Long handlerUserId, Integer current, Integer size);

    Page<SysFeedbackEntity> showPendFeedback(Long feedbackUserId, Integer current, Integer size);

    SysFeedbackEntity showFeedback(Long feedbackId);
}
