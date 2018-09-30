<template>
    <div style="margin-bottom: 0.15rem;">
        <div class="h_bg_block">
            <div v-if="houseInfo">
                <div @click="edit" class="h_bg_block_menu_btn">
                    <img class="h_bg_block_menu_btn_icon" :src="iconManage" alt="">
                    <span>管理</span>
                </div>
                <div @click="goCommunity" class="h_bg_block_row_1">
                    {{houseInfo.communityName}}
                    <img :src="iconArrowRight" alt="">
                </div>
                <div class="h_bg_block_row_2">
                    {{houseInfo.cityName}} {{houseInfo.districtName}} {{houseInfo.address}} {{houseInfo.buildingsquare || '--'}}㎡
                </div>
                <div class="h_bg_block_row_3">
                    <div class="h_bg_block_row_3_item">市场单价:{{houseInfo.assessSalePrice || '--'}}元/㎡</div>
                    <div class="h_bg_block_row_3_item" style="text-align: right;">购入价格:{{houseInfo.buyPrice || '--'}}万元</div>
                    <div class="h_bg_block_row_3_item" style="text-align: right;">购入日期:{{houseInfo.buyTime || '--'}}</div>
                </div>
                <div class="h_bg_block_row_4">
                    <div class="h_bg_block_row_4_item">
                        <div class="h_bg_block_row_4_item_label">房产估值 (万元) </div>
                        <div class="h_bg_block_row_4_item_val">{{houseInfo.assessSaleTotalPrice || '--'}}</div>
                        <div class="h_bg_block_row_4_item_rate">
                            环比
                            <img v-if="houseInfo.risePrice >= 0" :src="iconWhiteUp" alt="">
                            <img v-else :src="iconWhiteDown" alt="">
                            {{houseInfo.risePrice ? (houseInfo.risePrice.toFixed(2) + '').replace('-', '') + '%' : '--'}}
                        </div>
                    </div>
                    <div class="h_bg_block_row_4_item">
                        <div class="h_bg_block_row_4_item_label">房产增值 (万元) </div>
                        <div class="h_bg_block_row_4_item_val">{{houseInfo.increasePrice || '--'}}</div>
                        <div class="h_bg_block_row_4_item_rate">
                            环比
                            <img v-if="houseInfo.riseIncreasePrice >= 0" :src="iconWhiteUp" alt="">
                            <img v-else :src="iconWhiteDown" alt="">
                            {{houseInfo.riseIncreasePrice ? (houseInfo.riseIncreasePrice.toFixed(2) + '').replace('-', '') + '%' : '--'}}
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="h_card_1">
            <tab style="height: 1.04rem;" :line-width="2" custom-bar-width="1.62rem" active-color="#388cff">
                <tab-item @on-item-click="clickTab" selected>资产</tab-item>
                <tab-item @on-item-click="clickTab">贷款</tab-item>
                <tab-item @on-item-click="clickTab">租赁</tab-item>
            </tab>
            <div v-show="tabIndex === 0" class="h_card_1_item">
                <template v-if="!showValue">
                    <div class="h_card_1_item_no_loans">
                        <img class="h_card_1_item_no_loans_mask_1" :src="havingsChartMask" alt="">
                        <div @click="showDialog" class="h_show_property_chart_btn">查看资产分布图</div>
                    </div>
                </template>
                <template v-else>
                    <div class="h_card_1_item_chart_title">资产曲线</div>
                    <div id="h_chart_box" style="padding: 0 0.35rem;height:4.7rem; margin: auto;"></div>
                    <div class="h_chart_1_lends">
                        <span v-if="propertyRes.loans.length > 0" style="margin-right: 0.69rem;"><i class="dot dot_blue"></i>贷款负债</span> <i class="dot dot_green"></i>房净值
                    </div>
                </template>
            </div>
            <div v-show="tabIndex === 1" class="h_card_1_item">
                <template v-if="loans.length == 0">
                    <div class="h_card_1_item_no_loans_2">
                        <img class="h_card_1_item_no_loans_2_empty_img" :src="emptyState" alt="">
                        <p class="h_card_1_item_no_loans_2_p">添加贷款信息月供轻松管理</p>
                        <div @click="addLoan" class="h_add_loan_btn">
                            <img class="h_add_loan_btn_icon" :src="iconAdd" alt="">添加贷款
                        </div>
                    </div>
                </template>
                <template v-if="loans.length > 0 && nextLoan">
                    <div class="h_loan_block_row_1">下期还款</div>
                    <template v-if="nextLoan.allPersent < 100">
                        <div class="h_loan_block_row_2">{{nextLoan.money}}<span style="font-size: 0.26rem;">元</span></div>
                        <div class="h_loan_block_row_3">{{nextLoan.date}}{{nextLoan.typeName}}</div>
                        <i-progress style="padding-bottom: 0.23rem;" :val="nextLoan.allPersent" :label-left="`还款总进度：${nextLoan.allPersent}%`" :label-right="`(${nextLoan.allCurrTerm}/${nextLoan.allTerm})期`"></i-progress>
                    </template>
                    <template v-else>
                        <div class="h_loan_clear_btn" style="margin-bottom: 0.84rem">贷款已全部结清</div>
                    </template>
                </template>
            </div>
            <div v-show="tabIndex === 2" class="h_card_1_item">
                <template v-if="!nextRent || !nextRent.nextTime">
                    <div class="h_card_1_item_no_loans_2">
                        <img class="h_card_1_item_no_loans_2_empty_img" :src="emptyState" alt="">
                        <p class="h_card_1_item_no_loans_2_p">添加租约信息收租便捷提醒</p>
                        <div @click="addRent" class="h_add_loan_btn">
                            <img class="h_add_loan_btn_icon" :src="iconAdd" alt="">添加租约
                        </div>
                    </div>
                </template>
                <template v-else>
                    <div class="h_loan_block_row_1">下期收租</div>
                    <div class="h_loan_block_row_2">{{nextRent.money}}<span style="font-size: 0.26rem;">元</span></div>
                    <div class="h_loan_block_row_3">{{nextRent.nextTime}} 收取{{nextRent.leaseName}}租金</div>
                    <div class="h_lease_rate_block">
                        <div class="h_lease_rate_block_item">
                            <div class="h_lease_rate_block_item_val">{{nextRent.monthPrice}}元/月</div>
                            <div class="h_lease_rate_block_item_label">总租金</div>
                        </div>
                        <div class="h_lease_rate_block_item">
                            <div class="h_lease_rate_block_item_val">{{nextRent.lv}}%</div>
                            <div class="h_lease_rate_block_item_label">出租年回报率</div>
                        </div>
                        <div class="h_lease_rate_block_divider"></div>
                    </div>
                </template>
            </div>
        </div>
        <div v-show="tabIndex === 0" class="h_tab_ctn_box">
            <i-card tit='预授信'>
                <div class="h_loan_avilabel_box" slot="ctn">
                    <div class="h_loan_avilabel_box_val">预计最高可贷<span> {{res.loanAvilable}} </span>万元</div>
                    <div class="h_loan_apply_btn">立即申请</div>
                </div>
            </i-card>
            <i-card tit="资产分布">
                <div v-if="!showValue" slot="ctn"  class="h_distribution_chart_mask">
                    <img class="h_card_1_item_no_loans_mask_1" :src="havingsMask" alt="">
                    <div @click="showDialog" style="bottom: 1.44rem;" class="h_show_property_chart_btn">查看资产分布图</div>
                </div>
                <div v-else slot="ctn" class="h_distribution_box">
                    <div id="h_distribution_chart"></div>
                    <div class="h_distribution_info_block">
                        <p>房净值</p>
                        <div class="h_distribution_info_block_val">{{res.pureValue}}<span>元</span></div>
                        <div class="h_distribution_chart_lend">
                            <i class="dot dot_red"></i>按揭贷款 
                            <i class="dot dot_blue" style="margin-left: 0.05rem;"></i>公积金贷款
                            <i class="dot dot_green" style="margin-left: 0.05rem;"></i>房净值 
                        </div>
                    </div>
                </div>
            </i-card>
        </div>
        <div v-show="tabIndex === 1 && loans.length > 0" class="h_tab_ctn_box">
            <div @click="editLoan(item)" v-for="item in loans" :key="item.id" class="h_loan_card">
                <div class="h_loan_card_raw_1">
                    <div class="h_loan_card_raw_1_left">
                        <img class="h_loan_card_bank_icon" :src="bankIconArray[item.channel]" alt="">
                        <div class="h_loan_card_raw_1_left_bank">{{item.channelName}}</div>
                    </div>
                    <div class="h_loan_card_raw_1_right">
                        <template v-if="item.state == 0">
                            <div class="h_loan_card_raw_1_right_line_label">{{item.typeName}}</div>
                            <div class="h_loan_card_raw_1_right_line_val">下期还款时间：{{item.nextDate}}</div>
                            <div class="h_loan_card_raw_1_right_line_val">下期还款金额：{{item.nextMoney}}元</div>                        
                        </template>
                        <template v-else>
                            <div class="h_loan_clear_btn">贷款已结清</div>
                        </template>
                        
                    </div>
                    <div class="h_loan_card_raw_1_divider"></div>
                </div>
                <i-progress style="padding-bottom: 0.23rem;" :val="item.currPercent" :label-left="`还款总进度：${item.currPercent}%`" :label-right="`(${item.currTerm}/${item.term})期`"></i-progress>
            </div>
            <div @click="addLoan" class="h_loan_add_btn">
                添加贷款信息
            </div>
        </div>
        <div v-show="tabIndex === 2 && rents.length > 0" class="h_tab_ctn_box">
            <div @click="editRent(item)" v-for="(item, index) in rents" :key="index" class="h_loan_card">
                <div class="h_loan_card_raw_1">
                    <div class="h_loan_card_raw_1_left">
                        <img class="h_lease_icon_human" :src="iconHumanPic" alt="">
                        <div class="h_loan_card_raw_1_leaser">{{item.leaseName}}</div>
                        <div class="h_loan_card_raw_1_leaser">
                            <img class="h_lease_icon_phone" :src="iconPhone" alt="">
                            {{item.mobile}}
                        </div>
                    </div>
                    <div class="h_loan_card_raw_1_right">
                        <template v-if="item.state == 0">
                            <div class="h_loan_card_raw_1_right_line_label">收租周期：{{item.paymentMethod}}</div>
                            <div class="h_loan_card_raw_1_right_line_val">下期收租：{{item.nextTime}}</div>
                            <div class="h_loan_card_raw_1_right_line_val">下期租金：{{item.money}}元</div>                        
                        </template>
                        <template v-else>
                            <div class="h_loan_clear_btn">租约已到期</div>
                        </template>
                        
                    </div>
                    <div class="h_loan_card_raw_1_divider"></div>
                </div>
                <i-progress style="padding-bottom: 0.23rem;" :val="item.ratio" :label-left="`累计收租：${item.grandTotal}元`" :label-right="`(${item.month}/${item.term})个月`"></i-progress>
            </div>
            <div @click="addRent" class="h_loan_add_btn">
                添加租赁信息
            </div>
        </div>
       
    </div>
