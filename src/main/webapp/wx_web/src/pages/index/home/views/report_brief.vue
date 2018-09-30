<template>
    <div class="cmt_page">
        <div class="cmt_pic_wrapper">
            <swiper :list="pics" v-model="picIndex" :show-dots="false" auto :height="'4.82rem'"></swiper>
            <div class="cmt_pic_tips">{{picIndex + 1}}/{{pics.length}}</div>
        </div>
        <div class="cmt_block_1">
            <div class="cmt_block_1_top vux-1px-b">
                <div class="cmt_block_1_top_name">{{community.communityName}}</div>
                <div class="cmt_block_1_top_address">{{info.detailaddress || ''}}</div>
            </div>
            <div class="cmt_block_1_bottom">
                <div class="cmt_block_1_bottom_item" style="width: 50%;">
                    <div class="cmt_block_1_bottom_item_label">本月均价</div>
                    <div class="cmt_block_1_bottom_item_val">{{community.similarHousesSalesqmprice || ''}}元/㎡</div>
                </div>
                <div class="cmt_block_1_bottom_item" style="width: 50%;">
                    <div class="cmt_block_1_bottom_item_label">出租均价</div>
                    <div class="cmt_block_1_bottom_item_val">{{community.rentsqmprice || ''}}元/㎡</div>
                </div>
            </div>
        </div>
        <div v-show="community.communityName" class="rb_block_1">
            <i-progress-m :label="`均价超过${community.cityName}`" :val="community.cityScale"></i-progress-m>
            <i-progress-m style="margin-top: 0.3rem;" :label="`月增长超过${community.cityName}`" :val="community.differenceScale"></i-progress-m>
        </div>
        <div v-if="!!series && series.length > 0" class="rb_block_2">
            <div class="cmt_block_title vux-1px-b">均价走势</div>
            <m-chart :date="date" :series="series"></m-chart>
        </div>
        <div v-if="info" class="cmt_block_2">
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
                    <div class="cmt_block_2_ctn_item_label">主力面积</div>
                    <div class="cmt_block_2_ctn_item_val">{{info.mainArea ? info.mainArea + '㎡' : ''}}</div>
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
        <div class="rb_block_3">
            <div class="cmt_block_title vux-1px-b">租金收益率</div>
            <div class="rb_block_3_ctn">
                <div class="rb_block_3_ctn_item" v-for="(item, index) in leaseRatioArray" :key="index">
                    <div class="rb_block_3_ctn_item_label">{{item.name}}</div> {{item.val || '--'}}%
                </div>
            </div>
        </div>
        <div class="rb_block_4">
            <div class="cmt_block_title vux-1px-b">租金走势</div>
            <div v-if="leaseTendSeries.length > 0" class="rb_block_4_ctn">
                <div class="rb_block_4_tab">
                    <div @click="changeTab(index)" v-for="(item, index) in leaseTendSeries" :key="index" :class="{'rb_block_4_tab_item_active': index === tabIndex}" class="rb_block_4_tab_item">{{item.label}}</div>
                </div>
                <div v-show="index === tabIndex" v-for="(item, index) in leaseTendSeries" :key="index" class="rb_block_4_chart_box">
                    <div ref="leaseChart" class="rb_block_4_chart_box_inner"></div>
                </div>
                <div class="rb_block_4_chart_unit">(元/月)</div>
            </div>
        </div>
        <div class="cmt_block_3" v-if="info.latitude && info.longitude">
            <div class="cmt_block_title vux-1px-b">位置地图</div>
            <div class="cmt_block_3_ctn">
                <div class="cmt_block_3_ctn_map_mask"></div>
                <div class="cmt_block_3_ctn_maker">
                    <div class="cmt_block_3_ctn_maker_inner">
                        <div class="cmt_block_3_ctn_maker_inner_tit">{{community.communityName}}</div>
                        <div class="cmt_block_3_ctn_maker_inner_address">{{info.detailaddress || ''}}</div>
                    </div>
                </div>
                <div id="rb_block_3_ctn_map" class="cmt_block_3_ctn_map"></div>
            </div>
        </div>
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
import { Swiper, Actionsheet } from 'vux'
import iconSeeHouse from 'assets/img/house/icon-see-house.png'
import iconRease from 'assets/img/homepage/icon-rease.png'
import iconDecrease from 'assets/img/homepage/icon-decrease.png'
import iconHeart from 'assets/img/house/icon-heart.png'
import iconHeartActive from 'assets/img/house/icon-heart-active.png'
import iconAdd from 'assets/img/homepage/icon-add.png'
import BuyPop from 'components/buy_pop'
import IProgressM from 'components/progress_m'
import MChart from 'components/m_chart'
import _ from 'lodash'

