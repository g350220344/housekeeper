<template>
    <div>
        <group class="i_cell" :gutter="0">
            <x-input title="租客姓名" placeholder="请输入姓名或称呼" v-model="form.leaseName" text-align="right" :show-clear="false"></x-input>
            
            <x-input title="租客电话" placeholder="请输入联系电话" v-model="form.mobile" text-align="right" is-type="china-mobile" :show-clear="false"></x-input>
            <cell title="收租周期">
                <ul class="add_lease_checker">
                    <li :class="{'add_lease_checker_item_active': form.cycle === item.id}" @click="onTermChange(item, index)" v-for="(item, index) in leaseTerms" :key="item.id" class="add_lease_checker_item">{{item.name}}</li>
                </ul>
            </cell>
            <x-input style="line-height: 1rem;" title="每期租金" placeholder="必填" v-model="form.money" text-align="right" :show-clear="false">
                <span style="padding-left: 0.1rem;" slot="right">元</span>
            </x-input>
            <datetime
                v-model="form.leaseTime"
                format="YYYY-MM-DD"
                @on-change="change"
                title="租约开始日"
                placeholder="选择日期"
                @on-cancel="onCancel"
                @on-confirm="onConfirm"
                @on-hide="log('hide', $event)"></datetime>
            <x-input title="租期" placeholder="必填" v-model="form.term" text-align="right" :show-clear="false">
                <span style="padding-left: 0.1rem;" slot="right">个月</span>
            </x-input>
            <x-input title="押金" placeholder="必填" v-model="form.deposit" text-align="right" :show-clear="false">
                <span style="padding-left: 0.1rem;" slot="right">元</span>
            </x-input> 
        </group>
        <div @click="submit" style="margin-top: 0.85rem;" class="sub_btn" :class="{'sub_btn_disabled': !is_finish}">立即评估</div>
        <div v-if="is_edit" @click="del" style="margin-top: 0.55rem;color: #f9354d; text-align: center; font-size: 0.28rem;text-decoration-line: underline;">删除租约</div>
    </div>
</template>

<script>
import { Group, Cell, CellBox, Datetime, XInput, PopupRadio } from 'vux'
import _ from 'lodash'
import 'assets/css/house/add_lease.css';

export default {
    name: 'add-lease',
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
            houseId: '',
            leaseTerms: [{
                id: 1,
                name: '按月'
            },{
                id: 2,
                name: '按季'
            },{
                id: 3,
                name: '按年'
            }],
            is_edit: 0,
            form: {
                money: '',
                leaseName: '',
                mobile: '',
                cycle: 1, //收租周期
                leaseTime: '', //租约开始日期
                term: '', //租期
                deposit: '', //押金
                state: 0 //租约状态 (0:租约未到期,1:租约已到期2:删除租约)默认传0
            }
        }
    },
    computed: {
        is_finish() {
            for(let k in this.form) {
                if(this.form[k] === '') {
                    return false;
                }
            }
            return true
        }
    },
    methods: {
        del() {
            this.$http({
                url: 'WxRent/delectLease',
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
        onTermChange(item, index) {
            this.form.cycle = item.id;
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
            if(!this.is_finish) {return}
            let url = 'WxRent/addLease'
            let data = _.cloneDeep(this.form);
            if(this.is_edit == 1) {
                url = 'WxRent/updateLease';
                data['id'] = this.$route.query.id;
            }
            this.$http({
                url: url,
                method: 'post',
                data: {
                    ...data,
                    houseId: this.houseId
                }
            }).then(res => {
                if(res.data.statusCode == 1) {
                    this.$router.go(-1);
                }
            })
        },
        load() {
            this.$http({
                url: 'WxRent/selectRentByRentId',
                method: 'post',
                data: {
                    id: this.$route.query.id
                }
            }).then(res => {
                let data = res.data.data;
                if(res.data.statusCode == 1) {
                    let tmp = {};
                    for (let key in this.form) {
                        if(this.form.hasOwnProperty(key)) {
                            tmp[key] = data[key]
                        }
                    }
                    tmp.cycle = parseInt(tmp.cycle);
                    this.form = _.cloneDeep(tmp);
                }
            })
        }
    },
    created() {
        this.houseId = this.$route.query.houseId;
        let query = this.$route.query;
        if(this.$route.query.is_edit == 1) {
            this.is_edit = 1;
            this.load();
        }
    },
    mounted() {
        document.title = '添加租约'
    }
}
</script>