</template>

<script>
import iconArrowRight from 'assets/img/house/icon-arrow-right.png';
import iconWhiteUp from 'assets/img/house/icon-white-up.png';
import iconWhiteDown from 'assets/img/house/icon-white-down.png';
import iconBankCCB from 'assets/img/house/icon-bank-1.png';
import iconBankBoC from 'assets/img/house/icon-bank-2.png';
import iconHumanPic from 'assets/img/house/icon-human-pic.png';
import iconPhone from 'assets/img/house/icon-phone.png';
import iconManage from 'assets/img/house/icon-manage.png';
import havingsChartMask from 'assets/img/house/havings-chart-mask.png';
import havingsMask from 'assets/img/house/havings-mask.png';
import emptyState from 'assets/img/homepage/empty-state.png';
import iconAdd from 'assets/img/homepage/icon-add.png';

import { mapState } from "vuex";
import ICard from '../components/card'
import IProgress from 'components/progress'
import { Tab, TabItem, ConfirmPlugin } from 'vux'
import _ from 'lodash'
import Vue from 'vue'
Vue.use(ConfirmPlugin)
import 'assets/css/house/house.css';

const bankTypes = ['', '建设银行', '中国银行'];
const leaseTypes = ['', '按月', '按季', '按年'];
export default {
    name: 'house',
    components: {
        Tab,
        TabItem,
        ICard,
        IProgress
    },
    data() {
        return {
            iconArrowRight: iconArrowRight,
            iconWhiteUp: iconWhiteUp,
            iconWhiteDown: iconWhiteDown,
            iconHumanPic: iconHumanPic,
            iconPhone: iconPhone,
            iconManage: iconManage,
            havingsChartMask: havingsChartMask,
            havingsMask: havingsMask,
            bankIconArray: ['', iconBankBoC, iconBankCCB],
            emptyState: emptyState,
            iconAdd: iconAdd,
            finished: false,
            houseId: '',
            tabIndex: 0,
            showValue: false, //是否显示资产曲线
            propertyRes: { //资产曲线数据
                vals: [],
                loans: [],
                date: [],
            },
            pieChartRes: null,
            houseInfo: null,
            res: {
                name: '中海寰宇天下',
                cityName: '上海',
                districtName: '徐汇',
                address: '建国西路273号',
                area: 132, 
                price: 1532, //市场单价
                cost: 600, //购买价格
                buyDate: '2010-10', //购入日期
                value: 1100, //房屋估值
                increase: 320, //房产增值
                valueRate: 0.22, //房产估值环比
                increaseRate: -0.22, //房产增值环比,
                loanAvilable: '6,123', // 最高可贷款金额
                pureValue: '10,928', //房净值
                nextLoanPay: 2320.24, //下期还款
                loanDate: '2018-06-20', //贷款日期
                nextLease: 7600, //下期收租
                nextLeasePerson: '王先生',
                nextLeaseDate: '2018-07-20', //下次收租日期
                leasePrice: 19000, //总租金
                leaseIncomingRate: 2.64, //出租年回报率
            },
            loans: [],
            nextLoan: null, //下期贷款
            rents: [],
            nextRent: null //下期收租
        }
    },
    computed: {
        ...mapState({
            loading: state => state.glb.isLoading
        })
    },
    methods: {
        goCommunity() {
            this.$router.push({path: '/community', query: {communityId: this.houseInfo.communityId}})
        },
        addLoan() {
            this.$router.push({path: '/addLoan', query: {houseId: this.houseId}})
        },
        addRent() {
            this.$router.push({path: '/addLease', query: {houseId: this.houseId}})
        },
        editLoan(item) {
            this.$router.push({path: '/addLoan', query: {houseId: this.houseId, id: item.id, is_edit: 1}})
        },
        editRent(item) {
            this.$router.push({path: '/addLease', query: {id: item.id, is_edit: 1, houseId: this.houseId}})
        },
        showDialog() {
            const _this = this // 需要注意 onCancel 和 onConfirm 的 this 指向
            this.$vux.confirm.show({
                title: '完善贷款',
                content: '完善补充贷款信息，获得精准的资产曲线及分布数据。',
                confirmText: '添加贷款',
                cancelText: '无贷款',
                // 组件除show外的属性
                onCancel () {
                    _this.showValue = true;
                    _this.$nextTick(() => {
                        _this.initOwningsChart();
                        _this.initDistributionChart();
                    })
                },
                onConfirm () {

                }
            })
        },
        clickTab(index) {
            console.log('tab-index', index);
            this.tabIndex = index;
        },
        initOwningsChart() {
            let el = document.getElementById("h_chart_box");
            if(!el) {
                return;
            }
            var myRegression = echarts.init(el);
            var dateLableArr = _.cloneDeep(this.propertyRes.date);
            var valArray = this.propertyRes.vals;
            var loadArray = this.propertyRes.loans;
            var maxVal = Math.max.apply(Math, valArray);
            var option = {
                grid: {
                    left: 80,
                    bottom: 25
                },
                tooltip: {
                    show: true
                },
                xAxis: {
                    type: "category",
                    data: dateLableArr,
                    offset: -13,
                    axisLabel: {
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
                    offset: 13,
                    show: true,
                    axisLabel: {
                        show: true,
                        color: "#bbb",
                        rich: {
                            value: {
                                width: 400
                            }
                        }
                    },
                    axisTick: {
                        show: false
                    },
                    axisLine: {
                        show: false
                    },
                    splitLine: {
                        show: false
                    },
                    boundaryGap: true
                },
                series: [
                {
                    data: valArray,
                    type: "line",
                    smooth: true,
                    symbolSize: "5",
                    itemStyle: {
                        normal: {
                            lineStyle: {
                            // width: 1,
                            color: "#00d0c2"
                            },
                            color: "#00d0c2"
                        }
                    }
                },
                {
                    data: loadArray,
                    type: "line",
                    smooth: true,
                    symbolSize: "5",
                    itemStyle: {
                        normal: {
                            lineStyle: {
                            // width: 1,
                            color: "#388cff"
                            },
                            color: "#388cff"
                        }
                    }
                }
                ]
            };
            // 为echarts对象加载数据
            myRegression.setOption(option);
        },
        initDistributionChart() {
            let el = document.getElementById("h_distribution_chart");
            if(!el) {
                return;
            }
            var myRegression = echarts.init(el);
            var labelFromatter = {
                normal : {
                    label : {
                        formatter : function (params){
                            return 100 - params.value + '%'
                        },
                        textStyle: {
                            baseline : 'top'
                        }
                    }
                },
                emphasis: {
                    color: '#01cfc2'
                }
            }
            var radius = [25, 55];
            let option = {

                series : [
                    {
                        type : 'pie',
                        // center : ['40%', '50%'],
                        radius : radius,
                        label: {
                            normal: {
                                color: '#888',
                                show: false,
                                position: 'outer'
                            },
                            emphasis: {
                                show: true,
                                textStyle: {
                                    fontSize: '30',
                                    fontWeight: 'bold'
                                }
                            }
                        },
                        labelLine : {
                            show : true,
                        },
                        itemStyle: {
                            normal: {
                                color: (params) => {
                                    let colorList = ['#f9354d', '#01cfc2', '#388cff']
                                    return colorList[params.dataIndex]
                                }
                            }
                        },
                        x:'20%', // for funnel
                        // itemStyle : labelFromatter,
                        data : this.pieChartRes
                    },
                    
                ]
            };
            // 为echarts对象加载数据
            myRegression.setOption(option);
        },
        loadInfo() {
            if(!this.houseId) {
                return;
            }
            this.$http({
                method: 'post',
                url: '/WxHouse/getHouseInfo',
                data: {
                    houseId: this.houseId
                },
                
            }).then((res) => {
                console.log(res.data);
                let data = res.data.data;
                if(!data.houseId) {

                }else {
                    this.houseInfo = data;
                }
                
            })
        },
        loadLoan() {
            if(!this.houseId) {
                return;
            }
            this.$http({
                url: 'WxLoan/list',
                method: 'post',
                data: {
                    houseId: this.houseId
                }
            }).then(res => {
                let data = res.data.data;
                if(res.data.statusCode == 1) {
                    this.loans = _.cloneDeep(data.list);
                    this.nextLoan = _.cloneDeep(data.next);
                }
            })
        },
        loadRent() {
            if(!this.houseId) {
                return;
            }
            this.$http({
                url: 'WxRent/selectNextRentList',
                method: 'post',
                data: {
                    houseId: this.houseId
                }
            }).then(res => {
                let data = res.data.data;
                if(res.data.statusCode == 1) {
                    this.rents = _.cloneDeep(data);
                }
            })
        },
        loadNextRent() {
            if(!this.houseId) {
                return;
            }
            this.$http({
                url: 'WxRent/selectNextRent',
                method: 'post',
                data: {
                    houseId: this.houseId
                }
            }).then(res => {
                let data = res.data.data;
                if(res.data.statusCode == 1) {
                    this.nextRent = _.cloneDeep(data);
                }
            })
        },
        loadAssetsInfo() {
            if(!this.houseId) {
                return;
            }
            this.$http({
                url: 'WxHouse/getAssetsInfo',
                method: 'post', 
                data: {
                    houseId: this.houseId
                }
            }).then(res => {
                let data = res.data.data;
                this.propertyRes = {
                    vals: data.housePrice ? data.housePrice[1] : [],
                    loans: data.loanPrice ? data.loanPrice[1] : [],
                    date: data.housePrice ? data.housePrice[0] : []
                }
                this.pieChartRes = [
                    {name:'按揭贷款', value: data.sd || 0},
                    {name:'房净值', value: data.housePriceNow || 0},
                    {name:'公积金贷款', value: data.gjj || 0}
                ]
                if(this.propertyRes.loans.length > 0) {
                    this.showValue = true;
                }
                this.$nextTick(() => {
                    this.initOwningsChart();
                    this.initDistributionChart();
                })
                
                this.finished = true;
                this.$store.commit('updateLoadingStatus', {isLoading: false})
            })
        },
        edit() {
            this.$router.push({path: '/addHouse', query: {type: 'edit', houseId: this.houseId}});
        }
    },
    created() {
        this.houseId = this.$route.query.houseId;
        let count = 1;
        for(let i = 0; i < 2; i++) {
            this.loans.push({
                id: count,
                bankName: bankTypes[count],
                type: count,
                typeName: '商业按揭',
                nextDate: '2018-08-30', //下次还款时间
                nextPay: 2304.17, //下期还款余额
                progress: count == 2 ? 100 : 42.71, //还款进度
                nextPeriod: 123, //下次还款期数
                period: 288 //总期数
            })
            count ++;
        }
        let m = 1;
        for(let i = 0; i < 2; i++) {
            this.rents.push({
                id: m,
                leaseTypeName: leaseTypes[m], //收租类型名称
                leaser: '刘某某',
                leaserPhone: '186****1234',
                type: m,
                nextDate: '2018-08-30', //下次收租时间
                nextPay: 34200, //下期租金
                hasReceived: 136800, //累计收租
                progress: m == 2 ? 100 : 42.71, //收租
                nextPeriod: 12, //下次还款期数
                period: 36 //总期数
            })
            m ++;
        }
        this.loadInfo()
        this.loadAssetsInfo();
        this.loadLoan();
        this.loadRent();
        this.loadNextRent();
    },
    mounted() {
        // this.initOwningsChart();
        // this.initDistributionChart();
    }
}
</script>
