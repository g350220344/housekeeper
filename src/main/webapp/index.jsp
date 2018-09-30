<%@page import="com.cindata.housekeeper.core.common.tools.CommonHelper"%>
<%@page import="com.cindata.housekeeper.core.common.tools.ServletRequestHelper"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String password = ServletRequestHelper.getParameter(request, "key123", null);
	if(!"123456".equals(password)){
		return ;
	}
%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
	<script src="crypto-js.js"></script>

</head>
<body>
<a name="top" href="#yangshisen" >到最后</a>
<!-- 登录测试 -->
<div>登录测试:rest/user/login<br>
	<form method="post" action="rest/user/login" >
		mobile:<input type="text" name="mobile" value="13936457091" ><br>
		<input type="submit" value="test" >
	</form>
	<hr>
	<!-- 字典查询 -->
	<div>字典查询:rest/common/getPubList<br>
		<form method="post" action="rest/common/getPubList" >

			<input type="submit" value="test" >
		</form>
		<hr>
<!-- 城市列表 -->
<div>城市列表:rest/test/getCityList<br>
	<form method="post" action="rest/test/getCityList" >
		un:<input type="text" name="un" value="xdth" ><br>
		uuid:<input type="text" name="uuid" value="yangshisen123456" ><br>
		<input type="submit" value="test" >
	</form>
<hr>
<!-- 热门城市列表 -->
<div>热门城市列表:rest/city/getCityInfoListHoT<br>
	<form method="post" action="rest/city/getCityInfoListHoT" >

		<input type="submit" value="test" >
	</form>
<hr>
<!-- 搜索小区接口 -->
<div>搜索小区接口:community/searchCommunity<br>
	<form method="post" action="rest/community/searchCommunity" >
		<input name="communityName" value="太古" ><br>
		<input name="cityId" value="2301" ><br>
		<input type="submit" value="test" >
	</form>
	<hr>
</div>

	<!-- 城市行情接口 -->
	<div>城市行情接口:analysis/getCityMarket<br>
		<form method="post" action="rest/city/getCityMarket" >
			month:<input name="month" value="2017-07-21" ><br>
			cityId:<input name="cityId" value="2301" ><br>
			<input type="submit" value="test" >
		</form>
		<hr>
	</div>

	<!-- 添加房产接口 -->
	<div>添加房产接口:house/addHouse<br>
		<form method="post" action="rest/house/addHouse" >
			houseId:<input name="houseId" value="123" ><br>
			userId:<input name="userId" value="gaoy" ><br>
			communityId:<input name="communityId" value="588087879" ><br>
			cityId:<input name="cityId" value="2301" ><br>
			buildingsquare(建筑面积):<input name="buildingsquare" value="100" ><br>
<%--
			livingsquare(使用面积):<input name="livingsquare" value="80" ><br>
