import request from '../utils/request'

export const loginAPI = (data) => request.post('/auth/login', data)
export const refreshTokenAPI = (refreshToken) => request.post('/auth/refreshToken', { refreshToken })
export const logoutAPI = (refreshToken) => request.post('/auth/logout', { refreshToken })