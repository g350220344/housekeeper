<template>
    <div style="height: 100%; overflow: hidden; background: #fff;">
        <div ref="inputBox" class="search_input_box vux-1px-b">
            <div @click="changeCity" class="search_input_box_city">
                {{validCity.cityName}}<img class="search_input_box_city_icon" :src="iconArrowDown" alt="">
            </div>
            <input v-model="searchKey" class="search_input_box_inner" type="text" placeholder="搜索小区/地址">
            <div @click="cancel" class="search_input_box_cancel">取消</div>
        </div>
        <div :style="{height: resHeight}" class="search_scroll_wrap">
            <div v-if="showHistory && history.length > 0" class="search_history_box">
                <div class="search_history_box_tool">
                    搜索历史
                    <img :src="iconBin" alt="">
                </div>
                <ul>
                    <li @click="onClickHistory(item)" v-for="item in history" :key="item.id">{{item.communityname}} <span>({{item.cityName}})</span></li>
                </ul>
            </div>
            <ul v-if="list.length > 0" class="search_res_box vux-1px-b">
                <li @click="onClick(item)" v-for="item in list" :key="item.communityId" class="search_res_item vux-1px-b">
                    <div class="search_res_item_name">{{item.communityname}}</div>
                    <div class="search_res_item_address">{{item.detailaddress || ''}}</div>
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
import { throttle } from 'vux'
import iconArrowDown from 'assets/img/house/icon-arrow-down.png';
import iconBin from 'assets/img/house/icon-bin.png';
import { mapState } from "vuex";
import _ from 'lodash'

import 'assets/css/search.css';
export default {
    name: 'search',
    data() {
        return {
            iconArrowDown: iconArrowDown,
            iconBin: iconBin,
            type: 1, //1:进入小区页 2:来源于为表单
            resHeight: 0,
            showHistory: true,
            history: [],
            list: [],
            searchKey: ''
        }
    },
    computed: {
        ...mapState({
            city: state => state.glb.curCity,
            formCity: state => state.glb.formCity,
            user: state => state.glb.user
        }),
        validCity() {
            return this.type == 1 ? this.city : this.formCity ? this.formCity : this.city
        }
    },
    methods: {
        cancel() {
            this.$router.go(-1);
        },
        changeCity() {
            this.$router.push({path: '/city', query: {type: 1}})
        },
        load() {
            this.$http({
                url: 'WxCommunity/searchCommunity',
                method: 'post',
                data: {
                    cityId: this.validCity.cityId,
                    communityName: this.searchKey
                }
            }).then(res => {
                let data = res.data.data;
                if(data && data.length > 0) {
                    this.list = _.cloneDeep(data);
                }else {
                    this.list = [];
                }
            })
        },
        onClick(item) {
            console.log(item.communityId);
            let his = localStorage.getItem(`his_${this.user.userId}`);
            if(!his) {
                localStorage.setItem(`his_${this.user.userId}`, JSON.stringify([item]));
            }else {
                his = JSON.parse(his);
                let _index = -1;
                for(let i in his) {
                    if(his[i].communityId == item.communityId) {
                        _index = i;
                        break;
                    }
                }
                if(_index > -1) {
                    his.splice(_index,1);
                }else if(his.length == 5) {
                    his.length = 4;
                }
                his.unshift(item);
                console.log('_his:  ', his)
                localStorage.setItem(`his_${this.user.userId}`, JSON.stringify(his));
            }
            this.sub(item);
        },
        onClickHistory(item) {
            this.sub(item);
        },
        sub(item) {
            if(this.type == 1) {
                this.$router.push({path: '/community', query: {communityId: item.communityId, communityname: item.communityname}})
            }else if(this.type == 2) {
                this.$store.commit('updateFormCommunityStatus', item)
                if(this.formCity.cityId != item.cityId) {
                    let _tmp = _.cloneDeep(this.formCity);
                    _tmp.cityId = item.cityId;
                    _tmp.cityName = item.cityName;
                    _tmp.districtId = item.districtId;
                    _tmp.districtName = item.districtName;
                    this.$store.commit('updateFormCityStatus', _tmp);
                }
                
                this.$router.go(-1);
            }
        }
    },
    watch: {
        searchKey(val) {
            let throttled = throttle(this.load, 500,{ 'trailing': true } )
            if(!val) {
                this.showHistory = true;
                this.list.length = 0;
            }else {
                this.showHistory = false;
                throttled();
            }
        }
    },
    created() {
        this.type = this.$route.query.type;
        let his = localStorage.getItem(`his_${this.user.userId}`);
        if(!!his) {
            this.history = JSON.parse(his);
        }
        console.log('history:  ', this.history)
    },
    mounted() {
        document.title = '搜索小区'
        this.resHeight = document.body.clientHeight - this.$refs.inputBox.clientHeight + 'px';
        console.log('resHeight', this.resHeight)
    }
}
</script>
