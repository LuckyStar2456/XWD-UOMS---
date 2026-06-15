package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysNoticeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysNoticeRepository extends JpaRepository<SysNoticeEntity,Long> {
    Page<SysNoticeEntity> findAllByOriginatorId(Long originatorId, Pageable pageable);

    Page<SysNoticeEntity> findAllByMandatoryId(Long mandatoryId, Pageable pageable);

    SysNoticeEntity findSysNoticeEntityById(Long noticeId);
}
