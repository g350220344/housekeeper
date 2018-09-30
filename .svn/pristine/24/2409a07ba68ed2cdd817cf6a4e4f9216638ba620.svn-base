/**store */
import Vue from 'vue';
import Vuex from 'vuex'
import axios from 'axios'
import tools from 'assets/js/tools';

Vue.use(Vuex);
const store = new Vuex.Store({}) // 这里你可能已经有其他 module
store.registerModule('glb', { // 名字自己定义
    state: {
        isLoading: false,
        showBar: true,
        tabIndex: 0,
        isToast: false,
        isWarnToast: false,
        isWaitToast: false,
        city: {
            districtId: 230109, districtName: "松北区", cityId: 2301, cityName: "哈尔滨"
        },
        curCity: {
            districtId: 230109, districtName: "松北区", cityId: 2301, cityName: "哈尔滨"
        },
        formCity: {
            districtId: 230109, districtName: "松北区", cityId: 2301, cityName: "哈尔滨"
        },
        formCommunity: null, //添加房产表单，小区项
        user: null, //登录返回的user信息(包含wxOpenid等)
        userInfo: null, //根据userid获取的用户信息
        wxConfig: null,
        wxPayConfig: null
    },
    mutations: {
        updateToastStatus(state) {
            state.isToast = !state.isToast;
        },
        updateWarnToastStatus(state) {
            state.isWarnToast = !state.isWarnToast;
        },
        updateWaitToastStatus(state) {
            state.isWaitToast = !state.isWaitToast;
        },
        updateUserStatus(state, payload) {
            state.user = payload
        },
        updateUserInfoStatus(state, payload) {
            state.userInfo = payload
        },
        updateLoadingStatus(state, payload) {
            state.isLoading = payload.isLoading
        },
        updateShowBarStatus(state, payload) {
            state.showBar = payload.showBar
        },
        updateTabIndexStatus(state, payload) {
            state.tabIndex = payload.tabIndex
        },
        updateCityStatus(state, payload) {
            state.city = payload
        },
        updateCurCityStatus(state, payload) {
            state.curCity = payload
        },
        updateFormCityStatus(state, payload) {
            state.formCity = payload
        },
        updateFormCommunityStatus(state, payload) {
            state.formCommunity = payload
        },
        updateWxConfig(state, payload) {
            state.wxConfig = payload
        },
        updateWxPayConfig(state, payload) {
            state.wxPayConfig = payload
        }
    },
    actions: {
        updateUserStatus({ commit }) {
            let code = tools.getQueryString('code');
            let url = 'WxLogin/login';
            return new Promise((resolve, reject) => {
                axios({
                    url: url,
                    method: "post",
                    data: {
                        code: code
                    }
                }).then(res => {
                    console.log('login:  ', res);
                    let data = res.data.data;
                    commit('updateUserStatus', data);
                    resolve()
                }).catch(err => {
                    console.log(err);
                    reject(err)
                })
            })

        },
        updateWxConfig({ commit }) {
            let url = location.href.split("#")[0];
            return new Promise((resolve, reject) => {
                axios({
                    url: "wx/getWxConfig",
                    method: "post",
                    data: {
                        url: url
                    }
                }).then(res => {
                    let data = res.data.data;
                    commit("updateWxConfig", data);
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
                                axios({
                                    url: 'WxCommon/getLocationByWx',
                                    method: "post",
                                    data: {
                                      lat: res.latitude,// 纬度，浮点数，范围为90 ~ -90
                                      lon: res.longitude// 经度，浮点数，范围为180 ~ -180
                                    }
                                  }).then(res => {
                                    let data = res.data.data;
                                    console.log('locationTransform', data);
                                    data.cityName = data.ciytName.replace('市', '');
                                    if(data) {
                                      commit("updateCityStatus", data);
                                      commit("updateCurCityStatus", data);
                                      commit("updateFormCityStatus", data);
                                    }
                                    resolve();
                                  })
                            }
                        });
                    });
                    resolve();
                }).catch(err => {
                    reject();
                })
            })
        }
    }
})

export default store