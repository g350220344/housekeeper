<template>
    <div v-show="!!res.communityName" class="cmt_page">
        <div class="cmt_pic_wrapper">
            <swiper :list="pics" v-model="picIndex" :show-dots="false" auto :height="'4.82rem'"></swiper>
            <div class="cmt_pic_tips">{{picIndex + 1}}/{{pics.length}}</div>
        </div>
        <div class="cmt_block_1">
            <div class="cmt_block_1_top vux-1px-b">
                <div class="cmt_block_1_top_name">{{res.communityName || ''}}</div>
                <div class="cmt_block_1_top_address">{{info.detailaddress || ''}}</div>
            </div>
            <div class="cmt_block_1_bottom">
                <div class="cmt_block_1_bottom_item">
                    <div class="cmt_block_1_bottom_item_label">本月均价</div>
                    <div class="cmt_block_1_bottom_item_val">{{res.similarHousesSalesqmprice || ''}}元/㎡</div>
                </div>
                <div class="cmt_block_1_bottom_item">
                    <div class="cmt_block_1_bottom_item_label">环比上月</div>
                    <div class="cmt_block_1_bottom_item_val">
                        <img v-if="res.saleSqmPriceLinkRelativeRatio > 0" :src="iconRease" alt="">
                        <img v-else :src="iconDecrease" alt="">
                        <span :class="{'cmt_rate_up': res.saleSqmPriceLinkRelativeRatio >= 0, 'cmt_rate_down': res.saleSqmPriceLinkRelativeRatio < 0}">
                            {{(res.saleSqmPriceLinkRelativeRatio + '').replace('-', '')}}
                        </span>
                    </div>
                </div>
                <div class="cmt_block_1_bottom_item">
                    <div class="cmt_block_1_bottom_item_label">同比去年</div>
                    <div class="cmt_block_1_bottom_item_val">
                        <img v-if="res.saleSqmPriceOnYear_on_YearBasis > 0" :src="iconRease" alt="">
                        <img v-else :src="iconDecrease" alt="">
                        <span :class="{'cmt_rate_up': res.saleSqmPriceOnYear_on_YearBasis >= 0, 'cmt_rate_down': res.saleSqmPriceOnYear_on_YearBasis < 0}">
                            {{(res.saleSqmPriceOnYear_on_YearBasis + '').replace('-', '')}}
                        </span>
                    </div>
                </div>
            </div>
        </div>
        <div v-if="!!info" class="cmt_block_2">
            <div class="cmt_block_title vux-1px-b">基本信息</div>
            <div class="cmt_block_2_ctn">
                <div class="cmt_block_2_ctn_item">
                    <div class="cmt_block_2_ctn_item_label">建筑年代</div>
                    <div class="cmt_block_2_ctn_item_val">{{info.buildyear || ''}}</div>
                </div>
                <div class="cmt_block_2_ctn_item">
                    <div class="cmt_block_2_ctn_item_label">总户数</div>
                    <div class="cmt_block_2_ctn_item_val">{{info.totalhouseholdcount || ''}}</div>
                </div>
                
                <div class="cmt_block_2_ctn_item">
                    <div class="cmt_block_2_ctn_item_label">容积率</div>
                    <div class="cmt_block_2_ctn_item_val">{{info.plotratio || ''}}</div>
                </div>
                <div class="cmt_block_2_ctn_item">
                    <div class="cmt_block_2_ctn_item_label">停车位</div>
                    <div class="cmt_block_2_ctn_item_val">{{info.parkingNum || ''}}</div>
                </div>
                <div class="cmt_block_2_ctn_item">
                    <div class="cmt_block_2_ctn_item_label">绿化率</div>
                    <div class="cmt_block_2_ctn_item_val">{{info.greeningrate ? info.greeningrate + '%' : ''}}</div>
                </div>
                <div class="cmt_block_2_ctn_item">
                    <div class="cmt_block_2_ctn_item_label">物业费</div>
                    <div class="cmt_block_2_ctn_item_val">{{info.pmfee ? info.pmfee + '元平米/月' : ''}}</div>
                </div>
                <div class="cmt_block_2_ctn_item" style="width: 100%;">
                    <div class="cmt_block_2_ctn_item_label">开发商</div>
                    <div class="cmt_block_2_ctn_item_val">{{info.developername || ''}}</div>
                </div>
                <div class="cmt_block_2_ctn_item" style="width: 100%;">
                    <div class="cmt_block_2_ctn_item_label">物业公司</div>
                    <div class="cmt_block_2_ctn_item_val">{{info.companyname || ''}}</div>
                </div>
            </div>
        </div>
        <div class="cmt_block_3" v-show="info && info.latitude && info.latitude">
            <div class="cmt_block_title vux-1px-b">位置地图</div>
            <div class="cmt_block_3_ctn">
                <div class="cmt_block_3_ctn_map_mask"></div>
                <div class="cmt_block_3_ctn_maker">
                    <div class="cmt_block_3_ctn_maker_inner">
                        <div class="cmt_block_3_ctn_maker_inner_tit">{{res.communityName}}</div>
                        <div class="cmt_block_3_ctn_maker_inner_address">{{info.detailaddress || ''}}</div>
                    </div>
                </div>
                <div id="cmt_block_3_ctn_map" class="cmt_block_3_ctn_map"></div>
            </div>
        </div>
        <div class="cmt_tool_bar vux-1px-t">
            <div @click="mark" class="cmt_tool_bar_little_item vux-1px-r">
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
import { Swiper, Actionsheet } from 'vux'
import iconRease from 'assets/img/homepage/icon-rease.png'
import iconDecrease from 'assets/img/homepage/icon-decrease.png'
import iconHeart from 'assets/img/house/icon-heart.png'
import iconHeartActive from 'assets/img/house/icon-heart-active.png'
import iconSeeHouse from 'assets/img/house/icon-see-house.png'
import iconAdd from 'assets/img/homepage/icon-add.png'


