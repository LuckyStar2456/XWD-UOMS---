package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysObjectRepository extends JpaRepository<SysObjectEntity,Long> {
    Long findIdByCode(String code);
}
