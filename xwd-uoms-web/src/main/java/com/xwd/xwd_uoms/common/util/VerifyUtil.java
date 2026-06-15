package com.xwd.xwd_uoms.common.util;

import com.xwd.xwd_uoms.common.exception.PermissionException;
import com.xwd.xwd_uoms.entity.*;
import com.xwd.xwd_uoms.repository.SysObjectRepository;
import com.xwd.xwd_uoms.repository.SysOperationRepository;
import com.xwd.xwd_uoms.repository.SysOrganizationRepository;
import com.xwd.xwd_uoms.repository.SysRolePermissionRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class VerifyUtil {
    @Resource
    private SysObjectRepository sysObjectRepository;

    @Resource
    private SysOperationRepository sysOperationRepository;

    @Resource
    private SysRolePermissionRepository sysRolePermissionRepository;

    public boolean isExist(String str){
        if (str == null || str.trim().isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    public boolean isExist(SysUserEntity sysUser){
        if (sysUser == null || sysUser.getIsDeleted() == 1 || sysUser.getStatus() == 0){
            return false;
        }else{
            return true;
        }
    }
    public boolean isExist(SysOrganizationEntity sysOrganization){
        if (sysOrganization == null || sysOrganization.getIsDeleted() == 1 || sysOrganization.getStatus() == 0){
            return false;
        }else{
            return true;
        }
    }
    public boolean isExist(SysDepartmentEntity sysDepartment){
        if (sysDepartment == null || sysDepartment.getIsDeleted() == 1 || sysDepartment.getStatus() == 0){
            return false;
        }else{
            return true;
        }
    }
    public boolean isExist(SysEquipmentEntity sysEquipment){
        if (sysEquipment == null || sysEquipment.getIsDeleted() == 1 || sysEquipment.getStatus() == 0){
            return false;
        }else{
            return true;
        }
    }
    public boolean isExist(SysRoleEntity sysRole){
        if (sysRole == null || sysRole.getIsDeleted() == 1 || sysRole.getStatus() == 0){
            return false;
        }else{
            return true;
        }
    }
    public boolean isExist(SysNoticeEntity sysNotice){
        if (sysNotice == null || sysNotice.getIsDeleted() == 1){
            return false;
        }else{
            return true;
        }
    }
    public boolean isExist(SysApplyEntity apply){
        if (apply == null || apply.getIsDeleted() == 1){
            return false;
        }else{
            return true;
        }
    }
    public boolean isExist(Integer num){
        if (num == null || num < 0){
            return false;
        }else{
            return true;
        }
    }
    public <T> boolean isExist(T data){
        if (data == null){
            return false;
        }else{
            return true;
        }
    }

    public boolean hasPerm(Long userRoleId, String objectCode, String operationCode){
        if ((objectCode == null || objectCode.isEmpty()) && (operationCode == null || operationCode.isEmpty())) {
            return true;
        }

        if (userRoleId == null){
            return false;
        }

        try {
            Long objectId = sysObjectRepository.findIdByCode(objectCode);
            if (objectId == null) {
                return false;
            }

            Long operationId = sysOperationRepository.findIdByCode(operationCode);
            if (operationId == null) {
                return false;
            }

            boolean hasPermission = sysRolePermissionRepository.existsByRoleIdAndObjectIdAndOperationId(
                    userRoleId, objectId, operationId
            );
            if (hasPermission) {
                return true;
            }

            boolean hasAllPermission = sysRolePermissionRepository.existsByRoleIdAndObjectIdAndOperationId(
                    userRoleId, 1L, 1L
            );
            if (hasAllPermission) {
                return true;
            }

            boolean hasObjectPermission = sysRolePermissionRepository.existsByRoleIdAndObjectIdAndOperationId(
                    userRoleId,1L,operationId
            );
            if (hasObjectPermission) {
                return true;
            }

            boolean hasOperationPermission = sysRolePermissionRepository.existsByRoleIdAndObjectIdAndOperationId(
                    userRoleId,objectId,1L
            );
            if (hasOperationPermission){
                return true;
            }

        }catch(Exception e){
            throw new PermissionException("权限校验失败,"+e.getMessage());
        }
        return false;
    }
}
