package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysDepartmentEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface SysDepartmentRepository extends JpaRepository<SysDepartmentEntity,Long> {
    Long findIdByOrgIdAndName(Long orgId, String deptName);

    Page<SysDepartmentEntity> findAllByOrgId(Long orgId, Pageable pageable);

    Page<SysDepartmentEntity> findAllByNameLike(String name, Pageable pageable);

    @Query("SELECT d.name FROM SysDepartmentEntity d WHERE d.id = :deptId")
    String findNameById(@Param("deptId") Long deptId);

    SysDepartmentEntity findSysDepartmentEntityById(Long dept);

    SysDepartmentEntity findSysDepartmentEntityByOrgIdAndName(Long orgId, String name);
}
