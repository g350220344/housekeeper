<template>
    <div class="i_progress">
        <div class="i_progress_container">
            <div :style="{width: w}" class="i_progress_content"></div>
        </div>
        <div class="i_progress_label">
            <div class="i_progress_label_l">{{labelLeft}}</div>
            <div class="i_progress_label_r">{{labelRight}}</div>
        </div>
    </div>
</template>

<script>
import 'assets/css/progress.css';
export default {
    name: 'i-progress',
    data() {
        return {
            rate: this.val
        }
    },
    props: {
        labelLeft: {
            type: String,
            default: ''
        },
        labelRight: {
            type: String,
            default: ''
        },
        val: {
            default: 0
        }
    },
    computed: {
        w() {
            return this.val ? this.val + '%' : 0
        }
    },
    mounted() {
        
    }
}
</script>

