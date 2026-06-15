package com.xwd.xwd_uoms.service.apply;

import com.xwd.xwd_uoms.entity.SysApplyEntity;
import org.springframework.data.domain.Page;

public interface ApplyService {
    void createApply(SysApplyEntity sysApplyEntity);

    Page<SysApplyEntity> showPendApply(Long applyUserId,Integer current,Integer size);

    Page<SysApplyEntity> showRecApply(Long approveUserId,Integer current,Integer size);

    void approveApply(Long approveUserId, SysApplyEntity apply) throws Exception;

    void deletedApply(Long applyId);

    SysApplyEntity showApply(Long applyId);
}
