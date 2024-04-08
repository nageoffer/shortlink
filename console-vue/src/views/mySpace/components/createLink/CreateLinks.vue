<template>
  <div>
    <el-form ref="ruleFormRef" :model="formData" :rules="formRule" label-width="80px">
      <el-form-item label="跳转链接" prop="originUrls">
        <el-input
          :rows="4"
          v-model="formData.originUrls"
          type="textarea"
          placeholder="请输入http://或https://开头的链接或应用跳转链接，一行一个，最多100行"
        />
        <span style="font-size: 12px">{{ originUrlRows + '/' + maxDescribeRows }}</span>
      </el-form-item>
      <el-form-item label="描述信息" prop="describes">
        <el-input
          v-loading="isLoading"
          :rows="4"
          v-model="formData.describes"
          type="textarea"
          placeholder="请输入描述信息，一行一个，描述信息行数请与链接行数相等"
        />
        <span style="font-size: 12px">{{ describeRows + '/' + maxDescribeRows }}</span>
      </el-form-item>
      <el-form-item label="短链分组" prop="gid">
        <el-select v-model="formData.gid" placeholder="请选择">
          <el-option
            v-for="item in groupInfo"
            :key="item.gid"
            :label="item.name"
            :value="item.gid"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="有效期" prop="v">
        <el-radio-group v-model="formData.validDateType">
          <el-radio :label="0">永久</el-radio>
          <el-radio :label="1">自定义</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item v-if="formData.validDateType === 1" label="选择时间">
        <el-date-picker
          :disabled-date="disabledDate"
          v-model="formData.validDate"
          value-format="YYYY-MM-DD HH:mm:ss"
          type="datetime"
          placeholder="选择日期"
          :shortcuts="shortcuts"
        />
        <span class="alert">链接失效后将自动跳转到404页面 !</span>
      </el-form-item>
      <el-form-item>
        <div style="width: 100%; display: flex; justify-content: flex-end">
          <el-button
            class="buttons"
            type="primary"
            :disabled="submitDisable"
            @click="onSubmit(ruleFormRef)"
            >确认</el-button
          >
          <el-button class="buttons" @click="cancel">取消</el-button>
        </div>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import { reactive, ref, onMounted, nextTick, watch, onBeforeUnmount, getCurrentInstance } from 'vue'
import { ElMessage } from 'element-plus'
import { useStore } from 'vuex'

