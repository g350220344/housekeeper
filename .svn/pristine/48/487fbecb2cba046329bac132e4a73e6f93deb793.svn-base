<template>
    <div class="feedback_page">
        <group title="您的意见建议是我们的动力(至少输入6个字)">
            <x-textarea :height="150" :max="120" v-model="content" placeholder="请描述您在使用是遇到的问题和建议"></x-textarea>
        </group>
        <div @click="submit" style="margin-top: 0.85rem;" class="sub_btn" :class="{'sub_btn_disabled': !is_finish}">立即评估</div>
    </div>
</template>

<script>
import { Group, XTextarea } from 'vux'
export default {
    name: 'feedback',
    components: {
        Group,
        XTextarea
    },
    data() {
        return {
            content: ''
        }
    },
    computed: {
        is_finish() {
            return !!this.content && this.content.length >= 6;
        }
    },
    methods: {
        submit() {
            this.$http({
                url: 'WxUser/userSuggestion',
                method: 'post',
                data: {
                    content: this.content
                }
            }).then(res => {
                if(res.data.statusCode == 1) {
                    this.$router.go(-1);
                }
            })
        }
    },
    mounted() {
        document.title = '意见反馈'
    }
}
</script>

<style>
.feedback_page textarea {
    padding-top: 0.28rem;
}
.feedback_page .weui-textarea-counter {
    padding-top: 0.3rem;
    padding-bottom: 0.3rem;
}
</style>
