package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysRolePermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRolePermissionRepository extends JpaRepository<SysRolePermissionEntity,Long> {
    boolean existsByRoleIdAndObjectIdAndOperationId(Long roleId, Long objectId, Long operationId);
}
