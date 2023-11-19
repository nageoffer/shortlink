const req = import.meta.globEager('./modules/*.js')
const api = {}
for (const key in req) {
  const name = key.replace(/^\.\/modules\/(.*)\.\w+$/, '$1') // 取文件名
  const value = req[key] // 取文件的内容
  api[name] = value.default // 赋值
}
const API = api

export default API
