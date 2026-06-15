package com.xwd.xwd_uoms.service.borrow;

import com.xwd.xwd_uoms.entity.SysEquipmentBorrowEntity;
import org.springframework.data.domain.Page;

public interface BorrowService {
    void borrowAdd(SysEquipmentBorrowEntity borrow);

    void approveBorrow(Long approveUserId, SysEquipmentBorrowEntity borrow);

    void borrowUpdate(SysEquipmentBorrowEntity borrow);

    Page<SysEquipmentBorrowEntity> showOrgBorrow(Long orgId, Integer current, Integer size);

    Page<SysEquipmentBorrowEntity> showDeptBorrow(Long deptId, Integer current, Integer size);

    Page<SysEquipmentBorrowEntity> showUnfBorrow(Long borrowerId, Integer current, Integer size);

    Page<SysEquipmentBorrowEntity> showPendBorrow(Long approverId, Integer current, Integer size);

    SysEquipmentBorrowEntity showBorrow(Long borrowId);
}
