package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysFeedbackEntity;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysFeedbackRepository extends JpaRepository<SysFeedbackEntity,Long> {
    Page<SysFeedbackEntity> findAllByHandlerUserIdAndFeedbackStatus(Long handlerUserId, byte feedbackStatus, Pageable pageable);

    Page<SysFeedbackEntity> findAllByFeedbackUserIdAndFeedbackStatus(Long feedbackUserId, byte feedbackStatus, Pageable pageable);

    SysFeedbackEntity findSysFeedbackEntityById(Long id);

    Page<SysFeedbackEntity> findAllByHandlerUserId(Long handlerUserId, Pageable pageable);

    Page<SysFeedbackEntity> findAllByFeedbackUserId(Long feedbackUserId, Pageable pageable);

    SysFeedbackEntity findSysFeedbackById(Long id);
}
