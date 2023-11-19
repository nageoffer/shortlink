<template>
  <el-popover placement="bottom" trigger="click" :width="180">
    <div class="main-box">
      <canvas ref="canvas"></canvas>
      <el-button type="primary" :width="100" @click="download">下载二维码</el-button>
    </div>
    <template #reference>
      <div class="qr-code">
        <img src="@/assets/svg/二维码.svg" width="20" alt="" />
      </div>
    </template>
  </el-popover>
</template>

<script setup>
import { ref, onMounted, nextTick } from 'vue'
import { ElMessage } from 'element-plus'
import QRCode from 'qrcode'
const props = defineProps({
  url: String
})
const canvas = ref()
// 二维码
const createQrCode = () => {
  QRCode.toCanvas(canvas.value, props.url, { width: 150, height: 150 })
  // QRCode(qrcodeRef.value, {
  //   text: 'http://www.baidu.com',
  //   width: 200,
  //   height: 200,
  // })
}
const download = () => {
  let a = document.createElement('a')
  a.href = canvas.value.toDataURL('image/png');
  a.download = '二维码';
  a.click()
  ElMessage.success('正在下载')
}
onMounted(() => {
  createQrCode()
})
</script>

<style lang="scss" scoped>
.main-box {
  display: flex;
  flex-direction: column;
}

.qr-code {
  cursor: pointer !important;
}

.qr-code:hover {
  opacity: .5;
}
</style>
