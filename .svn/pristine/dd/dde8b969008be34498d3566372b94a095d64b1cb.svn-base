<template>
    <div class="audio_search_page">
        <div ref="inputBox" class="as_input_box vux-1px-b">
            <div class="as_input_box_city">
                {{city.name}}<img class="as_input_box_city_icon" :src="iconArrowDown" alt="">
            </div>
            <input @click.prevent="goSearch" style="width: 5.6rem;" v-model="searchKey" class="as_input_box_inner" type="text" placeholder="搜索小区/地址">
            <!-- <div class="as_input_box_cancel">取消</div> -->
        </div>
        <div style="padding-top: 1.12rem; padding-bottom: 0.67rem; font-size: 0.28rem; color: #111; text-align: center;">您可以这样说</div>
        <p style="color: #388cff; font-size: 0.3rem;line-height: 0.8rem; text-align: center;">
            "上海康城32栋2单元502室”
        </p>
        <p style="color: #388cff; font-size: 0.3rem;line-height: 0.8rem; text-align: center;">
            “中远两湾城”
        </p>
        <div class="as_btn_txt">{{btnTxt}}</div>
        <div class="as_btn_box">
			<div @touchstart.prevent="registStart" @touchend.prevent="registEnd" @touchmove.prevent="touchmove" class="as_btn_box_inner"><img :src="iconMacphone"></div>
			<div class="as_pulse_container">
				<div v-show="btnActive" class="as_pulse" style="display:none"></div>
			</div>
			<div class="as_pulse_container">
				<div v-show="btnActive" class="as_pulse1" style="display:none"></div>
			</div>
		</div>
    </div>
</template>

<script>
import { throttle } from 'vux'
import iconArrowDown from 'assets/img/house/icon-arrow-down.png';
import iconBin from 'assets/img/house/icon-bin.png';
import iconMacphone from 'assets/img/house/icon-macphone.png';
import 'assets/css/audio_search.css';
export default {
    name: 'audio-search',
    data() {
        return {
            iconArrowDown: iconArrowDown,
            iconBin: iconBin,
            iconMacphone: iconMacphone,
            city: {
                id: 2301,
                name: '哈尔滨'
            },
            searchKey: '',
            btnActive: false,
            posStart: 0,
            posMove: 0,
            btnTxt: '按住说话'
        }
    },
    methods: {
        registStart() {
            console.log('start');
            this.btnTxt = '上滑取消';
            this.posStart = 0;
            this.posStart = event.touches[0].pageY;
            this.btnActive = true;
        },
        registEnd() {
            console.log('end');
            this.btnTxt = '按住说话';
            this.btnActive = false;
        },
        touchmove() {
            this.posMove = 0;
            this.posMove = event.targetTouches[0].pageY;
            if(this.posStart - this.posMove >= 30){  
                //cancel
            }
        },
        goSearch() {
            this.$router.push({path: '/search'})
        }
    },
    created() {

    },
    mounted() {

    }
}
</script>
