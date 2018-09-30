import Vue from 'vue'
// import FastClick from 'fastclick'
import axios from 'axios'

import App from './app.vue'


// axios.defaults.withCredentials = true;
axios.defaults.baseURL = 'http://10.200.8.20:8080/housekeeper/rest/',
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
axios.defaults.transformRequest = [function (data) {
    let ret = ''
    for (let it in data) {
        ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
    }
    return ret
}]

Vue.prototype.$http = axios


function htRem() {
    var ww = document.documentElement.clientWidth;
    if (ww > 750) {
        ww = 750;
    }
    document.documentElement.style.fontSize = ww / 7.5 + "px";
}
htRem();
window.onresize = function () {
    htRem();
};

new Vue({
    el: '#app',
    render: h => h(App)
})  