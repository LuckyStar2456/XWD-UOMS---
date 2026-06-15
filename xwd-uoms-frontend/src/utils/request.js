import axios from 'axios';
import { message } from 'antd';
import { getAccessToken, getRefreshToken, setTokens, removeTokens } from './token';
import { refreshTokenAPI } from '../api/auth';

const request = axios.create({
    baseURL: import.meta.env.VITE_API_BASE_URL,
    timeout: 15000,
});

let isRefreshing = false;
let failedQueue = [];

const processQueue = (error, token = null) => {
    failedQueue.forEach(prom => {
        if (error) {
            prom.reject(error);
        } else {
            prom.resolve(token);
        }
    });
    failedQueue = [];
};

request.interceptors.request.use(config => {
    const token = getAccessToken();
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
});

request.interceptors.response.use(
    response => response,
    async error => {
        const originalRequest = error.config;
        if (error.response?.status === 401 && !originalRequest._retry) {
            if (isRefreshing) {
                return new Promise((resolve, reject) => {
                    failedQueue.push({ resolve, reject });
                })
                    .then(token => {
                        originalRequest.headers.Authorization = `Bearer ${token}`;
                        return request(originalRequest);
                    })
                    .catch(err => Promise.reject(err));
            }

            originalRequest._retry = true;
            isRefreshing = true;

            const refreshToken = getRefreshToken();
            if (!refreshToken) {
                removeTokens();
                window.location.href = '/login';
                return Promise.reject(error);
            }

            try {
                const res = await refreshTokenAPI(refreshToken);
                if (!res || !res.data) {
                    throw new Error('刷新Token失败：服务器未返回数据');
                }
                const newAccessToken = res.data.data;
                if (!newAccessToken) {
                    const errorMsg = res.data.msg || '刷新Token失败：返回数据格式错误';
                    throw new Error(errorMsg);
                }
                setTokens(newAccessToken, refreshToken);

                originalRequest.headers.Authorization = `Bearer ${newAccessToken}`;
                processQueue(null, newAccessToken);
                return request(originalRequest);
            } catch (refreshError) {
                processQueue(refreshError, null);
                removeTokens();
                message.error('登录已过期，请重新登录');
                setTimeout(() => {
                    window.location.href = '/login';
                }, 1500);
                return Promise.reject(refreshError);
            } finally {
                isRefreshing = false;
            }
        }
        // 非401错误，显示错误消息
        if (error.response?.data?.msg) {
            message.error(error.response.data.msg);
        } else if (error.code === 'ECONNABORTED' || error.message?.includes('timeout')) {
            message.error('请求超时，请稍后重试');
        } else if (error.message) {
            message.error(error.message);
        }
        return Promise.reject(error);
    }
);

export default request;