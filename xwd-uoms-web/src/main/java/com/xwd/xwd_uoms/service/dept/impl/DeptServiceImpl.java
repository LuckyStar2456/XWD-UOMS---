package com.xwd.xwd_uoms.service.dept.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysDeptDefaultConfig;
import com.xwd.xwd_uoms.entity.SysDepartmentEntity;
import com.xwd.xwd_uoms.entity.SysOrganizationEntity;
import com.xwd.xwd_uoms.repository.SysDepartmentRepository;
import com.xwd.xwd_uoms.repository.SysOrganizationRepository;
import com.xwd.xwd_uoms.service.dept.DeptService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {
    @Resource
    private SysDepartmentRepository sysDepartmentRepository;

    @Resource
    private SysOrganizationRepository sysOrganizationRepository;

    @Resource
    private SysDeptDefaultConfig sysDeptDefaultConfig;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void deptUpdate(SysDepartmentEntity dept) {
        Long deptId = dept.getId();
        SysDepartmentEntity oldDept = sysDepartmentRepository.findSysDepartmentEntityById(deptId);
        if (!verifyUtil.isExist(oldDept) || !verifyUtil.isExist(dept)){
            throw new IllegalArgumentException("部门不存在.");
        }
        SysOrganizationEntity org = sysOrganizationRepository.findSysOrganizationEntityById(dept.getOrgId());
        if (!verifyUtil.isExist(org)){
            throw new IllegalArgumentException("部门所属组织信息不存在.");
        }
        if (!Objects.equals(dept.getName(),oldDept.getName()) &&
                verifyUtil.isExist(sysDepartmentRepository.findSysDepartmentEntityByOrgIdAndName(dept.getOrgId(),dept.getName()))){
            throw new IllegalArgumentException("该部门已存在.");
        }

        oldDept.setName(dept.getName());
        oldDept.setDeptDesc(dept.getDeptDesc());

        LocalDate now = LocalDate.now();
        if (!verifyUtil.isExist(oldDept.getUpdateDate())){
            oldDept.setCreateDate(now);
        }
        oldDept.setUpdateDate(now);

        sysDepartmentRepository.save(oldDept);
    }

    @Override
    public void deptAdd(SysDepartmentEntity dept) {
        SysOrganizationEntity org = sysOrganizationRepository.findSysOrganizationEntityById(dept.getOrgId());
        if (!verifyUtil.isExist(org)){
            throw new IllegalArgumentException("部门所属组织信息不存在.");
        }
        if (verifyUtil.isExist(sysDepartmentRepository.findSysDepartmentEntityByOrgIdAndName(dept.getOrgId(),dept.getName()))){
            throw new IllegalArgumentException("该部门已存在.");
        }
        if (!verifyUtil.isExist(dept.getName())){
            throw new IllegalArgumentException("部门名称不可为空.");
        }
        if (!verifyUtil.isExist(dept.getDeptDesc())){
            dept.setDeptDesc(sysDeptDefaultConfig.getDeptDesc());
        }

        dept.setStatus(sysDeptDefaultConfig.getStatus());
        dept.setIsDeleted(sysDeptDefaultConfig.getIsDeleted());

        LocalDate now = LocalDate.now();
        dept.setCreateDate(now);
        dept.setUpdateDate(now);

        sysDepartmentRepository.save(dept);
    }

    @Override
    public SysDepartmentEntity showDept(Long deptId) {
        SysDepartmentEntity dept = sysDepartmentRepository.findSysDepartmentEntityById(deptId);
        if (!verifyUtil.isExist(dept)){
            throw new IllegalArgumentException("部门不存在.");
        }
        SysOrganizationEntity org = sysOrganizationRepository.findSysOrganizationEntityById(dept.getOrgId());
        if (!verifyUtil.isExist(org)){
            throw new IllegalArgumentException("部门所属组织信息不存在.");
        }
        return dept;
    }

    @Override
    public void deptDeleted(Long deptId){
        SysDepartmentEntity dept = sysDepartmentRepository.findSysDepartmentEntityById(deptId);
        if (!verifyUtil.isExist(dept)){
            throw new IllegalArgumentException("部门信息不存在.");
        }
        dept.setIsDeleted((byte)1);

        LocalDate now = LocalDate.now();
        dept.setUpdateDate(now);

        sysDepartmentRepository.save(dept);
    }
}
