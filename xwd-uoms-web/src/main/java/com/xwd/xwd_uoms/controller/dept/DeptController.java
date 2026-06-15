package com.xwd.xwd_uoms.controller.dept;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysDepartmentEntity;
import com.xwd.xwd_uoms.service.dept.DeptService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Log(module = "dept")
@RestController
@RequestMapping("/xwd_uoms/api/dept")
public class DeptController {
    @Resource
    private DeptService deptService;

    @PutMapping("/update")
    @RequirePermission(object = "dept",operation = "update")
    public Result<?> deptUpdate(@RequestBody SysDepartmentEntity dept){
        deptService.deptUpdate(dept);
        return Result.success("部门信息更新成功.");
    }

    @PostMapping("/add")
    @RequirePermission(object = "dept",operation = "add")
    public Result<?> deptAdd(@RequestBody SysDepartmentEntity dept){
        deptService.deptAdd(dept);
        return Result.success("部门信息创建成功.");
    }

    @DeleteMapping("/deleted/{deptId}")
    @RequirePermission(object = "dept",operation = "deleted")
    public Result<?> deptDeleted(@PathVariable Long deptId){
        deptService.deptDeleted(deptId);
        return Result.success("部门解散成功.");
    }

    @GetMapping("/show/{deptId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showDept(@PathVariable Long deptId){
        SysDepartmentEntity dept = deptService.showDept(deptId);
        return Result.success(dept);
    }
}
