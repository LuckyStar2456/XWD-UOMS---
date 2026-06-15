import { message } from 'antd';

const DEFAULT_ERROR_MSG = '操作失败，请稍后重试';

export const apiWrapper = async (apiCall, options = {}) => {
    const { 
        successMsg, 
        errorMsg = DEFAULT_ERROR_MSG, 
        showSuccess = true, 
        showError = true 
    } = options;

    try {
        const response = await apiCall();
        const data = response.data;
        
        if (data.code !== undefined && data.code !== 200) {
            throw new Error(data.msg || errorMsg);
        }
        
        if (showSuccess && successMsg) {
            message.success(successMsg);
        }
        
        return data;
    } catch (error) {
        if (showError) {
            const msg = error.response?.data?.msg || error.message || errorMsg;
            message.error(msg);
        }
        throw error;
    }
};

export const useApi = () => {
    const request = async (apiCall, options = {}) => {
        return apiWrapper(apiCall, options);
    };

    return { request };
};

export default apiWrapper;