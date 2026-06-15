package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends JpaRepository<SysUserEntity,Long> {
    SysUserEntity findSysUserEntityByUsername(String username);

    SysUserEntity findSysUserEntityById(Long id);

    SysUserEntity findByUsername(@NotBlank(message = "账号不能为空.") String username);

    Page<SysUserEntity> findAllByNameLike(String name, Pageable pageable);

    Page<SysUserEntity> findAllByDeptId(Long deptId, Pageable pageable);

    Page<SysUserEntity> findAllByRoleIdNot(long roleId, Pageable pageable);

    Long findRoleIdById(Long userId);

    Page<SysUserEntity> findAllByOrgIdAndRoleIdNot(Long orgId, long l, Pageable pageable);
}
