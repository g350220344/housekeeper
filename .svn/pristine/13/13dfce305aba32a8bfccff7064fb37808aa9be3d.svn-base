<template>
    <div>
        <div class="home_block_1">
            <div class="search_box">
                <div @click="changeCity" class="chose_city">{{city.cityName || '未定位'}}
                    <img :src='iconArrowDown' alt="">
                </div>
                <div @click="goSearch" class="search_input">搜索小区/地址</div>
                <div class="msg_btn" :class="{'msg_btn_active': is_msg }" @click="goMsg">
                    <img :src='iconMsg' alt="">
                </div>
            </div>
            <div class="tool_box">
                <div class="chart_title">房价走势
                    <!-- <span style="font-size: 0.3rem">房价走势</span> -->
                    <span style="font-size: 0.24rem">（元/㎡）</span>
                </div>
                <div class="tabs">
                    <div v-if="city.cityName" @click="changeTab(0)" class="tab_item" :class="{'tab_item_active': tab == 0}">{{city.cityName}}市</div>
                    <div v-if="city.districtName" @click="changeTab(1)" class="tab_item" :class="{'tab_item_active': tab == 1}">{{city.districtName}}</div>
                </div>
            </div>
            <div v-if="market" @click="goTend" class="chart_box">
                <i-chart v-show="tab == 0" :val-arr="market.cityMarketList[1]" :date-arr="market.cityMarketList[0]"></i-chart>
                <i-chart v-if="tab == 1" :val-arr="market.districtMarketList[1]" :date-arr="market.districtMarketList[0]"></i-chart>                
            </div>
        </div>
        <div class="home_block_2">
            <i-card v-if="!!user_house && user_house.houseCount" tit="我的房产">
                <img @click="addHouse" slot="icon" :src="iconAdd" alt="">
                <div slot="ctn">
                    <div class="house_count">
                        共{{user_house.houseCount}}套房产, 分布在{{user_house.listCity.length}}个城市
                        <span style="margin-left: 0.1rem;" v-for="item in user_house.listCity" :key="item" class="city_tag">{{item}}</span>
                    </div>
                    <div @click.stop="goMyHouse">
                        <div class="house_value_lable">房产总估值 (万元)</div>
                        <div class="house_total_val">{{user_house.totalPrice}}</div>
                    </div>
                    
                    <div class="house_rate_info">
                        土豪，你的房产总值超过了全国<span class="house_rate_val">{{user_house.sortPercent}}%</span>的人
                    </div>
                    <div class="rease_info_box">
                        <div class="rease_info_item">
                            <div class="rease_info_item_val">
                                <img v-if="user_house.totalAppreciation >= 0" :src="iconRease" alt="">
                                <img v-else :src="iconDecrease" alt="">
                                {{(`${user_house.totalAppreciation}`).replace('-','')}}万元
                            </div>
                            <div class="rease_info_item_label">房产已升值</div>
                        </div>
                        <div class="rease_info_item">
                            <div class="rease_info_item_val">
                                <img v-if="user_house.appreciationPercent >= 0" :src="iconRease" alt="">
                                <img v-else :src="iconDecrease" alt="">
                                {{(`${user_house.appreciationPercent.toFixed(2)}`).replace('-','')}}%
                            </div>
                            <div class="rease_info_item_label">增长率</div>
                        </div>
                        <div class="rease_info_divider vux-1px-r"></div>
                    </div>
                </div>
            </i-card>
            <i-card v-else tit="我的房产">
                <div slot="ctn" class="no_house">
                    <img class="empty_gif" :src="emptyState" alt="">
                    <div class="no_house_label">看看我的房子为我赚了多少钱</div>
                    <div @click="addHouse" class="btn_add_house">
                        <img class="btn_add_house_icon" :src="iconAdd" alt="">
                        添加房产
                    </div>
                </div>
            </i-card>
            <i-card tit="工具包">
                <div slot="ctn">
                    <ul class="tool_ul">
                        <li class="tool_item">
                            <img :src="iconCounter" alt="">
                            <div class="tool_item_label">房贷计算</div>
                        </li>
                        <li class="tool_item">
                            <img :src="iconTax" alt="">
                            <div class="tool_item_label">税费计算</div>
                        </li>
                        <li class="tool_item">
                            <img :src="iconQualification" alt="">
                            <div class="tool_item_label">购房资格</div>
                        </li>
                        <li class="tool_item">
                            <img :src="iconLoan" alt="">
                            <div class="tool_item_label">房产税</div>
                        </li>
                    </ul>
                </div>
            </i-card>
        </div>
    </div>
