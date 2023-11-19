import http from '../axios'
export default {
  // 查询分组集合
  queryGroup(data) {
    return http({
      url: '/group',
      method: 'get',
      params: data
    })
  },
  // 新增短链分组
  addGroup(data) {
    return http({
      url: '/group',
      method: 'post',
      data
    })
  },
  // 修改短链分组
  editGroup(data) {
    return http({
      url: '/group',
      method: 'put',
      data
    })
  },
  // 删除短链分组
  deleteGroup(data) {
    return http({
      url: '/group',
      method: 'delete',
      params: data
    })
  },
  sortGroup(data) {
    return http({
      url: '/group/sort',
      method: 'post',
      data
    })
  }
}