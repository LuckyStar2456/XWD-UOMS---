package com.xwd.xwd_uoms.controller.user;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.common.util.JwtUtil;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.entity.dto.AdminDTO;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import com.xwd.xwd_uoms.service.user.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Log(module = "user")
@RestController
@RequestMapping("/xwd_uoms/api/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequirePermission(object = "",operation = "")
    @PutMapping("/self/update/{userId}")
    public Result<?> updateSelf(@PathVariable Long userId,@RequestBody SysUserDTO sysUserDTO) throws Exception {
        userService.userUpdate(userId,sysUserDTO);
        return Result.success("用户数据更新成功.");
    }

    @RequirePermission(object = "",operation = "")
    @PutMapping("/self/cancel")
    public Result<?> cancelSelf(@RequestBody String refreshToken) throws Exception {
        userService.userDelete(refreshToken);
        return Result.success("用户注销成功.");
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/view/{userId}")
    public Result<?> showSelf(@PathVariable Long userId) throws Exception {
        SysUserDTO self = userService.userView(userId);
        return Result.success(self);
    }

    @RequirePermission(object = "user",operation = "add")
    @PostMapping("/oth/add")
    public Result<?> userAdd(@RequestBody SysUserDTO sysUserDTO) throws Exception {
        userService.userAdd(sysUserDTO);
        return Result.success("用户添加成功.");
    }

    @RequirePermission(object = "user",operation = "update")
    @PutMapping("/oth/update")
    public Result<?> userUpdate(@RequestBody SysUserDTO sysUserDTO) throws Exception {
        userService.userUpdate(sysUserDTO);
        return Result.success("用户数据更新成功.");
    }

    @RequirePermission(object = "user",operation = "move")
    @PutMapping("/oth/move")
    public Result<?> userMove(@RequestBody SysUserDTO sysUserDTO) throws Exception {
        userService.userMove(sysUserDTO);
        return Result.success("用户迁移成功.");
    }

    @RequirePermission(object = "user",operation = "delete")
    @DeleteMapping("/oth/delete/{userId}")
    public Result<?> userDelete(@PathVariable Long userId) throws Exception {
        userService.userDelete(userId);
        return Result.success("用户删除成功.");
    }

    @RequirePermission(object = "perm",operation = "update")
    @PutMapping("/perm/update")
    public Result<?> permUpdate(@RequestBody AdminDTO adminDTO) throws Exception {
        userService.permUpdate(adminDTO);
        return Result.success("用户权限变更成功.");
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/show/admin/{orgId}")
    public Result<?> showOrgAdmin(@PathVariable(required = false) Long orgId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysUserEntity> page = userService.showAdmin(orgId, current, size);
        return Result.success(page);
    }
}
