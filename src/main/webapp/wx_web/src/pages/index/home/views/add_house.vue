<template>
    <div class="add_house_page">
        <group :gutter="0">
            <cell title="选择城市" :value="city.cityName || '请选择'" is-link :link="{path: '/city', query: {type: 2}}"></cell>
            <cell title="房产地址" value="请选择" is-link :link="{path: '/search', query: {type: 2}}">
                <template v-if="community">
                    <div>{{community.communityname}}</div>
                    <div v-if="community.detailaddress" style="margin-top: 0.1rem;">{{community.detailaddress}}</div>
                </template>
            </cell>
            <x-input title="建筑面积" v-model="form.area" text-align="right" :is-type="areaCheck" :show-clear="false">
                <span style="padding-left: 0.1rem;" slot="right">㎡</span>
            </x-input>
            <datetime
                v-model="form.date"
                format="YYYY-MM"
                @on-change="change"
                title="购入时间"
                placeholder="选择日期"
                @on-cancel="onCancel"
                @on-confirm="onConfirm"
                @on-hide="log('hide', $event)"></datetime>
            <x-input title="购入价格" v-model="form.buyPrice" text-align="right" :is-type="areaCheck" :show-clear="false">
                <span style="padding-left: 0.1rem;" slot="right">万</span>
            </x-input>
        </group>
        <div @click="submit" style="margin-top: 0.85rem;" class="sub_btn" :class="{'sub_btn_disabled': !is_finish}">立即评估</div>
        <div v-if="type == 'edit'" @click="del" style="margin-top: 0.55rem;color: #f9354d; text-align: center; font-size: 0.28rem;text-decoration-line: underline;">删除房产</div>

    </div>
</template>

<script>
import { mapState } from "vuex";
import { Group, Cell, CellBox, Datetime, XInput } from 'vux'
import _ from 'lodash'
import 'assets/css/house/add_house.css';
export default {
    name: 'add-house',
    components: {
        Group,
        Cell,
        CellBox,
        Datetime,
        XInput
    },
    data() {
        return {
            houseId: '',
            type: '',
            house: null,
            form: {
                area: '',
                date: '',
                buyPrice: ''
            }
        }
    },
    computed: {
        is_finish() {
            for(let k in this.form) {
                if(!this.form[k]) {
                    return false;
                }
            }
            return true
        },
        ...mapState({
            location: state => state.glb.city,
            city: state => state.glb.formCity,
            community: state => state.glb.formCommunity
        })
    },
    methods: {
        clear() {
            this.form = {
                area: '',
                date: '',
                buyPrice: ''
            }
            this.type = '';
            this.house = null;
            this.$store.commit('updateFormCommunityStatus', null);
            this.$store.commit("updateFormCityStatus", this.location);
        },
        del() {
            this.$http({
                url: 'WxHouse/deleteHouse',
                method: 'post',
                data: {
                    houseId: this.$route.query.houseId
                }
            }).then(res => {
                if(res.data.statusCode == 1) {
                    this.$router.replace({path: '/myHouse'})
                }
            })
        },
        areaCheck(val) {
            if(isNaN(val * 1)) {
                return {
                    valid:false, msg:'请输入数字'
                }
            }else {
                return {valid:true}
            }
        },
        log (str1, str2 = '') {
            console.log(str1, str2)
        },
        change() {

        },
        onConfirm(val) {
            console.log('on-confirm arg', val)
        },
        onCancel() {

        },
        submit() {
            if(!this.is_finish) {
                return;
            }
            let data = {
                cityId: this.city.cityId,
                cityName: this.city.cityName,
                communityId: this.community.communityId,
                communityName: this.community.communityname,
                districtId: this.community.districtId,
                districtName: this.community.districtName,
                provinceId: this.city.provinceId || '',
                provinceName: this.city.provinceName || '',
                address: this.community.detailaddress || '',
                buildingsquare: this.form.area,
                buyTime: this.form.date + '-01',
                buyPrice: this.form.buyPrice
            }
            if(this.type == 'edit') {
                data['houseId'] = this.houseId;
            }
            this.$http({
                url: 'WxHouse/addHouse',
                method: 'post',
                data: data
            }).then(res => {
                if(res.data.statusCode == 1) {
                    this.$router.go(-1);
                }
            })
            
        },
        load() {
            this.$http({
                method: 'post',
                url: '/WxHouse/getHouseInfo',
                data: {
                    houseId: this.houseId
                },
                
            }).then((res) => {
                console.log(res.data);
                let data = res.data.data;
                this.house = _.cloneDeep(data);
                let community = {
                    cityId: data.cityId,
                    cityName: data.cityName,
                    districtId: data.districtId,
                    districtName: data.districtName,
                    communityId: data.communityId,
                    communityname: data.communityName,
                    detailaddress: data.address,
                    
                };
                let formCity = {
                    cityId: data.cityId,
                    cityName: data.cityName,
                    districtId: data.districtId,
                    districtName: data.districtName,
                }
                this.$store.commit('updateFormCommunityStatus', community)
                this.$store.commit('updateFormCityStatus', formCity);
                this.form = {
                    area: data.buildingsquare,
                    date: data.buyTime.substr(0, data.buyTime.length - 3),
                    buyPrice: data.buyPrice
                }
            })
        }
    },
    beforeRouteLeave(to, from, next) {
        console.log(to.path)
        if(!(to.path == '/city' || to.path == '/search')) {
            this.clear();
        }
        next()
        // called when the route that renders this component is about to
        // be navigated away from.
        // has access to `this` component instance.
    },
    // watch: {
    //     '$route'(to, from) {
    //         console.warn(from.path);
    //         if(!(from.path == '/city' || from.path == '/search')) {
    //             if(this.$route.query.type == 'edit') {
    //                 this.type = 'edit';
    //                 this.houseId = this.$route.query.houseId;
    //                 this.load();
    //             }
    //         }
    //     }
    // },
    activated() {
        if(this.$route.query.type == 'edit') {
            this.type = 'edit';
            this.houseId = this.$route.query.houseId;
            if(!this.house) {
                this.load();
            }
        }
    },
    mounted() {
        document.title = '添加房产'
    }
}
</script>
