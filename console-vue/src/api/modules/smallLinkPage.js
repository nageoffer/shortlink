import http from '../axios'
export default {
  queryPage(data) {
    return http({
      url: '/page',
      method: 'get',
      params: data
    })
  },
  addSmallLink(data) {
    return http({
      url: '/create',
      method: 'post',
      data
    })
  },
  editSmallLink(data) {
    return http({
      url: '/update',
      method: 'post',
      data
    })
  },
  // 通过链接查询标题
  queryTitle(data) {
    return http({
      method: 'get',
      url: '/title',
      params: data
    })
  },
  // 移动到回收站
  toRecycleBin(data) {
    return http({
      url: '/recycle-bin/save',
      method: 'post',
      data
    })
  },
  // 查询回收站数据
  queryRecycleBin(data) {
    return http({
      url: '/recycle-bin/page',
      method: 'get',
      params: data
    })
  },
  // 恢复短链接
  recoverLink(data) {
    return http({
      method: 'post',
      url: '/recycle-bin/recover',
      data
    })
  },
  removeLink(data) {
    return http({
      method: 'post',
      url: '/recycle-bin/remove',
      data
    })
  },
  // 查询单链的图表数据
  queryLinkStats(data) {
    return http({
      method: 'get',
      params: data,
      url: 'stats'
    })
  },
  // 查询分组的访问记录
  queryLinkTable(data) {
    return http({
      method: 'get',
      params: data,
      url: 'stats/access-record'
    })
  }
}
