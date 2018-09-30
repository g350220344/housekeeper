<template>
    <div class="i_card">
        <div class="card_tit_box" :class="{'vux-1px-b': !noLine}">
            <div class="i_card_tit">
                <div v-if="type === 'msg'" style="display: inline-block; position: relative;">
                    <badge v-if="isNew" style="position: absolute; top: 0.15rem; right: -0.05rem;"></badge>
                    <img class="i_card_tit_icon" :src="titIcon" alt="">
                </div>
                
                {{title}}
                <span v-if="subTit" class="i_card_sub_tit">{{subTit}}</span>
            </div>
            <div class="card_icon_box">
                <slot name="icon"></slot>
            </div>
        </div>
        <div class="card_ctn_box">
            <slot name="ctn"></slot>
        </div>
    </div>
</template>

<script>
import priceMsgIcon from 'assets/img/homepage/icon-msg-price.png';//房价图标
import loanMsgIcon from 'assets/img/homepage/icon-msg-loan.png'; //月供图标
import leaseMsgIcon from 'assets/img/homepage/icon-msg-lease.png';//收租图标
import { Badge } from 'vux'
import 'assets/css/index/card.css';

const msgIconMap = ['', priceMsgIcon, loanMsgIcon, leaseMsgIcon];
export default {
    name: 'i-card',
    components: { Badge },
    props: {
        tit: {
            type: String,
            default: ''
        },
        type: {
            type: String,
            default: ''
        },
        msgType: {
            type: Number,
            default: 1
        },
        subTit: {
            type: String,
            default: ''
        },
        isNew: {
            type: Boolean,
            default: false
        },
        noLine: {
            type: Boolean,
            default: false
        }
    },
    // props: ['tit', 'type', 'msgType', 'subTit', 'isNew', 'noLine'],
    data() {
        return {
            title: this.tit || '--'
        }
    },
    computed: {
        titIcon() {
            let type = this.msgType || 1;
            return msgIconMap[type];
        }
    },
    mounted() {

    }
}
</script>
