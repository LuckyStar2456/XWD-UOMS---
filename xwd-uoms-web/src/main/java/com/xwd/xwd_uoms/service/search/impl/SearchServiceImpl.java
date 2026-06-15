package com.xwd.xwd_uoms.service.search.impl;

import com.xwd.xwd_uoms.common.util.ConvertUtil;
import com.xwd.xwd_uoms.entity.SysDepartmentEntity;
import com.xwd.xwd_uoms.entity.SysEquipmentEntity;
import com.xwd.xwd_uoms.entity.SysOrganizationEntity;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import com.xwd.xwd_uoms.repository.SysDepartmentRepository;
import com.xwd.xwd_uoms.repository.SysEquipmentRepository;
import com.xwd.xwd_uoms.repository.SysOrganizationRepository;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import com.xwd.xwd_uoms.service.search.SearchService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {
    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysOrganizationRepository sysOrganizationRepository;

    @Resource
    private SysDepartmentRepository sysDepartmentRepository;

    @Resource
    private SysEquipmentRepository sysEquipmentRepository;

    @Resource
    private ConvertUtil convertUtil;

    @Override
    public Page<SysUserDTO> searchUser(String userName,Integer current,Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysUserEntity> page = sysUserRepository.findAllByNameLike(userName,pageable);
        List<SysUserDTO> dtoList = page.getContent().stream()
                .map(entity -> {
                    SysUserDTO dto = convertUtil.userToDTO(entity);
                    return dto;
                })
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, page.getTotalElements());
    }

    @Override
    public Page<SysOrganizationEntity> searchOrg(String orgName,Integer current,Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysOrganizationEntity> page = sysOrganizationRepository.findAllByNameLike(orgName,pageable);
        return page;
    }

    @Override
    public Page<SysDepartmentEntity> searchOrgDept(Long orgId, Integer current, Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysDepartmentEntity> page = sysDepartmentRepository.findAllByOrgId(orgId,pageable);
        return page;
    }

    @Override
    public Page<SysEquipmentEntity> searchOrgEquip(Long orgId, Integer current, Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentEntity> page = sysEquipmentRepository.findAllByOrgId(orgId,pageable);
        return page;
    }
    @Override
    public Page<SysDepartmentEntity> searchDept(String deptName,Integer current,Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysDepartmentEntity> page = sysDepartmentRepository.findAllByNameLike(deptName,pageable);
        return page;
    }

    @Override
    public Page<SysUserDTO> searchDeptUser(Long deptId, Integer current, Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysUserEntity> page = sysUserRepository.findAllByDeptId(deptId,pageable);
        List<SysUserDTO> dtoList = page.getContent().stream()
                .map(entity -> {
                    SysUserDTO dto = convertUtil.userToDTO(entity);
                    return dto;
                })
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, page.getTotalElements());
    }

    @Override
    public Page<SysEquipmentEntity> searchDeptEquip(Long deptId, Integer current, Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentEntity> page = sysEquipmentRepository.findAllByDeptId(deptId,pageable);
        return page;
    }

    @Override
    public Page<SysEquipmentEntity> searchEquip(String equipName, Integer current, Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentEntity> page = sysEquipmentRepository.findAllByNameLike(equipName,pageable);
        return page;
    }

    @Override
    public Page<SysUserDTO> searchAllUser(Integer current, Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysUserEntity> page = sysUserRepository.findAll(pageable);
        List<SysUserDTO> dtoList = page.getContent().stream()
                .map(entity -> {
                    SysUserDTO dto = convertUtil.userToDTO(entity);
                    return dto;
                })
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, page.getTotalElements());
    }

    @Override
    public Page<SysOrganizationEntity> searchAllOrg(Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysOrganizationEntity> page = sysOrganizationRepository.findAll(pageable);
        return page;
    }

    @Override
    public Page<SysDepartmentEntity> searchAllDept(Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysDepartmentEntity> page = sysDepartmentRepository.findAll(pageable);
        return page;
    }

    @Override
    public Page<SysEquipmentEntity> searchAllEquip(Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentEntity> page = sysEquipmentRepository.findAll(pageable);
        return page;
    }
}
