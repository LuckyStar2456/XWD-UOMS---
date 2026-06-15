import request from '../utils/request'

export const getUserInfo = (userId) => request.get(`/user/view/${userId}`)
export const updateSelf = (userId, data) => request.put(`/user/self/update/${userId}`, data)
export const cancelSelf = (refreshToken) => request.put('/user/self/cancel', refreshToken)

export const addUser = (data) => request.post('/user/oth/add', data)
export const updateUser = (data) => request.put('/user/oth/update', data)
export const moveUser = (data) => request.put('/user/oth/move', data)
export const deleteUser = (userId) => request.delete(`/user/oth/delete/${userId}`)

export const updatePerm = (data) => request.put('/user/perm/update', data)

export const getOrgAdmin = (orgId, current = 1, size = 10) =>
    request.get(`/user/show/admin/${orgId}`, { params: { current, size } })

export const searchUser = (userName, current = 1, size = 10) => 
    request.get(`/search/user/${userName}`, { params: { current, size } })

export const listAllUser = (current = 1, size = 10) => 
    request.get('/search/user/all', { params: { current, size } })