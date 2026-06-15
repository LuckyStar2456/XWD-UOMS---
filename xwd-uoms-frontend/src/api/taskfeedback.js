import request from '../utils/request'

export const addTaskFeedback = (data) => request.post('/taskfeedback/add', data)
export const updateTaskFeedback = (data) => request.put('/taskfeedback/update', data)
export const approveTaskFeedback = (reviewUserId, data) => request.put(`/taskfeedback/approve/${reviewUserId}`, data)
export const getReceivedTaskFeedback = (reviewUserId, current = 1, size = 10) => request.get(`/taskfeedback/received/view/${reviewUserId}`, { params: { current, size } })
export const getPendingTaskFeedback = (feedbackUserId, current = 1, size = 10) => request.get(`/taskfeedback/pending/view/${feedbackUserId}`, { params: { current, size } })
export const getTaskFeedbackDetail = (id) => request.get(`/taskfeedback/show/${id}`)