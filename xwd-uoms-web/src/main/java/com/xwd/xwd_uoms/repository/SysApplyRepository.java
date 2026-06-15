package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysApplyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysApplyRepository extends JpaRepository<SysApplyEntity,Long> {
    Page<SysApplyEntity> findAllByApproverUserIdAndApplyStatus(Long approverUserId, byte applyStatus, Pageable pageable);

    Page<SysApplyEntity> findAllByApplyUserIdAndApplyStatus(Long applyUserId, byte applyStatus, Pageable pageable);

    Page<SysApplyEntity> findAllByApplyUserId(Long applyUserId, Pageable pageable);

    SysApplyEntity findSysApplyEntityById(Long applyId);
}
