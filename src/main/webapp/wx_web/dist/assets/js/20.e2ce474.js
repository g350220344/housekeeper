(window.webpackJsonp=window.webpackJsonp||[]).push([[20],{228:function(t,e,i){},229:function(t,e,i){},23:function(t,e,i){"use strict";e.a=function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{};for(var e in t)void 0===t[e]&&delete t[e];return t}},230:function(t,e,i){},234:function(t,e,i){},25:function(t,e,i){"use strict";var n={mounted:function(){0},data:function(){return{uuid:Math.random().toString(36).substring(3,8)}}};e.a={mixins:[n],props:{required:{type:Boolean,default:!1}},created:function(){this.handleChangeEvent=!1},computed:{dirty:{get:function(){return!this.pristine},set:function(t){this.pristine=!t}},invalid:function(){return!this.valid}},methods:{setTouched:function(){this.touched=!0}},watch:{value:function(t){!0===this.pristine&&(this.pristine=!1),this.handleChangeEvent||(this.$emit("on-change",t),this.$emit("input",t))}},data:function(){return{errors:{},pristine:!0,touched:!1}}}},3:function(t,e,i){"use strict";var n=i(23),s=(n.a,String,String,String,String,String,String,Number,String,String,{name:"group",methods:{cleanStyle:n.a},props:{title:String,titleColor:String,labelWidth:String,labelAlign:String,labelMarginRight:String,gutter:[String,Number],footerTitle:String,footerTitleColor:String}}),o=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[t.title?i("div",{staticClass:"weui-cells__title",style:t.cleanStyle({color:t.titleColor}),domProps:{innerHTML:t._s(t.title)}}):t._e(),t._v(" "),t._t("title"),t._v(" "),i("div",{staticClass:"weui-cells",class:{"vux-no-group-title":!t.title},style:t.cleanStyle({marginTop:"number"==typeof t.gutter?t.gutter+"px":t.gutter})},[t._t("after-title"),t._v(" "),t._t("default")],2),t._v(" "),t.footerTitle?i("div",{staticClass:"weui-cells__title vux-group-footer-title",style:t.cleanStyle({color:t.footerTitleColor}),domProps:{innerHTML:t._s(t.footerTitle)}}):t._e()],2)};o._withStripped=!0;var l=i(1),r=!1;var a=function(t){r||i(228)},c=Object(l.a)(s,o,[],!1,a,null,null);c.options.__file="node_modules/vux/src/components/group/index.vue";e.a=c.exports},385:function(t,e,i){},4:function(t,e,i){"use strict";var n=i(8),s=i(24),o=i(41),l=i(23),r=function(t,e){return t.$parent&&void 0!==t.$parent[e]?t.$parent[e]:t.$parent&&t.$parent.$parent&&void 0!==t.$parent.$parent[e]?t.$parent.$parent[e]:void 0},a=(n.a,Object(o.a)(),{name:"cell",components:{InlineDesc:n.a},props:Object(o.a)(),created:function(){0},beforeMount:function(){this.hasTitleSlot=!!this.$slots.title,this.$slots.value},computed:{labelStyles:function(){return Object(l.a)({width:r(this,"labelWidth"),textAlign:r(this,"labelAlign"),marginRight:r(this,"labelMarginRight")})},valueClass:function(){return{"vux-cell-primary":"content"===this.primary||"left"===this.valueAlign,"vux-cell-align-left":"left"===this.valueAlign,"vux-cell-arrow-transition":!!this.arrowDirection,"vux-cell-arrow-up":"up"===this.arrowDirection,"vux-cell-arrow-down":"down"===this.arrowDirection}},labelClass:function(){return{"vux-cell-justify":"justify"===this.$parent.labelAlign||"justify"===this.$parent.$parent.labelAlign}},style:function(){if(this.alignItems)return{alignItems:this.alignItems}}},methods:{onClick:function(){!this.disabled&&Object(s.a)(this.link,this.$router)}},data:function(){return{hasTitleSlot:!0,hasMounted:!1}}}),c=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"weui-cell",class:{"vux-tap-active":t.isLink||!!t.link,"weui-cell_access":t.isLink||!!t.link,"vux-cell-no-border-intent":!t.borderIntent,"vux-cell-disabled":t.disabled},style:t.style,on:{click:t.onClick}},[i("div",{staticClass:"weui-cell__hd"},[t._t("icon")],2),t._v(" "),i("div",{staticClass:"vux-cell-bd",class:{"vux-cell-primary":"title"===t.primary&&"left"!==t.valueAlign}},[i("p",[t.title||t.hasTitleSlot?i("label",{staticClass:"vux-label",class:t.labelClass,style:t.labelStyles},[t._t("title",[t._v(t._s(t.title))])],2):t._e(),t._v(" "),t._t("after-title")],2),t._v(" "),i("inline-desc",[t._t("inline-desc",[t._v(t._s(t.inlineDesc))])],2)],1),t._v(" "),i("div",{staticClass:"weui-cell__ft",class:t.valueClass},[t._t("value"),t._v(" "),t._t("default",[t._v(t._s(t.value))]),t._v(" "),t.isLoading?i("i",{staticClass:"weui-loading"}):t._e()],2),t._v(" "),t._t("child")],2)};c._withStripped=!0;var u=i(1),d=!1;var h=function(t){d||i(230)},f=Object(u.a)(a,c,[],!1,h,null,null);f.options.__file="node_modules/vux/src/components/cell/index.vue";e.a=f.exports},400:function(t,e,i){"use strict";i.r(e);var n=i(4),s=i(3),o=i(14),l=i(2),r=Object.assign||function(t){for(var e=1;e<arguments.length;e++){var i=arguments[e];for(var n in i)Object.prototype.hasOwnProperty.call(i,n)&&(t[n]=i[n])}return t},a=(n.a,s.a,o.a,r({},Object(l.mapState)({user:function(t){return t.glb.user},userInfo:function(t){return t.glb.userInfo}}),{validUser:function(){return this.userInfo?this.userInfo:this.user},codeLock:function(){var t=/^[1][3,4,5,7,8][0-9]{9}$/;return console.log(t.test(this.mobile)),!this.mobile||!t.test(this.mobile)||this.time>0},formCheck:function(){return!(!this.mobile||!/^[1][3,4,5,7,8][0-9]{9}$/.test(this.mobile))&&!!this.code}}),Object.assign||function(t){for(var e=1;e<arguments.length;e++){var i=arguments[e];for(var n in i)Object.prototype.hasOwnProperty.call(i,n)&&(t[n]=i[n])}return t}),c=-1,u={name:"mobile",components:{Cell:n.a,Group:s.a,XInput:o.a},data:function(){return{mobile:"",code:"",time:0}},computed:a({},Object(l.mapState)({user:function(t){return t.glb.user},userInfo:function(t){return t.glb.userInfo}}),{validUser:function(){return this.userInfo?this.userInfo:this.user},codeLock:function(){var t=/^[1][3,4,5,7,8][0-9]{9}$/;return console.log(t.test(this.mobile)),!this.mobile||!t.test(this.mobile)||this.time>0},formCheck:function(){return!(!this.mobile||!/^[1][3,4,5,7,8][0-9]{9}$/.test(this.mobile))&&!!this.code}}),methods:{showLoading:function(){this.$store.commit("updateLoadingStatus",{isLoading:!0})},hideLoading:function(t){this.$store.commit("updateLoadingStatus",{isLoading:!1}),2==t?this.$store.commit("updateWarnToastStatus"):this.$store.commit("updateToastStatus")},sendCode:function(){this.codeLock||(this.codeLock||(this.time=60,this.clock()),this.$http({url:"WxSms/send",method:"post",data:{mobile:this.mobile}}).then(function(t){t.data.statusCode}))},checkCode:function(){var t=this;this.showLoading(),this.$http({url:"WxSms/check",method:"post",data:{mobile:this.mobile,code:this.code}}).then(function(e){1==e.data.statusCode&&t.save()})},clock:function(){var t=this;c=setTimeout(function(){t.time--,t.time>0&&t.clock()},1e3)},save:function(){var t=this;this.$http({url:"WxUser/updateUserInfo",method:"post",data:{mobile:this.mobile}}).then(function(e){if(1==e.data.statusCode){if(!t.user.mobile){var i=_.cloneDeep(t.user);i.mobile=t.mobile,t.$store.commit("updateUserStatus",i)}t.hideLoading(),t.loadUser(1)}})},submit:function(){this.formCheck&&this.checkCode()},loadUser:function(t){var e=this;this.showLoading(),this.$http({url:"WxUser/selectUserInfo",method:"post",data:{}}).then(function(i){1==i.data.statusCode&&(e.$store.commit("updateUserInfoStatus",i.data.data),e.$store.commit("updateLoadingStatus",{isLoading:!1}),1==t&&e.$router.go(-1))})}},created:function(){this.userInfo||this.loadUser()},mounted:function(){this.validUser.pwdMobile?document.title="修改手机号":document.title="绑定手机号"},destroyed:function(){clearTimeout(c)}},d=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"mobile_page"},[i("group",{attrs:{gutter:0}},[t.validUser.pwdMobile?i("cell",{attrs:{"is-type":"china-mobile","text-align":"right",title:"原手机号"}},[t._v(t._s(t.validUser.pwdMobile))]):t._e(),t._v(" "),i("x-input",{attrs:{"is-type":"china-mobile","text-align":"right",title:"手机号"},model:{value:t.mobile,callback:function(e){t.mobile=e},expression:"mobile"}}),t._v(" "),i("x-input",{attrs:{max:6,"text-align":"right","show-clear":!1,title:"验证码"},model:{value:t.code,callback:function(e){t.code=e},expression:"code"}},[i("div",{staticClass:"mobile_code_btn",class:{mobile_code_btn_active:!t.codeLock},attrs:{slot:"right"},on:{click:t.sendCode},slot:"right"},[t._v("\n                获取验证码"),t.codeLock&&t.time>0?i("span",[t._v("("+t._s(t.time)+"s)")]):t._e()])])],1),t._v(" "),i("div",{staticClass:"sub_btn",class:{sub_btn_disabled:!t.formCheck},staticStyle:{"margin-top":"0.85rem"},on:{click:t.submit}},[t._v("保存")])],1)};d._withStripped=!0;var h=i(1),f=!1;var m=function(t){f||i(385)},p=Object(h.a)(u,d,[],!1,m,null,null);p.options.__file="src/pages/index/home/views/mobile.vue";e.default=p.exports},41:function(t,e,i){"use strict";e.a=function(){return{title:[String,Number],value:[String,Number,Array],isLink:Boolean,isLoading:Boolean,inlineDesc:[String,Number],primary:{type:String,default:"title"},link:[String,Object],valueAlign:[String,Boolean,Number],borderIntent:{type:Boolean,default:!0},disabled:Boolean,arrowDirection:String,alignItems:String}}},43:function(t,e,i){"use strict";String,Boolean;var n={name:"icon",props:{type:String,isMsg:Boolean},computed:{className:function(){return"weui-icon weui_icon_"+this.type+" weui-icon-"+this.type.replace(/_/g,"-")}}},s=function(){var t=this.$createElement;return(this._self._c||t)("i",{class:[this.className,this.isMsg?"weui-icon_msg":""]})};s._withStripped=!0;var o=i(1),l=!1;var r=function(t){l||i(234)},a=Object(o.a)(n,s,[],!1,r,null,null);a.options.__file="node_modules/vux/src/components/icon/index.vue";e.a=a.exports},8:function(t,e,i){"use strict";var n=function(){var t=this.$createElement;return(this._self._c||t)("span",{staticClass:"vux-label-desc"},[this._t("default")],2)};n._withStripped=!0;var s=i(1),o=!1;var l=function(t){o||i(229)},r=Object(s.a)({name:"inline-desc"},n,[],!1,l,null,null);r.options.__file="node_modules/vux/src/components/inline-desc/index.vue";e.a=r.exports}}]);
//# sourceMappingURL=20.e2ce474.js.map