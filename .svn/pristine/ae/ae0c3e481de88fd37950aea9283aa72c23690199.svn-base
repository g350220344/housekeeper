<template>
    <div class="mobile_page">
        <group :gutter="0">
            <cell v-if="validUser.pwdMobile" is-type="china-mobile" text-align="right" title="原手机号">{{validUser.pwdMobile}}</cell>
            <x-input is-type="china-mobile" text-align="right" title="手机号" v-model="mobile"></x-input>
            <x-input :max="6" text-align="right" :show-clear="false" title="验证码" v-model="code">
                <div @click="sendCode" class="mobile_code_btn" slot="right" :class="{'mobile_code_btn_active': !codeLock}">
                    获取验证码<span v-if="codeLock && time > 0">({{time}}s)</span>
                </div>
            </x-input>
        </group>
        <div @click="submit" style="margin-top: 0.85rem;" class="sub_btn" :class="{'sub_btn_disabled': !formCheck}">保存</div>
    </div>
</template>

<script>
import { Cell, Group, XInput } from 'vux'
import { mapState } from 'vuex'

let timeClock = -1;
export default {
    name: 'mobile',
    components: { Cell, Group, XInput },
    data() {
        return {
            mobile: '',
            code: '',
            time: 0
        }
    },
    computed: {
        ...mapState({
            user: state => state.glb.user,
            userInfo: state => state.glb.userInfo
        }),
        validUser() {
            return this.userInfo ? this.userInfo : this.user;
        },
        codeLock() {
            var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
            console.log(myreg.test(this.mobile))
            if(!this.mobile || !myreg.test(this.mobile)) {
                return true
            }
            if(this.time > 0) {
                return true
            }
            return false
        },
        formCheck() {
            var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
            if(!this.mobile || !myreg.test(this.mobile)) {
                return false
            }
            if(!this.code) {
                return false
            }
            return true
        }
    },
    methods: {
        sendCode() {
            if(this.codeLock) {
                return;
            }
            if(!this.codeLock) {
                this.time = 60;
                this.clock();
            }
            this.$http({
                url: 'WxSms/send',
                method: 'post',
                data: {
                    mobile: this.mobile
                }
            }).then(res => {
                if(res.data.statusCode == 1) {
                    
                }
            })
        },
        checkCode() {
            this.$http({
                url: 'WxSms/check',
                method: 'post',
                data: {
                    mobile: this.mobile,
                    code: this.code
                }
            }).then(res => {
                if(res.data.statusCode == 1) {
                    this.save();
                }
            })
        },
        clock() {
            timeClock = setTimeout(() => {
                this.time --;
                if(this.time > 0) {
                    this.clock();
                }
            }, 1000);
        },
        save() {
            this.$http({
                url: 'WxUser/updateUserInfo',
                method: 'post',
                data: {
                    mobile: this.mobile
                }
            }).then(res => {
                if(res.data.statusCode == 1) {
                    this.loadUser(1);
                }
            })
        },
        submit() {
            if(!this.formCheck) {
                return;
            }
            this.checkCode();
        },
        loadUser(type) {
            this.$http({
                url: 'WxUser/selectUserInfo',
                method: 'post',
                data: {}
            }).then(res => {
                if(res.data.statusCode == 1) {
                    this.$store.commit('updateUserInfoStatus', res.data.data);
                    if(type == 1) {
                        this.$router.go(-1);
                    }
                }
            })
        }
    },
    created() {
        if(!this.userInfo) {
            this.loadUser();
        }
    },
    mounted() {
        document.title = '个人设置'
    },
    destroyed() {
        clearTimeout(timeClock);
    }
}
</script>

<style>
.mobile_page .vux-label {
    text-align-last: auto!important;
    color: #bbb;
}
.mobile_page .weui-label {
    text-align-last: auto!important;
    color: #bbb;
}
.mobile_code_btn {
    padding: 0.14rem 0.2rem;
    font-size: 0.26rem;
    color: #bbb;
    text-align: center;
    border-radius: 0.15rem;
    background-color: #f2f2f2;
    margin-left: 0.2rem;
}
.mobile_code_btn_active {
    color: #388cff;
    border: 1px solid #388cff;
    background: #fff;
}
</style>
