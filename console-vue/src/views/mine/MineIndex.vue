<template>
  <div style="display: flex; height: 100%; width: 100%">
    <div class="options-box">
      <div>
        <span>账号设置</span>
      </div>
    </div>
    <div class="main-box">
      <el-descriptions
        class="margin-top content-box"
        title="个人信息"
        :column="1"
        :size="size"
        border
      >
        <el-descriptions-item>
          <template #label>
            <div class="cell-item">
              <el-icon :style="iconStyle">
                <user />
              </el-icon>
              用户名
            </div>
          </template>
          <span v-if="!dialogVisible">{{ userInfo?.data?.data?.username }}</span>
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div class="cell-item">
              <el-icon :style="iconStyle">
                <iphone />
              </el-icon>
              手机号
            </div>
          </template>
          <span>{{ userInfo?.data?.data?.phone }}</span>
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div class="cell-item">
              <el-icon :style="iconStyle">
                <tickets />
              </el-icon>
              姓名
            </div>
          </template>
          <span>{{ userInfo?.data?.data?.realName }}</span>
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div class="cell-item">
              <el-icon :style="iconStyle">
                <Message />
              </el-icon>
              邮箱
            </div>
          </template>
          <span>{{ userInfo?.data?.data?.mail }}</span>
        </el-descriptions-item>
      </el-descriptions>
      <el-button style="position: absolute;left: 35px; top: 250px; " type="primary" @click="dialogVisible = !dialogVisible">修改个人信息</el-button>
    </div>
  </div>
  <!-- 修改信息 -->
  <el-dialog v-model="dialogVisible" title="修改个人信息" width="60%" :before-close="handleClose">
    <div class="register" :class="{ hidden: isLogin }">
      <el-form
        ref="loginFormRef"
        :model="userInfoForm"
        label-width="50px"
        class="form-container"
        width="width"
        :rules="formRule"
      >
        <el-form-item prop="username">
          <el-input
            v-model="userInfoForm.username"
            placeholder="请输入用户名"
            maxlength="11"
            show-word-limit
            disabled
          >
            <template v-slot:prepend> 用户名 </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="mail">
          <el-input v-model="userInfoForm.mail" placeholder="请输入邮箱" show-word-limit clearable>
            <template v-slot:prepend> 邮<span class="second-font">箱</span> </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="phone">
          <el-input
            v-model="userInfoForm.phone"
            placeholder="请输入手机号"
            show-word-limit
            clearable
          >
            <template v-slot:prepend> 手机号 </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="realName">
          <el-input
            v-model="userInfoForm.realName"
            placeholder="请输入姓名"
            show-word-limit
            clearable
          >
            <template v-slot:prepend> 姓<span class="second-font">名</span> </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            v-model="userInfoForm.password"
            placeholder="默认密码，如需修改可输入新密码"
            show-word-limit
            clearable
          >
            <template v-slot:prepend> 密<span class="second-font">码</span> </template>
          </el-input>
        </el-form-item>
        <el-form-item>
          <div style="width: 100%; display: flex; justify-content: flex-end">
            <el-button @click="dialogVisible = false">取消</el-button>
            <el-button type="primary" @click="changeUserInfo(loginFormRef)"> 提交 </el-button>
          </div>
        </el-form-item>
      </el-form>
    </div>
  </el-dialog>
</template>

<script setup>
import { getCurrentInstance, ref, reactive } from 'vue'
import { getUsername } from '@/core/auth'
import { cloneDeep } from 'lodash'
import { ElMessage } from 'element-plus'
const loginFormRef = ref()
const { proxy } = getCurrentInstance()
// eslint-disable-next-line no-unused-vars
const API = proxy.$API
const userInfo = ref()
const userInfoForm = ref() // 修改信息
const getUserInfo = async () => {
  const username = getUsername()
  userInfo.value = await API.user.queryUserInfo(username)
  userInfoForm.value = cloneDeep(userInfo.value.data?.data)
  // console.log(userInfoForm.value)
}
getUserInfo()
// 修改信息
const dialogVisible = ref(false)
const formRule = reactive({
  phone: [
    { required: true, message: '请输入手机号', trigger: 'blur' },
    {
      pattern: /^1[3|5|7|8|9]\d{9}$/,
      message: '请输入正确的手机号',
      trigger: 'blur'
    },
    { min: 11, max: 11, message: '手机号必须是11位', trigger: 'blur' }
  ],
  username: [{ required: true, message: '请输入您的用户名', trigger: 'blur' }],
  mail: [
    { required: true, message: '请输入邮箱', trigger: 'blur' },
    {
      pattern: /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/,
      message: '请输入正确的邮箱号',
      trigger: 'blur'
    }
  ],
  password: [
    { required: false, message: '请输入密码', trigger: 'blur' },
    { min: 8, max: 15, message: '密码长度请在八位以上', trigger: 'blur' }
  ],
  realNamee: [{ required: true, message: '请输姓名', trigger: 'blur' }]
})
const changeUserInfo = (formEl) => {
  if (!formEl) return
  formEl.validate(async (valid) => {
    if (valid) {
      await API.user.editUser(userInfoForm.value)
      getUserInfo()
      dialogVisible.value = false
      ElMessage.success('修改成功!')
    } else {
      return false
    }
  })
}
</script>

<style lang="scss" scoped>
.main-box {
  position: relative;
  flex: 1;
  padding: 15px;
  background-color: rgb(238, 240, 245);
  height: calc(100vh - 50px);
  display: flex;
  flex-direction: column;
}

.content-box {
  flex: 1;
  background-color: #ffffff;
  padding: 20px;
}

.register {
  padding-right: 30px;
}

:deep(.el-descriptions__label) {
  width: 200px !important;
}

.second-font {
  margin-left: 13px;
}

.options-box {
  position: relative;
  height: 100%;
  width: 190px;
  border-right: 1px solid rgba(0, 0, 0, 0.1);
  display: flex;
  padding-top: 15px;
  div {
    flex: 1;
    display: flex;
    height: 50px;
    align-items: center;
    // justify-content: center;
    padding-left: 15px;
    background-color: rgb(235, 239, 250);
    font-family:
      PingFangSC-Semibold,
      PingFang SC;
    color: #3464e0;
    font-weight: 600;
  }
}
:deep(.el-descriptions__body) {
  width: 500px;
}
</style>
