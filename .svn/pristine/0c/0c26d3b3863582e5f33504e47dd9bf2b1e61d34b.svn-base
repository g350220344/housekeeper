<template>
    <div v-if="!!res">
        <div class="lcr_block_1 vux-1px-b">
            <div class="lcr_block_1_row_1">房屋总价(万元)</div>
            <div class="lcr_block_1_row_2">{{res.total}}</div>
            <div class="lcr_block_1_row_3">商业贷款</div>
        </div>
        <div class="lcr_block_2">
            <div class="lcr_block_2_item">
                <div class="lcr_block_2_item_label">首付金额(万元)</div>
                <div class="lcr_block_2_item_val">{{res.firstpay}}</div>
            </div>
            <div class="lcr_block_2_item">
                <div class="lcr_block_2_item_label">贷款金额(万元)</div>
                <div class="lcr_block_2_item_val">{{res.loan}}</div>
            </div>
            <div class="lcr_block_2_divider"></div>
        </div>
        <group title="等额本息">
            <cell-box>
                <div class="lcr_cell_box_label">每月还款</div>
                <div class="lcr_cell_box_val">{{equalEorpusInterest.everyMonth}}</div>
            </cell-box>
            <cell-box>
                <div class="lcr_cell_box_label">利息</div>
                <div class="lcr_cell_box_val">{{equalEorpusInterest.interest}}</div>
            </cell-box>
            <cell-box>
                <div class="lcr_cell_box_label">还款年限</div>
                <div class="lcr_cell_box_val">{{equalEorpusInterest.time}}</div>
            </cell-box>
        </group>
        <group title="等额本金">
            <cell-box>
                <div class="lcr_cell_box_label">首月还款</div>
                <div class="lcr_cell_box_val">{{equalEorpus.firstMonth}}</div>
            </cell-box>
            <cell-box>
                <div class="lcr_cell_box_label">每月还款</div>
                <div class="lcr_cell_box_val">{{equalEorpus.everyMonth}}</div>
            </cell-box>
            <cell-box>
                <div class="lcr_cell_box_label">利息</div>
                <div class="lcr_cell_box_val">{{equalEorpus.interest}}</div>
            </cell-box>
            <cell-box>
                <div class="lcr_cell_box_label">还款年限</div>
                <div class="lcr_cell_box_val">{{equalEorpus.time}}</div>
            </cell-box>
        </group>
        <div class="sub_btn_middle" style="margin-top: 0.5rem;">重新计算</div>
        <div class="lcr_bottom_notice">*以上结果仅供参考，请以当地实际情况为准</div>
    </div>
</template>

<script>
import { Group, CellBox } from 'vux'
import 'assets/css/computer/loan_compute_res.css'
export default {
    name: 'loan-compute-res',
    components: {
        Group,
        CellBox
    },
    data() {
        return {
            res: {
                total: '500.00',
                firstpay: '100.00',
                loan: '400.00'
            },
            equalEorpusInterest: { //等额本息
                everyMonth: 3458, //每月还款
                interest: 119.84, //利息
                time: 20 //还款年限
            },
            equalEorpus: { //等额本金
                firstMonth: 3458, //首月还款
                everyMonth: 3458, //每月还款
                interest: 119.84, //利息
                time: 20 //还款年限
            }
        }
    },
    mounted() {
        document.title = '房贷计算结果'
    }
}
</script>
