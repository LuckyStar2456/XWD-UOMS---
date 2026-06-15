package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysEquipmentBorrowEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysEquipmentBorrowRepository extends JpaRepository<SysEquipmentBorrowEntity,Long> {
    Page<SysEquipmentBorrowEntity> findAllByBorrowerIdAndStatus(Long borrowerId, byte status, Pageable pageable);

    Page<SysEquipmentBorrowEntity> findAllByApproverIdAndStatus(Long approverId, byte status, Pageable pageable);

    SysEquipmentBorrowEntity findSysEquipmentBorrowEntityById(Long id);

    Page<SysEquipmentBorrowEntity> findAllByApproverId(Long approverId, Pageable pageable);

    Page<SysEquipmentBorrowEntity> findAllByBorrowerId(Long borrowerId, Pageable pageable);

    Page<SysEquipmentBorrowEntity> findAllByDeptId(Long deptId, Pageable pageable);

    Page<SysEquipmentBorrowEntity> findAllByOrgId(Long orgId, Pageable pageable);
}
