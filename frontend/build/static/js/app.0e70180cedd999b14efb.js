webpackJsonp([1],{NHnr:function(e,r,t){"use strict";Object.defineProperty(r,"__esModule",{value:!0});var s=t("7+uW"),o={render:function(){var e=this.$createElement,r=this._self._c||e;return r("div",{attrs:{id:"app"}},[r("router-view")],1)},staticRenderFns:[]};var a=t("VU/8")({name:"App"},o,!1,function(e){t("NqUm")},null,null).exports,n=t("/ocq"),l=t("mtWM"),i=t.n(l),u=function(e){return i.a.post("/api/login",e)},m=function(e){return i.a.post("/api/register",e)},c=(t("spwX"),{data:function(){return{ruleForm:{userName:"",password:""},rules:{userName:[{message:"请输入用户名",trigger:"onsubmit"}],password:[{message:"请输入密码",trigger:"onsubmit"}]}}},methods:{submitForm:function(e){var r=this;u({username:this.ruleForm.userName,password:this.ruleForm.password}).then(function(e){var t=e.status,s=e.headers;200===t&&(r.$router.push("/dashboard"),axios.default.headers.Token=s.Token)}).catch(function(e){switch(e.response.status){case 404:r.$notify({title:"错误",message:"找不到资源，请确认...",type:"error"});break;case 400:r.$notify({title:"错误",message:"用户名/密码错误，请重新输入！",type:"error"});break;default:r.$notify({title:"错误",message:"服务器连接失败，请稍后...",type:"error"})}})}}}),p={render:function(){var e=this,r=e.$createElement,t=e._self._c||r;return t("div",{staticClass:"form-container"},[t("div",{staticClass:"form"},[e._m(0),e._v(" "),t("el-form",{ref:"ruleForm",attrs:{model:e.ruleForm,rules:e.rules,"label-width":"65px","label-position":"top"}},[t("el-form-item",{attrs:{label:"账号",prop:"userName"}},[t("el-col",[t("el-input",{model:{value:e.ruleForm.userName,callback:function(r){e.$set(e.ruleForm,"userName",r)},expression:"ruleForm.userName"}})],1)],1),e._v(" "),t("el-form-item",{attrs:{label:"密码：",prop:"password"}},[t("el-col",[t("el-input",{attrs:{type:"password"},model:{value:e.ruleForm.password,callback:function(r){e.$set(e.ruleForm,"password",r)},expression:"ruleForm.password"}})],1)],1),e._v(" "),t("el-form-item",[t("el-row",{attrs:{type:"flex",justify:"center"}},[t("button",{staticClass:"button",on:{click:function(r){e.submitForm("ruleForm")}}},[e._v("登入")])])],1),e._v(" "),t("el-form-item",[t("el-row",{attrs:{type:"flex",justify:"center"}},[t("router-link",{staticStyle:{color:"#666666"},attrs:{to:"/signup"}},[e._v("新用户注册")])],1)],1)],1)],1)])},staticRenderFns:[function(){var e=this.$createElement,r=this._self._c||e;return r("div",{staticClass:"header"},[r("img",{attrs:{src:"/static/img/fill.svg",alt:"logo"}}),this._v(" "),r("div",{staticClass:"title"},[r("div",{staticClass:"main"},[this._v("\n          思沃学院\n        ")]),this._v(" "),r("div",{staticClass:"desc"},[this._v("\n          线上学习系统\n        ")])])])}]},d=t("VU/8")(c,p,!1,null,null,null).exports,f={data:function(){var e=this;return{ruleForm:{userName:"",password:"",password2:""},rules:{userName:[{validator:function(e,r,t){""===r?t(new Error("请输入账号")):t()},trigger:"onsubmit"}],password:[{validator:function(r,t,s){""===t?s(new Error("请输入密码")):t.length<6?s(new Error("密码不可少于6位")):(""!==e.ruleForm.password2&&e.$refs.ruleForm.validateField("password2"),s())},trigger:"onsubmit"}],password2:[{validator:function(r,t,s){""===t?s(new Error("请再次输入密码")):t!==e.ruleForm.password?s(new Error("两次输入密码不一致!")):s()},trigger:"onsubmit"}]}}},methods:{submitForm:function(e){var r=this;this.$refs[e].validate(function(e){e&&m({username:r.ruleForm.userName,password:r.ruleForm.password}).then(function(e){200===e.status&&(r.$router.push("/"),r.$notify({title:"成功",message:"注册成功，请登录...",type:"success"}))}).catch(function(e){switch(e.response.status){case 404:r.$notify({title:"错误",message:"找不到资源，请确认...",type:"error"});break;case 400:r.$notify({title:"错误",message:"用户名已存在，请重新输入...",type:"error"});break;default:r.$notify({title:"错误",message:"服务器连接失败，请稍后...",type:"error"})}})})},back:function(){this.$router.push("/")}}},v={render:function(){var e=this,r=e.$createElement,t=e._self._c||r;return t("div",{staticClass:"form-container"},[t("div",{staticClass:"form"},[t("div",{staticStyle:{height:"130px"}},[t("div",{staticStyle:{margin:"32px","font-size":"32px",color:"#999999",cursor:"pointer"},on:{click:e.back}},[e._v("<")])]),e._v(" "),t("el-form",{ref:"ruleForm",attrs:{model:e.ruleForm,rules:e.rules,"label-width":"65px","label-position":"top"}},[t("el-form-item",{attrs:{label:"用户名：",prop:"userName"}},[t("el-col",[t("el-input",{model:{value:e.ruleForm.userName,callback:function(r){e.$set(e.ruleForm,"userName",r)},expression:"ruleForm.userName"}})],1)],1),e._v(" "),t("el-form-item",{attrs:{label:"密码：",prop:"password"}},[t("el-col",[t("el-input",{attrs:{type:"password"},model:{value:e.ruleForm.password,callback:function(r){e.$set(e.ruleForm,"password",r)},expression:"ruleForm.password"}})],1)],1),e._v(" "),t("el-form-item",{attrs:{label:"确认密码：",prop:"password2"}},[t("el-col",[t("el-input",{attrs:{type:"password"},model:{value:e.ruleForm.password2,callback:function(r){e.$set(e.ruleForm,"password2",r)},expression:"ruleForm.password2"}})],1)],1),e._v(" "),t("el-form-item",[t("el-row",{attrs:{type:"flex",justify:"center"}},[t("button",{staticClass:"button",on:{click:function(r){e.submitForm("ruleForm")}}},[e._v("注册")])])],1)],1)],1)])},staticRenderFns:[]},h=t("VU/8")(f,v,!1,null,null,null).exports,w={render:function(){var e=this.$createElement;return(this._self._c||e)("el-alert",{attrs:{title:"尴尬",type:"info",description:"很遗憾，昨晚前端同学忘记带充电器回家，结果电脑没电了，没法完成这张卡。求原谅～","show-icon":""}})},staticRenderFns:[]},b=t("VU/8")({name:"Dashboard"},w,!1,null,null,null).exports;s.default.use(n.a);var F=new n.a({routes:[{path:"/",name:"SignIn",component:d},{path:"/signup",name:"SignUp",component:h},{path:"/dashboard",name:"Dashboard",component:b}]}),g=t("NYxO"),_=t("zL8q"),y=t.n(_);t("tvR6"),t("h5AK");s.default.use(y.a),s.default.use(g.a);var $=new g.a.Store({state:{user:{userName:"",token:""}}});s.default.config.productionTip=!1,new s.default({el:"#app",router:F,store:$,components:{App:a},template:"<App/>"})},NqUm:function(e,r){},h5AK:function(e,r){},spwX:function(e,r){},tvR6:function(e,r){}},["NHnr"]);
//# sourceMappingURL=app.0e70180cedd999b14efb.js.map