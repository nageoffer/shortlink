<template>
  <div style="display: flex; height: 100%">
    <div class="options-box">
      <div class="option-title flex-box">
        <div>
          短链分组<span> 共{{ editableTabs?.length }}组</span>
        </div>
        <div class="hover-box" style="width: 24px" @click="showAddGroup">
          <img src="@/assets/svg/添加.svg" alt="" />
        </div>
      </div>
      <!-- 拖动选项 -->
      <ul class="sortOptions">
        <li v-for="(item, index) in editableTabs" :key="item.gid">
          <div
            class="item-box flex-box hover-box"
            :class="{ selectedItem: selectedIndex === index }"
            @click="changeSelectIndex(index)"
          >
            <div style="display: flex">
              <img src="@/assets/svg/移动 竖.svg" width="13" style="margin-right: 3px" alt="" />
              <span class="over-text">{{ item.name }}</span>
            </div>
            <div class="flex-box">
              <!-- 图标 -->
              <el-tooltip
                class="box-item"
                effect="dark"
                :content="'查看图表'"
                placement="bottom-end"
              >
                <!-- 传group是为了表示这个请求是查询分组图表数据 -->
                <el-icon
                  v-if="!(item.shortLinkCount === 0 || item.shortLinkCount === null)"
                  class="edit"
                  :class="{ zero: item.shortLinkCount === 0 }"
                  @click="chartsVisible({ describe: item.name, gid: item.gid, group: true })"
                >
                  <Histogram />
                </el-icon>
              </el-tooltip>
              <!-- 编辑按钮 -->
              <el-dropdown>
                <div class="block">
                  <el-icon class="edit" v-if="item.title !== '默认分组'">
                    <Tools />
                  </el-icon>
                </div>
                <template #dropdown>
                  <el-dropdown-menu>
                    <el-dropdown-item @click="showEditGroup(item.gid, item.name)"
                      >编辑</el-dropdown-item
                    >
                    <el-dropdown-item @click="deleteGroup(item.gid)">删除</el-dropdown-item>
                  </el-dropdown-menu>
                </template>
              </el-dropdown>
              <span class="item-length">{{ item.shortLinkCount ?? 0 }}</span>
            </div>
          </div>
        </li>
      </ul>
      <div class="recycle-bin">
        <!-- 当selectIndex等于-1时代表选中的是回收站 -->
        <div
          class="recycle-box hover-box"
          :class="{ selectedItem: selectedIndex === -1 }"
          @click="recycleBin"
        >
          回收站
          <el-icon style="margin-left: 5px; font-size: 20px">
            <Delete />
          </el-icon>
        </div>
      </div>
    </div>
    <!-- 主要数据展示区域 -->
    <div class="content-box">
      <div class="table-box">
        <!-- 默认展示创建短链输入框和按钮 -->
        <div v-if="!isRecycleBin" class="buttons-box">
          <div style="width: 100%; display: flex">
            <!-- <el-input style="flex: 1; margin-right: 20px" placeholder="请输入http://或https://开头的连接或引用跳转程序"></el-input> -->
            <el-button
              type="primary"
              style="width: 130px; margin-right: 10px"
              @click="isAddSmallLink = true"
              >创建短链</el-button
            >
            <el-button style="width: 130px; margin-right: 10px" @click="isAddSmallLinks = true"
              >批量创建</el-button
            >
          </div>
        </div>
        <!-- 展示回收站信息 -->
        <div v-else class="recycle-bin-box">
          <span>回收站</span>
          <span>一共{{ recycleBinNums }}条短链接</span>
        </div>
        <!-- 表格展示区域 -->
        <el-table
          :data="tableData"
          height="calc(100vh - 240px)"
          style="width: calc(100vw - 230px)"
          :header-cell-style="{ background: '#f7f8fa', color: '#606266' }"
        >
          <!-- 数据为空时展示的内容 -->
          <template #empty>
            <div style="height: 60vh; display: flex; align-items: center; justify-content: center">
              暂无链接
            </div>
          </template>
          <el-table-column type="selection" width="35" />
          <el-table-column label="短链接信息" prop="info" min-width="300">
            <template #header>
              <el-dropdown>
                <div class="block" style="margin-top: 3px">
                  <span>短链接信息</span>
                  <el-icon>
                    <CaretBottom />
                  </el-icon>
                </div>
                <template #dropdown>
                  <el-dropdown-item @click="pageParams.orderTag = null">创建时间</el-dropdown-item>
                </template>
              </el-dropdown>
            </template>
            <template #default="scope">
              <div
                class="table-link-box"
                :class="{
                  isExpire: scope?.row?.validDateType === 1 && !isExpire(scope?.row?.validDate)
                }"
              >
                <img :src="getImgUrl(scope.row.favicon)" width="20" height="20" alt="" />
                <div class="name-date">
                  <el-tooltip :content="scope.row.describe">
                    <span>{{ scope.row.describe }}</span>
                  </el-tooltip>
                  <div class="time" style="display: flex">
                    <span>{{ scope.row.createTime }}</span>
                    <el-tooltip
                      v-if="scope?.row?.validDate"
                      :content="'到期时间：' + scope?.row?.validDate"
                    >
                      <img
                        v-if="isExpire(scope?.row?.validDate)"
                        width="18"
                        height="18"
                        src="@/assets/png/沙漏倒计时.png"
                        alt=""
                      />
                      <div v-else><span>已失效</span></div>
                    </el-tooltip>
                  </div>
                </div>
              </div>
            </template>
          </el-table-column>
          <el-table-column label="短链接网址" prop="url" min-width="300">
            <template #default="scope">
              <div class="table-url-box">
                <!-- 当失效后就不能在点击跳转了 -->
                <el-link
                  type="primary"
                  :underline="false"
                  target="_blank"
                  :disabled="scope?.row?.validDateType === 1 && !isExpire(scope?.row?.validDate)"
                  :href="'http://' + scope.row.fullShortUrl"
                  >{{ scope.row.domain + '/' + scope.row.shortUri }}</el-link
                >
                <el-tooltip :content="scope.row.originUrl">
                  <span>{{ scope.row.originUrl }}</span>
                </el-tooltip>
              </div>
            </template>
          </el-table-column>
          <el-table-column prop="copy" width="170">
            <template #default="scope">
              <div style="display: flex; align-items: center">
                <!-- 二维码 -->
                <QRCode :url="'http://' + scope.row.fullShortUrl"></QRCode>
                <!-- 表格中的复制链接按钮 -->
                <el-tooltip
                  class="box-item"
                  effect="dark"
                  content="复制链接"
                  placement="bottom-end"
                >
                  <el-icon
                    @click="copyUrl('http://' + scope.row.fullShortUrl)"
                    class="table-edit copy-url"
                  >
                    <Share />
                  </el-icon>
                </el-tooltip>
              </div>
            </template>
          </el-table-column>
          <el-table-column label="访问次数" prop="times" width="120">
            <template #header>
              <el-dropdown>
                <div class="block" style="margin-top: 3px">
                  <span>访问次数</span>
                  <el-icon>
                    <CaretBottom />
                  </el-icon>
                </div>
                <template #dropdown>
                  <el-dropdown-item @click="pageParams.orderTag = 'todayPv'"
                    >今日访问次数</el-dropdown-item
                  >
                  <el-dropdown-item @click="pageParams.orderTag = 'totalPv'"
                    >累计访问次数</el-dropdown-item
                  >
                </template>
              </el-dropdown>
            </template>
            <template #default="scope">
              <div class="times-box">
                <div class="today-box">
                  <span>今日</span>
                  <span>{{ scope.row.todayPv }}</span>
                </div>
                <div class="total-box">
                  <span>累计</span>
                  <span>{{ scope.row.totalPv }}</span>
                </div>
              </div>
            </template>
          </el-table-column>
          <el-table-column label="访问人数" prop="people" width="120">
            <template #header>
              <el-dropdown>
                <div class="block" style="margin-top: 3px">
                  <span>访问人数</span>
                  <el-icon>
                    <CaretBottom />
                  </el-icon>
                </div>
                <template #dropdown>
                  <el-dropdown-item @click="pageParams.orderTag = 'todayUv'"
                    >今日访问人数</el-dropdown-item
                  >
                  <el-dropdown-item @click="pageParams.orderTag = 'totalUv'"
                    >累计访问人数</el-dropdown-item
                  >
                </template>
              </el-dropdown>
            </template>
            <template #default="scope">
              <div class="times-box">
                <div class="today-box">
                  <span>今日</span>
                  <span>{{ scope.row.todayUv }}</span>
                </div>
                <div class="total-box">
                  <span>累计</span>
                  <span>{{ scope.row.totalUv }}</span>
                </div>
              </div>
            </template>
          </el-table-column>
          <el-table-column label="IP数" prop="IP" width="120">
            <template #header>
              <el-dropdown>
                <div class="block" style="margin-top: 3px">
                  <span>IP数</span>
                  <el-icon>
                    <CaretBottom />
                  </el-icon>
                </div>
                <template #dropdown>
                  <el-dropdown-item @click="pageParams.orderTag = 'todayUip'"
                    >今日IP数</el-dropdown-item
                  >
                  <el-dropdown-item @click="pageParams.orderTag = 'totalUip'"
                    >累计IP数</el-dropdown-item
                  >
                </template>
              </el-dropdown>
            </template>
            <template #default="scope">
              <div class="times-box">
                <div class="today-box">
                  <span>今日</span>
                  <span>{{ scope.row.todayUip }}</span>
                </div>
                <div class="total-box">
                  <span>累计</span>
                  <span>{{ scope.row.totalUip }}</span>
                </div>
              </div>
            </template>
          </el-table-column>
          <el-table-column fixed="right" label="操作" width="180">
            <template #default="scope">
              <div style="display: flex; align-items: center">
                <!-- <el-link
                :underline="false"
                class="el-link"
                type="primary"
                @click="chartsVisible(row?.info)"
                >数据</el-link
              >
              <el-link :underline="false" class="el-link" type="primary">编辑</el-link> -->
                <!-- 表格中的数据按钮 -->
                <el-tooltip
                  class="box-item"
                  effect="dark"
                  content="查看图表"
                  placement="bottom-end"
                >
                  <el-icon class="table-edit" @click="chartsVisible(scope.row)">
                    <Histogram />
                  </el-icon>
                </el-tooltip>
                <!-- 正常页面展示编辑和删除 -->
                <template v-if="selectedIndex !== -1">
                  <!-- 表格中的编辑按钮 -->
                  <el-tooltip class="box-item" effect="dark" content="编辑" placement="bottom-end">
                    <el-icon @click="editLink(scope.row)" class="table-edit">
                      <Tools />
                    </el-icon>
                  </el-tooltip>
                  <!-- 删除按钮 -->
                  <el-tooltip class="box-item" effect="dark" content="删除" placement="bottom-end">
                    <el-popconfirm
                      width="100"
                      title="是否移入回收站"
                      @confirm="toRecycleBin(scope.row)"
                    >
                      <template #reference>
                        <el-icon class="table-edit">
                          <Delete />
                        </el-icon>
                      </template>
                    </el-popconfirm>
                  </el-tooltip>
                </template>
                <!-- 回收站操作 -->
                <template v-else>
                  <!-- 回收站中的恢复按钮 -->
                  <el-tooltip class="box-item" effect="dark" content="恢复" placement="bottom-end">
                    <el-icon @click="recoverLink(scope.row)" class="table-edit">
                      <HelpFilled />
                    </el-icon>
                  </el-tooltip>
                  <!-- 回收站中的删除按钮 -->
                  <el-tooltip class="box-item" effect="dark" content="删除" placement="bottom-end">
                    <el-popconfirm
                      width="300"
                      title="删除后短链跳转会失效，同时停止数据统计，这是一个不可逆的操作，是否删除?"
                      @confirm="removeLink(scope.row)"
                    >
                      <template #reference>
                        <el-icon class="table-edit">
                          <Delete />
                        </el-icon>
                      </template>
                    </el-popconfirm>
                  </el-tooltip>
                </template>
              </div>
            </template>
          </el-table-column>
        </el-table>
        <!-- 分页器 -->
        <div class="pagination-block">
          <el-pagination
            v-model:current-page="pageParams.current"
            v-model:page-size="pageParams.size"
            :page-sizes="[10, 15, 20, 30]"
            layout="total, sizes, prev, pager, next, jumper"
            :total="totalNums"
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
          />
        </div>
      </div>
    </div>
    <!-- 查看数据弹框 -->
    <ChartsInfo
      style="width: 880px"
      ref="chartsInfoRef"
      :title="chartsInfoTitle"
      :info="chartsInfo"
      :tableInfo="tableInfo"
      :isGroup="isGroup"
      :nums="nums"
      :favicon="favicon1"
      :originUrl="originUrl1"
      @changeTime="changeTime"
      @changePage="changePage"
      top="60px"
    ></ChartsInfo>
    <!-- 新建分组弹框 -->
    <el-dialog v-model="isAddGroup" title="新建短链接分组" style="width: 40%">
      <el-form :model="form">
        <el-form-item label="分组名称：" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="newGroupName" />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="isAddGroup = false">取消</el-button>
          <el-button type="primary" @click="addGroup" :disabled="addGroupLoading"> 确认 </el-button>
        </span>
      </template>
    </el-dialog>
    <!-- 编辑分组弹框 -->
    <el-dialog v-model="isEditGroup" title="编辑短链接分组" style="width: 40%">
      <el-form :model="form">
        <el-form-item label="分组名称：" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="editGroupName" />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="isEditGroup = false">取消</el-button>
          <el-button type="primary" @click="editGroup" :disabled="editGroupLoading">
            确认
          </el-button>
        </span>
      </template>
    </el-dialog>
    <!-- 创建短链弹框 -->
    <el-dialog @close="afterAddLink" v-model="isAddSmallLink" title="创建链接">
      <el-tabs class="demo-tabs">
        <el-tab-pane>
          <template #label>
            <span class="custom-tabs-label">
              <el-icon>
                <Link />
              </el-icon>
              <span>普通跳转</span>
            </span>
          </template>
          <CreateLink
            ref="createLink1Ref"
            :groupInfo="editableTabs"
            @onSubmit="addLink"
            @cancel="cancelAddLink"
            :is-single="true"
          ></CreateLink>
        </el-tab-pane>
        <el-tab-pane>
          <template #label>
            <span class="custom-tabs-label">
              <el-icon>
                <Connection />
              </el-icon>
              <span>随机跳转</span>
            </span> </template
          >暂未开发</el-tab-pane
        >
      </el-tabs>
    </el-dialog>
    <!-- 修改短链信息弹框 -->
    <el-dialog @close="afterAddLink" v-model="isEditLink" title="编辑链接">
      <EditLink
        ref="editLinkRef"
        :editData="editData"
        :groupInfo="editableTabs"
        @onSubmit="coverEditLink"
        @cancel="coverEditLink"
      ></EditLink>
    </el-dialog>
    <!-- 批量创建短链弹框 -->
    <el-dialog @close="afterAddLink" v-model="isAddSmallLinks" title="批量链接">
      <CreateLink
        ref="createLink2Ref"
        :groupInfo="editableTabs"
        @onSubmit="addLink"
        @cancel="cancelAddLink"
        :is-single="false"
      ></CreateLink>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, reactive, onMounted, getCurrentInstance, watch, nextTick } from 'vue'
