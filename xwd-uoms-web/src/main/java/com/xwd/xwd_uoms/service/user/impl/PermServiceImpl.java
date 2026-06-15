package com.xwd.xwd_uoms.service.user.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.entity.SysRoleEntity;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.entity.dto.AdminDTO;
import com.xwd.xwd_uoms.repository.SysRoleRepository;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import com.xwd.xwd_uoms.service.user.PermService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class PermServiceImpl implements PermService {
    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysRoleRepository sysRoleRepository;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void update(AdminDTO adminDTO) {
        Long userId = adminDTO.getUserId();
        if (!verifyUtil.isExist(userId)){
            throw new IllegalArgumentException("用户信息为空.");
        }
        Long roleId = adminDTO.getRoleId();
        if (!verifyUtil.isExist(roleId)){
            throw new IllegalArgumentException("权限信息为空.");
        }

        if (roleId == 1L){
            throw new IllegalArgumentException("不允许超级提权.");
        }

        SysUserEntity sysUser = sysUserRepository.findSysUserEntityById(userId);
        if (!verifyUtil.isExist(sysUser)){
            throw new IllegalArgumentException("用户不存在.");
        }

        SysRoleEntity sysRole = sysRoleRepository.findSysRoleEntityById(roleId);
        if (!verifyUtil.isExist(sysRole)){
            throw new IllegalArgumentException("权限角色不存在.");
        }

        sysUser.setRoleId(roleId);
        LocalDate now = LocalDate.now();
        sysUser.setUpdateDate(now);
        sysUserRepository.save(sysUser);
    }
}
