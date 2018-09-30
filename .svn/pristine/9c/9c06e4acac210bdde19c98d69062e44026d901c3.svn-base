<template>
    <div>
        <group class="i_cell" :gutter="0">
            <popup-radio title="房屋类型" :options="houseOptions" v-model="form.houseType"></popup-radio>
            <popup-radio title="唯一住房" :options="onlyOptions" v-model="form.isOnly"></popup-radio>

            <x-input title="房屋总价" v-model="form.value" text-align="right" :show-clear="false">
                <span style="padding-left: 0.1rem;" slot="right">万</span>
            </x-input>
            
            <x-input title="房屋面积" v-model="form.area" text-align="right" :show-clear="false">
                <span style="padding-left: 0.1rem;" slot="right">㎡</span>
            </x-input>
            <popup-radio title="出证年限" :options="periodOptions" v-model="form.period"></popup-radio>
            <popup-radio title="总楼层" :options="floorOptinos" v-model="form.allFloor"></popup-radio>
        </group>
        <div @click="compute" style="margin-top: 0.85rem;" class="sub_btn" :class="{'sub_btn_disabled': !is_finish}">开始计算</div>
    </div>
</template>

<script>
// import 'assets/css/house/add_lease.css';
import { Group, Cell, CellBox, Datetime, XInput, PopupRadio } from 'vux'

export default {
    name: 'loan-computer',
    components: {
        Group,
        Cell,
        CellBox,
        Datetime,
        XInput,
        PopupRadio
    },
    data() {
        return {
            houseOptions: ['二手房', '新房'],
            onlyOptions: ['唯一', '不唯一'],
            periodOptions: ['2年以内', '2年以上'],
            floorOptinos: ['8层以上', '8层以下'],
            form: {
                houseType: '二手房',  //房屋类型
                value: 300, //房屋总价
                area: 120, //房屋面积
                isOnly: '唯一',
                period: '2年以内', //出证年限
                allFloor: '8层以下'
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
        }
    },
    methods: {
        compute() {
            if(!this.is_finish) {
                return;
            }
            this.$router.push({
                path: '/taxComputeRes',
                query: {
                    houseType: this.houseOptions.indexOf(this.form.houseType),
                    value: this.form.value,
                    area: this.form.area,
                    period: this.periodOptions.indexOf(this.form.period),
                    allFloor: this.floorOptinos.indexOf(this.form.allFloor),
                    isOnly: this.onlyOptions.indexOf(this.form.isOnly)
                }
            })
        }
    },
    created() {
        
    },
    mounted() {
        document.title = '税费计算器'
    }
}
</script>
