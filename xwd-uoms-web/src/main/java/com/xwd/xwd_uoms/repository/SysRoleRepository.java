package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleRepository extends JpaRepository<SysRoleEntity,Long> {
    SysRoleEntity findSysRoleEntityById(Long roleId);
}
