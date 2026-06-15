package com.xwd.xwd_uoms.service.borrow.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysEquipBorrowDefaultConfig;
import com.xwd.xwd_uoms.entity.*;
import com.xwd.xwd_uoms.repository.*;
import com.xwd.xwd_uoms.service.borrow.BorrowService;
import com.xwd.xwd_uoms.service.equip.EquipService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {
    @Resource
    private SysEquipmentBorrowRepository sysEquipmentBorrowRepository;

    @Resource
    private SysEquipmentRepository sysEquipmentRepository;

    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysOrganizationRepository sysOrganizationRepository;

    @Resource
    private SysDepartmentRepository sysDepartmentRepository;

    @Resource
    private SysEquipBorrowDefaultConfig sysEquipBorrowDefaultConfig;

    @Resource
    private EquipService equipService;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void borrowAdd(SysEquipmentBorrowEntity borrow){
        LocalDate now = LocalDate.now();
        SysEquipmentEntity equip = sysEquipmentRepository.findSysEquipmentEntityById(borrow.getEquipmentId());
        if (!verifyUtil.isExist(equip)){
            throw new IllegalArgumentException("借取设备不存在.");
        }
        if (!verifyUtil.isExist(borrow.getBorrowNum()) ||
                !verifyUtil.isExist(equip.getAvailableNum() - borrow.getBorrowNum())){
            throw new IllegalArgumentException("借取数量异常.");
        }
        SysOrganizationEntity org = sysOrganizationRepository.findSysOrganizationEntityById(borrow.getOrgId());
        if (!verifyUtil.isExist(org) || !Objects.equals(borrow.getOrgId(), equip.getOrgId())){
            throw new IllegalArgumentException("借取表所属组织信息错误.");
        }
        if (verifyUtil.isExist(borrow.getDeptId())){
            SysDepartmentEntity dept = sysDepartmentRepository.findSysDepartmentEntityById(borrow.getDeptId());
            if (!Objects.equals(borrow.getDeptId(), equip.getDeptId()) || !verifyUtil.isExist(dept)){
                throw new IllegalArgumentException("借取表所属部门信息错误.");
            }
        }
        SysUserEntity borrowUser = sysUserRepository.findSysUserEntityById(borrow.getBorrowerId());
        if (!verifyUtil.isExist(borrowUser)){
            throw new IllegalArgumentException("设备借取人不存在.");
        }
        SysUserEntity approveUser = sysUserRepository.findSysUserEntityById(borrow.getApproverId());
        if (!verifyUtil.isExist(approveUser)){
            throw new IllegalArgumentException("审批人不存在.");
        }
        if (!verifyUtil.hasPerm(approveUser.getRoleId(), "borrow", "approve")){
            throw new IllegalArgumentException("审批人无权审批借取表.");
        }

        borrow.setStatus(sysEquipBorrowDefaultConfig.getStatus());
        borrow.setCreateDate(now);
        borrow.setUpdateDate(now);

        sysEquipmentBorrowRepository.save(borrow);
    }

    @Override
    public void approveBorrow(Long approveUserId, SysEquipmentBorrowEntity borrow){
        LocalDate now = LocalDate.now();
        if (!Objects.equals(approveUserId,borrow.getApproverId())){
            throw new IllegalArgumentException("审批人与借取表不匹配.");
        }
        SysEquipmentEntity equip = sysEquipmentRepository.findSysEquipmentEntityById(borrow.getEquipmentId());
        if (!verifyUtil.isExist(equip)){
            throw new IllegalArgumentException("借取设备不存在.");
        }
        SysOrganizationEntity org = sysOrganizationRepository.findSysOrganizationEntityById(borrow.getOrgId());
        if (!verifyUtil.isExist(org) || !Objects.equals(borrow.getOrgId(), equip.getOrgId())){
            throw new IllegalArgumentException("借取表所属组织信息错误.");
        }
        if (verifyUtil.isExist(borrow.getDeptId())){
            SysDepartmentEntity dept = sysDepartmentRepository.findSysDepartmentEntityById(borrow.getDeptId());
            if (!Objects.equals(borrow.getDeptId(), equip.getDeptId()) || !verifyUtil.isExist(dept)){
                throw new IllegalArgumentException("借取表所属部门信息错误.");
            }
        }
        SysUserEntity borrowUser = sysUserRepository.findSysUserEntityById(borrow.getBorrowerId());
        if (!verifyUtil.isExist(borrowUser)){
            throw new IllegalArgumentException("设备借取人不存在.");
        }
        SysUserEntity approveUser = sysUserRepository.findSysUserEntityById(approveUserId);
        if (!verifyUtil.isExist(approveUser)){
            throw new IllegalArgumentException("审批人不存在.");
        }
        if (!verifyUtil.isExist(borrow.getBorrowNum()) ||
                !verifyUtil.isExist(equip.getAvailableNum() - borrow.getBorrowNum())){
            throw new IllegalArgumentException("借取数量异常.");
        }
        SysEquipmentBorrowEntity oldBorrow = sysEquipmentBorrowRepository.findSysEquipmentBorrowEntityById(borrow.getId());
        if (!verifyUtil.isExist(oldBorrow)){
            throw new IllegalArgumentException("借取表不存在.");
        }
        if (oldBorrow.getStatus() == (byte)0 &&
                (borrow.getStatus() == (byte)1 || borrow.getStatus() == (byte)2)){
            oldBorrow.setStatus(borrow.getStatus());
            oldBorrow.setApproveTime(now);
            if (verifyUtil.isExist(borrow.getRemark())){
                oldBorrow.setRemark(borrow.getRemark());
            }
            if (borrow.getStatus() == (byte)2){
                equipService.equipBorrow(borrow.getId(), borrow.getBorrowNum());

                oldBorrow.setBorrowTime(now);
            }
        }else if(oldBorrow.getStatus() == (byte)2 &&
                (borrow.getStatus() == (byte)3 || borrow.getStatus() == (byte)4)){
            oldBorrow.setStatus(borrow.getStatus());
            oldBorrow.setApproveTime(now);
            if (borrow.getStatus() == (byte)3){
                oldBorrow.setReturnTime(now);
                equipService.equipBorrow(borrow.getId(), -borrow.getBorrowNum());
            }
        }else {
            throw new IllegalArgumentException("借取表借还状态异常.");
        }
        if (!verifyUtil.isExist(oldBorrow.getCreateDate())){
            oldBorrow.setCreateDate(now);
        }
        oldBorrow.setUpdateDate(now);

        sysEquipmentBorrowRepository.save(oldBorrow);
    }

    @Override
    public void borrowUpdate(SysEquipmentBorrowEntity borrow){
        LocalDate now = LocalDate.now();

        Long borrowId = borrow.getId();
        SysEquipmentBorrowEntity oldBorrow = sysEquipmentBorrowRepository.findSysEquipmentBorrowEntityById(borrowId);
        if (!verifyUtil.isExist(oldBorrow)){
            throw new IllegalArgumentException("借取表不存在.");
        }
        SysEquipmentEntity equip = sysEquipmentRepository.findSysEquipmentEntityById(borrow.getEquipmentId());
        if (!verifyUtil.isExist(equip)){
            throw new IllegalArgumentException("借取设备不存在.");
        }
        if (!verifyUtil.isExist(borrow.getBorrowNum()) ||
                !verifyUtil.isExist(equip.getAvailableNum() - borrow.getBorrowNum())){
            throw new IllegalArgumentException("借取数量异常.");
        }
        if (verifyUtil.isExist(borrow.getDeptId())){
            SysDepartmentEntity dept = sysDepartmentRepository.findSysDepartmentEntityById(borrow.getDeptId());
            if (!Objects.equals(borrow.getDeptId(), equip.getDeptId()) || !verifyUtil.isExist(dept)){
                throw new IllegalArgumentException("借取表所属部门信息错误.");
            }
        }
        SysUserEntity borrowUser = sysUserRepository.findSysUserEntityById(borrow.getBorrowerId());
        if (!verifyUtil.isExist(borrowUser)){
            throw new IllegalArgumentException("设备借取人不存在.");
        }
        SysUserEntity approveUser = sysUserRepository.findSysUserEntityById(borrow.getApproverId());
        if (!verifyUtil.isExist(approveUser)){
            throw new IllegalArgumentException("审批人不存在.");
        }
        if (!verifyUtil.hasPerm(approveUser.getRoleId(), "borrow", "approve")){
            throw new IllegalArgumentException("审批人无权审批借取表.");
        }

        oldBorrow.setEquipmentId(borrow.getEquipmentId());
        oldBorrow.setDeptId(borrow.getDeptId());
        oldBorrow.setBorrowNum(borrow.getBorrowNum());
        oldBorrow.setBorrowerId(borrow.getBorrowerId());
        oldBorrow.setApproverId(borrow.getApproverId());
        if (verifyUtil.isExist(borrow.getRemark())){
            oldBorrow.setRemark(borrow.getRemark());
        }
        oldBorrow.setUpdateDate(now);
        sysEquipmentBorrowRepository.save(oldBorrow);
    }

    @Override
    public Page<SysEquipmentBorrowEntity> showOrgBorrow(Long orgId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentBorrowEntity> page = sysEquipmentBorrowRepository.findAllByOrgId(orgId,pageable);
        return page;
    }

    @Override
    public Page<SysEquipmentBorrowEntity> showDeptBorrow(Long deptId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentBorrowEntity> page = sysEquipmentBorrowRepository.findAllByDeptId(deptId,pageable);
        return page;
    }

    @Override
    public Page<SysEquipmentBorrowEntity> showUnfBorrow(Long borrowerId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentBorrowEntity> page = sysEquipmentBorrowRepository.findAllByBorrowerId(borrowerId,pageable);
        return page;
    }

    @Override
    public Page<SysEquipmentBorrowEntity> showPendBorrow(Long approverId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentBorrowEntity> page = sysEquipmentBorrowRepository.findAllByApproverId(approverId,pageable);
        return page;
    }

    @Override
    public SysEquipmentBorrowEntity showBorrow(Long borrowId){
        SysEquipmentBorrowEntity borrow = sysEquipmentBorrowRepository.findSysEquipmentBorrowEntityById(borrowId);
        if (!verifyUtil.isExist(borrow)){
            throw new IllegalArgumentException("借取表不存在.");
        }
        return borrow;
    }
}
