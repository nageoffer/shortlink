<template>
  <div style="display: flex; height: 100%; width: 100%">
    <div class="options-box">
      <div>
        <span>Account Settings</span>
      </div>
    </div>
    <div class="main-box">
      <el-descriptions
        class="margin-top content-box"
        title="Profile"
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
              Username
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
              Phone
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
              Name
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
              Email
            </div>
          </template>
          <span>{{ userInfo?.data?.data?.mail }}</span>
        </el-descriptions-item>
      </el-descriptions>
      <el-button style="position: absolute;left: 35px; top: 250px; " type="primary" @click="dialogVisible = !dialogVisible">Edit Profile</el-button>
    </div>
  </div>
  <!-- 修改信息 -->
  <el-dialog v-model="dialogVisible" title="Edit Profile" width="60%" :before-close="handleClose">
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
            placeholder="Enter username"
            maxlength="11"
            show-word-limit
            disabled
          >
            <template v-slot:prepend> Username </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="mail">
          <el-input v-model="userInfoForm.mail" placeholder="Enter email" show-word-limit clearable>
            <template v-slot:prepend> Email </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="phone">
          <el-input
            v-model="userInfoForm.phone"
            placeholder="Enter phone number"
            show-word-limit
            clearable
          >
            <template v-slot:prepend> Phone </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="realName">
          <el-input
            v-model="userInfoForm.realName"
            placeholder="Enter name"
            show-word-limit
            clearable
          >
            <template v-slot:prepend> Name </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            v-model="userInfoForm.password"
            placeholder="Leave blank to keep the current password, or enter a new one"
            show-word-limit
            clearable
          >
            <template v-slot:prepend> Password </template>
          </el-input>
        </el-form-item>
        <el-form-item>
          <div style="width: 100%; display: flex; justify-content: flex-end">
            <el-button @click="dialogVisible = false">Cancel</el-button>
            <el-button type="primary" @click="changeUserInfo(loginFormRef)"> Save </el-button>
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
    { required: true, message: 'Enter a phone number', trigger: 'blur' },
    {
      pattern: /^1[3|5|7|8|9]\d{9}$/,
      message: 'Enter a valid phone number',
      trigger: 'blur'
    },
    { min: 11, max: 11, message: 'Phone number must be 11 digits', trigger: 'blur' }
  ],
  username: [{ required: true, message: 'Enter your username', trigger: 'blur' }],
  mail: [
    { required: true, message: 'Enter an email address', trigger: 'blur' },
    {
      pattern: /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/,
      message: 'Enter a valid email address',
      trigger: 'blur'
    }
  ],
  password: [
    { required: false, message: 'Enter a password', trigger: 'blur' },
    { min: 8, max: 15, message: 'Password must be at least 8 characters', trigger: 'blur' }
  ],
  realNamee: [{ required: true, message: 'Enter your name', trigger: 'blur' }]
})
const changeUserInfo = (formEl) => {
  if (!formEl) return
  formEl.validate(async (valid) => {
    if (valid) {
      await API.user.editUser(userInfoForm.value).then((res) => {
        if (res?.data?.code !== '0') {
          ElMessage.error(res.data.message)
        } else {
          getUserInfo()
          dialogVisible.value = false
          ElMessage.success('Profile updated successfully.')
        }
      })
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
