import request from '../utils/request'

export const getDeptInfo = (deptId) => request.get(`/dept/show/${deptId}`)
export const updateDept = (data) => request.put('/dept/update', data)
export const addDept = (data) => request.post('/dept/add', data)
export const deleteDept = (deptId) => request.delete(`/dept/deleted/${deptId}`)

export const searchDept = (deptName, current = 1, size = 10) => 
    request.get(`/search/dept/${deptName}`, { params: { current, size } })

export const listAllDept = (current = 1, size = 10) => 
    request.get('/search/dept/all', { params: { current, size } })

export const listDeptUser = (deptId, current = 1, size = 10) => 
    request.get(`/search/dept/${deptId}/user`, { params: { current, size } })

export const listDeptEquip = (deptId, current = 1, size = 10) => 
    request.get(`/search/dept/${deptId}/equip`, { params: { current, size } })