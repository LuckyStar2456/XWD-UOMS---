import request from '../utils/request'

export const addApply = (data) => request.post('/apply/add', data)
export const getPendingApply = (applyUserId, current = 1, size = 10) => request.get(`/apply/pending/view/${applyUserId}`, { params: { current, size } })
export const getReceivedApply = (approverUserId, current = 1, size = 10) => request.get(`/apply/received/view/${approverUserId}`, { params: { current, size } })
export const approveApply = (data) => request.put('/apply/approve', data)
export const deleteApply = (applyId) => request.delete(`/apply/deleted/${applyId}`)
export const getApplyDetail = (applyId) => request.get(`/apply/show/${applyId}`)