import BuyPop from 'components/buy_pop'
import __CONFIG__ from 'assets/js/config'
import _ from 'lodash'
import 'assets/css/house/community.css'
export default {
    name: 'community',
    components: {
        Swiper,
        BuyPop,
        Actionsheet
    },
    data() {
        return {
            iconAdd: iconAdd,
            iconRease: iconRease,
            iconDecrease: iconDecrease,
            iconHeart: iconHeart,
            iconHeartActive: iconHeartActive,
            iconSeeHouse: iconSeeHouse,
            communityId: '',
            picIndex: 0,
            showBuyPop: false,
            pics: [],
            res: {},
            info: {},
            isAtt: 0, //0未关注1关注
            isHouse: 0, //0 无房 1有房
            isRepor: 0, //报告 0没有 1有
            reportList: [], //该小区报告列表
            showMenu: false
        }
    },
    created() {
        this.communityId = this.$route.query.communityId;
        this.load();
        this.loadStatus();
        this.getReportList();
    },
    methods: {
        mark() {
            this.markLock = true;
            let url = 'WxAttention/addAttention';
            let data = {
                dataId: this.communityId
            }
            if(this.isAtt == 1) {
                url = 'WxAttention/canelAttention'
            }else {
                data['type'] = 1
            }
            this.$http({
                url: url,
                method: 'post',
                data: data
            }).then(res => {
                if(res.data.statusCode == 1) {
                    this.isAtt = this.isAtt == 1 ? 0 : 1;
                    this.markLock = false;
                }
            })
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
        initMap() {
            if(this.info.latitude && this.info.longitude) {
                var map = new BMap.Map("cmt_block_3_ctn_map");          // 创建地图实例  
                var point = new BMap.Point(this.info.longitude, this.info.latitude);  // 创建点坐标  
                map.centerAndZoom(point, 15);  
                var marker = new BMap.Marker(new BMap.Point(this.info.longitude, this.info.latitude));
                map.addOverlay(marker);   
            }
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
                    this.res = _.cloneDeep(data);
                    this.info = _.cloneDeep(data.communityInfo);
                    this.pics = this.info.pictureUrlList.split(',').map(item => {
                        return {
                            url: 'javascript:',
                            img: item
                        }
                    })
                    this.initMap();
                    this.$store.commit('updateLoadingStatus', {isLoading: false})
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
        onPopHide() {
            this.showBuyPop = false
        },
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
        clickHouse() {
            if(this.isHouse) {
                this.$router.push({path: '/myHouse'})
            }else {
                let community = {
                    cityId: this.res.cityId,
                    cityName: this.res.cityName,
                    districtId: this.res.districtId,
                    districtName: this.res.districtName,
                    communityId: this.res.communityId,
                    communityname: this.res.communityName,
                    detailaddress: this.info.detailaddress,
                    
                };
                let formCity = {
                    cityId: this.res.cityId,
                    cityName: this.res.cityName,
                    districtId: this.res.districtId,
                    districtName: this.res.districtName,
                }
                this.$store.commit('updateFormCommunityStatus', community)
                this.$store.commit('updateFormCityStatus', formCity);
                this.$router.push({path: '/addHouse'})
            }
        }
    },
    mounted() {
        document.title = '小区基本信息'
    }
}
</script>
