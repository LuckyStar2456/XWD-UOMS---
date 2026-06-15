import request from '../utils/request'

export const addBorrow = (data) => request.post('/borrow/add', data)
export const updateBorrow = (data) => request.put('/borrow/update', data)
export const approveBorrow = (data) => request.put('/borrow/approve', data)
export const getOrgBorrow = (orgId, current = 1, size = 10) => request.get(`/borrow/org/view/${orgId}`, { params: { current, size } })
export const getDeptBorrow = (deptId, current = 1, size = 10) => request.get(`/borrow/dept/view/${deptId}`, { params: { current, size } })
export const getUserBorrow = (borrowerId, current = 1, size = 10) => request.get(`/borrow/received/view/${borrowerId}`, { params: { current, size } })
export const getPendingBorrow = (approverId, current = 1, size = 10) => request.get(`/borrow/pending/view/${approverId}`, { params: { current, size } })
export const getBorrowDetail = (borrowId) => request.get(`/borrow/show/${borrowId}`)