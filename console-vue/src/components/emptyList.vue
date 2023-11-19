<!--
 * @Date: 2022-10-26 13:46:41
 * @LastEditTime: 2022-10-26 14:00:56
 * @Description: 列表空状态
-->
<script setup>
defineProps({
  text: {
    type: String,
    default: '暂无数据，请点击创建短链按钮创建数据'
  }
})
</script>

<template>
  <div class="empty">
    <img src="@/assets/png/无数据.png" alt="" class="empty_img" />
    <p>{{ text }}</p>
    <slot></slot>
  </div>
</template>

<style lang="scss" scoped>
.empty {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  font-size: 12px;
  font-family: PingFangSC-Regular, PingFang SC;
  font-weight: 400;
  color: #8591a9;
  height: 440px;

  &_img {
    width: 200px;
    margin-bottom: 11px;
  }
}
</style>
