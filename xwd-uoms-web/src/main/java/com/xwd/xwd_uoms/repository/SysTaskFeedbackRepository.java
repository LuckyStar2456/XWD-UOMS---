package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysFeedbackEntity;
import com.xwd.xwd_uoms.entity.SysTaskFeedbackEntity;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysTaskFeedbackRepository extends JpaRepository<SysTaskFeedbackEntity,Long> {
    SysTaskFeedbackEntity findSysTaskFeedbackEntityById(Long id);

    Page<SysTaskFeedbackEntity> findAllByFeedbackUserId(Long feedbackUserId, Pageable pageable);

    Page<SysTaskFeedbackEntity> findAllByReviewUserId(Long reviewUserId, Pageable pageable);

    SysTaskFeedbackEntity findSysTaskFeedbackById(Long id);
}
