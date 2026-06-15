package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysTaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysTaskRepository extends JpaRepository<SysTaskEntity,Long> {
    Page<SysTaskEntity> findAllByMandatoryIdAndStatus(Long mandatoryId, byte b, Pageable pageable);

    Page<SysTaskEntity> findAllByOriginatorIdAndStatus(Long originatorId, byte b, Pageable pageable);

    SysTaskEntity findSysTaskEntityById(Long taskId);

    Page<SysTaskEntity> findAllByMandatoryId(Long mandatoryId, Pageable pageable);

    Page<SysTaskEntity> findAllByOriginatorId(Long originatorId, Pageable pageable);
}
