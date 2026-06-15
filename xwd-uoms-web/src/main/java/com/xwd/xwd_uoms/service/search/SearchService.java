package com.xwd.xwd_uoms.service.search;

import com.xwd.xwd_uoms.entity.SysDepartmentEntity;
import com.xwd.xwd_uoms.entity.SysEquipmentEntity;
import com.xwd.xwd_uoms.entity.SysOrganizationEntity;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import org.springframework.data.domain.Page;

public interface SearchService {
    Page<SysUserDTO> searchUser(String userName,Integer current,Integer size);
    Page<SysOrganizationEntity> searchOrg(String orgName,Integer current,Integer size);
    Page<SysDepartmentEntity> searchOrgDept(Long orgId,Integer current,Integer size);
    Page<SysEquipmentEntity> searchOrgEquip(Long orgId,Integer current,Integer size);
    Page<SysDepartmentEntity> searchDept(String deptName, Integer current, Integer size);
    Page<SysUserDTO> searchDeptUser(Long deptId,Integer current,Integer size);
    Page<SysEquipmentEntity> searchDeptEquip(Long deptId,Integer current,Integer size);
    Page<SysEquipmentEntity> searchEquip(String equipName,Integer current,Integer size);

    Page<SysUserDTO> searchAllUser(Integer current, Integer size);
    Page<SysOrganizationEntity> searchAllOrg(Integer current, Integer size);
    Page<SysDepartmentEntity> searchAllDept(Integer current, Integer size);
    Page<SysEquipmentEntity> searchAllEquip(Integer current, Integer size);
}
