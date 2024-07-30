import axios, { AxiosError, type AxiosResponse, type InternalAxiosRequestConfig } from 'axios'

export const axiosInstance = axios.create({
  baseURL: import.meta.env.VITE_API_URL
})

const onResponse = (res: AxiosResponse): AxiosResponse => {
  const { method, url } = res.config
  const { code, message } = res.data
  if (code === 200) {
    console.log(`[API - RESPONSE] ${method?.toUpperCase()} ${url} | ${code} : ${message}`)
  } else {
    console.error(`[API - ERROR] ${method?.toUpperCase()} ${url} | ${code} : ${message}`)
  }

  return res
}

const onError = (error: AxiosError | Error): Promise<AxiosError> => {
  if (axios.isAxiosError(error)) {
    const { method, url } = error.config as InternalAxiosRequestConfig
    if (error.response) {
      const { statusCode, message } = error.response.data
      console.error(`[API - ERROR] ${method?.toUpperCase()} ${url} | ${statusCode} : ${message}`)
    }
  } else {
    console.error(`[API] | Error ${error.message}`)
  }
  return Promise.reject(error)
}

axiosInstance.interceptors.response.use(onResponse, onError)
