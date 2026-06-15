import request from '../utils/request'

export const getEquipInfo = (equipId) => request.get(`/equip/show/${equipId}`)
export const updateEquip = (data) => request.put('/equip/update', data)
export const addEquip = (data) => request.post('/equip/add', data)
export const borrowEquip = (data) => request.put('/equip/borrow', data)
export const deleteEquip = (equipId) => request.delete(`/equip/deleted/${equipId}`)
export const getOrgEquip = (orgId, current = 1, size = 10) => request.get(`/equip/org/view/${orgId}`, { params: { current, size } })
export const getDeptEquip = (deptId, current = 1, size = 10) => request.get(`/equip/dept/view/${deptId}`, { params: { current, size } })

export const searchEquip = (equipName, current = 1, size = 10) => 
    request.get(`/search/equip/${equipName}`, { params: { current, size } })

export const listAllEquip = (current = 1, size = 10) => 
    request.get('/search/equip/all', { params: { current, size } })