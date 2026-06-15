package com.xwd.xwd_uoms.controller.home;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.*;
import com.xwd.xwd_uoms.service.home.HomeService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Log(module = "home")
@RestController
@RequestMapping("/xwd_uoms/api/home")
public class HomeController {
    @Resource
    private HomeService homeService;

    @RequirePermission(object = "",operation = "")
    @GetMapping("/received/apply/{userId}")
    public Result<?> showUnfApply(@PathVariable Long userId, @RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysApplyEntity> page = homeService.showUnfApply(userId, current, size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/received/task/{userId}")
    public Result<?> showUnfTask(@PathVariable Long userId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysTaskEntity> page = homeService.showUnfTask(userId, current, size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/received/equipborrow/{userId}")
    public Result<?> showUnfEquipBorrow(@PathVariable Long userId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentBorrowEntity> page = homeService.showUnfEquipBorrow(userId, current, size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/received/feedback/{userId}")
    public Result<?> showUnfFeedback(@PathVariable Long userId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysFeedbackEntity> page = homeService.showUnfFeedBack(userId, current, size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/received/notice/{userId}")
    public Result<?> showRecNotice(@PathVariable Long userId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysNoticeEntity> page = homeService.showRecNotice(userId, current, size);
        return Result.success(page);
    }

    @RequirePermission(object = "admin",operation = "view")
    @GetMapping("/show/admin")
    public Result<?> showAdmin(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysUserEntity> page = homeService.showAdmin(current, size);
        return Result.success(page);
    }
}
