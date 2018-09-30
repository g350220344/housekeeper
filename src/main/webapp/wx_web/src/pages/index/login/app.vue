<template>
    <div>
        <div class="login_title">房产管家</div>
        <img class="login_bg" :src="bgLogin" alt="">
        <div @click="login" class="login_btn">
            <img :src="iconWx" alt="">微信登录
        </div>
    </div>
</template>

<script>
import __CONFIG__ from 'assets/js/config.js'
import bgLogin from 'assets/img/my/bg-login.png'
import iconWx from 'assets/img/my/icon-wx.png'
import 'assets/css/login.css'

export default {
    name: 'login',
    data() {
        return {
            bgLogin: bgLogin,
            iconWx: iconWx
        }
    },
    methods: {
        login() {
            let _url = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=' + __CONFIG__.APPID + '&redirect_uri=' + __CONFIG__.REDIRECT_URI + '&response_type=code&scope=' + __CONFIG__.SCOPE + '&state=123#wechat_redirect';
            window.location.href = _url;
            /**
             * 1.4版本授权操作
             */
            // var pre_page = getQueryString('pre');
            // var target_page = pre_page || REDIRECT_URI;
            // window.location.href = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=' + APPID + '&redirect_uri=' + target_page + '&response_type=code&scope=' + SCOPE + '&state=123#wechat_redirect';
        }
    },
    mounted() {

    }
}
</script>
