(window.webpackJsonp=window.webpackJsonp||[]).push([[18],{382:function(t,e,n){},404:function(t,e,n){"use strict";n.r(e);var s=n(3),a=n(95),i=(s.a,a.a,{name:"feedback",components:{Group:s.a,XTextarea:a.a},data:function(){return{content:""}},computed:{is_finish:function(){return!!this.content&&this.content.length>=6}},methods:{submit:function(){var t=this;this.$http({url:"WxUser/userSuggestion",method:"post",data:{content:this.content}}).then(function(e){1==e.data.statusCode&&t.$router.go(-1)})}},mounted:function(){document.title="意见反馈"}}),o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"feedback_page"},[n("group",{attrs:{title:"您的意见建议是我们的动力(至少输入6个字)"}},[n("x-textarea",{attrs:{height:150,max:120,placeholder:"请描述您在使用是遇到的问题和建议"},model:{value:t.content,callback:function(e){t.content=e},expression:"content"}})],1),t._v(" "),n("div",{staticClass:"sub_btn",class:{sub_btn_disabled:!t.is_finish},staticStyle:{"margin-top":"0.85rem"},on:{click:t.submit}},[t._v("提交反馈")])],1)};o._withStripped=!0;var c=n(1),u=!1;var r=function(t){u||n(382)},l=Object(c.a)(i,o,[],!1,r,null,null);l.options.__file="src/pages/index/home/views/feedback.vue";e.default=l.exports}}]);
//# sourceMappingURL=18.e2ce474.js.map