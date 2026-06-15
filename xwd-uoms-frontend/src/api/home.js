import request from '../utils/request'

export const getUnfApply = (userId, current = 1, size = 10) => request.get(`/home/received/apply/${userId}`, { params: { current, size } })
export const getUnfTask = (userId, current = 1, size = 10) => request.get(`/home/received/task/${userId}`, { params: { current, size } })
export const getUnfBorrow = (userId, current = 1, size = 10) => request.get(`/home/received/equipborrow/${userId}`, { params: { current, size } })
export const getUnfFeedback = (userId, current = 1, size = 10) => request.get(`/home/received/feedback/${userId}`, { params: { current, size } })
export const getNotice = (userId, current = 1, size = 10) => request.get(`/home/received/notice/${userId}`, { params: { current, size } })
export const getAdminList = (current = 1, size = 10) => request.get('/home/show/admin', { params: { current, size } })
export const getStats = (userId) => request.get(`/home/stats/${userId}`)