<template>
    <div>
        <group class="i_cell" :gutter="0">
            <datetime
                v-model="form.date"
                format="YYYY-MM-DD"
                @on-change="change"
                title="贷款起始日"
                placeholder="选择日期"
                @on-cancel="onCancel"
                @on-confirm="onConfirm"
                @on-hide="log('hide', $event)"></datetime>
            <popup-radio title="贷款期限" :options="termOptions" v-model="form.loanPeriod"></popup-radio>
            <popup-radio placeholder="请选择" title="贷款类型" :options="loanTypes" v-model="form.loanType"></popup-radio>
            <popup-radio placeholder="请选择" title="贷款渠道" :options="loanMethods" v-model="form.loanMethod"></popup-radio>
            <cell title="贷款金额">
                <input v-model="form.loan" class="add_loan_inline_input" type="text" placeholder="必填"> 万 | 年利率 <input v-model="interest" class="add_loan_inline_input" type="text" placeholder="必填"> %
            </cell>
            <popup-radio title="还款方式" :options="payTypes" v-model="form.payType"></popup-radio>
        </group>
        <div @click="submit" style="margin-top: 0.85rem;" class="sub_btn" :class="{'sub_btn_disabled': !is_finish}">立即评估</div>
        <div v-if="is_edit" @click="del" style="margin-top: 0.55rem;color: #f9354d; text-align: center; font-size: 0.28rem;text-decoration-line: underline;">删除贷款</div>
    </div>
</template>

<script>
import 'assets/css/house/add_loan.css';
import { Group, Cell, Datetime, PopupRadio } from 'vux'

export default {
    name: 'add-loan',
    components: {
        Group,
        Cell,
        Datetime,
        PopupRadio
    },
    data() {
        return {
            houseId: '',
            is_edit: 0,
            termOptions: [],
            loanTypes: [{
                key: 1,
                value: '商业按揭贷款'
            }, {
                key: 2,
                value: '公积金贷款'
            }, {
                key: 3,
                value: '信用贷'
            }, {
                key: 4,
                value: '房抵贷'
            }],
            loanMethods: [{key: 1, value: '公积金'},
            {key: 2, value: '建设银行'},
            {key: 3, value: '工商银行'},
            {key: 4, value: '中国银行'},
            {key: 5, value: '农业银行'},
            {key: 6, value: '交通银行'},
            {key: 7, value: '邮储银行'},
            {key: 8, value: '其他'}],
            payTypes: ['等额本息', '等额本金'],
            interest: '',
            form: {
                loan: '',
                loanType: '',
                loanPeriod: 20,
                loanMethod: '',
                payType: '等额本息',
                date: '',
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
    watch: {
        interest(val) {
            val = '' + val;
            val = val.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符  
            val = val.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的  
            val = val.replace(".","$#$").replace(/\./g,"").replace("$#$","."); 
            val = val.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');//只能输入两个小数 
            if(val.indexOf(".")< 0 && val !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额 
                val= parseFloat(val); 
            } 
            this.interest = val;
        }
    },
    methods: {
        del() {
            this.$http({
                url: 'WxLoan/deleteLoan',
                method: 'post',
                data: {
                    id: this.$route.query.id
                }
            }).then(res => {
                if(res.data.statusCode == 1) {
                    this.$router.go(-1);
                }
            })
        },
        interestCheck(obj){ 
            obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符  
            obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的  
            obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$","."); 
            obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');//只能输入两个小数  
            if(obj.value.indexOf(".")< 0 && obj.value !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额 
                obj.value= parseFloat(obj.value); 
            } 
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
            // this.form.date = value;
        },
        onCancel() {

        },
        submit() {
            if(!this.is_finish) {
                return;
            }
            let data = {
                houseId: this.houseId,
                loanTime: this.form.date,
                term: this.form.loanPeriod * 12,
                type: this.form.loanType,
                typeName: this.loanTypes[this.form.loanType - 1].value,
                channel: this.form.loanMethod,
                channelName: this.loanMethods[this.form.loanMethod - 1].value,
                money: this.form.loan,
                rate: this.interest,
                repayment: this.form.payType
            }
            let url = 'WxLoan/addLoan';
            if(this.$route.query.is_edit == 1) {
                data['id'] = this.$route.query.id;
                url = 'WxLoan/updateLoanByLoanId'
            }
            this.$http({
                url: url,
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
                url: 'WxLoan/selectLoanById',
                method: 'post',
                data: {
                    id: this.$route.query.id
                }
            }).then(res => {
                let data = res.data.data;
                if(res.data.statusCode == 1) {
                    this.form =  {
                        loan: data.money,
                        loanType: parseInt(data.type),
                        loanPeriod: data.term / 12,
                        loanMethod: parseInt(data.channel),
                        payType: data.repayment,
                        date: data.loanTime
                    }
                    this.interest = data.rate
                }
            })
        }
    },
    created() {
        let query = this.$route.query;
        this.houseId = this.$route.query.houseId;
        for(let i = 1; i <= 30; i++) {
            this.termOptions.push({
                key: i,
                value: `${i}年（${i*12}期)`
            });
        }
        if(query.is_edit == 1) {
            this.is_edit = query.is_edit;
            this.load();
        }
    },
    mounted() {
        document.title = '添加贷款'
    }
}
</script>