import Sortable from 'sortablejs'
import { cloneDeep } from 'lodash'
import ChartsInfo from './components/chartsInfo/ChartsInfo.vue'
import CreateLink from './components/createLink/CreateLink.vue'
import { getTodayFormatDate, getLastWeekFormatDate } from '@/utils/plugins.js'
import EditLink from './components/editLink/EditLink.vue'
import { ElMessage } from 'element-plus'
import defaultImg from '@/assets/png/短链默认图标.png'
import QRCode from './components/qrCode/QRCode.vue'

// 查看图表的时候传过去展示的，没什么用
const nums = ref(0)
const favicon1 = ref()
const originUrl1 = ref()

const { proxy } = getCurrentInstance()
const API = proxy.$API
const chartsInfoRef = ref()
const chartsInfoTitle = ref()
const chartsInfo = ref()
const tableInfo = ref()
const createLink1Ref = ref()
const createLink2Ref = ref()
let selectedIndex = ref(0)
const editableTabs = ref([])
// 添加弹窗关闭后重新请求一下页面数据
const afterAddLink = () => {
  setTimeout(() => {
    getGroupInfo(queryPage) // 重新请求数据
  }, 0)
  if (createLink1Ref.value) {
    createLink1Ref.value.initFormData()
  }
  if (createLink2Ref.value) {
    createLink2Ref.value.initFormData()
  }
  if (editLinkRef.value) {
    editLinkRef.value.initFormData()
  }
}
const statsFormData = reactive({
  endDate: getTodayFormatDate(),
  startDate: getLastWeekFormatDate(),
  size: 10,
  current: 1
})
const initStatsFormData = () => {
  statsFormData.endDate = getTodayFormatDate()
  statsFormData.startDate = getLastWeekFormatDate()
}
const visitLink = {
  fullShortUrl: '',
  gid: ''
}
// 打开的图表是分组（true为分组）的还是单链的
const isGroup = ref(false)
const tableFullShortUrl = ref()
const tableGid = ref()
// 点击查看数据图表
const chartsVisible = async (rowInfo, dateList) => {
  chartsInfoTitle.value = rowInfo?.describe
  // 如果传入的group为true的话就查询分组的数据，如果没传就查询单链的数据
  const { fullShortUrl, gid, group, originUrl, favicon } = rowInfo
  originUrl1.value = originUrl
  favicon1.value = favicon
  isGroup.value = group
  tableFullShortUrl.value = fullShortUrl
  tableGid.value = gid
  // 后续修改时间的时候拿去用
  visitLink.fullShortUrl = fullShortUrl
  visitLink.gid = gid
  chartsInfoRef?.value.isVisible()
  // 如果没有时间传值，就默认查找过去一周的数据
  if (!dateList) {
    initStatsFormData()
  } else {
    // 否则就按照传过来的数据去请求数据
    statsFormData.startDate = dateList?.[0] + ' 00:00:00'
    statsFormData.endDate = dateList?.[1] + ' 23:59:59'
  }
  let res = null
  let tableRes = null
  if (group) {
    res = await API.group.queryGroupStats({ ...statsFormData, fullShortUrl, gid })
    tableRes = await API.group.queryGroupTable({ gid, ...statsFormData })
  } else {
    res = await API.smallLinkPage.queryLinkStats({ ...statsFormData, fullShortUrl, gid })
    tableRes = await API.smallLinkPage.queryLinkTable({ gid, fullShortUrl, ...statsFormData })
  }
  tableInfo.value = tableRes
  chartsInfo.value = res?.data?.data
  console.log(res?.data?.data)
  // debugger
}
// 图表修改时间后重新请求数
const changeTimeData = async (rowInfo, dateList) => {
  const { fullShortUrl, gid } = rowInfo
  visitLink.fullShortUrl = fullShortUrl
  visitLink.gid = gid
  if (!dateList) {
    initStatsFormData()
  } else {
    // 否则就按照传过来的数据去请求数据
    statsFormData.startDate = dateList?.[0] + ' 00:00:00'
    statsFormData.endDate = dateList?.[1] + ' 23:59:59'
  }
  let res = null
  let tableRes = null
  // 判断是分组还是单个短链接
  if (isGroup.value) {
    res = await API.group.queryGroupStats({ ...statsFormData, fullShortUrl, gid })
    tableRes = await API.group.queryGroupTable({ gid, ...statsFormData })
  } else {
    res = await API.smallLinkPage.queryLinkStats({ ...statsFormData, fullShortUrl, gid })
    tableRes = await API.smallLinkPage.queryLinkTable({ gid, fullShortUrl, ...statsFormData })
  }
  tableInfo.value = tableRes
  chartsInfo.value = res?.data?.data
  console.log(res?.data?.data)
}
// 修改时间
const changeTime = (dateList) => {
  console.log('修改了时间')
  changeTimeData(visitLink, dateList)
}
// 修改页码信息
const changePage = async (page) => {
  const { current, size } = page
  statsFormData.current = current ?? 1
  statsFormData.size = size ?? 10
  let tableRes = null
  // 判断是分组还是单个短链接
  if (isGroup.value) {
    tableRes = await API.group.queryGroupTable({ gid: tableGid.value, ...statsFormData })
  } else {
    tableRes = await API.smallLinkPage.queryLinkTable({
      gid: tableGid.value,
      fullShortUrl: tableFullShortUrl.value,
      ...statsFormData
    })
  }
  tableInfo.value = tableRes
}
// 将原来的数据转化为拖拽后传给后端的数据格式
const transformGroupData = (oldIndex, newIndex) => {
  // 相当于直接对展示数据进行修改
  const formData = editableTabs.value
  const tempData = formData.splice(oldIndex, 1)
  // console.log('调整的值', tempData)
  formData.splice(newIndex, 0, tempData[0])
  // console.log('这是经过转化的1', formData)
  formData.forEach((item, index) => {
    item.sortOrder = index
  })
  // console.log('这是经过转化的2', formData)
  return formData
}
// 拖拽
const initSortable = (className) => {
  const table = document.querySelector('.' + className)
  // console.log(table)
  // 创建拖拽实例
  Sortable.create(table, {
    animation: 150, //动画
    // 开始拖动事件
    onStart: () => {
      // console.log('开始拖动')
    },
    // 结束拖动事件
    onEnd: async ({ to, from, oldIndex, newIndex, clone, pullMode }) => {
      // 当oldIndex不等于newIndex时才会去请求接口
      if (newIndex !== oldIndex) {
        // 对于不同情况下数据变化后的选中数据的实现
        if (selectedIndex.value === oldIndex) {
          selectedIndex.value = newIndex
        } else if (
          oldIndex < newIndex &&
          selectedIndex.value > oldIndex &&
          selectedIndex.value <= newIndex
        ) {
          selectedIndex.value = selectedIndex.value - 1
        } else if (
          oldIndex > newIndex &&
          selectedIndex.value < oldIndex &&
          selectedIndex.value >= newIndex
        ) {
          selectedIndex.value = selectedIndex.value + 1
        }
        const res = await API.group.sortGroup(transformGroupData(oldIndex, newIndex))
        // console.log('排序后的结果', res)
      }
    }
  })
}
// 改变选中分组时触发
watch(
  () => selectedIndex.value,
  (newValue) => {
    // -1为回收站，不需要重新请求正常页面数据
    if (newValue !== -1 && newValue !== -2) {
      queryPage()
    }
  }
)
onMounted(() => {
  initSortable('sortOptions')
})
const tableData = ref([])
const pageParams = reactive({
  gid: null,
  current: 1,
  size: 15,
  orderTag: null
})
watch(
  () => pageParams.orderTag,
  (nV) => {
    console.log(nV)
    queryPage()
  }
)
const totalNums = ref(0)
const queryPage = async () => {
  pageParams.gid = editableTabs.value?.[selectedIndex.value]?.gid
  nums.value = editableTabs.value?.[selectedIndex.value]?.shortLinkCount || 0
  console.log('------', editableTabs.value, selectedIndex.value)
  const res = await API.smallLinkPage.queryPage(pageParams)
  tableData.value = res.data?.data?.records
  totalNums.value = +res.data?.data?.total
  // console.log('获取到的页面数据', res)
}

