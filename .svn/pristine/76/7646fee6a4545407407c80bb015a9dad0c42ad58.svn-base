<template>
    <div v-if="community" class="report_sell_page">
        <div class="rsp_block_1">
            <div class="rsp_block_1_row_1">
                {{community.communityName}}
                <img :src="iconArrowWhiteRight" alt="">
            </div>
            <div class="rsp_block_1_row_2">{{info.detailaddress}}</div>
            <div class="rsp_block_1_row_3">
                <div class="rsp_block_1_row_3_divider" style="left: 3.1rem;"></div>
                <div class="rsp_block_1_row_3_divider" style="right: 1.7rem;"></div>
                <div class="rsp_block_1_row_3_item" style="text-align: left; width: 3rem;">
                    <div class="rsp_block_1_row_3_item_val" style="font-size: 0.52rem;">
                        {{community.similarHousesSalesqmprice}}<span style="font-size: 0.26rem;">元/平米</span>
                    </div>
                    <div class="rsp_block_1_row_3_item_label">出售均价</div>
                </div>
                <div class="rsp_block_1_row_3_item" style="width: 2.04rem;">
                    <div class="rsp_block_1_row_3_item_val">
                        <img v-if="community.saleSqmPriceLinkRelativeRatio >= 0" :src="iconWhiteUp" alt="">
                        <img v-else :src="iconWhiteDown" alt="">
                        {{(community.saleSqmPriceLinkRelativeRatio + '').replace('-', '')}}%
                    </div>
                    <div class="rsp_block_1_row_3_item_label">
                        均价环比
                    </div>
                </div>
                <div class="rsp_block_1_row_3_item" style="width: 1.49rem; text-align: right">
                    <div class="rsp_block_1_row_3_item_val">
                        <img v-if="community.saleSqmPriceOnYear_on_YearBasis >= 0" :src="iconWhiteUp" alt="">
                        <img v-else :src="iconWhiteDown" alt="">
                        {{(community.saleSqmPriceOnYear_on_YearBasis + '').replace('-', '')}}%
                    </div>
                    <div class="rsp_block_1_row_3_item_label">均价同比</div>
                </div>
            </div>
        </div>
        <div v-if="dealData" class="rsp_block_2">
            <div class="rsp_block_2_item">
                <div class="rsp_block_2_item_label">成交数量</div>
                <div class="rsp_block_2_item_val">{{dealData.saleCount}}套</div>
            </div>
            <div class="rsp_block_2_item">
                <div class="rsp_block_2_item_label">成交量环比</div>
                <div class="rsp_block_2_item_val">
                    <img v-if="dealData.ringRatio >= 0" :src="iconRease" alt="">
                    <img v-else :src="iconDecrease" alt="">
                    {{(dealData.ringRatio + '').replace('-', '')}}%
                </div>
            </div>
            <div class="rsp_block_2_item">
                <div class="rsp_block_2_item_label">在售房源</div>
                <div class="rsp_block_2_item_val">{{dealData.onSaleHouseCount}}套</div>
            </div>
        </div>
        <div class="rsp_block_3">
            <i-progress-m :label="`均价超过${community.cityName}`" :val="community.cityScale"></i-progress-m>
            <i-progress-m style="margin-top: 0.3rem;" :label="`月增长超过${community.cityName}`" :val="community.differenceScale"></i-progress-m>
        </div>
        <div v-if="!!series && series.length > 0" class="rsp_block_4 rsp_block">
            <div class="rsp_block_title vux-1px-b">均价走势</div>
            <m-chart unit="元/㎡" :date="date" :series="series"></m-chart>
        </div>
        <div class="rsp_block_4 rsp_block">
            <div class="rsp_block_title vux-1px-b">成交房源案例</div>
            <div class="rsp_tab">
                <div @click="changeDealTab(0)" class="rsp_tab_item" :class="{'rsp_tab_item_active': tabIndexDeal === 0}">{{community.communityName}}</div>
                <div @click="changeDealTab(1)" class="rsp_tab_item" :class="{'rsp_tab_item_active': tabIndexDeal === 1}">附近小区</div>
            </div>
            <div class="rsp_block_5_ctn">
                <template v-if="tabIndexDeal == 0">
                    <div v-for="(item, i) in dealList" :key="i" :class="{'vux-1px-b': i != dealList.length - 1}">
                        <cmt-pannel :item="item"></cmt-pannel>
                    </div>
                </template>
                <template v-else>
                    <div v-for="(item, i) in dealNearbyList" :key="i" :class="{'vux-1px-b': i != dealNearbyList.length - 1}">
                        <cmt-pannel :item="item"></cmt-pannel>
                    </div>
                </template>
            </div>
        </div>
        <div class="rsp_block_4 rsp_block">
            <div class="rsp_block_title vux-1px-b">出售房源参考</div>
            <div class="rsp_block_6_ctn">
                <div class="rsp_tab">
                    <div @click="changeSaleTab(0)" class="rsp_tab_item" :class="{'rsp_tab_item_active': tabIndexSale === 0}">{{res.communityName}}</div>
                    <div @click="changeSaleTab(1)" class="rsp_tab_item" :class="{'rsp_tab_item_active': tabIndexSale === 1}">附近小区</div>
                </div>
                <template v-if="tabIndexSale == 0">
                    <div v-for="(item, i) in onSaleList" :key="i" :class="{'vux-1px-b': i != onSaleList.length - 1}">
                        <cmt-pannel :item="item"></cmt-pannel>
                    </div>
                </template>
                <template v-else>
                    <div v-for="(item, i) in onSaleNearbyList" :key="i" :class="{'vux-1px-b': i != onSaleNearbyList.length - 1}">
                        <cmt-pannel :item="item"></cmt-pannel>
                    </div>
                </template>
            </div>
        </div>
        <!-- <div class="rsp_tool_bar vux-1px-t">
            <div class="rsp_tool_bar_little_item vux-1px-r">
                <img v-if="res.isMark" :src="iconHeartActive" alt="">
                <img v-else :src="iconHeart" alt="">
                <span>关注</span>
            </div>
            <div @click="addHouse" class="rsp_tool_bar_little_item" style="width: 1.46rem;">
                <img :src="iconAdd" alt="">
                <span>添加房产</span>
            </div>
            <div class="rsp_tool_bar_big_item" style="background-color: #388cff; width: 4.6rem">订阅小区报告</div>
        </div> -->
        <div class="cmt_tool_bar vux-1px-t">
            <div class="cmt_tool_bar_little_item vux-1px-r">
                <img v-if="isAtt == 1" :src="iconHeartActive" alt="">
                <img v-else :src="iconHeart" alt="">
                <span>关注</span>
            </div>
            <div @click="clickHouse" class="cmt_tool_bar_little_item" style="width: 1.46rem;">
                <img :src="isHouse == 1 ? iconSeeHouse : iconAdd" alt="">
                <span>{{ isHouse == 1 ? '查看房产' : '添加房产'}}</span>
            </div>
            <template v-if="isRepor == 1">
                <div @click="showMenu = true" class="cmt_tool_bar_big_item" style="background-color: #ffbb38;">查看报告</div>
                <div @click="showBuyPop = true" class="cmt_tool_bar_big_item" style="background-color: #388cff;">订阅小区报告</div>
            </template>
            <template v-else>
                <div @click="showBuyPop = true" class="cmt_tool_bar_big_item" style="background-color: #388cff; width: 4.6rem">订阅小区报告</div>
            </template>
        </div>
        <buy-pop @on-hide="onPopHide" :pop-show="showBuyPop"></buy-pop>
        <actionsheet v-model="showMenu" show-cancel :menus="reportList" @on-click-menu="selReport"></actionsheet>
    </div>
