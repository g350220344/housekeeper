<template>
    <div v-transfer-dom>
        <popup @on-hide="onHide" style="background: #f2f2f2;" v-model="show" position="bottom" height="9.49rem">
            <div class="bp_container">
                <img @click="show = false" class="bp_icon_close" :src="iconClose" alt="">
                <div class="bp_block_1">
                    <div class="bp_block_1_row_1">
                        {{res.commnuityName}}
                    </div>
                    <div class="bp_block_1_row_2 vux-1px-b">
                        <span style="margin-left: -0.1rem;">￥{{priceObj.price}}</span><span style="margin-left: 0.2rem;color: #bbb; font-size: 0.26rem; text-decoration: line-through;">原价 ￥{{priceObj.prePrice}}</span><span style="margin-left: 0.4rem;font-size: 0.26rem; color: #00d0c2;">{{pCount}}</span><span style="font-size: 0.26rem; color: #888;">人订阅</span>
                    </div>
                    <div class="bp_block_1_row_3">
                        <span><img class="bp_icon_ok" :src="iconOk" alt="">月度报告</span>
                        <span style="margin-left: 0.13rem;"><img class="bp_icon_ok" :src="iconOk" alt="">电子版</span>
                        <div @click="isNoticeShow = true" class="bp_block_1_row_3_right">
                            <img :src="iconHelp" alt="">
                            订阅须知
                        </div>
                    </div>
                    <div v-show="isNoticeShow" class="bp_block_1_row_4">
                        <div class="bp_block_1_row_4_ctn">
                            <p>1.订阅价格为单个小区的小区报告</p>
                            <p>2.报告期限：根据所选服务期限</p>
                            <p>3.报告格式为电子版</p>
                            <p>4.订阅成功后可在【我的】→【我的订阅】中查看</p>
                            <p>5.由于报告数据需要统计周期（如7月时统计6月数据），报告更新可能会产生一定天数的延迟</p>
                            <p>6.因电子文件特殊性，订阅成功后不支持退款</p>
                            <div @click="isNoticeShow = false" class="bp_block_1_row_4_up">
                                <img :src="iconArrow" alt="">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="bt_tit">报告类型</div>
                <div class="bt_block_2">
                    <checker v-model="type" default-item-class="bt_block_2_checker" selected-item-class="bt_block_2_checker_active">
                        <checker-item v-for="item in typeOptions" :key="item.value" :value="item.value">{{ item.name }}</checker-item>
                    </checker>
                </div>
                <div class="bt_tit">服务期限</div>
                <div class="bt_block_3">
                    <checker v-model="periodType" default-item-class="bt_block_2_checker" selected-item-class="bt_block_2_checker_active">
                        <checker-item style="margin-bottom: 0.28rem;" v-for="item in periodTypeOptions" :key="item.value" :value="item.value">{{ item.name }}</checker-item>
                    </checker>
                </div>
                <div class="bt_tit">报告内容</div>
            </div>
            <div class="bt_block_4">
                <img class="bt_chart_pic" :src="chartPic" alt="">
            </div>
            <div class="bt_buy_btn">立即订阅</div>
        </popup>
    </div>
</template>

<script>
import { Popup, Checker, CheckerItem, TransferDom } from 'vux'
import __CONFIG__ from 'assets/js/config'
import _ from 'lodash'

import iconOk from 'assets/img/report/icon-ok.png'
import iconHelp from 'assets/img/report/icon-help.png'
import chartPic from 'assets/img/report/chart.png'
import iconClose from 'assets/img/report/icon-close.png'
import iconArrow from 'assets/img/homepage/icon-arrow-right.png'

import 'assets/css/buy_pop.css'
export default {
    name: 'buy-pop',
    components: {
        Popup, Checker, CheckerItem
    },
    directives: {
        TransferDom
    },
    props: {
        popShow: {
            type: Boolean,
            default: false
        }
    },
    data() {
        return {
            iconOk: iconOk,
            iconHelp: iconHelp,
            chartPic: chartPic,
            iconClose: iconClose,
            iconArrow: iconArrow,
            show: this.popShow,
            priceMap: __CONFIG__.REPORT_PRICE_MAP,
            res: {
                commnuityName: '置地星月',
            },
            price: 0.9,
            pCount: 263, //订阅人数
            type: 1, //报告类型
            periodType: 1, //服务期限
            isNoticeShow: false,
            typeOptions: [{
                value: 1,
                name: '完整报告'
            }, {
                value: 2,
                name: '简要报告'
            }, {
                value: 3,
                name: '出售报告'
            }, {
                value: 4,
                name: '租赁报告'
            }],
            periodTypeOptions: [{
                value: 1,
                name: '2018年6月（共1期）'
            },{
                value: 2,
                name: '2018年6月~2018年12月（共6期）'
            },{
                value: 3,
                name: '2018年6月~2019年6月（共12期）'
            }]
        }
    },
    computed: {
        priceObj() {
            let obj = __CONFIG__.REPORT_PRICE_MAP[this.type - 1].options[this.periodType - 1]
            return obj || {}
        }
    },
    watch: {
        popShow(val) {
            if(val) {
                this.show = true;
            }
        }
    },
    methods: {
        onHide() {
            this.$emit('on-hide');
        },
        initPeriodOptions() {
            let res = [];
            let date = new Date();
            let lastMonth = `${date.getFullYear()}年${date.getMonth()}月`;
            console.log('lastMonth: ', lastMonth)
            res.push({
                value: 1,
                name: `${lastMonth}（共1期）`
            })
            let _m = date.getMonth() + 5;
            let m = _m > 12 ? _m % 12 : _m;
            let y = _m > 12 ? date.getFullYear() + 1 : date.getFullYear();
            res.push({
                value: 2,
                name: `${lastMonth}~${y}年${m}月（共6期）`
            })
            _m = date.getMonth() + 11;
            m = _m > 12 ? _m % 12 : _m;
            y = _m > 12 ? date.getFullYear() + 1 : date.getFullYear();
            res.push({
                value: 3,
                name: `${lastMonth}~${y}年${m}月（共12期）`
            })
            console.log(res);
            this.periodTypeOptions = _.cloneDeep(res);
            let obj = __CONFIG__.REPORT_PRICE_MAP[this.type - 1].options[this.periodType - 1]
            console.log('obj:  ', obj);
        }
    },
    created() {
        this.initPeriodOptions();
    },
    mounted() {

    }
}
</script>