--%>
			buildingId(楼栋):<input name="buildingId" value="16" ><br>
			unitId(单元):<input name="unitId" value="4" ><br>
			doorNum(室号):<input name="doorNum" value="302" ><br>
			communitytype(用途):<input name="communitytype" value="住宅" ><br>
			currentfloor(楼层):<input name="currentfloor" value="12" ><br>
			totalfloor(总层数):<input name="totalfloor" value="21" ><br>
			floorplantype(户型):<input name="floorplantype" value="两室一厅一卫" ><br>
			roomcount(室数):<input name="roomcount" value="2" ><br>
			loungecount(厅数):<input name="loungecount" value="1" ><br>
			bathroomcount(卫数):<input name="bathroomcount" value="1" ><br>
			aspect(朝向):<input name="aspect" value="南北" ><br>
			cityName(城市名称):<input name="cityName" value="哈尔滨市" ><br>
			address(朝向):<input name="address" value="红旗大街338号" ><br>
			communityName(小区名称):<input name="communityName" value="大鹏青年城邦" ><br>
			districtname(小区名称):<input name="districtname" value="道外区" ><br>
			<input type="submit" value="test" >
		</form>
		<hr>
	</div>
	<!-- 编辑房产接口 -->
	<div>编辑房产接口:house/updateHouse<br>
		<form method="post" action="rest/house/updateHouse" >
			houseId:<input name="houseId" value="123" ><br>
			userId:<input name="userId" value="gaoy4" ><br>
			communityId:<input name="communityId" value="5880878794" ><br>
			cityId:<input name="cityId" value="23014" ><br>
			buildingsquare(建筑面积):<input name="buildingsquare" value="1004" ><br>
			livingsquare(使用面积):<input name="livingsquare" value="804" ><br>
			status:<input name="status" value="0" ><br>
			<input type="submit" value="test" >
		</form>
		<hr>
	</div>
	<!-- 删除房产接口 -->
	<div>删除房产接口:house/updateHouse<br>
		<form method="post" action="rest/house/updateHouse" >
			houseId:<input name="houseId" value="1000001" ><br>
			status:<input name="status" value="0" ><br>
			<input type="submit" value="test" >
		</form>
		<hr>
	</div>
	<!-- 我的资产总值接口 -->
	<div>我的资产总值接口:house/getHouseAvmByUserId<br>
		<form method="post" action="rest/house/getHouseAvmByUserId" >
			userId:<input name="userId" value="gaoy" ><br>
			<input type="submit" value="test" >
		</form>
		<hr>
	</div>

	<!-- 小区行情接口 -->
	<div>小区行情接口:community/getCommunityMarket<br>
		<form method="post" action="rest/community/getCommunityMarket" >
			communityId:<input name="communityId" value="588087879" ><br>
			month:<input name="month" value="2017-07-21" ><br>
			<input type="submit" value="test" >
		</form>
		<hr>
	</div>

	<!-- 出售相似案例列表接口（当前小区） -->
	<div>出售相似案例列表接口（当前小区）:community/getSameSaleListing<br>
		<form method="post" action="rest/community/getSameSaleListing" >
			communityId:<input name="communityId" value="588087879" ><br>
			square:<input name="square" value="50" ><br>
			cityId:<input name="cityId" value="2301" ><br>
			<input type="submit" value="test" >
		</form>
		<hr>
	</div>
    <!-- 出售相似案例列表接口（附近小区） -->
    <div>出售相似案例列表接口（附近小区）:community/getSameSaleListingNearbyCommunity<br>
        <form method="post" action="rest/community/getSameSaleListingNearbyCommunity" >
            <%--communityId:<input name="communityId" value="588087879" ><br>

            cityId:<input name="cityId" value="2301" ><br>--%>
				square:<input name="square" value="50" ><br>
            lng(经度):<input name="lng" value="126.673622571506" ><br>
            lat(纬度):<input name="lat" value="45.80000806988274" ><br>
            range:<input name="range" value="500" ><br>
            <input type="submit" value="test" >
        </form>
        <hr>
    </div>
	<!-- 成交案例列表接口（当前小区） -->
	<div>成交案例列表接口（当前小区）:community/getSameDealListing<br>
		<form method="post" action="rest/community/getSameDealListing" >
			communityId:<input name="communityId" value="588087879" ><br>
			cityId:<input name="cityId" value="2301" ><br>
			<input type="submit" value="test" >
		</form>
		<hr>
	</div>
	<!-- 成交案例列表接口（附近小区） -->
	<div>成交案例列表接口（附近小区）:community/getSameDealListingNearbyCommunity<br>
		<form method="post" action="rest/community/getSameDealListingNearbyCommunity" >
			square:<input name="square" value="50" ><br>
			lng(经度):<input name="lng" value="126.673622571506" ><br>
			lat(纬度):<input name="lat" value="45.80000806988274" ><br>
			range:<input name="range" value="500" ><br>
			<input type="submit" value="test" >
		</form>
		<hr>
	</div>
    <div>租金走势:community/getCommunityRent<br>
		<form method="post" action="rest/community/getCommunityRent" >
			communityId:<input name="communityId" value="588087879" ><br>
			cityId:<input name="purpose" value="一室" ><br>
			<input type="submit" value="测试租金走势" >
		</form>
		<hr>
	</div>
    
    <div>房屋列表:house/getHouseList<br>
		<form method="post" action="rest/house/getHouseList" >
			userId:<input name="userId" value="gaoy4" ><br>
			<input type="submit" value="测试房屋列表" >
		</form>
		<hr>
	</div>
	<div>微信支付:house/getHouseList<br>
		<form method="post" action="rest/wx/wxPay" >
			userId:<input name="openid" value="123456" ><br>
			<input type="submit" value="测试微信支付" >
		</form>
		<hr>
	</div>
	 <div>房产信息:house/selectHouseInfoByHouseId<br>
		<form method="post" action="rest/house/selectHouseInfoByHouseId" >
			houseId:<input name="houseId" value="123" ><br>
			<input type="submit" value="测试房产信息" >
		</form>
		<hr>
	</div>
	<div>评估房产:house/houseAvm<br>
		<form method="post" action="rest/house/houseAvm" >

			<input type="submit" value="评估房产" >
		</form>
		<hr>
	</div>
	<form id="form1" method="post" action="rest/upload/uploadTest" enctype="multipart/form-data">
		<tr>
			<td width="25%" align="right">上传文件：</td>
			<td><input id="file1" type="file" NAME="file" style="width:300px;"></td>
		</tr>
		<tr align="center" valign="middle">
			<td height="60" colspan="2"><input type="submit" ID="BtnOK" value="确认上传"></td>
		</tr>
	</form>
	<!-- 百度地图城市映射接口 -->
	<div>百度地图城市映射接口:rest/city/getCityCode<br>
		<form method="post" action="rest/city/getCityCode" >
			areaId:<input type="text" name="areaId" value="48" ><br>
			<input type="submit" value="test" >
		</form>
		<hr>
		<div id="uploadForm">
			<input id="file" type="file"/>
			<button id="upload" type="button" onclick="bb()">upload</button>
		</div>
		orderId:<input type="text" name="orderId" id="orderId" value="1000001" ><br>
		<input type="button" value="H5支付" onclick="aa()">

		<input type="button" value="des加密" onclick="cc()">

		<a name="yangshisen" href="#top" >到顶部</a>
		<script>
            function aa() {
                var orderId = $("#orderId").val();
                $.ajax({
                    async:false,
                    type:"post",
                    url: "rest/test/weixinPayH5?orderId="+orderId,
                    dataType:"text",
                    timeout: 20000,
                    error: function (json) {
                        console.log(json);
                    },
                    success: function (json) {
                        //alert(json);
                        location.href=json;
                    }
                });
            }
            function bb(){
                var formData = new FormData();
                formData.append('file', $('#file')[0].files[0]);
                $.ajax({
                    url: 'rest/upload/upload3',
                    type: 'POST',
                    cache: false,
                    data: formData,
                    processData: false,
                    contentType: false
                }).done(function(res) {
                }).fail(function(res) {});
			}
            function cc(){
               var str = encryptByDES("hello","Avj!@#853PoIuds&");
                $.ajax({
                    url: 'rest/test/des?str='+str,
                    type: 'POST',
                    cache: false,
                    processData: false,
                    contentType: false
                }).done(function(res) {
                }).fail(function(res) {});
            }
            function encryptByDES(message, key) {

                var keyHex = CryptoJS.enc.Utf8.parse(key);
                var encrypted = CryptoJS.DES.encrypt(message, keyHex, {
                    mode: CryptoJS.mode.ECB,
                    padding: CryptoJS.pad.Pkcs7
                });
                alert(encrypted.ciphertext.toString(CryptoJS.enc.Base64));
                return encrypted.toString();
            }
		</script>
</body>
</html>