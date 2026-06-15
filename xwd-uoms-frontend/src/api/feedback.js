import request from '../utils/request'

export const addFeedback = (data) => request.post('/feedback/add', data)
export const updateFeedback = (data) => request.put('/feedback/update', data)
export const deleteFeedback = (feedbackId) => request.delete(`/feedback/deleted/${feedbackId}`)
export const approveFeedback = (data) => request.put('/feedback/approve', data)
export const getReceivedFeedback = (handlerUserId, current = 1, size = 10) => request.get(`/feedback/received/view/${handlerUserId}`, { params: { current, size } })
export const getPendingFeedback = (feedbackUserId, current = 1, size = 10) => request.get(`/feedback/pending/view/${feedbackUserId}`, { params: { current, size } })
export const getFeedbackDetail = (feedbackId) => request.get(`/feedback/show/${feedbackId}`)