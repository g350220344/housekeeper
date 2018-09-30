<template>
    <div class="msg_page" :style="{height: boxHeight}">
        <scroll ref="wrapper" @scroll="onScroll" class="msg_wrapper" :data="list" :pullup="true" @pullup="pullup">
            <div ref="content" class="msg_content"> 
                <div @tap="onClick(item)" :item="item" v-for="(item, i) in list" :key="i">
                    <i-card :is-new="item.isNew" :tit="item.title" type="msg" :msg-type="item.type" :sub-tit="item.date">
                        <img style="height: 0.21rem" slot="icon" :src="iconArrowRight" alt="">
                        <p class="msg_ctn" slot="ctn">
                            {{item.content}}
                        </p>
                    </i-card>
                </div>
                
            </div>
            <div class="loading-wrapper">{{bottomTip}}</div>
        </scroll>
    </div>
</template>

<script>
import iconArrowRight from 'assets/img/homepage/icon-arrow-right.png';
import Scroll from 'components/scroll';
import ICard from '../components/card';
import _ from 'lodash';
import { mapState } from "vuex";

import 'assets/css/index/msg.css';
export default {
    name: 'msg',
    components: {Scroll, ICard},
    data() {
        return {
            iconArrowRight: iconArrowRight,
            boxHeight: 0,
            fullHeight: 0,
            page: 1,
            rows: 10,
            total: 0,
            list: [],
            bottomTip: '查看更多',
            pulldown: true
        }
    },
    computed: {
        ...mapState({
            user: state => state.glb.user
        }),
        hasMore() {
            return this.list.length == 0 || this.list.length < this.total
        }
    },
    methods: {
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
        onClick(item) {
            if(item.isNew) {
                this.$http({
                    url: 'WxMessage/updateReadStatus',
                    method: 'post',
                    data: {
                        messageId: item.id
                    }
                }).then(res => {
                    if(res.data.statusCode == 1) {
                        this.$router.push({path: '/house', query: {houseId: item.dataId}})
                    }
                })
            }else {
                this.$router.push({path: '/house', query: {houseId: item.dataId}})
            }
        },
        loadData() {
            var arr = ['', '房价提醒', '月供提醒', '收租提醒'];
            if(!this.hasMore) {
                return;
            }
            this.$http({
                url: 'WxMessage/getMessageListByUserId',
                method: 'post',
                data: {
                    page: this.page,
                    rows: this.rows
                }
            }).then((res) => {
                if(res.data.statusCode == 1) {
                    let data = res.data;
                    this.total = data.dataCount;
                    if(data.data.length > 0) {
                        let sub = data.data.map(item => {
                            return {
                                id: item.id,
                                dataId: item.dataId,
                                isNew: item.isRead == 0,
                                title: arr[item.type],
                                date: item.createDate,
                                type: item.type,
                                content: item.title
                            }
                        });
                        if(this.page == 1) {
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
                    if(this.list.length == 0) {
                        this.bottomTip = '暂无数据';
                    }
                }else {
                    this.bottomTip = '暂无数据';
                }
                
            })
        }
    },
    created() {
        this.loadData();
    },
    mounted() {
        document.title = '消息';
        this.$refs.wrapper.$el.style.height = document.getElementById("app").offsetHeight + "px";
        this.$refs.content.style.minHeight = this.$refs.wrapper.offsetHeight + 1 + "px";
        this.boxHeight = document.body.clientHeight + 'px';
        // this.fullHeight = document.body.clientHeight + 'px';
        // this.fullHeight = document.body.clientHeight - this.$refs.noticeBar.clientHeight + 'px';
    }
}
</script>

