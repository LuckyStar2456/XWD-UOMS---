export const getRoleName = (roleId) => {
    const map = {
        1: '超级管理员',
        2: '部门部员',
        3: '部门部长',
        4: '组织主席',
    };
    return map[roleId] || '未知角色';
};