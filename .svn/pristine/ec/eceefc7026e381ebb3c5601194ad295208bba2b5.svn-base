<template>
    <div class="i_progress_m">
        <div class="i_progress_m_title">
            {{label}} <span class="i_progress_m_title_span">{{val}}%</span>的小区
        </div>
        <div class="i_progress_m_container">
            <div class="i_progress_m_container_dvider" style="left: 33.3%;"></div>
            <div class="i_progress_m_container_dvider" style="right: 33.3%;"></div>
            <div :style="{width: w}" class="i_progress_m_content"></div>
        </div>
        <div class="i_progress_m_label">
            <div class="i_progress_m_label_l">低</div>
            <div class="i_progress_m_label_r">高</div>
        </div>
    </div>
</template>

<script>
import 'assets/css/progress_m.css'
export default {
    name: 'i-progress-m',
    data() {
        return {
            rate: this.val
        }
    },
    props: {
        val: {
            type: Number,
            default: 0
        },
        label: {
            type: String,
            default: ''
        }
    },
    computed: {
        w() {
            return this.val ? this.val + '%' : 0;
        }
    },
    mounted() {
        
    }
}
</script>
