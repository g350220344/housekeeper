<template>
    <div class="marks_page" :style="{height: boxHeight}">
        <scroll ref="wrapper" @scroll="onScroll" class="marks_wrapper" :data="list" :pullup="true" @pullup="pullup">
            <div ref="content" class="marks_content"> 
                <div class="marks_list_item" @tap="onClick(item)" :item="item" v-for="item in list" :key="item.communityId">
                    <div class="marks_list_item_row">
                        <div class="marks_list_item_row_label">
                            <span class="marks_list_item_title">{{item.communityName}}</span>
                        </div>
                        <div class="marks_list_item_row_val"><img :src="iconArrowRight" alt=""></div>
                    </div>
                    <div class="marks_list_item_row">
                        <div class="marks_list_item_row_label">{{item.address}}</div>
                        <!-- <div class="marks_list_item_row_val">
                            <img :src="iconArrowRight" alt="">
                        </div> -->
                    </div>
                </div>
            </div>
            <div class="loading-wrapper">{{bottomTip}}</div>            
        </scroll>
    </div>
</template>

<script>
import iconArrowRight from 'assets/img/homepage/icon-arrow-right.png';
import Scroll from 'components/scroll';
import _ from 'lodash';
import { mapState } from 'vuex'
import tools from 'assets/js/tools'
import 'assets/css/my/marks.css';
export default {
    name: 'marks',
    components: { Scroll },
    data() {
        return {
            iconArrowRight: iconArrowRight,
            boxHeight: 0,
            page: 1,
            rows: 10,
            total: 0,
            list: [],
            bottomTip: ''
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
        onClick(item) {
            this.$router.push({path: '/community', query: {communityId: item.communityId}})
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
                url: 'WxUser/selectUserAttention',
                method: 'post',
                data: {
                    p: this.page,
                    psize: this.rows
                }
            }).then((res) => {
                let data = res.data;
                if(data.statusCode == 1) {
                    this.total = data.dataCount;
                    if(data.data.length > 0) {
                        let sub = _.cloneDeep(data.data).map(item => {
                            console.log(item.address, tools.getLength(item.address))
                            item.address = tools.getLength(item.address) > 40 ? item.address.substr(0, 20) + '...' : item.address;
                            return item;
                        })
                        if(this.page == 1) {
                            this.list = sub;
                        }else {
                            this.list = this.list.concat(sub);
                        }   
                    }
                    if(this.page == 1) {
                        this.$store.commit('updateLoadingStatus', {isLoading: false})
                    }
                    if(this.hasMore) {
                        this.page++;
                        this.bottomTip = '查看更多';
                    }else {
                        this.bottomTip = '没有更多了';
                    }
                }else {
                    this.bottomTip = '暂无数据';
                    this.$store.commit('updateLoadingStatus', {isLoading: false})
                }
                
                
            })
        }
    },
    created() {
        this.loadData();
    },
    mounted() {
        document.title = '我的关注'
        this.$refs.wrapper.$el.style.height = document.getElementById("app").offsetHeight + "px";
        this.$refs.content.style.minHeight = this.$refs.wrapper.offsetHeight + 1 + "px";
        this.boxHeight = document.body.clientHeight + 'px';
    }
}
</script>

