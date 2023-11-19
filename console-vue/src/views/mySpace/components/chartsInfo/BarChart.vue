<template>
  <!-- 柱状图 -->
  <div ref="barChartRef">
  </div>
</template>

<script setup>
import * as echarts from 'echarts'
import { onMounted, nextTick, ref, watch } from 'vue'
const props = defineProps({
  chartData: {
    type: Object,
    // eslint-disable-next-line vue/require-valid-default-prop
    default: {
      xAxis: [1, 2, 3, 4, 5, 6, 7],
      value: [12, 12, 32, 32, 23, 23, 16]
    }
  }
})
watch(
  () => props.chartData,
  () => {
    initChart()
  }
)
const barChartRef = ref()
const initChart = () => {
  const barDom = barChartRef.value
  const barChart = echarts.init(barDom)
  const option = {
    tooltip: {
      trigger: 'axis',
      axisPointer: {
        type: 'shadow'
      }
    },
    grid: {
      left: '5%',
      right: '5%',
      bottom: '5%',
      top: '13%',
      containLabel: true
    },
    xAxis: {
      type: 'category',
      axisLine: {
        show: false
      },
      axisTick: {
        show: false
      },
      axisLabel: {
        color: '#ababab'
      },
      data: props.chartData.xAxis
    },
    yAxis: {
      axisLabel: {
        color: '#ababab'
      },
      axisLine: {
        show: false
      },
      axisTick: {
        show: false
      },
      type: 'value'
    },
    series: [
      {
        data: props.chartData.value,
        type: 'bar',
        barWidth: '10px',
        itemStyle: {
          color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
            { offset: 0, color: '#83bff6' },
            { offset: 0.5, color: '#188df0' },
            { offset: 1, color: '#188df0' }
          ])
        },
        showBackground: true,
        backgroundStyle: {
          color: 'rgba(180, 180, 180, 0.2)'
        }
      }
    ]
  };
  barChart.setOption(option)
}
onMounted(() => {
  nextTick(() => {
    initChart()
  })
})
</script>

<style lang="scss" scoped>
.barChart {
  width: 100%;
  height: 100%;
}
</style>
