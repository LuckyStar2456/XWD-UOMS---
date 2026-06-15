import request from '../utils/request'

export const getOrgInfo = (orgId) => request.get(`/org/show/${orgId}`)
export const updateOrg = (data) => request.put('/org/update', data)
export const addOrg = (data) => request.post('/org/add', data)
export const deleteOrg = (orgId) => request.delete(`/org/deleted/${orgId}`)

export const searchOrg = (orgName, current = 1, size = 10) => 
    request.get(`/search/org/${orgName}`, { params: { current, size } })

export const listAllOrg = (current = 1, size = 10) => 
    request.get('/search/org/all', { params: { current, size } })

export const listOrgDept = (orgId, current = 1, size = 10) => 
    request.get(`/search/org/${orgId}/dept`, { params: { current, size } })

export const listOrgEquip = (orgId, current = 1, size = 10) => 
    request.get(`/search/org/${orgId}/equip`, { params: { current, size } })