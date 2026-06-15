const ACCESS_TOKEN = 'accessToken'
const REFRESH_TOKEN = 'refreshToken'

export const getAccessToken = () => localStorage.getItem(ACCESS_TOKEN)
export const getRefreshToken = () => localStorage.getItem(REFRESH_TOKEN)
export const setTokens = (access, refresh) => {
    localStorage.setItem(ACCESS_TOKEN, access)
    localStorage.setItem(REFRESH_TOKEN, refresh)
}
export const removeTokens = () => {
    localStorage.removeItem(ACCESS_TOKEN)
    localStorage.removeItem(REFRESH_TOKEN)
}