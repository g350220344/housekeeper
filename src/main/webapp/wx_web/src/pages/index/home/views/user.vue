<template>
    <div class="user_page">
        <group :gutter="0">
            <cell title="头像">
                <img style="width: 0.66rem; height: 0.66rem; border-radius: 50%;" :src="personPic" alt="">
            </cell>
            <cell title="名字">
                {{validUser.nickname}}
            </cell>
            <cell @click="goMobile" title="手机号" is-link link="/mobile">
                {{validUser.pwdMobile || '未设置'}}
            </cell>
        </group>
        <group :gutter="'0.8rem'">
            <cell title="退出账号" is-link></cell>
        </group>
        <!-- <div style="margin-top: 0.85rem;" class="sub_btn">保存</div> -->
    </div>
</template>

<script>
import personPic from 'assets/img/my/person-pic.png'
import { CellBox, Group, Cell } from 'vux'
import { mapState } from 'vuex'
export default {
    name: 'user',
    components: {
        CellBox,
        Cell,
        Group
    },
    data() {
        return {
            
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
        personPic() {
            return this.validUser.headUrl ? this.validUser.headUrl : personPic
        }
    },
    methods: {
        goMobile() {
            this.$router.push({path: '/mobile'})
        },
        loadUser() {
            this.$http({
                url: 'WxUser/selectUserInfo',
                method: 'post',
                data: {}
            }).then(res => {
                if(res.data.statusCode == 1) {
                    this.$store.commit('updateUserInfoStatus', res.data.data);
                    // this.userInfo = _.cloneDeep(res.data.data);
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
        document.title = '个人资料'
    }
}
</script>

<style>
    .user_page .vux-label {
        text-align-last: auto!important;
    }
    .user_page .weui-label {
        text-align-last: auto!important;
    }
</style>
