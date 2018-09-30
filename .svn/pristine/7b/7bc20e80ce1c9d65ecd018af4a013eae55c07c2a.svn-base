<template>
    <div class="loan_computer_page">
        <group class="i_cell" :gutter="0">
            <popup-radio title="贷款方式" :options="loanTypes" v-model="form.loanType"></popup-radio>

            <x-input title="房屋总价" v-model="form.value" text-align="right" :show-clear="false">
                <span style="padding-left: 0.1rem;" slot="right">万</span>
            </x-input>
            
            <x-input title="利率" v-model="form.interest" text-align="right" :show-clear="false">
                <span style="padding-left: 0.1rem;" slot="right">%</span>
            </x-input>
            <popup-radio title="利率折扣" :options="discountOptions" v-model="form.discount"></popup-radio>
            <popup-radio title="首付成数" :options="firstPays" v-model="form.firstPay"></popup-radio>
            <popup-radio :height="'50%'" title="贷款年限" :options="loanPeriods" v-model="form.period"></popup-radio>
        </group>
        <div @click="compute" style="margin-top: 0.85rem;" class="sub_btn" :class="{'sub_btn_disabled': !is_finish}">开始计算</div>
    </div>
</template>

<script>
// import 'assets/css/house/add_lease.css';
import { Group, Cell, CellBox, Datetime, XInput, PopupRadio } from 'vux'
const discountArr = [0.7, 0.8, 0.85, 0.9, 1, 1.1, 1.2, 1.3];
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
            loanTypes: ['商业贷款', '公积金贷款'],
            firstPays: [],
            loanPeriods: [],
            discountOptions: [],
            form: {
                loanType: '商业贷款',  //贷款方式
                discount: '基准利率', //利率折扣
                value: '', //房屋总价
                interest: 4.9, //利率
                firstPay: '3成', //首付成数
                period: '20年' //贷款年限
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
            let res = {
                loan: this.form.loan,
                // discount: this.discountArr[this.discountOptions.indexOf(this.form.discount)],
                value: this.form.value,
                interest: this.discountArr[this.discountOptions.indexOf(this.form.discount)] * this.form.interest,
                payment: (this.firstPays.indexOf(this.form.firstPay) + 1) / 10

            }
        }
    },
    created() {
        
        this.discountOptions = discountArr.map((item) => {
            let str = '基准利率';
            if(item < 1) {
                str += item * 10 + '折'
            }else if(item > 1) {
                str += item + '倍'
            }
            return str
        })
        for(let i = 1; i <= 9; i++) {
            this.firstPays.push(i + '成');
        }
        for(let i = 1; i <= 30; i++) {
            this.loanPeriods.push(i + '年')
        }
    },
    mounted() {
        document.title = '房贷计算器'
    }
}
</script>