import 'assets/css/house/community.css'
export default {
    name: 'report-brief',
    components: {
        Swiper, IProgressM, MChart, BuyPop, Actionsheet
    },
    data() {
        return {
            iconSeeHouse: iconSeeHouse,
            iconRease: iconRease,
            iconDecrease: iconDecrease,
            iconHeart: iconHeart,
            iconHeartActive: iconHeartActive,
            iconAdd: iconAdd,
            showBuyPop: false, //订阅弹出框
            picIndex: 0,
            communityId: '',
            isMark: 0,
            pics: [],
            leaseRatioArray: [],
            community: {},
            info: {},
            date: [],
            series: [],
            tabIndex: 0,
            renderQueue: [], //记录已渲染图表
            leaseTendSeries: [], //租金数据
            leaseTendDate: [],
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
        this.loadRentTend();
        this.getReportList();
    },
    methods: {
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
        clickHouse() {
            if(this.isHouse == 1) {
                this.$router.push({path: '/myHouse'})
            }else {
                this.addHouse();
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
                    this.community = _.cloneDeep(data);
                    this.getRentalPriceRatio();
                    this.loadPriceTend();
                    this.info = _.cloneDeep(data.communityInfo);
                    this.pics = this.info.pictureUrlList.split(',').map(item => {
                        return {
                            url: 'javascript:',
                            img: item
                        }
                    })
                    document.title = this.community.communityName;

                    this.$nextTick(() => {
                        this.initMap();
                    });
                    
                    this.$store.commit('updateLoadingStatus', {isLoading: false})
                }
            })
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
        loadRentTend() {
            this.$http({
                url: 'WxCommon/getCommunityRent',
                method: 'post',
                data: {
                    communityId: this.$route.query.communityId
                }
            }).then(res => {
                let data = res.data.data;
                if(res.data.statusCode == 1) {
                    let map = ['oneRoom', 'twoRoom', 'threeRoom'];
                    let labelMap = ['一居', '二居', '三居'];
                    let _tmp = map.map((key, index) => {
                        return {
                            label: labelMap[index],
                            data: _.cloneDeep(data[key][1])
                        }
                    })
                    
                    if(_tmp.length > 0) {
                        this.leaseTendDate = data.oneRoom[0]
                        this.leaseTendSeries = _.cloneDeep(_tmp);
                        this.$nextTick(() => {
                            this.renderChart();
                        })
                    }
                }
            })
        },
        getRentalPriceRatio() {
            this.$http({
                url: 'WxCommon/getRentalPriceRatio',
                method: 'post',
                data: {
                    cityId: this.community.cityId,
                    districtId: this.community.districtId,
                    communityId: this.communityId
                }
            }).then(res => {
                let data = res.data.data;
                if(res.data.statusCode == 1) {
                    this.leaseRatioArray = [{
                        name: data.cityName,
                        val: data.cityRatio
                    }, {
                        name: data.districtName,
                        val: data.districtRatio
                    }, {
                        name: data.communityName,
                        val: data.communityRatio
                    }]
                }
            })
        },
        initMap() {
            if(this.info.latitude && this.info.longitude) {
                var map = new BMap.Map("rb_block_3_ctn_map");          // 创建地图实例  
                var point = new BMap.Point(this.info.longitude, this.info.latitude);  // 创建点坐标  
                map.centerAndZoom(point, 15);  
                var marker = new BMap.Marker(new BMap.Point(this.info.longitude, this.info.latitude));
                map.addOverlay(marker);   
            }
        },
        renderChart() { //初始化租金走势图
            // if(this.date.length == 0 || this.series.length == 0) {
            //     return;
            // }
            let item = this.leaseTendSeries[this.tabIndex];
            let index = this.tabIndex;
            if(this.renderQueue.indexOf(index) >= 0) {
                return;
            }
            let el = this.$refs.leaseChart[index];
            var myRegression = echarts.init(el);
            var dateLableArr = this.leaseTendDate;
            let series = {
                name: item.label,
                data: item.data,
                type: "line",
                smooth: false,
                symbolSize: 0,
                itemStyle: {
                    normal: {
                        lineStyle: {
                            color: '#388cff'
                        },
                        color: '#388cff'
                    }
                },
                //渐变
                areaStyle: {
                    normal: {
                        opacity: 0.2,
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1, [{
                                offset: 0,
                                color: '#388cff'
                            },
                            {
                                offset: 1,
                                color: '#fff'
                            }

                            ]
                        )
                    }
                }
            }
            var option = {
                grid: {
                    top: 40,
                    bottom: 30,
                    right: 12,
                    left: 50
                },
                tooltip: {
                    show: true
                },
                xAxis: {
                    type: "category",
                    data: dateLableArr,
                    offset: -13,
                    axisLabel: {
                        interval:0,
                        show: true,
                        color: "#bbb"
                    },
                    splitNumber: 2,
                    scale: true,
                    axisLine: {
                        show: false
                    },

                    axisTick: {
                        show: true,
                            lineStyle: {
                            color: "#fff"
                        }
                    },
                    splitLine: {
                        show: false,
                            lineStyle: {
                            type: "dotted",
                            color: "#fff"
                        }
                    },
                    boundaryGap: false
                },
                yAxis: {
                    type: "value",
                    scale: false,
                    offset: 10,
                    show: true,
                    axisLabel: {
                        show: true,
                        color: "#bbb"
                    },
                    axisTick: {
                        show: false
                    },
                    axisLine: {
                        show: false
                    },
                    splitLine: {
                        show: false
                    }
                },
                series: series
            };
            // 为echarts对象加载数据
            myRegression.setOption(option);
            this.$nextTick(() => {
                this.renderQueue.push(index);
            });
        },
        changeTab(index) {
            this.tabIndex = index;
            this.$nextTick(() => {
                this.renderChart()
            })
        }
    },
    mounted() {
        // this.initMap();
       
    }
}
</script>
