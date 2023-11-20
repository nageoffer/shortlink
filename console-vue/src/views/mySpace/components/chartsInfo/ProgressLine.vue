<template>
  <div class="main-box">
    <span v-if="!dataLists"> 所选日期内没有访问数据 </span>
    <div v-else>
      <div class="flex-box" v-for="(item, index) in dataLists" :key="index">
        <div class="flex-item">
          <div>
            <img :src="getUrl(item?.browser, item?.os)" width="25" alt="" />
            <span>{{ item?.browser || item?.os }} {{ item?.ratio * 100 }}%</span>
          </div>
          <div>
            <span>{{ item?.cnt }} 次</span>
          </div>
        </div>
        <div>
          <el-progress
            color="#3464e0"
            :text-inside="true"
            :stroke-width="12"
            :percentage="item?.ratio * 100"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import edge from '@/assets/png/edge.png'
import Andriod from '@/assets/png/Andriod.png'
import Chorme from '@/assets/png/Chorme.png'
import firefox from '@/assets/png/firefox.png'
import iOS from '@/assets/png/iOS.png'
import macOS from '@/assets/png/macOS.png'
import other from '@/assets/png/other.png'
import Safair from '@/assets/png/Safair.png'
import WeChat from '@/assets/png/WeChat.png'
import Windows from '@/assets/png/Windows.png'
import linux from '@/assets/png/linux.png'

defineProps({
  dataLists: {
    type: Array
    // eslint-disable-next-line vue/require-valid-default-prop
    // default: [
    //   {
    //     name: 'windows',
    //     img: null,
    //     times: 2,
    //     percentage: 50
    //   },
    //   {
    //     name: 'linux',
    //     img: null,
    //     times: 2,
    //     percentage: 50
    //   },
    // ]
  }
})
const getUrl = (img1, img2) => {
  if (img1) {
    img1 = img1.toLowerCase()
  }
  if (img2) {
    img2 = img2.toLowerCase()
  }
  if (img1?.includes('edge') || img2?.includes('edge')) {
    return edge
  } else if (img1?.includes('chrome') || img2?.includes('chrome')) {
    return Chorme
  } else if (img1?.includes('andriod') || img2?.includes('andriod')) {
    return Andriod
  } else if (img1?.includes('fire') || img2?.includes('fire')) {
    return firefox
  } else if (img1?.includes('ios') || img2?.includes('ios')) {
    return iOS
  } else if (img1?.includes('mac') || img2?.includes('mac')) {
    return macOS
  } else if (img1?.includes('safair') || img2?.includes('safair')) {
    return Safair
  } else if (img1?.includes('windows') || img2?.includes('windows')) {
    return Windows
  } else if (
    img1?.includes('wechat') ||
    img1?.includes('微信') ||
    img2?.includes('wechat') ||
    img2?.includes('微信')
  ) {
    return WeChat
  } else if (img1?.includes('linux') || img2?.includes('linux')) {
    return linux
  } else {
    return other
  }
}
</script>

<style lang="scss" scoped>
.main-box {
  padding: 20px;

  .flex-box {
    height: 50px;
    display: flex;
    flex-direction: column;

    .flex-item {
      height: 35px;
      display: flex;
      align-items: center;
      justify-content: space-between;

      span {
        font-size: 15px;
      }

      img {
        margin-right: 10px;
      }
    }
  }
}

:deep(.el-progress-bar__innerText) {
  font-size: 12px;
  transform: translateY(-1.5px) !important;
}
</style>