const store = useStore()
const defaultDomain = store.state.domain ?? ' '
const props = defineProps({
  groupInfo: Array,
  defaultGid: String
})
const { proxy } = getCurrentInstance()
const API = proxy.$API
// url的校验规则
const reg =
  /^(https?:\/\/(([a-zA-Z0-9]+-?)+[a-zA-Z0-9]+\.)+(([a-zA-Z0-9]+-?)+[a-zA-Z0-9]+))(:\d+)?(\/.*)?(\?.*)?(#.*)?$/
// 自定义时间中选择几天
const shortcuts = [
  {
    text: '一天',
    value: () => {
      const date = new Date()
      date.setTime(date.getTime() + 3600 * 1000 * 24)
      return date
    }
  },
  {
    text: '七天',
    value: () => {
      const date = new Date()
      date.setTime(date.getTime() + 3600 * 1000 * 24 * 7)
      return date
    }
  },
  {
    text: '三十天',
    value: () => {
      const date = new Date()
      date.setTime(date.getTime() + 3600 * 1000 * 24 * 30)
      return date
    }
  }
]
// eslint-disable-next-line vue/no-dupe-keys
const groupInfo = ref()
const formData = reactive({
  domain: defaultDomain,
  originUrls: null,
  gid: null,
  createdType: 1,
  validDate: null,
  describes: null,
  validDateType: 0
})
const initFormData = () => {
  formData.domain = defaultDomain
  formData.originUrls = null
  formData.createdType = 1
  formData.validDate = null
  formData.describes = null
  formData.validDateType = 0
}
const maxOriginUrlRows = ref(100) // 最多多少行
// 链接有多少行
const originUrlRows = ref(0)
// 防抖
// const fd = (fn, delay) => {
//   let timer = null
//   return function (url) {
//     if (timer) {
//       clearTimeout(timer)
//       timer = null
//     }
//     timer = setTimeout(() => {
//       fn(url)
//     }, delay)
//   }
// }
const isLoading = ref(false)
// const queryTitle = (url) => {
//   if (reg.test(url)) {
//     isLoading.value = true
//     API.smallLinkPage.queryTitle({ url: url }).then((res) => {
//       formData.describe = res?.data?.data
//       isLoading.value = false
//     })
//   }
// }
// const getTitle = fd(queryTitle, 1000)
watch(
  () => formData.originUrls,
  (nV) => {
    originUrlRows.value = (nV || '').split(/\r|\r\n|\n/)?.length ?? 0
    // // 只有在描述内容为空时才会去查询链接对应的标题
    // if (!formData.describe) {
    //   // 外边包一层防抖
    //   getTitle(nV)
    // }
  }
)
const maxDescribeRows = ref(100) // 最多多少行
// 描述信息有多少行
const describeRows = ref(0)
watch(
  () => formData.describes,
  (nV) => {
    describeRows.value = (nV || '').split(/\r|\r\n|\n/)?.length ?? 0
  }
)

// 将分组数据传给选择分组选项并默认选中第一项
watch(
  () => props.groupInfo,
  (nV) => {
    groupInfo.value = nV
    // console.log('默认的gid', props.defaultGid)
    formData.gid = nV[0].gid
  },
  {
    immediate: true
  }
)
watch(
  () => props.defaultGid,
  (nV) => {
    if (props.defaultGid) {
      formData.gid = props.defaultGid
    } else {
      formData.gid = nV[0].gid
    }
  },
  {
    immediate: true
  }
)

// 校验规则
const formRule = reactive({
  originUrls: [
    { required: true, message: '请输入链接', trigger: 'blur' },
    {
      validator: function (rule, value, callback) {
        // console.log('============', value, value.split('/n'))
        if (value) {
          value.split(/\r|\r\n|\n/).forEach((item) => {
            if (!reg.test(item)) {
              callback(new Error('请输入 http:// 或 https:// 开头的链接或应用跳转链接'))
            }
          })
        }
        if (originUrlRows.value > maxOriginUrlRows.value) {
          callback(new Error('超过输入' + maxOriginUrlRows.value + '行'))
        } else {
          callback()
          submitDisable.value = false
        }
      },
      trigger: 'blur'
    }
  ],
  gid: [{ required: true, message: '请选择分组', trigger: 'blur' }],
  describes: [
    { required: true, message: '请输入描述信息', trigger: 'blur' },
    {
      validator: function (rule, value, callback) {
        if (value) {
          value.split(/\r|\r\n|\n/).forEach((item) => {
            if (item === '' || !item) {
              callback(new Error('请不要输入空行'))
            }
          })
        }
        // console.log('============', value, value.split('/n'))
        if (describeRows.value !== originUrlRows.value) {
          callback(new Error('标题数量与链接数量不等'))
        }
        if (describeRows.value > maxDescribeRows.value) {
          callback(new Error('超过输入' + maxDescribeRows.value + '行'))
        } else {
          callback()
        }
      },
      trigger: 'blur'
    }
  ],
  validDate: [
    { required: false, message: '请输日期', trigger: 'blur' }
    // {
    //   validator: function (rule, value, callback) {
    //     if (describeRows.value > maxDescribeRows.value) {
    //       callback(new Error('超过输入' + maxDescribeRows.value + '行'))
    //     } else {
    //       callback()
    //     }
    //   },
    //   trigger: 'blur'
    // }
  ]
})
// 限制日期选择器选择过去的时间
const disabledDate = (time) => {
  return new Date(time).getTime() < new Date().getTime() //选当前时间之后的时间
}

// 将输入框中的含有\n的字符串变为数组
const transferStrToArray = (str) => {
  return str.split(/[\n]+/)
}
// 将组件里面的确认和取消点击事件传出去
const emits = defineEmits(['onSubmit', 'cancel'])

function downLoadXls(res) {
  let url = window.URL.createObjectURL(
    new Blob([res.data], {
      type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
    })
  )
  // 创建A标签
  let link = document.createElement('a')
  link.style.display = 'none'
  link.href = url
  // 设置的下载文件文件名
  const fileName = decodeURI(res.headers['content-disposition'].split(';')[1].split('filename*=')[1])
  // 触发点击方法
  link.setAttribute('download', fileName)
  document.body.appendChild(link)
  link.click()
}

// 点击确定按钮后的校验
const ruleFormRef = ref()
const submitDisable = ref(false)
const onSubmit = async (formEl) => {
  submitDisable.value = true
  if (!formEl) {
    submitDisable.value = false
    return
  }
  await formEl.validate(async (valid, fields) => {
    if (valid) {
      let { describes, originUrls } = formData
      describes = transferStrToArray(describes)
      originUrls = transferStrToArray(originUrls)
      const res = await API.smallLinkPage.addLinks({ ...formData, describes, originUrls })
      if (!res.data.data && res.data) {
        ElMessage.success('创建成功！短链列表已开始下载')
        emits('onSubmit', false)
        submitDisable.value = false
        downLoadXls(res)
      } else if (!res?.data?.success) {
        ElMessage.error(res?.data?.message)
      } else {
        ElMessage.success('创建成功！短链列表已开始下载')
        emits('onSubmit', false)
        submitDisable.value = false
      }
    } else {
      // ElMessage.error('创建失败！')
    }
  })
}
const cancel = () => {
  emits('cancel', false)
  initFormData()
}
onBeforeUnmount(() => {
  initFormData()
})
defineExpose({
  // 当外部对话框以任何方式关闭时，初始化表单数据
  initFormData
})
</script>

<style lang="less" scoped>
.alert {
  color: rgb(231, 166, 67);
  font-size: 12px;
  width: 90%;
}
</style>
