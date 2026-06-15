import request from '../utils/request'

export const addNotice = (data) => request.post('/notice/add', data)
export const updateNotice = (data) => request.put('/notice/update', data)
export const deleteNotice = (noticeId) => request.delete(`/notice/deleted/${noticeId}`)
export const getReceivedNotice = (mandatoryId, current = 1, size = 10) => request.get(`/notice/received/view/${mandatoryId}`, { params: { current, size } })
export const getPendingNotice = (originatorId, current = 1, size = 10) => request.get(`/notice/pending/view/${originatorId}`, { params: { current, size } })
export const getNoticeDetail = (noticeId) => request.get(`/notice/show/${noticeId}`)