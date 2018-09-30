<template>
    <div class="my_page">
        <group :gutter="0">
            <cell-box is-link link="/user">
                <div class="my_block_1">
                    <img class="my_persion_pic" :src="personPic" alt="">
                    <div class="my_block_1_right">
                        <div v-if="user" class="my_block_1_right_row_1">{{userInfo.nickname}}</div>
                        <div v-if="userInfo" class="my_block_1_right_row_2">{{userInfo.pwdMobile || '个人信息未完善'}}</div>
                    </div>
                </div>
            </cell-box>
            <ul class="my_block_2">
                <li @click="goBuy" class="my_block_2_item">
                    <img class="my_block_2_item_icon" :src="iconBuy" alt="">
                    <div class="my_block_2_item_label">
                        订阅<span class="my_block_2_item_label_num">({{buyCount}})</span>
                    </div>
                </li>
                <li @click="goMarks" class="my_block_2_item">
                    <img class="my_block_2_item_icon" :src="iconMark" alt="">
                    <div class="my_block_2_item_label">
                        关注<span class="my_block_2_item_label_num">({{mark}})</span>
                    </div>
                </li>
                <li @click="goMsg" class="my_block_2_item" :class="{'my_block_2_item_badge': is_msg}">
                    <img class="my_block_2_item_icon" :src="iconMessage" alt="">
                    <div class="my_block_2_item_label">
                        消息<span class="my_block_2_item_label_num">({{msgCount}})</span>
                    </div>
                </li>
            </ul>
            <div class="my_block_3">
                <swiper v-show="reportList.length > 0" :height="'2.2rem'" dots-position="center">
                    <swiper-item v-for="(item, index) in reportList" :key="index">
                        <div class="my_report_item" :style="{'background-image': 'url(' + bgReport + ')'}">
                            <div class="my_report_item_tit"><i v-if="item.isRead == 0" class="my_report_item_new dot_red"></i>[小区报告] {{item.communityName}}</div>
                            <div class="my_report_item_address">{{item.address}}</div>
                            <div class="my_report_item_date">
                                {{item.subscribeDate.replace(/-/g, '.')}}
                            </div>
                        </div>
                    </swiper-item>
                </swiper>
            </div>
        </group>
        <group>
            <cell title="消息设置" value="" is-link link="/msgSet"></cell>
            <cell title="在线客服" value="" is-link link="/service"></cell>
            <cell title="意见反馈" value="" is-link link="/feedback"></cell>
            <cell title="关于我们" value="V1.4" is-link link="/about"></cell>
        </group>
    </div>
</template>

<script>
import bgReport from 'assets/img/my/bg-report.png'
import iconMark from 'assets/img/my/icon-mark.png'
import iconMessage from 'assets/img/my/icon-message.png'
import personPic from 'assets/img/my/person-pic.png'
import iconBuy from 'assets/img/my/icon-buy.png'
import { CellBox, Group, Cell, Swiper, SwiperItem } from 'vux'
import { mapState } from "vuex"
import _ from 'lodash'

import 'assets/css/my/my.css'
export default {
    name: 'my',
    components: {
        CellBox,
        Cell,
        Group,
        Swiper,
        SwiperItem
    },
    data() {
        return {
            bgReport: bgReport,
            iconMark: iconMark,
            iconMessage: iconMessage,
            iconBuy: iconBuy,
            mark: 0, //关注数
            msgCount: 0, //消息数
            buyCount: 0, //订阅数
            is_msg: false, //是否有未读消息
            reportList: [],
            userInfo: null
        }
    },
    computed: {
        ...mapState({
            user: state => state.glb.user,
            userRegisted: state => state.glb.userInfo
        }),
        personPic() {
            return this.user ?  this.user.headUrl || personPic : personPic
        }
    },
    methods: {
        goMarks() {
            this.$router.push({path: '/marks'})
        },
        goMsg() {
            this.$router.push({path: '/msg'})
        },
        goBuy() {
            this.$router.push({path: '/buyList'})
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
            this.$http({
                url: 'WxMessage/getMessageListByUserId',
                method: 'post',
                data: {
                    page: 1,
                    rows: 10
                }
            }).then(res => {
                let data = res.data.dataCount;
                this.msgCount = data;
            })
        },
        getBuyList() {
            this.$http({
                url: 'WxUser/selectUserSubscribe',
                method: 'post',
                data: {}
            }).then(res => {
                if(res.data.statusCode == 1) {
                    this.reportList = res.data.data || [];
                    this.buyCount = res.data.dataCount;
                }
            })
        },
        getMark() {
            this.$http({
                url: 'WxUser/selectUserAttention',
                method: 'post',
                data: {
                    p: 1
                }
            }).then(res => {
                this.mark = res.data.dataCount;
            })
        },
        loadUser() {
            this.$http({
                url: 'WxUser/selectUserInfo',
                method: 'post',
                data: {}
            }).then(res => {
                if(res.data.statusCode == 1) {
                    this.$store.commit('updateUserInfoStatus', res.data.data);
                    this.userInfo = _.cloneDeep(res.data.data);
                }
            })
        }
    },
    created() {
        if(!this.userRegisted) {
            this.loadUser();
        }else {
            this.userInfo = _.cloneDeep(this.userRegisted);
        }
        this.getMsg();
        this.getBuyList();
        this.getMark();
    },
    mounted() {
        document.title = '我的';
    }
}
</script>
