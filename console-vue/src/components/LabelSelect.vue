<template>
  <div style="display: flex; align-items: center; height: 40px; padding: 0 10px">
    <span class="label">{{ label + ':' }}</span>
    <el-select v-model="value" size="small" class="m-2" :placeholder="placeholder" width="80" clearable>
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value"
      />
    </el-select>
  </div>
</template>

<script setup>
import { ref, watch } from 'vue'
const value = ref()
const emits = defineEmits(['changeValue'])
defineProps({
  label: {
    type: String,
    default: '选项名称'
  },
  options: {
    type: Array,
    default: () => {
      return [
        { value: 'option1', label: 'option1' },
        { value: 'option2', label: 'option2' }
      ]
    }
  },
  placeholder: {
    type: String,
    default: '请选择'
  }
})
watch(
  () => value.value,
  (newValue) => {
    emits('changeValue', newValue)
  }
)
</script>

<style lang="scss" scoped>
.label {
  font-size: 14px;
  font-family:
    PingFangSC-Regular,
    PingFang SC;
  font-weight: 400;
  color: #323a47;
  line-height: 20px;
  margin-right: 10px;
}
.m-2 {
  flex: 1
}
</style>