const handleSizeChange = () => {
  !isRecycleBin.value ? queryPage() : queryRecycleBinPage()
}

const handleCurrentChange = () => {
  !isRecycleBin.value ? queryPage() : queryRecycleBinPage()
}

// 获取分组信息
const getGroupInfo = async (fn) => {
  const res = await API.group.queryGroup()
  editableTabs.value = res.data?.data?.reverse()
  fn && fn()
}
getGroupInfo(queryPage)

// 是否展示回收站相关的组件
const isRecycleBin = ref(false)
const recycleBinNums = ref(0) // 回收站中的数量
// 获取回收站页面，gid到时候要删除
const queryRecycleBinPage = () => {
  API.smallLinkPage
    .queryRecycleBin({ current: pageParams.current, size: pageParams.size })
    .then((res) => {
      tableData.value = res.data?.data?.records
      totalNums.value = +res.data?.data?.total
      recycleBinNums.value = totalNums.value
    })
}
// 点击回收站
const recycleBin = () => {
  isRecycleBin.value = true
  selectedIndex.value = -1 // -1作为回收站，-2作为选中其他
  pageParams.current = 1
  pageParams.size = 15
  // 点击回收站相关的请求
  queryRecycleBinPage()
}
// 点击分组中的选项
const changeSelectIndex = (index) => {
  selectedIndex.value = index
  isRecycleBin.value = false
  // 对应分组的数据请求
}
// 添加分组相关
const isAddGroup = ref(false)
const newGroupName = ref()
const addGroupLoading = ref(false)
// 展示添加分组弹框
const showAddGroup = () => {
  newGroupName.value = ''
  isAddGroup.value = true
}
// 添加分组
const addGroup = async () => {
  addGroupLoading.value = true
  const res1 = await API.group.addGroup({ name: newGroupName.value })
  if (res1?.data.success) {
    ElMessage.success('添加成功')
    getGroupInfo(queryPage)
  } else {
    ElMessage.error('添加失败')
  }
  isAddGroup.value = false
  addGroupLoading.value = false
}
// 删除分组
const deleteGroup = async (gid) => {
  const res = await API.group.deleteGroup({ gid })
  selectedIndex.value = 0
  if (res.data.success) {
    ElMessage.success('删除成功')
    getGroupInfo(queryPage)
  } else {
    ElMessage.error('删除失败')
  }
}
// 编辑分组
const isEditGroup = ref(false)
const editGroupName = ref()
const editGid = ref('')
const editGroupLoading = ref(false)
// 点击编辑按钮，出现编辑弹框
const showEditGroup = (gid, name) => {
  editGid.value = gid
  editGroupName.value = name
  isEditGroup.value = true
}
// 编辑分组标题
const editGroup = async () => {
  editGroupLoading.value = true
  const res = await API.group.editGroup({ gid: editGid.value, name: editGroupName.value })
  if (res.data.success) {
    ElMessage.success('编辑成功')
    getGroupInfo(queryPage)
  } else {
    ElMessage.error('编辑失败')
  }
  isEditGroup.value = false
  editGroupLoading.value = false
}
// 创建短链
const isAddSmallLink = ref(false)
const isAddSmallLinks = ref(false)
// 关闭新建短链接弹窗
const addLink = () => {
  isAddSmallLink.value = false
  isAddSmallLinks.value = false
}
// 新建批量新建短链接弹窗
const cancelAddLink = () => {
  isAddSmallLink.value = false
  isAddSmallLinks.value = false
}
const getImgUrl = (url) => {
  return url ?? defaultImg
}
// 判断链接是否过期
const isExpire = (validDate) => {
  if (validDate) {
    const date = new Date(validDate).getTime()
    return new Date().getTime() < date
  }
}
// 复制链接
const copyUrl = (url) => {
  let eInput = document.createElement('input')
  eInput.value = url
  document.body.appendChild(eInput)
  eInput.select()
  let copyText = document.execCommand('Copy')
  eInput.style.display = 'none'
  if (copyText) {
    // console.log(eInput.value)
    ElMessage.success('链接复制成功!')
  }
}
// 修改短链信息
const isEditLink = ref(false) // 是否展示编辑弹框
const editLinkRef = ref()
const editData = ref() // 编辑弹框的数据
const editLink = (data) => {
  // console.log('data: ---' + data)
  editData.value = data
  isEditLink.value = true
}
// 隐藏弹框
const coverEditLink = () => {
  isEditLink.value = false
}
// 移动到回收站
const toRecycleBin = (data) => {
  const { gid, fullShortUrl } = data
  API.smallLinkPage
    .toRecycleBin({ gid, fullShortUrl })
    .then((res) => {
      ElMessage.success('删除成功')
      getGroupInfo(queryPage)
    })
    .catch((reason) => {
      ElMessage.error('删除失败')
    })
}
// 回收站中恢复
const recoverLink = (data) => {
  const { gid, fullShortUrl } = data
  API.smallLinkPage
    .recoverLink({ gid, fullShortUrl })
    .then((res) => {
      ElMessage.success('恢复成功')
      queryRecycleBinPage()
      getGroupInfo(queryPage)
    })
    .catch((reason) => {
      ElMessage.error('恢复失败')
    })
}
// 从回收站中删除
const removeLink = (data) => {
  const { gid, fullShortUrl } = data
  API.smallLinkPage
    .removeLink({ gid, fullShortUrl })
    .then((res) => {
      ElMessage.success('删除成功')
      queryRecycleBinPage()
    })
    .catch((reason) => {
      ElMessage.error('删除失败')
    })
}
</script>

