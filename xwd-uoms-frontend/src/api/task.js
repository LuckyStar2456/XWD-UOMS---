import request from '../utils/request'

export const addTask = (data) => request.post('/task/add', data)
export const updateTask = (data) => request.put('/task/update', data)
export const deleteTask = (taskId) => request.delete(`/task/deleted/${taskId}`)
export const approveTask = (data) => request.put('/task/approve', data)
export const getReceivedTask = (mandatoryId, current = 1, size = 10) => request.get(`/task/received/${mandatoryId}`, { params: { current, size } })
export const getPendingTask = (originatorId, current = 1, size = 10) => request.get(`/task/pending/${originatorId}`, { params: { current, size } })
export const getTaskDetail = (taskId) => request.get(`/task/show/${taskId}`)