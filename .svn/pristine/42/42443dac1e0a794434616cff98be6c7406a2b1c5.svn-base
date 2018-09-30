<template>
    <div class="msg_set_page">
        <group title="短信提醒">
            <x-switch title="月供提醒" v-model="shortMsgNotice.smsMonth"></x-switch>
            <x-switch title="收租提醒" v-model="shortMsgNotice.smsRent"></x-switch>
            <x-switch title="房价提醒" v-model="shortMsgNotice.smsPrice"></x-switch>
        </group>
        <group title="消息提醒">
            <x-switch title="月供提醒" v-model="msgNotice.messageMonth"></x-switch>
            <x-switch title="收租提醒" v-model="msgNotice.messageRent"></x-switch>
            <x-switch title="房价提醒" v-model="msgNotice.messagePrice"></x-switch>
        </group>
        <group gutter="0.8rem">
            <cell title="短信手机号" is-link link="/mobile">
                {{mobile || '未设置'}}
            </cell>
        </group>
        <div @click="submit" style="margin-top: 0.85rem;" class="sub_btn">保存</div>
    </div>
</template>

<script>
import { XSwitch, Group, Cell } from 'vux'
import { mapState } from "vuex"
import _ from 'lodash'

export default {
    name: 'msg-set',
    components: {
        XSwitch,
        Group,
        Cell
    },
    data() {
        return {
            shortMsgNotice: {},
            msgNotice: {},
            mobile: ''
        }
    },
    computed: {
        ...mapState({
            user: state => state.glb.user,
            userRegisted: state => state.glb.userInfo
        }),
        isChanged() {
            for(let key in this.shortMsgNotice) {
                if(this.shortMsgNotice.hasOwnProperty(key) && this.shortMsgNotice[key] != this.userRegisted[key]) {
                    return true
                }
            }
            for(let key in this.msgNotice) {
                if(this.msgNotice.hasOwnProperty(key) && this.msgNotice[key] != this.userRegisted[key]) {
                    return true
                }
            }
            return false
        }
    },
    methods: {
        loadUser() {
            this.$http({
                url: 'WxUser/selectUserInfo',
                method: 'post',
                data: {}
            }).then(res => {
                if(res.data.statusCode == 1) {
                    this.$store.commit('updateUserInfoStatus', res.data.data);
                    this.init();
                }
            })
        },
        init() {
            let data = _.cloneDeep(this.userRegisted);
            this.shortMsgNotice = {
                smsMonth: !!data.smsMonth,
                smsRent: !!data.smsRent,
                smsPrice: !!data.smsPrice
            }
            this.msgNotice = {
                messageMonth: !!data.messageMonth,
                messageRent: !!data.messageRent,
                messagePrice: !!data.messagePrice
            }
            this.mobile = data.pwdMobile;
        },
        submit() {
            if(!this.isChanged) {
                this.$router.go(-1);
                return;
            }
            let _smsg = {};
            for(let key in this.shortMsgNotice) {
                if(this.shortMsgNotice.hasOwnProperty(key)) {
                    _smsg[key] = this.shortMsgNotice[key] ? 1 : 0
                }
            }
            let _msg = {};
            for(let key in this.msgNotice) {
                if(this.msgNotice.hasOwnProperty(key)) {
                    _msg[key] = this.msgNotice[key] ? 1 : 0
                }
            }
            let params = {..._smsg, ..._msg}
            this.$http({
                url: 'WxUser/updateUserInfo',
                method: 'post',
                data: params
            }).then(res => {
                if(res.data.statusCode == 1) {
                    let _tmp = _.cloneDeep(this.userRegisted);
                    for(let key in params) {
                        if(params.hasOwnProperty(key)) {
                            _tmp[key] = params[key]
                        }
                    }
                    this.$store.commit('updateUserInfoStatus', _tmp);
                    this.$router.go(-1);
                }
                
            })
        }
    },
    created() {
        if(this.userRegisted) {
            this.init()
        }else {
            this.loadUser();
        }
        
    },
    mounted() {
        document.title = '推送设置'
    }
}
</script>

<style>
.msg_set_page .vux-label {
    text-align-last: auto!important;
}
.msg_set_page .weui-label {
    text-align-last: auto!important;
}

</style>
