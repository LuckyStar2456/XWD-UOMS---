package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysOperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysOperationRepository extends JpaRepository<SysOperationEntity,Long> {
    Long findIdByCode(String code);
}
