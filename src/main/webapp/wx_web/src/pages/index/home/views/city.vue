<template>
    <div class="search-page">
        <ul @click.stop="searchPin" class="s_citynav">
            <li>热门</li>
            <li>A</li>
            <li>B</li>
            <li>C</li>
            <li>D</li>
            <li>E</li>
            <li>F</li>
            <li>G</li>
            <li>H</li>
            <li>I</li>
            <li>J</li>
            <li>K</li>
            <li>L</li>
            <li>M</li>
            <li>N</li>
            <li>O</li>
            <li>P</li>
            <li>Q</li>
            <li>R</li>
            <li>S</li>
            <li>T</li>
            <li>W</li>
            <li>X</li>
            <li>Y</li>
            <li>Z</li>
        
        </ul>
    
        <div class="c_search_box">
            <div class="c_search_input">
                <img :src="iconSearch" class="ding_w" onclick="cityName()">
                <input v-model="key" class="text required" type="search" placeholder="搜索城市名称"  name = "cityName" >
            </div>
            <div @click="cancel" class="c_cancel_btn">取消</div>
        </div>
        <div @click="setFromDw" class="c_cur_city_box">
            <div class="c_cur_city_left">
                <img :src="iconDing" alt="" class="ding_w">
                <span>{{city.cityName || '定位失败，请手动选择'}}</span>
            </div>
            <div class="c_cur_city_right">当前城市</div>
        </div>
        <dl v-if="!!hotList && hotList.length > 0" class="c_hotcity">
            <dt>热门城市</dt>
            <dd @click="setRes(item)" v-for="item in hotList" :key="item.cityId">{{item.cityName}}</dd>
        </dl>
        <dl class="c_citylist" id="a">
            <dt v-if="list.length == 0" style='text-align: center'>暂无匹配结果</dt>
            <template v-if="list.length > 0 && search_type == 'all'" v-for="(value, _key) in pinRenderObj">
                <dt :id="'p_' + _key">{{_key}}</dt>
                <dd @click="setRes(item)" v-for="item in value" :key="item.cityId">
                    <div class="vux-1px-b">{{item.cityName}}</div>
                </dd>
            </template>
            <template v-if="list.length > 0 && search_type == 'key'">
                <dt>搜索结果</dt>
                <dd @click="setRes(item)" v-for="item in list" :key="item.cityId">
                    <div class="vux-1px-b">{{item.cityName}}</div>
                </dd>
            </template>
            <template v-if="list.length > 0 && search_type == 'nav'">
                <dt>{{pin}}</dt>
                <dd @click="setRes(item)" v-for="item in list" :key="item.cityId">
                    <div class="vux-1px-b">{{item.cityName}}</div>
                </dd>
            </template>
        </dl>
    </div>
</template>

<script>
let timer = null;
import iconSearch from 'assets/img/city/search.png'
import iconDing from 'assets/img/city/ding.png'
import { mapState } from "vuex";
import wx from 'wx';
import _ from 'lodash'

import 'assets/css/city.css'

export default {
    name: 'city',
    data() {
        return {
            iconSearch: iconSearch,
            iconDing: iconDing,
            // show: this.isShow,
            key: '',
            allList: [],
            list: [],
            hotList: [],
            pinRenderObj: {},
            search_type: 'all',
            pin: 'A',
            dwCity: {}
        }
    },
    computed: {
        ...mapState({
            city: state => state.glb.city,
            community: state => state.glb.formCommunity,
            user: state => state.glb.user
        })
    },
    watch: {
        key(val) {
            let throttled = _.throttle(() => {
                this.search(val);
            }, 500,{ 'trailing': true } )
            throttled();
        }
    },
    methods: {
        cancel() {
            this.$router.go(-1);
        },
        renderByPin() {
            var list = this.list.map(function(item) {
                var cur = item;
                cur.pin = item.cityPy[0];
                return cur;
            })
            this.pinRenderObj = _.groupBy(list, 'pin');
        },
        search(key) {
            if(key === '') {
                this.search_type = 'all';
                if(this.allList.length > 0) {
                    this.list = _.cloneDeep(this.allList);
                    this.renderByPin();
                    return;
                }
            }
            this.$http.get('city/getCityInfoListByCityNameAndPinyin', {
                params: {
                    cityName: key
                }
            }).then((res) => {
                let data = res.data.data;
                if(key === '') {
                    this.allList = _.cloneDeep(data);
                }
                this.list = _.cloneDeep(data);
                this.renderByPin()
            }).catch((res) => {

            }).then(() => {
                // always executed
            }); 
        
        },
        searchByname(key) {
            var vm = this;
            var params = "cityPy=" + key;
            this.$http.get('city/getCityInfoListBycityName', {
                params: {
                    cityPy: key
                }
            }).then((res) => {
                let data = res.data.data;
                this.list = data;
            }).catch((res) => {

            }).then(() => {
                // always executed
            }); 
        },
        loadHotCity() {
            this.$http.get('city/getCityInfoListHoT').then((res) => {
                let data = res.data.data;
                this.hotList = data;
            }).catch((res) => {

            }).then(() => {
                // always executed
            });
        },
        searchPin() {
            console.log(event.target.tagName.toLowerCase());
            if(event.target.tagName.toLowerCase() == 'li') {
                this.search_type = 'nav';
                this.pin = event.target.innerHTML;
                if(this.pin !== '热门') {
                    this.searchByname(event.target.innerHTML);
                }
            }
        },
        setFromDw() { //选择定位城市
            if(this.city.cityId) {
                // if(this.$route.query.type == 1) {
                //     this.$store.commit('updateCurCityStatus', this.city);
                // }else {
                //     this.$store.commit('updateFormCityStatus', this.city);
                // }
                this.sub(this.city);
                this.$router.go(-1);
            }else {
                // this.$store.dispatch('updateWxConfig');
            }
        },
        setRes(item) { //从搜索结果中选择
            let _tmp = this.city || {};
            if(_tmp.cityId != item.cityId) {
                _tmp = item
            }
            // if(this.$route.query.type == 1) {
            //     this.$store.commit('updateCurCityStatus', _tmp);
            // }else {
            //     this.$store.commit('updateFormCityStatus', _tmp);
            // }
            this.sub(_tmp);
            this.$router.go(-1);
        },
        sub(res) {
            if(this.$route.query.type == 1) {
                this.$store.commit('updateCurCityStatus', res);
            }else {
                this.$store.commit('updateFormCityStatus', res);
                if(this.community.cityId != res.cityId) {
                    this.$store.commit('updateFormCommunityStatus', null);
                }
            }
            
        }
    },
    created() {
        this.loadHotCity();
        this.search('');
    },
    mounted() {
        document.title = '城市搜索';
        // this.dw();
        // this.search('');
    }
}
</script>