</template>

<script>
import iconArrowDown from 'assets/img/homepage/icon-arrow-down.png'
import iconMsg from 'assets/img/homepage/icon-msg.png'
import iconAdd from 'assets/img/homepage/icon-add.png'
import iconRease from 'assets/img/homepage/icon-rease.png'
import iconDecrease from 'assets/img/homepage/icon-decrease.png'
import emptyState from 'assets/img/homepage/empty-state.png'
import iconCounter from 'assets/img/homepage/icon-counter.png'
import iconTax from 'assets/img/homepage/icon-tax.png'
import iconQualification from 'assets/img/homepage/icon-qualification.png'
import iconLoan from 'assets/img/homepage/icon-loan.png'

import 'assets/css/index/index.css';
import IChart from '../components/chart';
import ICard from '../components/card';
import { mapState } from "vuex";
import __CONFIG__ from 'assets/js/config.js'
import _ from 'lodash'

export default {
    name: 'home',
    components: {IChart, ICard},
    methods: {
        goMyHouse() {
            this.$router.push({path: '/myHouse'});
        },
        goMsg() {
            this.$router.push({path: '/msg'});
        },
        goTend() {
            this.$router.push({path: '/nearby'});
        },
        goSearch() {
            this.$router.push({path: '/search'});
        },
        changeTab(val) {
            this.tab = val;
        },
        changeCity() {
            this.$router.push({path: '/city', query: {type: 1}})
        },
        getMarket() {
            this.$http({
                url: 'WxCommon/getMarket',
                method: 'post',
                data: {
                    cityId: this.city.cityId,
                    districtId: this.city.districtId || ''
                },
                // data: {
                //     cityId: this.city.cityId,
                //     districtId: this.city.districtId
                // }
            }).then(res => {
                let data = res.data.data;
                this.market = data;
                console.log('getMarket', data)
                
            }).catch(err => {

            })
        },
        wxPay() {
            this.$http({
                url: 'wx/wxPay',
                method: 'post',
                data: {
                    openid: 'oe08c0yfQV_q9R7PcP6EBXwwCEBg'
                }
            }).then(res => {
                console.log('wxPay', res.data.data);
                let data = res.data.data;
                wx.chooseWXPay({
                    nonceStr: data.nonceStr, // 支付签名随机串，不长于 32 位
                    package: data.package, // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=\*\*\*）
                    signType: data.signType, // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
                    paySign: data.paySign, // 支付签名
                    timestamp: data.timeStamp, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
                    success: (res) => {
                        // 支付成功后的回调函数
                        console.log('pay success', res);
                    }
                });
            })
        },
        myHouse() {
            console.log('user', this.user);
            this.$http({
                url: 'WxHouse/getHouseAvmByUserId',
                method: 'post',
                data: {}
            }).then(res => {
                let data = res.data.data;
                this.user_house = _.cloneDeep(data);
            })
        },
        addHouse() {
            this.$router.push({path: '/addHouse'})
        },
        getMsg() {
            this.$http({
                url: 'WxMessage/getNoReadMessageListByUserId',
                method: 'post',
                data: {}
            }).then(res => {
                if(res.data.statusCode == 1) {
                    this.is_msg = res.data.dataCount > 0;
                }
            })
        }
    },
    data() {
        return {
            iconArrowDown: iconArrowDown,
            iconMsg: iconMsg,
            iconAdd: iconAdd,
            iconRease: iconRease,
            iconDecrease: iconDecrease,
            emptyState: emptyState,
            iconCounter: iconCounter,
            iconTax: iconTax,
            iconQualification: iconQualification,
            iconLoan: iconLoan,
            is_msg: false,
            tab: 0,
            market: null,
            user_house: {}
        }
    },
    computed: {
        ...mapState({
            city: state => state.glb.curCity,
            wxConfig: state => state.glb.wxConfig,
            user: state => state.glb.user
        })
    },
    created() {
        this.getMsg();
    },
    mounted() {
        this.getMarket();
        this.myHouse();
    }
}
</script>

