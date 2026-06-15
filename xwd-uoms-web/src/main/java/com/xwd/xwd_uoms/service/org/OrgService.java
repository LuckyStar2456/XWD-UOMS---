package com.xwd.xwd_uoms.service.org;

import com.xwd.xwd_uoms.entity.SysOrganizationEntity;

public interface OrgService {
    SysOrganizationEntity showOrg(Long orgId);

    void orgUpdate(SysOrganizationEntity org);

    void orgAdd(SysOrganizationEntity org);

    void orgDeleted(Long orgId);
}
