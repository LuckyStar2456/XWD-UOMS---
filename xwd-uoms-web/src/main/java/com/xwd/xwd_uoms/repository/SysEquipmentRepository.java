package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysEquipmentEntity;
import com.xwd.xwd_uoms.entity.SysTaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysEquipmentRepository extends JpaRepository<SysEquipmentEntity,Long> {
    Page<SysEquipmentEntity> findAllByOrgId(Long orgId, Pageable pageable);

    Page<SysEquipmentEntity> findAllByDeptId(Long deptId, Pageable pageable);

    Page<SysEquipmentEntity> findAllByNameLike(String name, Pageable pageable);

    SysEquipmentEntity findSysEquipmentEntityById(Long equipId);
}