</template>

<script>
import IProgressM from 'components/progress_m'
import MChart from 'components/m_chart'
import CmtPannel from '../components/cmt_pannel';
import { Actionsheet } from 'vux'
import BuyPop from 'components/buy_pop'

import 'assets/css/report/report_sell.css'
import iconSeeHouse from 'assets/img/house/icon-see-house.png'
import iconArrowWhiteRight from 'assets/img/report/icon-arrow-white-right.png'
import iconWhiteUp from 'assets/img/house/icon-white-up.png'
import iconWhiteDown from 'assets/img/house/icon-white-down.png'
import iconRease from 'assets/img/homepage/icon-rease.png'
import iconDecrease from 'assets/img/homepage/icon-decrease.png'
import iconHeart from 'assets/img/house/icon-heart.png'
import iconHeartActive from 'assets/img/house/icon-heart-active.png'
import iconAdd from 'assets/img/homepage/icon-add.png'
import _ from 'lodash'
export default {
    name: 'report-sell',
    components: { IProgressM, MChart, CmtPannel, BuyPop, Actionsheet },
    data() {
        return {
            iconSeeHouse: iconSeeHouse,
            iconArrowWhiteRight: iconArrowWhiteRight,
            iconWhiteUp: iconWhiteUp,
            iconWhiteDown: iconWhiteDown,
            iconRease: iconRease,
            iconDecrease: iconDecrease,
            iconHeart: iconHeart,
            iconHeartActive: iconHeartActive,
            iconAdd: iconAdd,
            communityId: '',
            community: null,
            info: null,
            date: [],
            series: [],
            dealList: [], //成交房源案例
            dealNearbyList: [], //成交房源附近房源
            onSaleList: [], //在售房源案例
            onSaleNearbyList: [], //在售房源附近房源
            res: {},
            dealData: null,
            showBuyPop: false,
            tabIndexDeal: 0, //成交房源案例tab index
            tabIndexSale: 0, //挂牌房源案例tab index
            isAtt: 0, //0未关注1关注
            isHouse: 0, //0 无房 1有房
            isRepor: 0, //报告 0没有 1有
            reportList: [], //该小区报告列表
            showMenu: false
        }
    },
    methods: {
        loadStatus() { //获取下方工具栏状态
            this.$http({
                url: 'WxAttention/getUserCommunityInfo',
                method: 'post',
                data: {
                    communityId: this.communityId
                }
            }).then(res => {
                let data = res.data.data;
                if(res.data.statusCode == 1) {
                    this.isAtt = data.isAtt;
                    this.isHouse = data.isHouse;
                    this.isRepor = data.isRepor;
                }
            })
        },
        checkReport(path) {
            console.log('path:  ', path)
            if(path === '') {

            }else {
                this.$router.push({path: path, query: {'communityId': this.communityId}})
            }
        },
        selReport(menuKey, menuItem) {
            if(menuKey == 'cancel') {
                return;
            }
            let pathArr = ['', '', '/reportBrief', '/reportSell', '', ''];
            this.checkReport(pathArr[menuItem.r_type]);
        },
        getReportList() {
            this.$http({
                url: 'WxUser/selectReportByUserIdAndCommunityId',
                method: 'post',
                data: {
                    communityId: this.communityId
                }
            }).then(res => {
                let data = res.data.data;
                let arr = ['', '完整报告', '简要报告', '出售报告', '出租报告', '持产报告'];
                if(res.data.statusCode == 1) {
                    this.reportList = data.map(item => {
                        return {
                            label: item.isExpired == 1 ? arr[item.type] + '(已过期)' : arr[item.type],
                            value: item.communityId,
                            r_type: item.type,
                            isExpired: item.isExpired,
                            type: item.isExpired == 1 ? 'disabled' : 'default'
                        }
                    })
                }
            })
        },
        onPopHide() {
            this.showBuyPop = false
        },
        clickHouse() {
            if(this.isHouse == 1) {
                this.$router.push({path: '/myHouse'})
            }else {
                this.addHouse();
            }
        },
        addHouse() {
            let community = {
                cityId: this.community.cityId,
                cityName: this.community.cityName,
                districtId: this.community.districtId,
                districtName: this.community.districtName,
                communityId: this.community.communityId,
                communityname: this.community.communityName,
                detailaddress: this.info.detailaddress,
                
            };
            let formCity = {
                cityId: this.community.cityId,
                cityName: this.community.cityName,
                districtId: this.community.districtId,
                districtName: this.community.districtName,
            }
            this.$store.commit('updateFormCommunityStatus', community)
            this.$store.commit('updateFormCityStatus', formCity);
            this.$router.push({path: '/addHouse'})
        },
        changeDealTab(val) {
            this.tabIndexDeal = val;
        },
        changeSaleTab(val) {
            this.tabIndexSale = val;
        },
        load() {
            this.$http({
                url: 'community/getCommunityMarket',
                method: 'post',
                data: {
                    communityId: this.$route.query.communityId
                }
            }).then(res => {
                let data = res.data.data;
                if(res.data.statusCode == 1) {
                    this.community = _.cloneDeep(data);
                    this.info = _.cloneDeep(data.communityInfo);
                    document.title = this.community.communityName + '出售报告'
                    this.getSaleDealCount();
                    this.loadPriceTend();
                    this.loadDealList();
                    this.loadDealNearbyList();
                    this.loadOnSaleList();
                    this.loadOnSaleNearbyList();
                }
            })
        },
        loadPriceTend() { //均价走势数据
            this.$http({
                url: 'WxCommon/getMarketYear',
                method: 'post',
                data: {
                    cityId: this.community.cityId,
                    districtId: this.community.districtId,
                    communityId: this.community.communityId
                }
            }).then(res => {
                let data = res.data.data;
                if(res.data.statusCode == 1) {
                    let _series = [];
                    if(data.communityMarketList && data.communityMarketList.length > 0) {
                        _series.push({
                            label: data.communityName,
                            data: data.communityMarketList[1]
                        })
                    }
                    if(data.districtMarketList && data.districtMarketList.length > 0) {
                        _series.push({
                            label: data.districtName,
                            data: data.districtMarketList[1]
                        })
                    }
                    if(data.cityMarketList && data.cityMarketList.length > 0) {
                        _series.push({
                            label: data.cityName,
                            data: data.cityMarketList[1]
                        })
                    }
                    this.date = _.cloneDeep(data.cityMarketList[0]);
                    this.series = _.cloneDeep(_series);
                }
            })
        },
        getSaleDealCount() {
            this.$http({
                url: 'WxCommunity/getSaleDealCount',
                method: 'post',
                data: {
                    communityId: this.communityId,
                    cityId: this.community.cityId
                }
            }).then(res => {
                let data = res.data.data;
                if(res.data.statusCode == 1) {
                    this.dealData = _.cloneDeep(data);
                }
            })
        },
        loadDealList() {
            this.$http({
                url: 'WxCommunity/getSameDealListing',
                method: 'post',
                data: {
                    communityId: this.communityId,
                    cityId: this.community.cityId,
                    square: 0
                }
            }).then(res => {
                let data = res.data.data;
                if(res.data.statusCode == 1) {
                    let _tmp = data.map(item => {
                        return {
                            type: 2,
                            communityName: item.communityName,
                            Detailaddress: `${item.buildingarea}平米 | ${item.sqmprice}元/平米`,
                            Salesqmprice: `${item.totalprice}`,
                            distance: item.contractdate ? item.contractdate.split(' ')[0] : ''
                        }
                    })
                    this.dealList = _.cloneDeep(_tmp)
                }
            })
        },
        loadDealNearbyList() {
            this.$http({
                url: 'WxCommunity/getSameDealListingNearbyCommunity',
                method: 'post',
                data: {
                    square: 0,
                    lng: this.info.longitude,
                    lat: this.info.latitude,
                    range: 500
                }
            }).then(res => {
                let data = res.data.data;
                if(res.data.statusCode == 1) {
                    let _tmp = data.map(item => {
                        return {
                            type: 2,
                            communityName: item.communityName,
                            Detailaddress: `${item.buildingarea}平米 | ${item.sqmprice}元/平米`,
                            Salesqmprice: `${item.totalprice}`,
                            distance: item.contractdate ? item.contractdate.split(' ')[0] : ''
                        }
                    })
                    this.dealNearbyList = _.cloneDeep(_tmp)
                }
            })
        },
        loadOnSaleList() {
            this.$http({
                url: 'WxCommunity/getSameSaleListing',
                method: 'post',
                data: {
                    communityId: this.communityId,
                    cityId: this.community.cityId,
                    square: 0
                }
            }).then(res => {
                let data = res.data.data;
                if(res.data.statusCode == 1) {
                    let _tmp = data.map(item => {
                        return {
                            type: 2,
                            communityName: item.communityName,
                            Detailaddress: `${item.buildingsquare}平米 | ${item.sqmprice}元/平米`,
                            Salesqmprice: `${item.totalsqmprice || ''}`,
                            distance: item.dayId ? item.dayId.split(' ')[0] : ''
                        }
                    })
                    this.onSaleList = _.cloneDeep(_tmp)
                }
            })
        },
        loadOnSaleNearbyList() {
            this.$http({
                url: 'WxCommunity/getSameSaleListingNearbyCommunity',
                method: 'post',
                data: {
                    square: 0,
                    lng: this.info.longitude,
                    lat: this.info.latitude,
                    range: 500
                }
            }).then(res => {
                let data = res.data.data;
                if(res.data.statusCode == 1) {
                    let _tmp = data.map(item => {
                        return {
                            type: 2,
                            communityName: item.communityName,
                            Detailaddress: `${item.buildingsquare}平米 | ${item.sqmprice}元/平米`,
                            Salesqmprice: `${item.totalsqmprice || ''}`,
                            distance: item.contractdate ? item.contractdate.split(' ')[0] : ''
                        }
                    })
                    this.onSaleNearbyList = _.cloneDeep(_tmp)
                }
                this.$store.commit('updateLoadingStatus', {isLoading: false})                
            })
        },
    },
    created() {
        this.communityId = this.$route.query.communityId
        this.load();
        this.loadStatus();
        this.getReportList();
    },
    mounted() {
        document.title = '出售报告'
    }
}
</script>

<style scoped>
.cmt_pannel_box {
    margin-bottom: 0;
    width: 6.9rem;
    padding: 0.35rem 0;
}
</style>
