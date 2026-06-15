package com.xwd.xwd_uoms.controller.apply;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysApplyEntity;
import com.xwd.xwd_uoms.service.apply.ApplyService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Log(module = "apply")
@RestController
@RequestMapping("/xwd_uoms/api/apply")
public class ApplyController {
    @Resource
    private ApplyService applyService;

    @PostMapping("/add")
    @RequirePermission(object = "",operation = "")
    public Result<?> applyAdd(@RequestBody SysApplyEntity apply){
        applyService.createApply(apply);
        return Result.success("申请表创建成功.");
    }

    @GetMapping("/pending/view/{applyUserId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showPendApply(@PathVariable Long applyUserId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysApplyEntity> page = applyService.showPendApply(applyUserId, current, size);
        return Result.success(page);
    }

    @GetMapping("/received/view/{approveUserId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showRecApply(@PathVariable Long approveUserId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysApplyEntity> page = applyService.showRecApply(approveUserId, current, size);
        return Result.success(page);
    }

    @PutMapping("/approve/{approveUserId}")
    @RequirePermission(object = "apply",operation = "approve")
    public Result<?> approveApply(@PathVariable Long approveUserId, @RequestBody SysApplyEntity apply) throws Exception {
        applyService.approveApply(approveUserId, apply);
        return Result.success("申请表审批成功.");
    }

    @DeleteMapping("/deleted/{applyId}")
    @RequirePermission(object = "apply",operation = "deleted")
    public Result<?> deletedApply(@PathVariable Long applyId){
        applyService.deletedApply(applyId);
        return Result.success("申请表撤销成功.");
    }

    @GetMapping("/show/{applyId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showApply(@PathVariable Long applyId){
        SysApplyEntity apply = applyService.showApply(applyId);
        return Result.success(apply);
    }
}