<style lang="scss" scoped>
.flex-box {
  display: flex;
  align-items: center;
  padding: 0 10px;
  justify-content: space-between;
}

.hover-box:hover {
  cursor: pointer;
  color: rgba(40, 145, 206, 0.6);
  background-color: #f7f7f7;
  box-shadow: 0px 2px 8px 0px rgba(28, 41, 90, 0.1);
}

.option-title {
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 56px;
  font-size: 15px;
  font-weight: 600;
  border-bottom: 1px solid rgba(0, 0, 0, 0.1);

  span {
    font-size: 12px;
    font-weight: 400;
  }
}

.options-box {
  position: relative;
  height: 100%;
  width: 190px;
  border-right: 1px solid rgba(0, 0, 0, 0.1);

  .item-box {
    height: 43px;
    width: 190px;
    font-family:
      PingFangSC-Semibold,
      PingFang SC;
    font-weight: 520;
  }

  .item-box:hover {
    .flex-box {
      .edit {
        display: block;
      }

      .item-length {
        display: none !important;
      }
    }
  }
}

.recycle-bin {
  position: absolute;
  display: flex;
  bottom: 0;
  height: 50px;
  width: 100%;
}

.recycle-box {
  flex: 1;
  border-top: 1px solid rgba(0, 0, 0, 0.1);
  display: flex;
  align-items: center;
  justify-content: center;
}

