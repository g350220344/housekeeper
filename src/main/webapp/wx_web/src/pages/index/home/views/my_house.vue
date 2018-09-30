<template>
    <div>
        <template v-if="list.length > 0">
            <div v-if="user_house" class="mh_info_block">
                <div class="mh_info_block_line_1">我的房产总估值（万元）</div>
                <div class="mh_info_block_line_2">{{user_house.totalPrice}}</div>
                <div class="mh_info_block_line_3">
                    土豪，你的房产总值超过了全国 {{user_house.sortPercent}}% 的人
                </div>
                <div @click="goHavingsReport" class="mh_house_report_btn">持产报告</div>
                <div class="mh_info_block_line_4 vux-1px-t">
                    <div class="mh_info_block_line_4_item">
                        房产已升值
                        <img v-if="user_house.totalAppreciation >= 0" :src="iconRease" alt="">
                        <img v-else :src="iconDecrease" alt="">
                        <span class="mh_info_block_line_4_item_val">{{(`${user_house.totalAppreciation}`).replace('-','')}}万元</span>
                    </div>
                    <div class="mh_info_block_line_4_item">
                        升值增长率
                        <img v-if="user_house.appreciationPercent >= 0" :src="iconRease" alt="">
                        <img v-else :src="iconDecrease" alt="">
                        <span class="mh_info_block_line_4_item_val">{{(`${user_house.appreciationPercent.toFixed(2)}`).replace('-','')}}%</span>
                    </div>
                    <div class="mh_info_block_line_4_divider"></div>
                </div>
            </div>
            <div v-if="user_house" class="mh_block_2">
                <div class="mh_block_2_item">
                    <div class="mh_block_2_item_val">{{user_house.loanPrice}}元</div>
                    <div class="mh_block_2_item_label">本月月供支出</div>
                    <img :src="iconPay" class="mh_block_2_item_icon">
                </div>
                <div class="mh_block_2_item">
                    <div class="mh_block_2_item_val">{{user_house.rentPrice}}元</div>
                    <div class="mh_block_2_item_label">本月租金收益</div>
                    <img :src="iconIncoming" class="mh_block_2_item_icon">
                </div>
            </div>
            <div class="mh_block_3">
                <div class="mh_block_3_tool">
                    <div class="mh_block_3_tool_tit">共{{list.length}}套房产</div>
                    <div @click="addHouse" class="mh_block_3_tool_right">
                        <img :src="iconAdd" alt="">添加
                    </div>
                </div>
                <i-card v-for="item in list" :key="item.houseId" no-line :tit="item.communityName" @click.native="goHouse(item)">
                    <img style="height: 0.21rem" slot="icon" :src="iconArrowRight" alt="">
                    <div class="mh_house_ctn" slot="ctn">
                        <p class="mh_house_address">
                            {{item.address || ''}}
                        </p>
                        <div class="mh_house_line_2">
                            <div class="mh_house_line_2_item">
                                <div class="mh_house_line_2_item_val">
                                    <img v-if="item.assessSaleTotalPrice >= 0" :src="iconRease" alt="">
                                    <img v-else :src="iconDecrease" alt="">
                                    {{(item.assessSaleTotalPrice + '').replace('-','')}}
                                </div>
                                <div class="mh_house_line_2_item_label">房产估值 (万元) </div>
                            </div>
                            <div class="mh_house_line_2_item">
                                <div class="mh_house_line_2_item_val">
                                    <img v-if="item.increasePrice >= 0" :src="iconRease" alt="">
                                    <img v-else :src="iconDecrease" alt="">
                                    {{(item.increasePrice + '').replace('-','')}}
                                </div>
                                <div class="mh_house_line_2_item_label">房产增值 (万元) </div>
                            </div>
                        </div>
                        <div class="mh_house_line_3 vux-1px-t">
                            <div class="mh_house_line_3_item">月供支出  {{item.loanPrice}}元/月</div>
                            <div class="mh_house_line_3_item" style="text-align: right;">租金收益  {{item.rentPrice}}元/月</div>
                        </div>
                    </div>
                    
                </i-card>
            </div>
        </template>
        <template v-else>
            <img style="width: 2.83rem;height: 1.69rem; display: block; padding-top: 1.45rem;margin: auto;" :src="emptyState" alt="">
            <div style="padding-top: 0.32rem;text-align: center; line-height: 0.23rem; font-size: 0.24rem;color: #bbb; ">看看我的房子为我赚了多少钱</div>
            <div @click="addHouse" style="margin: 0.96rem auto 0;width: 2.2rem; line-height: 0.58rem; border: 1px solid #4b9af8; border-radius: 0.29rem; font-size: 0.26rem; color: #388cff; text-align: center;">
                <img style="vertical-align: middle;margin-bottom: 0.02rem;width: 0.24rem; height: 0.24rem;" :src="iconAdd" alt=""> 添加房产
            </div>
        </template>
    </div>
</template>

<script>
import iconPay from 'assets/img/house/icon-pay.png';
import iconIncoming from 'assets/img/house/icon-incoming.png';
import iconAdd from 'assets/img/homepage/icon-add.png';
import iconArrowRight from 'assets/img/homepage/icon-arrow-right.png';
import emptyState from 'assets/img/homepage/empty-state.png';
import iconRease from 'assets/img/homepage/icon-rease.png'
import iconDecrease from 'assets/img/homepage/icon-decrease.png'

import { mapState } from "vuex";
import _ from 'lodash'
import ICard from '../components/card';
import 'assets/css/house/my_house.css';
export default {
    name: 'my_house',
    components: { ICard },
    data() {
        return {
            iconRease: iconRease,
            iconDecrease: iconDecrease,
            emptyState: emptyState,
            iconPay: iconPay,
            iconIncoming: iconIncoming,
            iconAdd: iconAdd,
            iconArrowRight: iconArrowRight,
            user_house: null,
            list: []
        }
    },
    computed: {
        ...mapState({
            city: state => state.glb.curCity,
            user: state => state.glb.user
        })
    },
    methods: {
        addHouse() {
            this.$router.push({path: '/addHouse'})
        },
        goHavingsReport() {
            // 进入持产报告
            this.$router.push({path: '/havingsReport'})
        },
        goHouse(item) {
            this.$router.push({path: '/house', query: {houseId: item.houseId}})
        },
        myHouse() {
            this.$http({
                url: 'WxHouse/getHouseAvmByUserId',
                method: 'post'
            }).then(res => {
                let data = res.data.data;
                this.user_house = _.cloneDeep(data);
            })
        },
        loadList() {
            this.$http({
                url: 'WxHouse/getHouseList',
                method: 'post'
            }).then(res => {
                let data = res.data.data;
                if(data.length > 0) {
                    this.list = _.cloneDeep(data);
                }
            })
        }
    },
    created() {
        this.myHouse();
        this.loadList();
    },
    mounted() {
        
    }
}
</script>
