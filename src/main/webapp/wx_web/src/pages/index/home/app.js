import Vue from 'vue'
import VueRouter from 'vue-router'
import axios from 'axios'
import App from './app.vue'
import store from './store/index'
//routers
const Home = () => import('./views/index.vue').then(m => m.default)
const Nearby = () => import('./views/nearby.vue').then(m => m.default)
const Msg = () => import('./views/msg.vue').then(m => m.default)
const MyHouse = () => import('./views/my_house.vue').then(m => m.default)
const House = () => import('./views/house.vue').then(m => m.default)
const Search = () => import('./views/search.vue').then(m => m.default)
const AddHouse = () => import('./views/add_house.vue').then(m => m.default)
const AddLoan = () => import('./views/add_loan.vue').then(m => m.default)
const AddLease = () => import('./views/add_lease.vue').then(m => m.default)
const LoanComputer = () => import('./views/loan_computer.vue').then(m => m.default)
const TaxComputer = () => import('./views/tax_computer.vue').then(m => m.default)
const LoanComputeRes = () => import('./views/loan_compute_res.vue').then(m => m.default)
const TaxComputeRes = () => import('./views/tax_compute_res.vue').then(m => m.default)
const My = () => import('./views/my.vue').then(m => m.default)
const Marks = () => import('./views/marks.vue').then(m => m.default)
const User = () => import('./views/user.vue').then(m => m.default)
const About = () => import('./views/about.vue').then(m => m.default)
const Service = () => import('./views/service.vue').then(m => m.default)
const Mobile = () => import('./views/mobile.vue').then(m => m.default)
const MsgSet = () => import('./views/msg_set.vue').then(m => m.default)
const Feedback = () => import('./views/feedback.vue').then(m => m.default)
const City = () => import('./views/city.vue').then(m => m.default)
const Community = () => import('./views/community.vue').then(m => m.default)
const ReportBrief = () => import('./views/report_brief.vue').then(m => m.default)
const ReportSell = () => import('./views/report_sell.vue').then(m => m.default)
const BuyList = () => import('./views/buy_list.vue').then(m => m.default)
const CompareChart = () => import('./views/compare_chart.vue').then(m => m.default)
const AudioSearch = () => import('./views/audio_search.vue').then(m => m.default)
const HavingsReport = () => import('./views/havings_report.vue').then(m => m.default)


Vue.use(VueRouter)
// Vue.use(Vuex);

axios.defaults.withCredentials = true;
axios.defaults.baseURL = 'http://10.200.8.20:8080/housekeeper/rest/',
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
axios.defaults.transformRequest = [function (data) {
  let ret = ''
  data = data || {};
  for (let it in data) {
      ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
  }
  return ret
}]

Vue.prototype.$http = axios

const router = new VueRouter({
  routes: [
    {
      path: '/', //首页
      component: Home
    },
    {
      path: '/nearby', //附近小区列表页面
      component: Nearby
    },
    {
      path: '/msg', //消息列表页面
      component: Msg
    },
    {
      path: '/MyHouse', //我的房产页面
      component: MyHouse
    },
    {
      path: '/house', //房产详情
      component: House
    },
    {
      path: '/search', //搜索页
      component: Search
    },
    {
      path: '/addHouse', //添加房产
      component: AddHouse
    },
    {
      path: '/addLoan', //添加贷款
      component: AddLoan
    },
    {
      path: '/addLease', //添加租约
      component: AddLease
    },
    {
      path: '/loanComputer', //贷款计算器
      component: LoanComputer
    },
    {
      path: '/taxComputer', //税费计算器
      component: TaxComputer
    },
    {
      path: '/loanComputeRes', //贷款计算结果
      component: LoanComputeRes
    },
    {
      path: '/taxComputeRes', //税费计算结果
      component: TaxComputeRes
    },
    {
      path: '/my', //我的
      component: My
    },
    {
      path: '/marks', //我的关注
      component: Marks
    },
    {
      path: '/user', //个人资料
      component: User
    },
    {
      path: '/about', //关于我们
      component: About
    },
    {
      path: '/service', //客户服务
      component: Service
    },
    {
      path: '/mobile', //设置手机号
      component: Mobile
    },
    {
      path: '/msgSet', //推送设置
      component: MsgSet
    },
    {
      path: '/feedback', //意见反馈
      component: Feedback
    },
    {
      path: '/city', //搜索城市
      component: City
    },
    {
      path: '/community', //小区基本信息
      component: Community
    },
    {
      path: '/reportBrief', //简要报告
      component: ReportBrief
    },
    {
      path: '/reportSell', //出售报告
      component: ReportSell
    },
    {
      path: '/buyList', //订阅列表
      component: BuyList
    },
    {
      path: '/compareChart', //均价对比
      component: CompareChart
    },
    {
      path: '/audioSearch', //语音搜索
      component: AudioSearch
    },
    {
      path: '/havingsReport', //持产报告
      component: HavingsReport
    }
  ]
})
console.log(store);
router.beforeEach((to, from, next) => {
  store.commit('updateLoadingStatus', {isLoading: true})
  if(!store.state.glb.user) {
    store.dispatch('updateUserStatus').then(() => {
      Vue.prototype.$http.defaults.transformRequest = [function (data) {
        let ret = ''
        data = data || {};
        // data['userId'] = store.state.glb.user.userId;
        data['userId'] = 123456;
        for (let it in data) {
            ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
        }
        return ret
      }]
      return new Promise((resolve, reject) => {
        if(!store.state.glb.wxConfig) {
          store.dispatch('updateWxConfig').then(() => {
            resolve()
          }).catch(err => {
            reject()
          })
        }else {
          resolve();
        }
      })
    }).then(() => {
      next();
    })
  }else {
    next()
  }
})

router.afterEach(function (to) {
  console.log(to.path);
  let delayPathMap = ['/house', '/marks', '/community', '/reportBrief', '/reportSell', '/buyList'];
  let map = ['/', '/myHouse', '/report', '/my'];
  let index = map.indexOf(to.path);
  if(index > -1) {
    store.commit('updateShowBarStatus', {showBar: true})
    store.commit('updateTabIndexStatus', {tabIndex: index})
  }else {
    store.commit('updateShowBarStatus', {showBar: false})
  }
  setTimeout(() => {
    if(delayPathMap.indexOf(to.path) == -1) {
      store.commit('updateLoadingStatus', {isLoading: false})
    }
  }, 500);
})
// FastClick.attach(document.body)

function htRem() {
  var ww = document.documentElement.clientWidth;
  if (ww > 750) {
      ww = 750;
  }
  document.documentElement.style.fontSize = ww / 7.5 + "px";
}
htRem();
window.onresize = function() {
  htRem();
};

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app-box')

// new Vue({
//   el: '#app',
//   render: h => h(App)
// })
