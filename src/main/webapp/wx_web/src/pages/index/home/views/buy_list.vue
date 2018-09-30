<template>
    <div class="bl_page">
        <div :style="{height: boxHeight}" class="bl_list_box">
            <scroll ref="wrapper" @scroll="onScroll" class="bl_wrapper" :data="list" :pullup="true" @pullup="pullup">
                <div ref="content" class="msg_content">
                    <i-card class="bl_list_item" v-for="(item, i) in list" :key="item.i" no-line :tit="item.name">
                        <img style="height: 0.21rem" slot="icon" :src="iconArrowRight" alt="">
                        <div class="bl_list_item_ctn" slot="ctn">
                            <img v-if="item.isNew" class="bl_list_item_icon_new" :src="iconNew" alt="">
                            <p class="bl_list_item_address">
                                {{item.address}}
                            </p>
                            <div class="bl_list_item_btm">
                                <div class="bl_list_item_btm_item">
                                    <div class="bl_list_item_btm_item_val">
                                        {{item.price}}<span class="bl_list_item_btm_item_val_unit">元/㎡</span>
                                    </div>
                                    <div class="bl_list_item_btm_item_label">
                                        出售均价
                                    </div>
                                </div>
                                <div class="bl_list_item_btm_item">
                                    <div class="bl_list_item_btm_item_val">
                                        {{item.dealCount}}<span class="bl_list_item_btm_item_val_unit">套</span>
                                    </div>
                                    <div class="bl_list_item_btm_item_label">
                                        本月成交
                                    </div>
                                </div>
                                <div class="bl_list_item_btm_item">
                                    <div class="bl_list_item_btm_item_val">
                                        {{item.leaseRatio}}%
                                    </div>
                                    <div class="bl_list_item_btm_item_label">
                                        租金收益率
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </i-card>
                </div>
                <div class="loading-wrapper">{{bottomTip}}</div>
            </scroll>
        </div>
        <div ref="btnBox" class="bl_btn_box">
            <div v-show="!noData" @click="goCompare" style="margin: 0.25rem auto 0.85rem;" class="sub_btn">价格对比</div>
        </div>
    </div>
</template>

<script>
import ICard from '../components/card'
import iconArrowRight from 'assets/img/homepage/icon-arrow-right.png'
import iconNew from 'assets/img/my/icon-new.png'
import Scroll from 'components/scroll';

import 'assets/css/my/buy_list.css'

export default {
    name: 'buy-list',
    components: {
        ICard, Scroll
    },
    data() {
        return {
            iconArrowRight: iconArrowRight,
            iconNew: iconNew,
            boxHeight: 0,
            fullHeight: 0,
            noData: false,
            page: 1,
            rows: 10,
            total: 0,
            list: [],
            bottomTip: '查看更多',
            res: {
                list: []
            }
        }
    },
    computed: {
        hasMore() {
            return this.list.length == 0 || this.list.length < this.total
        }
    },
    methods: {
        goCompare() {
            this.$router.push({path: '/compareChart'})
        },
        onScroll(pos, maxY) {
            if(this.hasMore && pos.y < (maxY + 30)) {
                this.bottomTip = '加载中...'
            }
        },
        pullup() {
            this.$nextTick(() => {
                this.loadData();
            })
        },
        loadData() {
            if(!this.hasMore) {
                return;
            }
            this.$http({
                url: 'WxUser/selectUserSubscribeDetail',
                method: 'post',
                data: {
                    p: this.page,
                    psize: this.rows
                }
            }).then((res) => {
                let data = res.data.data;
                this.total = res.data.dataCount;
                if(res.data.statusCode != 1) {
                    this.bottomTip = '暂无数据';
                    this.$store.commit('updateLoadingStatus', {isLoading: false})
                    this.noData = true;
                    return;
                }
                if(data.length > 0) {
                    let sub = data.map((item, index) => {
                        return {
                            communityId: item.communityId,
                            isNew: item.isRead == 0,
                            name: item.communityName,
                            address: item.address,
                            price: item.salesqmprice, //出售均价
                            dealCount: item.saleDealCount, //本月成交
                            leaseRatio: item.rentalPriceRatio //资金收益率
                        }
                    });
                    if(this.page == 1) {
                        this.$store.commit('updateLoadingStatus', {isLoading: false})
                        this.list = sub;
                    }else {
                        this.list = this.list.concat(sub);
                    }   
                }
                if(this.hasMore) {
                    this.page++;
                    this.bottomTip = '查看更多';
                }else {
                    this.bottomTip = '没有更多了';
                }
            })
        }
    },
    created() {
        this.loadData();
    },
    mounted() {
        this.boxHeight = document.body.clientHeight - this.$refs.btnBox.clientHeight + 'px';
        this.$refs.wrapper.$el.style.height = this.boxHeight;
        this.$refs.content.style.minHeight = this.$refs.wrapper.offsetHeight + 1 + "px";
        
    }
}
</script>
