<template>
    <div class="cmt_pannel_box needsclick">
        <div class="cmt_pannel_img_box">
            <img :src="src" alt="">
        </div>
        <div class="cmt_pannel_ctn">
            <div class="cmt_pannel_ctn_line_1">{{item.communityName || ''}}</div>
            <div class="cmt_pannel_ctn_line_2">{{item.Detailaddress || ''}}</div>
            <div class="cmt_pannel_ctn_line_3">
                {{item.Salesqmprice || '--'}}<span class="cmt_pannel_ctn_line_3_unit">{{item.type != 2 ? '元/㎡' : '元'}}</span>
                <div v-if="item.type == 2" class="cmt_pannel_ctn_line_3_right">{{item.distance || ''}}</div>
                <div v-else class="cmt_pannel_ctn_line_3_right">{{item.distance ? `距离${item.distance}米` : ''}}</div>
            </div>
        </div>
    </div>
</template>

<script>
import 'assets/css/index/cmt_pannel.css';
import defaultImg from 'assets/img/homepage/pannel_dft_bg.png';
export default {
    name: 'cmt-pannel',
    data() {
        return {
            
        }
    },
    props: ['item'],
    computed: {
        src() {
            return this.item.img || defaultImg;
        }
    },
    methods: {
        click() {
            this.$emit('cmt-click', this.item);
        }
    },
    created() {
        
    },
    mounted() {
        
    }
}
</script>
