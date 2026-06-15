package com.xwd.xwd_uoms.controller.search;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysDepartmentEntity;
import com.xwd.xwd_uoms.entity.SysEquipmentEntity;
import com.xwd.xwd_uoms.entity.SysOrganizationEntity;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import com.xwd.xwd_uoms.service.search.SearchService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Log(module = "search")
@RestController
@RequestMapping("/xwd_uoms/api/search")
public class SearchController {
    @Resource
    private SearchService searchService;

    @RequirePermission(object = "",operation = "")
    @GetMapping("/user/{userName}")
    public Result<?> searchUser(@PathVariable(required = false) String userName, @RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysUserDTO> page = searchService.searchUser(userName,current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/user/all")
    public Result<?> searchAllUser(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysUserDTO> page = searchService.searchAllUser(current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/org/all")
    public Result<?> searchAllOrg(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysOrganizationEntity> page = searchService.searchAllOrg(current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/dept/all")
    public Result<?> searchAllDept(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysDepartmentEntity> page = searchService.searchAllDept(current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/equip/all")
    public Result<?> searchAllEquip(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentEntity> page = searchService.searchAllEquip(current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/org/{orgName}")
    public Result<?> searchOrg(@PathVariable(required = false) String orgName,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysOrganizationEntity> page = searchService.searchOrg(orgName,current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/org/{orgId}/dept")
    public Result<?> searchOrgDept(@PathVariable(required = false) Long orgId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysDepartmentEntity> page = searchService.searchOrgDept(orgId,current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/org/{orgId}/equip")
    public Result<?> searchOrgEquip(@PathVariable(required = false) Long orgId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentEntity> page = searchService.searchOrgEquip(orgId,current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/dept/{deptName}")
    public Result<?> searchDept(@PathVariable(required = false) String deptName,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysDepartmentEntity> page = searchService.searchDept(deptName,current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/dept/{deptId}/user")
    public Result<?> searchDeptUser(@PathVariable(required = false) Long deptId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysUserDTO> page = searchService.searchDeptUser(deptId,current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/dept/{deptId}/equip")
    public Result<?> searchDeptEquip(@PathVariable(required = false) Long deptId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentEntity> page = searchService.searchDeptEquip(deptId,current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/equip/{equipName}")
    public Result<?> searchEquip(@PathVariable(required = false) String equipName,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentEntity> page = searchService.searchEquip(equipName,current,size);
        return Result.success(page);
    }
}
