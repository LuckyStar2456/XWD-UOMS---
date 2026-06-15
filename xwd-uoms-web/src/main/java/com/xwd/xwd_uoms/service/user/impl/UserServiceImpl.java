package com.xwd.xwd_uoms.service.user.impl;

import com.xwd.xwd_uoms.common.exception.LoginException;
import com.xwd.xwd_uoms.common.util.ConvertUtil;
import com.xwd.xwd_uoms.common.util.JwtUtil;
import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysUserDefaultConfig;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.entity.dto.AdminDTO;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import com.xwd.xwd_uoms.repository.SysDepartmentRepository;
import com.xwd.xwd_uoms.repository.SysOrganizationRepository;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import com.xwd.xwd_uoms.service.user.PermService;
import com.xwd.xwd_uoms.service.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private SysUserRepository sysUserRepository;
    
    @Resource
    private PasswordEncoder passwordEncoder;
    
    @Resource
    private SysOrganizationRepository sysOrganizationRepository;
    
    @Resource
    private SysDepartmentRepository sysDepartmentRepository;

    @Resource
    private VerifyUtil verifyUtil;

    @Resource
    private SysUserDefaultConfig sysUserDefaultConfig;

    @Resource
    private PermService permService;

    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private ConvertUtil convertUtil;

    @Override
    public void userUpdate(Long userId, SysUserDTO sysUserDTO) throws Exception {
        try {
            Long userDTOId = sysUserDTO.getId();
            if (!Objects.equals(userDTOId, userId)){
                throw new LoginException("用户不匹配.");
            }
            SysUserEntity sysUser = sysUserRepository.findSysUserEntityById(userId);
            if (!verifyUtil.isExist(sysUser)){
                throw new IllegalArgumentException("用户不存在.");
            }
            if (verifyUtil.isExist(sysUserDTO.getName())){
                sysUser.setName(sysUserDTO.getName());
            }
            if (verifyUtil.isExist(sysUserDTO.getEmail())){
                sysUser.setEmail(sysUserDTO.getEmail());
            }
            if (verifyUtil.isExist(sysUserDTO.getPhone())){
                sysUser.setPhone(sysUserDTO.getPhone());
            }
            if (verifyUtil.isExist(sysUserDTO.getGrade())){
                sysUser.setGrade(sysUserDTO.getGrade());
            }
            if (verifyUtil.isExist(sysUserDTO.getPassword())){
                String password = passwordEncoder.encode(sysUserDTO.getPassword());
                sysUser.setPassword(password);
            }
            if (verifyUtil.isExist(sysUser.getCreateDate())){
                LocalDate now = LocalDate.now();
                sysUser.setCreateDate(now);
            }
            LocalDate now = LocalDate.now();
            sysUser.setUpdateDate(now);
            sysUserRepository.save(sysUser);
        }catch (Exception e){
            throw new Exception("用户信息更新失败:" + e.getMessage());
        }
    }

    @Override
    public void userUpdate(SysUserDTO sysUserDTO) throws Exception {
        try{
            Long userId = sysUserDTO.getId();
            SysUserEntity sysUser = sysUserRepository.findSysUserEntityById(userId);
            if (!verifyUtil.isExist(sysUser)){
                throw new IllegalArgumentException("用户不存在.");
            }
            if (verifyUtil.isExist(sysUserDTO.getName())){
                sysUser.setName(sysUserDTO.getName());
            }
            if (verifyUtil.isExist(sysUserDTO.getEmail())){
                sysUser.setEmail(sysUserDTO.getEmail());
            }
            if (verifyUtil.isExist(sysUserDTO.getPhone())){
                sysUser.setPhone(sysUserDTO.getPhone());
            }
            if (verifyUtil.isExist(sysUserDTO.getGrade())){
                sysUser.setGrade(sysUserDTO.getGrade());
            }
            if (verifyUtil.isExist(sysUserDTO.getPassword())){
                String password = passwordEncoder.encode(sysUserDTO.getPassword());
                sysUser.setPassword(password);
            }
            if (verifyUtil.isExist(sysUser.getCreateDate())){
                LocalDate now = LocalDate.now();
                sysUser.setCreateDate(now);
            }
            LocalDate now = LocalDate.now();
            sysUser.setUpdateDate(now);
            sysUserRepository.save(sysUser);
        }catch (Exception e){
            throw new Exception("用户信息更新失败:" + e.getMessage());
        }
    }

    @Override
    public void userAdd(SysUserDTO sysUserDTO) throws Exception {
        try {
            if (!verifyUtil.isExist(sysUserDTO)){
                throw new IllegalArgumentException("用户信息为空.");
            }
            if (!verifyUtil.isExist(sysUserDTO.getOrgName()) ||!verifyUtil.isExist(sysUserDTO.getOrgType())){
                throw new IllegalArgumentException("用户缺少组织信息.");
            }
            if (!verifyUtil.isExist(sysUserDTO.getPhone())){
                throw new IllegalArgumentException("用户缺少电话信息.");
            }
            if (!verifyUtil.isExist(sysUserDTO.getUsername()) || !verifyUtil.isExist(sysUserDTO.getName())){
                throw new IllegalArgumentException("用户缺少账号信息.");
            }

            SysUserEntity sysUser = new SysUserEntity();
            sysUser.setUsername(sysUserDTO.getUsername());
            sysUser.setName(sysUserDTO.getName());
            String password;
            if (!verifyUtil.isExist(sysUserDTO.getPassword())){
                password = sysUserDefaultConfig.getPassword();
            }else{
                password = sysUserDTO.getPassword();
            }
            sysUser.setPassword(passwordEncoder.encode(password));
            sysUser.setGrade(sysUserDTO.getGrade());
            sysUser.setPhone(sysUserDTO.getPhone());
            sysUser.setEmail(sysUserDTO.getEmail());
            Long orgId = sysOrganizationRepository.findIdByTypeAndName(sysUserDTO.getOrgType(),sysUserDTO.getOrgName());
            if (verifyUtil.isExist(orgId)){
                sysUser.setOrgId(orgId);
            }else{
                throw new IllegalArgumentException("组织不存在.");
            }
            if (verifyUtil.isExist(sysUserDTO.getDeptName())){
                Long deptId = sysDepartmentRepository.findIdByOrgIdAndName(orgId,sysUserDTO.getDeptName());
                if (!verifyUtil.isExist(deptId)){
                    throw new IllegalArgumentException("部门不存在.");
                }else{
                    sysUser.setDeptId(deptId);
                }
            }
            sysUser.setRoleId(sysUserDefaultConfig.getRoleId());

            sysUser.setStatus(sysUserDefaultConfig.getStatus());
            sysUser.setIsDeleted(sysUserDefaultConfig.getIsDeleted());
            LocalDate now = LocalDate.now();
            sysUser.setCreateDate(now);
            sysUser.setUpdateDate(now);
            sysUserRepository.save(sysUser);

        }catch (Exception e){
            throw new Exception("创建用户失败:" + e.getMessage());
        }
    }

    @Override
    public void permUpdate(AdminDTO adminDTO) throws Exception {
        try {
            if (!verifyUtil.isExist(adminDTO)){
                throw new IllegalArgumentException("权限信息为空.");
            }
            permService.update(adminDTO);
        }catch (Exception e){
            throw new Exception("权限更新失败.");
        }
    }

    @Override
    public void userMove(SysUserDTO sysUserDTO) throws Exception {
        try {
            if (!verifyUtil.isExist(sysUserDTO)){
                throw new IllegalArgumentException("迁移信息为空.");
            }
            if (!verifyUtil.isExist(sysUserDTO.getOrgName()) || !verifyUtil.isExist(sysUserDTO.getOrgType())){
                throw new IllegalArgumentException("用户组织信息为空.");
            }
            Long orgId = sysOrganizationRepository.findIdByTypeAndName(sysUserDTO.getOrgType(),sysUserDTO.getOrgName());
            if (!verifyUtil.isExist(orgId)){
                throw new IllegalArgumentException("组织信息不存在.");
            }
            if (verifyUtil.isExist(sysUserDTO.getDeptName())) {
                Long deptId = sysDepartmentRepository.findIdByOrgIdAndName(orgId, sysUserDTO.getDeptName());
                if (!verifyUtil.isExist(deptId)) {
                    throw new IllegalArgumentException("部门信息不存在.");
                }
            }
            Long userId = sysUserDTO.getId();
            if (!verifyUtil.isExist(userId)){
                throw new IllegalArgumentException("缺少用户信息.");
            }
            SysUserEntity sysUser = sysUserRepository.findSysUserEntityById(userId);
            if (!verifyUtil.isExist(sysUser)){
                throw new IllegalArgumentException("用户不存在.");
            }
            if (!Objects.equals(sysUser.getOrgId(), orgId)){
                throw new IllegalArgumentException("用户仅允许在组织内迁移.");
            }
            Long deptId = sysDepartmentRepository.findIdByOrgIdAndName(orgId, sysUserDTO.getDeptName());
            sysUser.setDeptId(deptId);
            LocalDate now = LocalDate.now();
            sysUser.setUpdateDate(now);
            sysUserRepository.save(sysUser);

        }catch (Exception e){
            throw new Exception("用户迁移失败:" + e.getMessage());
        }
    }

    @Override
    public void userDelete(Long userId) throws Exception {
        try {
            SysUserEntity sysUser = sysUserRepository.findSysUserEntityById(userId);
            if (!verifyUtil.isExist(sysUser)){
                throw new IllegalArgumentException("用户不存在.");
            }
            sysUser.setIsDeleted((byte)1);
            LocalDate now = LocalDate.now();
            sysUser.setUpdateDate(now);
            sysUserRepository.save(sysUser);
        }catch (Exception e){
            throw new Exception("删除用户失败:" + e.getMessage());
        }
    }

    @Override
    public void userDelete(String refreshToken) throws Exception {
        try{
            if (!verifyUtil.isExist(refreshToken)){
                throw new IllegalArgumentException("用户信息为空.");
            }
            jwtUtil.validateToken(refreshToken);

            if (!verifyUtil.isExist(jwtUtil.getFromToken(refreshToken,"username"))){
                throw new IllegalArgumentException("用户信息缺失.");
            }
            String username = jwtUtil.getFromToken(refreshToken,"username");

            SysUserEntity sysUser = sysUserRepository.findSysUserEntityByUsername(username);
            if (!verifyUtil.isExist(sysUser)){
                throw new IllegalArgumentException("用户不存在.");
            }
            sysUser.setIsDeleted((byte) 1);
            LocalDate now = LocalDate.now();
            sysUser.setUpdateDate(now);
            sysUserRepository.save(sysUser);

            String redisKey = "refresh_token:" + username;
            redisTemplate.delete(redisKey);

        }catch (Exception e){
            throw new Exception("注销账号失败:" + e.getMessage());
        }
    }

    @Override
    public SysUserDTO userView(Long userId) throws Exception {
        if (!verifyUtil.isExist(userId)){
            throw new IllegalArgumentException("用户不存在.");
        }
        SysUserEntity user = sysUserRepository.findSysUserEntityById(userId);
        if (!verifyUtil.isExist(user)){
            throw new IllegalArgumentException("用户不存在.");
        }

        SysUserDTO self = convertUtil.userToDTO(user);

        return self;
    }

    @Override
    public Page<SysUserEntity> showAdmin(Long orgId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysUserEntity> page = sysUserRepository.findAllByOrgIdAndRoleIdNot(orgId,2L,pageable);
        return page;
    }
}
