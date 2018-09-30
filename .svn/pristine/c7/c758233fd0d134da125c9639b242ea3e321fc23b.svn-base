<template>
    <div v-if="!!res">
        <div class="lcr_block_1 vux-1px-b">
            <div class="lcr_block_1_row_1">房屋总价(万元)</div>
            <div class="lcr_block_1_row_2">{{res.total}}</div>
            <div class="lcr_block_1_row_3">{{res.isOnly ? '唯一住房': '非唯一住房'}}</div>
        </div>

        <group>
            <i-cell-form left-label="单价" :left-val="`${houseDetails.price}元`" right-label="面积" :right-val="`${houseDetails.area}㎡`"></i-cell-form>
            <i-cell-form left-label="楼层" :left-val="houseDetails.floor" right-label="类型" :right-val="houseDetails.type"></i-cell-form>
            <i-cell-form left-label="房产证年限" :left-val="houseDetails.year"></i-cell-form>
        </group>
        
        <group title="税费明细">
            <i-cell-form left-label="税费合计" :left-val="`${taxInfo.total}元`" right-label="手续费" :right-val="`${taxInfo.serviceCharge}元`"></i-cell-form>
            <i-cell-form left-label="契税" :left-val="`${taxInfo.deedTax}元`" right-label="所得税" :right-val="`${taxInfo.incomeTax}元`"></i-cell-form>
            <i-cell-form left-label="营业税" :left-val="`${taxInfo.turnoverTax}元`" right-label="工本费" :right-val="`${taxInfo.nominalFee}元`"></i-cell-form>
            <i-cell-form left-label="印花税" :left-val="`${taxInfo.stampTax}元`"></i-cell-form>
            <!-- <i-cell-form left-label="房产证年限" :left-val="houseDetails.year"></i-cell-form> -->
            <cell-box>
                <div class="lcr_cell_box_label" style="width: 2.5rem;">住房专项维修基金</div>
                <div class="lcr_cell_box_val">{{taxInfo.repairFound}}元</div>
            </cell-box>
        </group>

        <div @click="computeAgain" class="sub_btn_middle" style="margin-top: 0.5rem;">重新计算</div>
        <div class="lcr_bottom_notice">*以上结果仅供参考，请以当地实际情况为准</div>
    </div>
</template>

<script>
import { Group, CellBox } from 'vux'
import ICellForm from 'components/cell_form'
import 'assets/css/computer/loan_compute_res.css'
const houseOptions = ['二手房', '新房']
const onlyOptions = ['唯一', '不唯一']
const periodOptions = ['2年以内', '2年以上']
const floorOptinos = ['8层以上', '8层以下']
export default {
    name: 'loan-compute-res',
    components: {
        Group,
        CellBox,
        ICellForm
    },
    data() {
        return {
            res: {
                total: '500.00',
                isOnly: true
            },
            houseDetails: {
                price: 3458,
                area: 120,
                floor: '8层以下',
                type: '二手房',
                year: '20'
            },
            taxInfo: {
                total: 9, //税费合计
                deedTax: 12, //契税
                serviceCharge: 720,
                incomeTax: 3, //所得税
                turnoverTax: 0, //营业税
                nominalFee: 80, //工本费
                stampTax: 5, //印花税
                repairFound: 1800 //住房专项维修基金
            }
        }
    },
    methods: {
        init() {
            var res = this.$route.query;
            this.res = {
                total: res.value.toFixed(2),
                isOnly: res.isOnly == 0
            }
            this.houseDetails = {
                price: (res.value *10000 / res.area).toFixed(0),
                area: res.area,
                floor: floorOptinos[res.allFloor],
                type: houseOptions[res.houseType],
                year: periodOptions[res.period]
            }
            //月利率
            var interest = 0.049 / 12;
            //房价
            var price = res.value;
            price = +(price.toFixed(2));
            //契税
            var tax;
            if (res.area <= 90) {
                tax = price * 10000 * 0.01;
                tax=+(tax.toFixed(0));
            } else if (res.area > 90) {
                tax = price * 10000 * 0.02;
                tax=+(tax.toFixed(0));
            }
            //手续费
            var poundage = +((res.area * 6).toFixed(0));
            //所得税 默认不唯一住房 房证2年以上
            var incomeTax = 0;
            //营业税 默认不唯一住房 房证2年以上
            var businessTax = 0;
            //住房专项维修基金
            var fund;
            if (res.floor === 0) {
                fund = res.area * 20;
                fund=+(fund.toFixed(0));
            } else {
                fund = res.area * 32;
                fund=+(fund.toFixed(0));
            }
            //税费合计
            var total = +((Number(tax) + Number(incomeTax) + Number(businessTax) + Number(poundage) + 80 + 5 + Number(fund)).toFixed(0));
            this.taxInfo = {
                total: total, //税费合计
                deedTax: tax, //契税
                serviceCharge: poundage, //手续费
                incomeTax: incomeTax, //所得税
                turnoverTax: businessTax, //营业税
                nominalFee: 80, //工本费
                stampTax: 5, //印花税
                repairFound: fund //住房专项维修基金
            }
        },
        computeAgain() {
            this.$router.go(-1)
        }
    },
    created() {
        this.init();
    },
    mounted() {
        document.title = '税费计算结果'
    }
}
</script>
