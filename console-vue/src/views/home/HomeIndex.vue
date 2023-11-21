<template>
  <div class="common-layout">
    <el-container>
      <el-header height="50px" style="padding: 0">
        <div class="header">
          <div @click="toMySpace" class="logo">拿个offer-SaaS短链接</div>
          <div style="display: flex; align-items: center">
            <a class="link-span" style="text-decoration:none;" target="_blank" href="https://nageoffer.com/shortlink/">文档</a>
            <a class="link-span" style="text-decoration:none;" target="_blank" href="https://nageoffer.com/shortlink/">博客</a>
            <a class="link-span" style="text-decoration:none;" target="_blank" href="https://nageoffer.com/shortlink/">社区</a>
            <el-dropdown>
              <div class="block">
                <el-avatar
                  :size="30"
                  class="avatar"
                  :style="`background:${extractColorByName(firstName)}`"
                  >{{ firstName }}
                </el-avatar>
              </div>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item @click="toMine">个人信息</el-dropdown-item>
                  <el-dropdown-item divided @click="logout">退出</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </div>
        </div>
      </el-header>
      <el-main style="padding: 0">
        <div class="content-box">
          <RouterView class="content-space" />
        </div>
      </el-main>
      <!-- <el-container>
        <el-aside width="180px">
          <el-menu
            active-text-color="#073372"
            background-color="#0e5782"
            class="el-menu-vertical-demo"
            :default-active="getLasteRoute(route.path)"
            text-color="#fff"
            @select="handleSelect"
          >
            <template v-for="item in menuInfos" :key="item.name">
              <el-menu-item :index="item.path">
                <el-icon><icon-menu /></el-icon>
                <span>{{ item.name }}</span>
              </el-menu-item>
            </template>
          </el-menu></el-aside
        >

      </el-container> -->
    </el-container>
  </div>
</template>

<script setup>
import { ref, getCurrentInstance, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import { removeKey, removeUsername, getToken, getUsername } from '@/core/auth.js'
import { ElMessage } from 'element-plus'
const { proxy } = getCurrentInstance()
const API = proxy.$API
// 当当前路径和菜单不匹配时，菜单不会被选中
const router = useRouter()
const squareUrl = ref('https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png')
const toMine = () => {
  router.push('/home' + '/mine')
}
// 登出
const logout = async () => {
  const token = getToken()
  const username = getUsername()
  // 请求登出的接口
  await API.user.logout({ token, username })
  // 删除cookies中的token和username
  removeUsername()
  removeKey()
  localStorage.removeItem('token')
  localStorage.removeItem('username')
  router.push('/')
  ElMessage.success('成功退出！')
}
// 点击左上方的图片跳转到我的空间
const toMySpace = () => {
  router.push('/home' + '/mySpace')
}
const firstName = ref('')
onMounted(async () => {
  const username = getUsername()
  const res = await API.user.queryUserInfo(username)
  firstName.value = res?.data?.data?.realName?.split('')[0]
})
const extractColorByName = (name) => {
  var temp = []
  temp.push('#')
  for (let index = 0; index < name.length; index++) {
    temp.push(parseInt(name[index].charCodeAt(0), 10).toString(16))
  }
  return temp.slice(0, 5).join('').slice(0, 4)
}
</script>

<style lang="scss" scoped>
.el-container {
  height: 100vh;

  .el-aside {
    border: 0;
    background-color: #0e5782;

    ul {
      border: 0px;
    }
  }

  .el-main {
    background-color: #e8e8e8;
  }
}

.header {
  background-color: #2550cd;
  padding: 0 30px 0 20px;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: space-between;

  .block {
    margin-top: 5px;
    cursor: pointer;
    display: flex;
    align-items: center;
    border: 0px;
  }
}

.content-box {
  height: calc(100vh - 50px);
  background-color: white;
}

:deep(.el-tooltip__trigger:focus-visible) {
  outline: unset;
}

.logo {
  font-size: 15px;
  font-weight: 600;
  color: #e8e8e8;
  font-family: Helvetica, Tahoma, Arial, 'PingFang SC', 'Hiragino Sans GB', 'Heiti SC',
    'Microsoft YaHei', 'WenQuanYi Micro Hei';
  // font-family: 'Helvetica Neue', Helvetica, STHeiTi, Arial, sans-serif;
  cursor: pointer;
}

.logo:hover {
  color: #82b1cc;
}

.link-span {
  color: #e8e8e8;
  margin-right: 30px;
  font-size: 16px;
  font-family: 'Helvetica Neue', Helvetica, STHeiTi, Arial, sans-serif;
  cursor: pointer;
}

.link-span:hover {
  color: #80b0cb;
}

.avatar {
  transform: translateY(-2px);
}
</style>
