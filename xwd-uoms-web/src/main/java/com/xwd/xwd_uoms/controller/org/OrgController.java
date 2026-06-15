package com.xwd.xwd_uoms.controller.org;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysOrganizationEntity;
import com.xwd.xwd_uoms.service.org.OrgService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Log(module = "org")
@RestController
@RequestMapping("/xwd_uoms/api/org")
public class OrgController {
    @Resource
    private OrgService orgService;

    @RequirePermission(object = "",operation = "")
    @GetMapping("/show/{orgId}")
    public Result<?> showOrg(@PathVariable Long orgId){
        SysOrganizationEntity org = orgService.showOrg(orgId);
        return Result.success(org);
    }

    @RequirePermission(object = "org",operation = "update")
    @PutMapping("/update")
    public Result<?> updateOrg(@RequestBody SysOrganizationEntity newOrg){
        orgService.orgUpdate(newOrg);
        return Result.success("组织信息更新成功.");
    }

    @RequirePermission(object = "org",operation = "add")
    @PostMapping("/add")
    public Result<?> addOrg(@RequestBody SysOrganizationEntity org){
        orgService.orgAdd(org);
        return Result.success("组织信息添加成功.");
    }

    @RequirePermission(object = "org",operation = "deleted")
    @DeleteMapping("/deleted/{orgId}")
    public Result<?> deletedOrg(@PathVariable Long orgId){
        orgService.orgDeleted(orgId);
        return Result.success("组织解散成功.");
    }
}
