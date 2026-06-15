package com.xwd.xwd_uoms.service.dept;

import com.xwd.xwd_uoms.entity.SysDepartmentEntity;

public interface DeptService {
    void deptUpdate(SysDepartmentEntity dept);

    void deptAdd(SysDepartmentEntity dept);

    SysDepartmentEntity showDept(Long deptId);

    void deptDeleted(Long deptId);
}
