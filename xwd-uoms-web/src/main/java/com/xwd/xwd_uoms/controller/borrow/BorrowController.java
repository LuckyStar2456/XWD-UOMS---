package com.xwd.xwd_uoms.controller.borrow;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysEquipmentBorrowEntity;
import com.xwd.xwd_uoms.service.borrow.BorrowService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Log(module = "borrow")
@RestController
@RequestMapping("/xwd_uoms/api/borrow")
public class BorrowController {
    @Resource
    private BorrowService borrowService;

    @PostMapping("/add")
    @RequirePermission(object = "borrow",operation = "add")
    public Result<?> borrowAdd(@RequestBody SysEquipmentBorrowEntity borrow){
        borrowService.borrowAdd(borrow);
        return Result.success("借取表创建成功.");
    }

    @PutMapping("/update")
    @RequirePermission(object = "borrow",operation = "update")
    public Result<?> borrowUpdate(@RequestBody SysEquipmentBorrowEntity borrow){
        borrowService.borrowUpdate(borrow);
        return Result.success("截取表信息更新成功.");
    }

    @PutMapping("/approve/{approveUserId}")
    @RequirePermission(object = "borrow",operation = "approve")
    public Result<?> approveBorrow(@PathVariable Long approveUserId,@RequestBody SysEquipmentBorrowEntity borrow){
        borrowService.approveBorrow(approveUserId, borrow);
        return Result.success("借取表审批成功.");
    }

    @GetMapping("/org/view/{orgId}")
    @RequirePermission(object = "org",operation = "view")
    public Result<?> showOrgBorrow(@PathVariable Long orgId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentBorrowEntity> page = borrowService.showOrgBorrow(orgId, current, size);
        return Result.success(page);
    }

    @GetMapping("/dept/view/{deptId}")
    @RequirePermission(object = "dept",operation = "view")
    public Result<?> showDeptBorrow(@PathVariable Long deptId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentBorrowEntity> page = borrowService.showDeptBorrow(deptId, current, size);
        return Result.success(page);
    }

    @GetMapping("/received/view/{borrowerId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showUnfBorrow(@PathVariable Long borrowerId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentBorrowEntity> page = borrowService.showUnfBorrow(borrowerId, current, size);
        return Result.success(page);
    }

    @GetMapping("/pending/view/{approveId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showPendBorrow(@PathVariable Long approveId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentBorrowEntity> page = borrowService.showPendBorrow(approveId, current, size);
        return Result.success(page);
    }

    @GetMapping("/show/{borrowId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showBorrow(@PathVariable Long borrowId){
        SysEquipmentBorrowEntity borrow = borrowService.showBorrow(borrowId);
        return Result.success(borrow);
    }
}
