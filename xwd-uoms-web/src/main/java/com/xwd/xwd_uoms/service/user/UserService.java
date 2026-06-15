package com.xwd.xwd_uoms.service.user;

import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.entity.dto.AdminDTO;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import org.springframework.data.domain.Page;

public interface UserService {
    void userUpdate(Long userId, SysUserDTO sysUserDTO) throws Exception;

    void userAdd(SysUserDTO sysUserDTO) throws Exception;

    void permUpdate(AdminDTO adminDTO) throws Exception;

    void userUpdate(SysUserDTO sysUserDTO) throws Exception;

    void userMove(SysUserDTO sysUserDTO) throws Exception;

    void userDelete(Long userId) throws Exception;

    void userDelete(String refreshToken) throws Exception;

    SysUserDTO userView(Long userId) throws Exception;

    Page<SysUserEntity> showAdmin(Long orgId, Integer current, Integer size);
}
