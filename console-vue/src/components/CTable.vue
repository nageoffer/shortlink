<script setup>
import { onBeforeMount, ref, toRefs } from 'vue'
import zhCn from "element-plus/es/locale/lang/zh-cn";
import NoData from './emptyList.vue'

let headerPromise = null
onBeforeMount(() => {
  headerPromise = dealHeaders()
})

const pageLoading = ref(false)
const props = defineProps({
  getListData: [Function, Array],
  otherParams: Object,
  tableHeaders: Array,
  headerCellClassName: {
    type: String,
    default: 'app-table-header'
  },
  showPagination: {
    type: Boolean,
    default: true
  },
  showImg: {
    type: Boolean,
    default: true
  }
})

const { otherParams } = toRefs(props)
const emit = defineEmits(['getTotal'])
const tableData = ref([])
const pageParams = ref({
  pageNum: 1,
  pageSize: 30
})
const total = ref(0)
const result = ref()
const getList = () => {
  pageLoading.value = true
  let ajaxParams = {
    ...otherParams.value,
    ...pageParams.value
  }

  let dataFun = props.getListData
  let callFun = (res) => {
    if (!res) return
    result.value = res
    let data = res || {}
    tableData.value = Array.isArray(data.records) ? data.records : [] // 表数据
    total.value = data.total || 0 // 数据长度
    emit('getTotal', total.value)
    if (tableData.value.length === 0 && pageParams.value.pageNum > 1) {
      pageParams.value.pageNum = pageParams.value.pageNum - 1 || 1
      getList()
    } // 无数据时，重定向前一页或第一页
  }
  if (typeof dataFun === 'function') {
    let dataPromise = dataFun && dataFun(ajaxParams)
    if (dataPromise && typeof dataPromise.then === 'function') {
      Promise.all([dataPromise, headerPromise])
        .then((res) => {
          callFun(res[0])
          pageLoading.value = false
        })
        .catch((e) => {
          pageLoading.value = false
          console.error(e)
          callFun()
        })
    } else {
      callFun()
    }
  } else {
    pageLoading.value = false
    tableData.value = dataFun
  }
}
const formatterEmptyData = (str) => (['', null, undefined].indexOf(str) >= 0 ? '-' : str)

const computedHeaders = ref([])
function dealHeaders() {
  let headers = props.tableHeaders
  computedHeaders.value = headers.map((headItem) => {
    // 序号类型，补充分页信息返回
    let fun = headItem.index
    if (headItem.type === 'index' && typeof fun === 'function') {
      headItem.index = (index) => fun(index, pageParams.value.pageNum, pageParams.value.pageSize)
      // console.log(headItem.index);
    }
    let formatter = headItem.formatter
    if (typeof formatter === 'function') {
      headItem.formatter = (...args) => {
        let res = formatter.apply(null, args)
        return formatterEmptyData(res)
      }
    } else {
      headItem.formatter = (row, col, value) => formatterEmptyData(value)
    }
    return headItem
  })
  // console.log('sdfsdf', computedHeaders.value)
}


const handleCurrentChange = (val) => {
  pageParams.value.pageNum = val
  getList()
}

const handleSizeChange = (val) => {
  pageParams.value.pageNum = 1
  pageParams.value.pageSize = val
  getList()
}

const refreshList = () => {
  getList()
}

getList()

defineExpose({
  refreshList
})
</script>

<template>
  <div class="app-content">
    <slot name="form"></slot>
    <slot name="btnRow"></slot>
    <div>
      <el-table
        class="table-wrapper"
        :data="tableData"
        :header-cell-class-name="headerCellClassName"
        style="width: 100%; height: calc(100vh - 300px)"
        ref="multipleTableRef"
        v-loading="pageLoading"
      >
        <template v-for="(col, index) in computedHeaders">
          <!-- btns操作栏 -->
          <el-table-column
            :key="index + col"
            v-bind="col"
            v-if="col.colType == 'btns' && !col.hidden"
          >
            <template v-slot="scope">
              <el-button
                :size="btn.size"
                :type="btn.type"
                :key="btnIndex"
                v-for="(btn, btnIndex) in col.btns"
                v-show="isShowButton(scope.row, scope.$index, btn)"
                @click.stop="btn.click(scope.row, scope.$index, btnIndex)"
                >{{ btn.label }}</el-button
              >
            </template>
          </el-table-column>
          <!-- 自定义栏 -->
          <el-table-column
            :key="index + col"
            v-bind="col"
            v-else-if="col.colType == 'column' && !col.hidden"
          >
            <template #default="scope">
              <slot :name="col.slotName || col.prop" :row="scope.row"></slot>
            </template>
          </el-table-column>
          <!-- 通用栏 -->
          <el-table-column v-bind="col" :key="index + col" v-else-if="!col.hidden">
          </el-table-column>
        </template>
        <!-- 数据为空 -->
        <template v-slot:empty>
          <no-data v-if="showImg" class="nodata"></no-data>
          <div v-else>暂无数据</div>
        </template>
      </el-table>
    </div>

    <div class="pagination-wrapper" v-if="showPagination">
      <el-config-provider :locale="zhCn"
        ><el-pagination
          v-if="tableData.length"
          class="pagination"
          :page-sizes="[10, 30, 50, 100]"
          layout="total,sizes,prev, pager, next,jumper"
          :total="total"
          :current-page="pageParams.pageNum"
          :page-size="pageParams.pageSize"
          @current-change="handleCurrentChange"
          @size-change="handleSizeChange"
      /></el-config-provider>
    </div>
    <slot name="footer"></slot>
  </div>
</template>

<style lang="scss" scoped>
.app-content {
  background: #fff;
  padding: 20px 24px;

  .line {
    width: 100%;
    height: 1px;
    background-color: #dcdfe6;
    margin-bottom: 15px;
  }

  .pagination-wrapper {
    margin-top: 20px;
    width: 100%;
    display: flex;
    justify-content: flex-end;
  }
  .nodata {
    height: calc(100vh - 200px);
  }
}
:deep(.el-scrollbar__view) {
  height: 480px !important;
}
</style>
