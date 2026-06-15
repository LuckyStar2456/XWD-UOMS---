package com.xwd.xwd_uoms.service.equip;

import com.xwd.xwd_uoms.entity.SysEquipmentEntity;
import org.springframework.data.domain.Page;

public interface EquipService {
    void equipUpdate(SysEquipmentEntity equip);

    void equipAdd(SysEquipmentEntity equip);

    SysEquipmentEntity showEquip(Long equipId);

    void equipDeleted(Long id);

    void equipBorrow(Long equipId, Integer borrowNum);

    Page<SysEquipmentEntity> showOrgEquip(Long orgId, Integer current, Integer size);

    Page<SysEquipmentEntity> showDeptEquip(Long deptId, Integer current, Integer size);
}
