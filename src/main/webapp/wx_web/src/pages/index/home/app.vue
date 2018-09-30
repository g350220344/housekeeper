<template>
  <div id="app" style="height: 100%;">
    <view-box :bodyPaddingBottom="barHeight" ref="viewBox">
      <loading v-model="isLoading"></loading>
      <keep-alive include="add-house">
        <router-view>
            <!-- 所有路径匹配到的视图组件都会被缓存！ -->
        </router-view>
      </keep-alive>
      <tabbar ref="tabBar" v-if="showBar" slot="bottom" icon-class="bar-icon-class" @on-index-change="onBarChange">
        <tabbar-item :selected='tabIndex == 0' :link="{path: '/'}">
          <img slot="icon" :src="iconHomepage">
          <img slot="icon-active" :src="iconHouseActive">
          <span slot="label">首页</span>
        </tabbar-item>
        <tabbar-item :selected='tabIndex == 1' :link="{path: '/myHouse'}">
          <img slot="icon" :src="iconHouse">
          <img slot="icon-active" :src="iconHouseActive">
          <span slot="label">房产</span>
        </tabbar-item>
        <tabbar-item :selected='tabIndex == 2' :link="{path: '/report'}">
          <img slot="icon" :src="iconReport">
          <img slot="icon-active" :src="iconReportActive">          
          <span slot="label">报告</span>
        </tabbar-item>
        <tabbar-item :selected='tabIndex == 3' :link="{path: '/my'}">
          <img slot="icon" :src="iconMy">
          <img slot="icon-active" :src="iconMyActive">
          <span slot="label">我的</span>
        </tabbar-item>
      </tabbar>
    </view-box>
    <toast v-model="showToast">{{toastTip}}</toast>
    <toast v-model="showWarnToast" type="warn">出错了</toast> 
    <toast v-model="showWaitToast" type="text">敬请期待</toast> 
       
    <!--<router-view></router-view>-->
  </div>
</template>

<script>
import wx from "wx";
import { ViewBox, Tabbar, TabbarItem, Loading, Toast } from "vux";
import { mapState } from "vuex";
import iconHomepage from 'assets/img/homepage/icon-homepage.png'
import iconHomepageActive from 'assets/img/homepage/icon-homepage-active.png'
import iconHouse from 'assets/img/homepage/icon-house.png'
import iconHouseActive from 'assets/img/homepage/icon-house-active.png'
import iconReport from 'assets/img/homepage/icon-report.png'
import iconReportActive from 'assets/img/homepage/icon-report-active.png'
import iconMy from 'assets/img/homepage/icon-my.png'
import iconMyActive from 'assets/img/homepage/icon-my-active.png'

// import { functionDeclaration } from "babel-types";
import "assets/css/common.css";
export default {
  name: "app",
  components: { ViewBox, Tabbar, TabbarItem, Loading, Toast },
  data() {
    return {
      iconHomepage: iconHomepage,
      iconHomepageActive: iconHomepageActive,
      iconHouse: iconHouse,
      iconHouseActive: iconHouseActive,
      iconReport: iconReport,
      iconReportActive: iconReportActive,
      iconMy: iconMy,
      iconMyActive: iconMyActive,
      // showBar: false,
      tabBarPx: 0,
      toastTip: '操作成功',
      showToast: false,
      showWarnToast: false,
      showWaitToast: false,
    };
  },
  computed: {
    barHeight: function() {
      // return this.showBar ? '1.1rem' : '0.15rem';
      return this.showBar ? "1.1rem" : 0;
    },
    ...mapState({
      isToast: state => state.glb.isToast,
      isWarnToast: state => state.glb.isWarnToast,
      isWaitToast: state => state.glb.isWaitToast,

      city: state => state.glb.city,
      isLoading: state => state.glb.isLoading,
      tabIndex: state => state.glb.tabIndex,
      showBar: state => state.glb.showBar,
      user: state => state.glb.user
    })
  },
  methods: {
    onBarChange(val) {
      this.$store.commit("updateTabIndexStatus", { tabIndex: val });
    },
    sendCode() {
      let code = tools.getQueryString('code');
      let url = 'WxLogin/login';
      this.$http({
        url: url,
        method: "post",
        data: {
          code: code
        }
      }).then(res => {
        console.log('login:  ', res);
      }).catch(err => {
        console.log(err);
      })
    },
    locationTransform(loc) {
      this.$http({
        url: 'WxCommon/getLocationByWx',
        method: "post",
        data: {
          lat: loc.lat,
          lon: loc.lon
        }
      }).then(res => {
        let data = res.data.data;
        console.log('locationTransform', data);
        data.cityName = data.ciytName.replace('市', '');
        if(data) {
          this.$store.commit("updateCityStatus", data);
          this.$store.commit("updateCurCityStatus", data);
        }
      })
    },
    initWx() {
      let url = location.href.split("#")[0];
      this.$http({
        url: "wx/getWxConfig",
        method: "post",
        data: {
          url: url
        }
      }).then(res => {
        let data = res.data.data;
        this.$store.commit("updateWxConfig", data);
        wx.config({
          debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
          appId: data.appId, // 必填，公众号的唯一标识
          timestamp: data.timestamp, // 必填，生成签名的时间戳
          nonceStr: data.noncestr, // 必填，生成签名的随机串
          signature: data.signature, // 必填，签名
          jsApiList: [
            "checkJsApi",
            "startRecord",
            "stopRecord",
            "playVoice",
            "translateVoice",
            "uploadVoice",
            "getLocation",
            "chooseWXPay"
          ] // 必填，需要使用的JS接口列表
        });
        wx.ready(() => {
          wx.getLocation({
            type: "wgs84", // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
            success: (res) => {
              var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
              var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
              var speed = res.speed; // 速度，以米/每秒计
              var accuracy = res.accuracy; // 位置精度
              // console.log("纬度 latitude: ", latitude);
              // console.log("经度 longitude: ", longitude);
              this.locationTransform({
                lat: latitude,
                lon: longitude
              })
            }
          });
        });
      });
    }
  },
  watch: {
    isToast(val) {
      if(val) {
        this.showToast = true;
      }
    },
    isWarnToast(val) {
      if(val) {
        this.showWarnToast = true;
      }
    },
    isWaitToast(val) {
      if(val) {
        this.showWaitToast = true;
      }
    },
    showToast(val) {
      if(!val) {
        this.$store.commit('updateToastStatus')
      }
    },
    showWarnToast(val) {
      if(!val) {
        this.$store.commit('updateWarnToastStatus')
      }
    },
    showWaitToast(val) {
      if(!val) {
        this.$store.commit('updateWaitToastStatus')
      }
    },
    '$route'(to, from){
      this.$refs.viewBox.scrollTo('top');
      // this.$refs.viewBox.$el.scrollTop = 0;
    }
  },
  created() {
    // this.sendCode();
    // this.initWx();
  },
  mounted() {
    // this.tabBarPx = this.$refs.tabBar.$el.clientHeight;
    // document.getElementById('app').style.height = window.screen.height + 'px';
    
  }
};
</script>

<style lang="less">
@import "~vux/src/styles/reset.less";
@import "~vux/src/styles/1px.less";

body {
  background-color: #f2f2f2;
  font-family: PingFang-SC-Bold;
}
#app {
  height: 100%;
  width: 100%;
}

// .weui-tab__panel {
//   padding-bottom: 0!important;
// }
.weui-bar__item_on .weui-tabbar__label span {
  color: #555;
}
</style>
