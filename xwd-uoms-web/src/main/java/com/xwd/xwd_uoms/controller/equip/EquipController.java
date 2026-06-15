package com.xwd.xwd_uoms.controller.equip;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysEquipmentEntity;
import com.xwd.xwd_uoms.service.equip.EquipService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Log(module = "equip")
@RestController
@RequestMapping("/xwd_uoms/api/equip")
public class EquipController {
    @Resource
    private EquipService equipService;

    @PutMapping("/update")
    @RequirePermission(object = "equip",operation = "update")
    public Result<?> equipUpdate(@RequestBody SysEquipmentEntity equip){
        equipService.equipUpdate(equip);
        return Result.success("设备信息更新成功.");
    }

    @PostMapping("/add")
    @RequirePermission(object = "equip",operation = "add")
    public Result<?> equipAdd(@RequestBody SysEquipmentEntity equip){
        equipService.equipAdd(equip);
        return Result.success("设备添加成功.");
    }

    @PutMapping("/borrow/{equipId}/{borrowNum}")
    @RequirePermission(object = "equip",operation = "update")
    public Result<?> equipBorrow(@PathVariable Long equipId, @PathVariable Integer borrowNum){
        equipService.equipBorrow(equipId,borrowNum);
        return Result.success("设备借取成功.");
    }

    @DeleteMapping("/deleted/{equipId}")
    @RequirePermission(object = "equip",operation = "deleted")
    public Result<?> equipDeleted(@PathVariable Long equipId){
        equipService.equipDeleted(equipId);
        return Result.success("设备删除成功.");
    }

    @GetMapping("/org/view/{orgId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showOrgEquip(@PathVariable Long orgId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size) {
        Page<SysEquipmentEntity> page = equipService.showOrgEquip(orgId, current, size);
        return Result.success(page);
    }

    @GetMapping("/dept/view/{deptId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showDeptEquip(@PathVariable Long deptId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size) {
        Page<SysEquipmentEntity> page = equipService.showDeptEquip(deptId, current, size);
        return Result.success(page);
    }

    @GetMapping("/show/{equipId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showEquip(@PathVariable Long equipId){
        SysEquipmentEntity equip = equipService.showEquip(equipId);
        return Result.success(equip);
    }
}
