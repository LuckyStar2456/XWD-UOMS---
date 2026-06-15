package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysOrganizationEntity;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SysOrganizationRepository extends JpaRepository<SysOrganizationEntity,Long> {
    Long findIdByTypeAndName(String orgType, String orgName);

    Page<SysOrganizationEntity> findAllByNameLike(String name, Pageable pageable);

    @Query("SELECT o.name FROM SysOrganizationEntity o WHERE o.id = :orgId")
    String findNameById(@Param("orgId") Long orgId);

    @Query("SELECT o.type FROM SysOrganizationEntity o WHERE o.id = :orgId")
    String findTypeById(@Param("orgId") Long orgId);

    SysOrganizationEntity findSysOrganizationEntityById(Long id);

    SysOrganizationEntity findSysOrganizationEntityByNameAndType(String name, String type);
}
