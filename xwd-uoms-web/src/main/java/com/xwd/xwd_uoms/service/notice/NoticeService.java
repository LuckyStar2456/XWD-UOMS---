package com.xwd.xwd_uoms.service.notice;

import com.xwd.xwd_uoms.entity.SysNoticeEntity;
import org.springframework.data.domain.Page;

public interface NoticeService {
    void noticeAdd(SysNoticeEntity notice);

    void noticeUpdate(SysNoticeEntity notice);

    Page<SysNoticeEntity> showRecNotice(Long mandatoryId, Integer current, Integer size);

    Page<SysNoticeEntity> showIniNotice(Long originatorId, Integer current, Integer size);

    void noticeDeleted(Long noticeId);

    SysNoticeEntity showNotice(Long noticeId);
}
