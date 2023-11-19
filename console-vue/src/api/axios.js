import axios from 'axios'
import { getToken, getUsername } from '@/core/auth.js'
// import Router from '../router'
import { ElMessage } from 'element-plus'
import { isNotEmpty } from '@/utils/plugins.js'

// const baseURL = '/resourcesharing/organizational'
const baseURL = '/api/short-link/admin/v1'
// 创建实例
const http = axios.create({
  // api 代理为服务器请求地址
  baseURL: '/api' + baseURL,
  timeout: 15000
})
// 请求拦截 -->在请求发送之前做一些事情
http.interceptors.request.use(
  (config) => {
    config.headers.Token = isNotEmpty(getToken()) ? getToken() : ''
    config.headers.Username = isNotEmpty(getUsername()) ? getUsername() : ''
    // console.log('获取到的token和username', getToken(), getUsername())
    return config
  },
  (error) => {
    return Promise.reject(error)
  }
)
// 响应拦截 -->在返回结果之前做一些事情
http.interceptors.response.use(
  (res) => {
    // 如果返回的code为 A000200代表登录过期或者没登录，将localStorage中的token清空
    if (res.data.code === ' A000200') {
      localStorage.removeItem('token')
    }
    if (res.status == 0 || res.status == 200) {
      // 请求成功对响应数据做处理，此处返回的数据是axios.then(res)中接收的数据
      // code值为 0 或 200 时视为成功
      return Promise.resolve(res)
    }
    return Promise.reject(res)
  },
  (err) => {
    // 在请求错误时要做的事儿
    // 此处返回的数据是axios.catch(err)中接收的数据
    return Promise.reject(err)
  }
)
export default http
