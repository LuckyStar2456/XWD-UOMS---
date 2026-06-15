package com.xwd.xwd_uoms.service.task;

import com.xwd.xwd_uoms.entity.SysTaskEntity;
import org.springframework.data.domain.Page;

public interface TaskService {

    void taskUpdate(SysTaskEntity task);

    void taskAdd(SysTaskEntity task);

    void taskDeleted(Long id);

    Page<SysTaskEntity> showRecTask(Long mandatoryId, Integer current, Integer size);

    Page<SysTaskEntity> showPendTask(Long originatorId, Integer current, Integer size);

    void finiTask(SysTaskEntity task);

    SysTaskEntity showTask(Long taskId);
}
