package com.xwd.xwd_uoms.service.org.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysOrgDefaultConfig;
import com.xwd.xwd_uoms.entity.SysOrganizationEntity;
import com.xwd.xwd_uoms.repository.SysOrganizationRepository;
import com.xwd.xwd_uoms.service.org.OrgService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class OrgServiceImpl implements OrgService {
    @Resource
    private SysOrganizationRepository sysOrganizationRepository;

    @Resource
    private SysOrgDefaultConfig sysOrgDefaultConfig;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public SysOrganizationEntity showOrg(Long orgId) {
        SysOrganizationEntity org = sysOrganizationRepository.findSysOrganizationEntityById(orgId);
        if (!verifyUtil.isExist(org)){
            throw new IllegalArgumentException("组织不存在.");
        }
        return org;
    }

    @Override
    public void orgUpdate(SysOrganizationEntity org) {
        Long orgId = org.getId();
        if (!verifyUtil.isExist(orgId) || !verifyUtil.isExist(org)){
            throw new IllegalArgumentException("组织不存在.");
        }
        SysOrganizationEntity oldOrg = sysOrganizationRepository.findSysOrganizationEntityById(orgId);
        if (verifyUtil.isExist(sysOrganizationRepository.findSysOrganizationEntityByNameAndType(org.getName(),org.getType())) &&
                (!oldOrg.getName().equals(org.getName()) || !oldOrg.getType().equals(org.getType()))){
            throw new IllegalArgumentException("组织已存在.");
        }

        oldOrg.setType(org.getType());
        oldOrg.setName(org.getName());
        oldOrg.setOrgDesc(org.getOrgDesc());
        oldOrg.setPhone(org.getPhone());
        oldOrg.setAddress(org.getAddress());

        LocalDate now = LocalDate.now();
        if (!verifyUtil.isExist(oldOrg.getCreateDate())){
            oldOrg.setCreateDate(now);
        }
        oldOrg.setUpdateDate(now);

        sysOrganizationRepository.save(oldOrg);
    }

    @Override
    public void orgAdd(SysOrganizationEntity org) {
        SysOrganizationEntity newOrg = new SysOrganizationEntity();
        if (!verifyUtil.isExist(org)){
            throw new IllegalArgumentException("组织参数不存在.");
        }
        if (!verifyUtil.isExist(org.getName())){
            throw new IllegalArgumentException("组织名称不可为空.");
        }
        if (verifyUtil.isExist(sysOrganizationRepository.findSysOrganizationEntityByNameAndType(org.getName(), org.getType()))){
            throw new IllegalArgumentException("组织已存在.");
        }
        newOrg.setName(org.getName());
        if (!verifyUtil.isExist(org.getType())){
            newOrg.setType(sysOrgDefaultConfig.getType());
        }else {
            newOrg.setType(org.getType());
        }if (!verifyUtil.isExist(org.getOrgDesc())){
            newOrg.setOrgDesc(sysOrgDefaultConfig.getOrgDesc());
        }else {
            newOrg.setOrgDesc(org.getOrgDesc());
        }
        newOrg.setAddress(org.getAddress());
        newOrg.setPhone(org.getPhone());
        newOrg.setStatus(sysOrgDefaultConfig.getStatus());
        newOrg.setIsDeleted(sysOrgDefaultConfig.getIsDeleted());

        LocalDate now = LocalDate.now();
        newOrg.setCreateDate(now);
        newOrg.setUpdateDate(now);

        sysOrganizationRepository.save(newOrg);
    }

    @Override
    public void orgDeleted(Long orgId){
        SysOrganizationEntity org = sysOrganizationRepository.findSysOrganizationEntityById(orgId);
        if (!verifyUtil.isExist(org)){
            throw new IllegalArgumentException("组织不存在.");
        }
        org.setIsDeleted((byte)1);
        LocalDate now = LocalDate.now();
        org.setUpdateDate(now);
        sysOrganizationRepository.save(org);
    }
}
