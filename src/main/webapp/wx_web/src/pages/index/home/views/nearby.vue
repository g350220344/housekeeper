<template>
    <div class="nearby_page" :style="{height: boxHeight}">
        <div ref="noticeBar" class="notice">您附近共找到{{total}}个小区</div>
        <scroll ref="wrapper" @scroll="onScroll" class="msg_wrapper" :data="list" :pullup="true" @pullup="pullup">
            <div ref="content" class="nearby_content"> 
                <div @click="onClick(item)" :item="item" v-for="(item, i) in list" :key="i">
                    <cmt-pannel :item="item"></cmt-pannel>
                </div>
            </div>
            <div class="loading-wrapper">{{bottomTip}}</div>
        </scroll>
    </div>
</template>

<script>
import Scroll from 'components/scroll';
import CmtPannel from '../components/cmt_pannel';
import _ from 'lodash';
import { mapState } from "vuex";
import 'assets/css/index/nearby.css';

export default {
    name: 'nearby',
    components: {Scroll, CmtPannel},
    data() {
        return {
            boxHeight: 0,
            fullHeight: 0,
            rang: 1000, //搜索半径
            page: 1,
            rows: 10,
            total: 0,
            list: [],
            pulldown: true,
            bottomTip: '查看更多',
        }
    },
    computed: {
        ...mapState({
            city: state => state.glb.city
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
            this.$router.push({path: '/community', query: {communityId: item.communityId}})
        },
        loadData() {
            var arr = ['', '房价提醒', '月供提醒', '收租提醒'];
            if(!this.hasMore) {
                return;
            }
            this.$http({
                url: 'WxCommunity/searchNearCommunity',
                method: 'post',
                data: {
                    lat: this.city.lat,
                    lng: this.city.lng,
                    rang: this.rang,
                    page: this.page,
                    rows: this.rows
                }
            }).then((res) => {
                let data = res.data;
                // console.log(data);
                this.total = data.dataCount;
                if(data.data.length > 0) {
                    let sub = _.cloneDeep(data.data);
                    if(this.page == 1) {
                        this.list = sub;
                    }else {
                        this.list = this.list.concat(sub);
                    }   
                }else {
                    let sub = [];
                    this.total = 10;
                    for (let i = 0; i < 10; i++) {
                        sub.push({
                            id: i,
                            "communityName": "傲城国际",
                            "Detailaddress": "平准街69号",
                            "Salesqmprice": 10193,
                            "distance": 162,
                            "direction": "北",
                            "buildYear": "2000"
                        })
                    }
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
                    if(this.total > 0) {
                        this.bottomTip = `已显示全部${this.total}个小区`
                    }else {
                        this.bottomTip = '暂无数据'
                    }
                    
                }
            })
        }
    },
    created() {
        this.loadData();
    },
    mounted() {
        this.boxHeight = document.body.clientHeight - 51 + 'px';
        // this.fullHeight = document.body.clientHeight - this.$refs.noticeBar.clientHeight + 'px';
        this.$refs.wrapper.$el.style.height = document.getElementById("app").offsetHeight - this.$refs.noticeBar.clientHeight + "px";
        this.$refs.content.style.minHeight = this.$refs.wrapper.offsetHeight + 1 + "px";
    }
}
</script>

