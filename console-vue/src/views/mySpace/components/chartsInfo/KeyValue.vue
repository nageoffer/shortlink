<template>
  <div class="main">
    <span v-if="dataLists.length === 0">
      所选日期内没有访问数据
    </span>
    <div class="flex-box">
      <div class="flex-item" v-for="(item, index) in dataLists" :key="index">
        <span class="key-text">{{ item.ip }}</span>
        <span>{{ item.cnt }} 次</span>
      </div>
    </div>
  </div>
</template>

<script setup>
defineProps({
  dataLists: {
    type: Array,
    // eslint-disable-next-line vue/require-valid-default-prop
    default: []
  }
})

</script>

<style lang="scss" scoped>
.main {
  padding: 20px;
  .flex-box {
    display: flex;
    flex-direction: column;
    .flex-item {
      display: flex;
      margin-bottom: 5px;
      justify-content: space-between;
      .key-text {
        color: #3464e0;
      }
    }
  }
}
</style>
