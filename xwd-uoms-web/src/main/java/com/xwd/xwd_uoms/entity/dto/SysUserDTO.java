package com.xwd.xwd_uoms.entity.dto;

import lombok.Data;

@Data
public class SysUserDTO {
    private Long id;
    private Long roleId;
    private String username;
    private String name;
    private String password;
    private String grade;
    private String phone;
    private String email;
    private String orgType;
    private String orgName;
    private String deptName;
}