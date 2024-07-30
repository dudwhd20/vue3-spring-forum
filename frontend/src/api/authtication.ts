import { axiosInstance } from '@/customAxios'

export interface RequestUser  {
  email: string
  password: string
}

export function loginMember(data: RequestUser) {
  const url = '/api/auth'
  return axiosInstance.post(url, data)
}
