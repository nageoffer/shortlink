/**
 * 替换第三方插件里面的 __require() 方法
 * @param {*} code
 * @param {*} id
 * @returns
 */
// eslint-disable-next-line camelcase
import { nextTick } from 'vue'
export const transformRequireDynamic = function (code, id) {
  // console.log(code)
  if (!/\/node_modules\//g.test(id)) return code
  const requireRegex = /_{2}require*\(\s*(["'].*["'])\s*\)/g
  const IMPORT_STRING_PREFIX = '__require_for_vite'
  const requireMatches = code.matchAll(requireRegex)
  let importsString = ''
  let packageName = ''
  let replaced = false
  for (const item of requireMatches) {
    if (!isString(item[1])) {
      console.warn(`Not supported dynamic import, file:${id}`)
      continue
    }
    replaced = true
    packageName = `${IMPORT_STRING_PREFIX}_${randomString(6)}`
    importsString += `import ${packageName} from ${item[1]};\n`
    code = code.replace(item[0], `${packageName}`)
  }
  if (replaced) {
    code = importsString + code
  }
  return code
}
export const resourceUserInfo = () => {
  return localStorage.getItem('resourceUserInfo')
    ? JSON.parse(localStorage.getItem('resourceUserInfo'))
    : {}
}
/**
 *
 * @param {必填，数字} length
 * @returns hash串
 */
function randomString(length) {
  const code = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890'
  let result = ''
  for (let index = 0; index < length; index++) {
    result += code[Math.floor(Math.random() * code.length)]
  }
  return result
}
function isString(text) {
  try {
    // eslint-disable-next-line no-eval
    return typeof eval(text) === 'string'
  } catch (err) {
    return false
  }
}

export const hidePhone = (phone) => {
  let reg = /^(\d{3})\d{4}(\d{4})$/
  if (phone) {
    return phone.replace(reg, '$1****$2')
  }
  return ''
}

export const showTeachingYears = (str) => {
  return str === '名优教师' || str === '教育专家' || str === '金牌教练'
}

export const setImg = (str) => {
  if (str?.includes('/src/assets/images')) {
    return new URL(str, import.meta.url).href
  }
  return str
}

export function isMax(file) {
  return Math.ceil(file.size / 1024 / 1024) < 3072
}

export function isMin(file) {
  return Math.floor(file.size / 1024 / 1024) > 5
}

// .FLV,.WMV,.MOV,
export function acceptVideo() {
  return '.MP4'
}

export function isValid(file) {
  let acceptArr = [
    'MP4'
    /*  'TS',
    'MOV',
    'MXF',
    'FLV',
    'MPG',
    'WMV',
    'AVI',
    'F4V',
    'M4V',
    'HLS',
    'MPEG' */
  ]
  if (file.raw?.type) {
    let type = file.raw.type.split('/')[1].toUpperCase()
    return acceptArr.includes(type)
  }
  if (file.type) {
    let type = file.type.split('/')[1].toUpperCase()
    return acceptArr.includes(type)
  }
  return true
}

export const computeSize = (fileSize) => {
  if (!fileSize) return 0
  let size = ''
  if (fileSize >= 1024 * 1024) {
    size = `${(fileSize / (1024 * 1024)).toFixed(2)} MB`
  } else if (fileSize >= 1024) {
    size = `${(fileSize / 1024).toFixed(2)} KB`
  } else {
    size = `${fileSize.toFixed(2)}B`
  }
  return size
}

// 把树结构转为一维数组
export const flattenTree = (tree, childrenKey = 'childrenTag') => {
  return tree.reduce((arr, item) => {
    let children = item[childrenKey]
    arr.push(item)
    arr = arr.concat(Array.isArray(children) ? flattenTree(children, childrenKey) : [])
    return arr
  }, [])
}

export const isNotEmpty = (value) => {
  // eslint-disable-next-line eqeqeq
  return value && value != 'undefined' && value != 'null'
}

export function moveToErr() {
  nextTick(() => {
    let isError = document.getElementsByClassName('is-error')
    if (isError.length) {
      isError[0].scrollIntoView({
        block: 'center',
        behavior: 'smooth'
      })
    }
  })
}
// 返回最后面的路由信息
export function getLasteRoute(fullpath) {
  const arr = fullpath.split('/')
  const length = arr.length
  return '/' + arr[length - 1]
}

//获取今日日期函数   2023-11-12 23:59:59
export function getTodayFormatDate() {
  let date = new Date(new Date().getTime()),
    year = date.getFullYear(), //获取完整的年份(4位)
    month = date.getMonth() + 1, //获取当前月份(0-11,0代表1月)
    strDate = date.getDate() // 获取当前日(1-31)
  if (month < 10) month = `0${month}` // 如果月份是个位数，在前面补0
  if (strDate < 10) strDate = `0${strDate}` // 如果日是个位数，在前面补0

  return `${year}-${month}-${strDate}` + ' 23:59:59'
}
// 获取上周的日期   2023-11-12 00:00:00
export function getLastWeekFormatDate() {
  let nextWeekDate = new Date(new Date().getTime() - 6 * 24 * 60 * 60 * 1000),
    year = nextWeekDate.getFullYear(), //获取完整的年份(4位)
    month = nextWeekDate.getMonth() + 1, //获取当前月份(0-11,0代表1月)
    strDate = nextWeekDate.getDate() // 获取当前日(1-31)
  if (month < 10) month = `0${month}` // 如果月份是个位数，在前面补0
  if (strDate < 10) strDate = `0${strDate}` // 如果日是个位数，在前面补0

  return `${year}-${month}-${strDate}` + ' 00:00:00'
}