.edit {
  display: none;
  margin-left: 5px;
  color: rgb(83, 97, 97);
  font-size: 20px;
}

.edit:hover {
  color: #2991ce;
  cursor: pointer;
}

.zero {
  color: rgb(83, 97, 97) !important;
}

// 提示框样式
.tooltip-base-box {
  width: 600px;
}

.tooltip-base-box .row {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.tooltip-base-box .center {
  justify-content: center;
}

.tooltip-base-box .box-item {
  width: 110px;
}

.selectedItem {
  color: #3464e0 !important;
  background-color: #ebeffa !important;
  font-weight: 600 !important;
}

.block:hover {
  color: rgb(121, 187, 255);
  .el-icon {
    color: rgb(121, 187, 255) !important;
  }
}

.table-edit {
  font-size: 20px;
  margin-right: 20px;
  color: #3677c2;
  cursor: pointer;
}

.table-edit:hover {
  color: #98cafe;
}

.qr-code {
  margin-right: 20px;
  cursor: pointer;
}

.qr-code:hover {
  opacity: 0.5;
}

.content-box {
  flex: 1;
  padding: 16px;
  background-color: #eef0f5;
  position: relative;

  .table-box {
    background-color: #ffffff;
    height: 100%;

    .buttons-box {
      display: flex;
      align-items: center;
      justify-content: space-between;
      padding: 16px;
    }

    .pagination-block {
      position: absolute;
      bottom: 4%;
      left: 50%;
      transform: translate(-50%, 0);
    }

    .recycle-bin-box {
      height: 64px;
      display: flex;
      align-items: center;
      padding-left: 16px;

      span:nth-child(1) {
        font-size: 20px;
        margin-right: 5px;
      }
    }
  }
}

.over-text {
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box; //作为弹性伸缩盒子模型显示。
  -webkit-box-orient: vertical; //设置伸缩盒子的子元素排列方式--从上到下垂直排列
  -webkit-line-clamp: 1; //显示的行
}

.table-link-box {
  display: flex;
  align-items: center;

  .name-date {
    display: flex;
    flex-direction: column;
    margin-left: 10px;

    span:nth-child(1) {
      font-size: 15px;
      font-weight: 500;
      overflow: hidden;
      text-overflow: ellipsis;
      display: -webkit-box; //作为弹性伸缩盒子模型显示。
      -webkit-box-orient: vertical; //设置伸缩盒子的子元素排列方式--从上到下垂直排列
      -webkit-line-clamp: 1; //显示的行
    }

    .time {
      display: flex;
      align-items: center;

      span {
        font-size: 12px;
      }

      img {
        margin-left: 10px;
      }

      div {
        border: 1.5px solid rgb(253, 81, 85);
        border-radius: 8px;
        line-height: 20px;
        font-size: 12px;
        transform: scale(0.7);
        color: rgb(253, 81, 85);
        padding: 0 4px;
        background-color: rgba(250, 210, 211);

        span {
          font-weight: bolder;
        }
      }
    }
  }
}

.isExpire {
  .name-date {
    span:nth-child(1) {
      color: rgba(0, 0, 0, 0.3);
    }

    .time {
      div {
        span {
          font-weight: bolder;
          color: red;
        }
      }
    }
  }
}

.table-url-box {
  display: flex;
  flex-direction: column;
  align-items: flex-start;

  span {
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box; //作为弹性伸缩盒子模型显示。
    -webkit-box-orient: vertical; //设置伸缩盒子的子元素排列方式--从上到下垂直排列
    -webkit-line-clamp: 1; //显示的行
    color: rgba(0, 0, 0, 0.4);
  }
}

.times-box {
  display: flex;
  flex-direction: column;

  .today-box {
    span {
      font-size: 13px;
      font-weight: 600;
      margin-right: 10px;
    }

    span:nth-child(1) {
      font-weight: 400;
      color: rgba(0, 0, 0, 0.4);
    }
  }

  .total-box {
    span {
      font-size: 13px;
      font-weight: 400;
      margin-right: 10px;
    }

    span:nth-child(1) {
      font-weight: 400;
      color: rgba(0, 0, 0, 0.4);
    }
  }
}

.copy-url {
  margin-left: 10px;
}

.demo-tabs > .el-tabs__content {
  font-size: 32px;
  font-weight: 600;
}

.demo-tabs .custom-tabs-label .el-icon {
  vertical-align: middle;
}

.demo-tabs .custom-tabs-label span {
  vertical-align: middle;
  margin-left: 4px;
}
</style>
