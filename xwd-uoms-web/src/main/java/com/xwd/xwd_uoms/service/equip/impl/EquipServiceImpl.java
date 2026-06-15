package com.xwd.xwd_uoms.service.equip.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysEquipDefaultConfig;
import com.xwd.xwd_uoms.entity.SysDepartmentEntity;
import com.xwd.xwd_uoms.entity.SysEquipmentEntity;
import com.xwd.xwd_uoms.entity.SysOrganizationEntity;
import com.xwd.xwd_uoms.repository.SysDepartmentRepository;
import com.xwd.xwd_uoms.repository.SysEquipmentRepository;
import com.xwd.xwd_uoms.repository.SysOrganizationRepository;
import com.xwd.xwd_uoms.service.equip.EquipService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class EquipServiceImpl implements EquipService {
    @Resource
    private SysEquipmentRepository sysEquipmentRepository;

    @Resource
    private SysOrganizationRepository sysOrganizationRepository;

    @Resource
    private SysDepartmentRepository sysDepartmentRepository;

    @Resource
    private SysEquipDefaultConfig sysEquipDefaultConfig;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void equipUpdate(SysEquipmentEntity equip) {
        Long equipId = equip.getId();
        SysEquipmentEntity oldEquip = sysEquipmentRepository.findSysEquipmentEntityById(equipId);
        if (!verifyUtil.isExist(oldEquip)){
            throw new IllegalArgumentException("设备不存在.");
        }
        if (!verifyUtil.isExist(equip.getName())){
            throw new IllegalArgumentException("设备名称不可为空.");
        }
        SysOrganizationEntity org = sysOrganizationRepository.findSysOrganizationEntityById(equip.getOrgId());
        if (!verifyUtil.isExist(org)){
            throw new IllegalArgumentException("设备所属组织不存在.");
        }
        if (verifyUtil.isExist(equip.getDeptId())) {
            SysDepartmentEntity dept = sysDepartmentRepository.findSysDepartmentEntityById(equip.getDeptId());
            if (!verifyUtil.isExist(dept)) {
                throw new IllegalArgumentException("设备所属部门不存在.");
            }
        }
        if (!verifyUtil.isExist(equip.getTotalNum()) || !verifyUtil.isExist(equip.getAvailableNum())){
            throw new IllegalArgumentException("设备储量非法.");
        }
        if (!verifyUtil.isExist(equip.getEquipmentDesc())){
            oldEquip.setEquipmentDesc(sysEquipDefaultConfig.getEquipmentDesc());
        } else {
            oldEquip.setEquipmentDesc(equip.getEquipmentDesc());
        }
        oldEquip.setName(equip.getName());
        oldEquip.setTotalNum(equip.getTotalNum());
        oldEquip.setAvailableNum(equip.getAvailableNum());
        oldEquip.setOrgId(equip.getOrgId());
        oldEquip.setDeptId(equip.getDeptId());

        LocalDate now = LocalDate.now();
        if (!verifyUtil.isExist(oldEquip.getCreateDate())){
            oldEquip.setCreateDate(now);
        }
        oldEquip.setUpdateDate(now);

        sysEquipmentRepository.save(oldEquip);
    }

    @Override
    public void equipAdd(SysEquipmentEntity equip) {
        if (!verifyUtil.isExist(equip)){
            throw new IllegalArgumentException("设备信息不可为空.");
        }
        if (!verifyUtil.isExist(equip.getName())){
            throw new IllegalArgumentException("设备名称不可为空.");
        }
        if (!verifyUtil.isExist(equip.getOrgId())){
            throw new IllegalArgumentException("设备所属组织不可为空.");
        }
        if (!verifyUtil.isExist(equip.getTotalNum()) || !verifyUtil.isExist(equip.getAvailableNum())){
            throw new IllegalArgumentException("设备储量非法.");
        }

        if (!verifyUtil.isExist(equip.getEquipmentDesc())){
            equip.setEquipmentDesc(sysEquipDefaultConfig.getEquipmentDesc());
        }
        equip.setStatus(sysEquipDefaultConfig.getStatus());
        equip.setIsDeleted(sysEquipDefaultConfig.getIsDeleted());

        LocalDate now = LocalDate.now();
        equip.setCreateDate(now);
        equip.setUpdateDate(now);

        sysEquipmentRepository.save(equip);
    }

    @Override
    public SysEquipmentEntity showEquip(Long equipId) {
        SysEquipmentEntity equip = sysEquipmentRepository.findSysEquipmentEntityById(equipId);
        if (!verifyUtil.isExist(equip)){
            throw new IllegalArgumentException("设备不存在.");
        }

        return equip;
    }

    @Override
    public void equipDeleted(Long equipId) {
        SysEquipmentEntity equip = sysEquipmentRepository.findSysEquipmentEntityById(equipId);
        if (!verifyUtil.isExist(equip)){
            throw new IllegalArgumentException("设备不存在.");
        }

        equip.setIsDeleted((byte)1);

        LocalDate now =LocalDate.now();
        equip.setUpdateDate(now);

        sysEquipmentRepository.save(equip);
    }

    @Override
    public void equipBorrow(Long equipId, Integer borrowNum){
        SysEquipmentEntity equip = sysEquipmentRepository.findSysEquipmentEntityById(equipId);
        if (!verifyUtil.isExist(equip)){
            throw new IllegalArgumentException("设备不存在.");
        }
        Integer newNum = equip.getAvailableNum() - borrowNum;
        if (!verifyUtil.isExist(newNum)){
            throw new IllegalArgumentException("借取数量非法.");
        }
        equip.setAvailableNum(newNum);
        LocalDate now = LocalDate.now();
        if (!verifyUtil.isExist(equip.getCreateDate())){
            equip.setCreateDate(now);
        }
        equip.setUpdateDate(now);

        sysEquipmentRepository.save(equip);
    }

    @Override
    public Page<SysEquipmentEntity> showOrgEquip(Long orgId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentEntity> page = sysEquipmentRepository.findAllByOrgId(orgId,pageable);
        return page;
    }

    @Override
    public Page<SysEquipmentEntity> showDeptEquip(Long deptId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentEntity> page = sysEquipmentRepository.findAllByDeptId(deptId,pageable);
        return page;
    }
}
