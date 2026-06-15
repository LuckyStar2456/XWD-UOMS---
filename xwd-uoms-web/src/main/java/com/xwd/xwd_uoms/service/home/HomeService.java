package com.xwd.xwd_uoms.service.home;

import com.xwd.xwd_uoms.entity.*;
import org.springframework.data.domain.Page;

public interface HomeService {

    Page<SysApplyEntity> showUnfApply(Long userId, Integer current, Integer size);

    Page<SysTaskEntity> showUnfTask(Long userId, Integer current, Integer size);

    Page<SysEquipmentBorrowEntity> showUnfEquipBorrow(Long userId, Integer current, Integer size);

    Page<SysFeedbackEntity> showUnfFeedBack(Long userId, Integer current, Integer size);

    Page<SysNoticeEntity> showRecNotice(Long userId, Integer current, Integer size);

    Page<SysUserEntity> showAdmin(Integer current, Integer size);
}
