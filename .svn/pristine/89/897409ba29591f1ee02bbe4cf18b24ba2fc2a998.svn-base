package com.cindata.housekeeper.web.model;

import com.cindata.housekeeper.core.common.tools.CommonHelper;
import com.cindata.housekeeper.core.common.tools.LatLonUtil;
import com.cindata.housekeeper.core.common.tools.PubDictValue;
import com.cindata.housekeeper.core.common.tools.StringUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;


public class AvmCaseData {
	
	private BigDecimal juli;
	
	public BigDecimal getJuli() {
		return juli;
	}

	public void setJuli(BigDecimal juli) {
		this.juli = juli;
	}

	public AvmCaseData() {
		
	}
	private String kjcz;
	
	public String getKjcz() {
		return kjcz;
	}

	public void setKjcz(String kjcz) {
		this.kjcz = kjcz;
	}

	public String tableType;
	
	public String getTableType() {
		return tableType;
	}
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	private Integer dayAgo;
	public Integer getDayAgo() {
		return dayAgo;
	}
	public void setDayAgo(Integer dayAgo) {
		this.dayAgo = dayAgo;
	}

	private Timestamp assessTime;
	
	public Timestamp getAssessTime() {
		return assessTime;
	}
	public void setAssessTime(Timestamp assessTime) {
		this.assessTime = assessTime;
	}

	private String housepicture;
	
	public String getHousepicture() {
		return housepicture;
	}
	public void setHousepicture(String housepicture) {
		this.housepicture = housepicture;
	}

	private Integer orderByTime;
	
	public Integer getOrderByTime() {
		return orderByTime;
	}
	public void setOrderByTime(Integer orderByTime) {
		this.orderByTime = orderByTime;
	}

	private Date atMonth;//在哪个月份时间点查询
	
	public Date getAtMonth() {
		return atMonth;
	}
	public void setAtMonth(Date atMonth) {
		this.atMonth = atMonth;
	}
	private Integer atfloor;

	//--住宅15753722、商铺15755275、写字楼15755276
	/*
	 * 
15753805	别墅
15753675	平房
15753676	板楼
15753677	塔楼
15753678	板塔结合
15753679	独栋别墅
15753680	联排别墅
15753681	叠拼别墅
15753682	双拼别墅
15753683	四合院
15753684	洋房
15753685	未知

开间
一室一厅
两室一厅
三室一厅
两室两厅
三室两厅
四室以上


	 */
	private BigDecimal lng;
	private BigDecimal lat;
	
	public BigDecimal getLng() {
		return lng;
	}
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	
	public Double getMin_lat() {
		return min_lat;
	}
	public void setMin_lat(Double min_lat) {
		this.min_lat = min_lat;
	}
	public Double getMin_lng() {
		return min_lng;
	}
	public void setMin_lng(Double min_lng) {
		this.min_lng = min_lng;
	}
	public Double getMax_lat() {
		return max_lat;
	}
	public void setMax_lat(Double max_lat) {
		this.max_lat = max_lat;
	}
	public Double getMax_lng() {
		return max_lng;
	}
	public void setMax_lng(Double max_lng) {
		this.max_lng = max_lng;
	}

	private Double min_lat;
	private Double min_lng;
	private Double max_lat;
	private Double max_lng;
	
	public Integer getAtfloor() {
		return atfloor;
	}

	public void setAtfloor(Integer atfloor) {
		this.atfloor = atfloor;
	}

	public void setXy(BigDecimal lng, BigDecimal lat, int range){
	    if(lng != null && lat != null){
		    double[] xyRange = LatLonUtil.GetAround(lat.doubleValue(), lng.doubleValue(), range);
		    min_lat = xyRange[0];
		    min_lng = xyRange[1];
		    max_lat = xyRange[2];
		    max_lng = xyRange[3];
	    }
	}



	private Double power;
	private Integer cityId;
	private Long communityId;
	private String communityName;
	private Integer buildyear;
	private String currentfloor;
	private Integer totalfloor;
	private Integer buildingsquare;
	private String aspectName;
	private Integer aspect;
	private Integer sqmprice;
	private BigDecimal totalsqmprice;
	private String dayId;
	private String buildingtype;
	private String communitytype;
	private String floorplantype;
	private String floorplantypeCN;
	private Integer floortype;
	
	public Integer getFloorByType(){
		Integer ret = StringUtil.parseInt(this.getAtfloor(), null);
		/**
		 * 
                  when t.floortype = 15753745 then
                   '高层'
                  when t.floortype = 15753744 then
                   '中层'
                  when t.floortype = 15753743 then
                   '低层'
                   else '--'
		 */
		if(ret == null){
			if(this.floortype != null && this.totalfloor != null){
				if(this.floortype.equals(15753745)){
					ret = totalfloor / 3 * 25 / 10;
				}else if(this.floortype.equals(15753744)){
					ret = totalfloor / 3 * 15 / 10;
				}else if(this.floortype.equals(15753743)){
					ret = totalfloor / 3 * 5 / 10;
				}
			}
		}
		return ret;
	}

	public BigDecimal getTotalsqmprice() {
		return totalsqmprice;
	}

	public void setTotalsqmprice(BigDecimal totalsqmprice) {
		this.totalsqmprice =  totalsqmprice;
	}

	public Integer getFloortype() {
		return floortype;
	}
	public void setFloortype(Integer floortype) {
		this.floortype = floortype;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getFloorplantypeCn() {
		return floorplantype == null ? null : PubDictValue.getRoomTypeNameByCode(floorplantype);
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Long getCommunityId() {
		return communityId;
	}
	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
	}
	public Integer getBuildyear() {
		return buildyear;
	}
	public void setBuildyear(Integer buildyear) {
		this.buildyear = buildyear;
	}
	public String getCurrentfloor() {
		return currentfloor;
	}
	public void setCurrentfloor(String currentfloor) {
		this.currentfloor = currentfloor;
	}
	public Integer getTotalfloor() {
		return totalfloor;
	}
	public void setTotalfloor(Integer totalfloor) {
		this.totalfloor = totalfloor;
	}
	public Integer getBuildingsquare() {
		return buildingsquare;
	}
	public void setBuildingsquare(Integer buildingsquare) {
		this.buildingsquare = buildingsquare;
	}
	public String getAspectName() {
		return aspectName;
	}
	public void setAspectName(String aspectName) {
		this.aspectName = aspectName;
	}
	public Integer getAspect() {
		return aspect;
	}
	public void setAspect(Integer aspect) {
		this.aspect = aspect;
	}
	public Integer getSqmprice() {
		return sqmprice;
	}
	public void setSqmprice(Integer sqmprice) {
		this.sqmprice = sqmprice;
	}
	public String getDayId() {
		return dayId;
	}
	public void setDayId(String dayId) {
		this.dayId = dayId;
	}
	public String getBuildingtype() {
		return buildingtype;
	}
	public void setBuildingtype(String buildingtype) {
		this.buildingtype = buildingtype;
	}
	public String getCommunitytype() {
		return communitytype == null ? null : PubDictValue.getPurposeNameByCode(communitytype);
	}
	public String getCommunitytypeCode() {
		return communitytype == null ? null : PubDictValue.getPurposeCodeByName(communitytype);
	}
//	public String getCommunitytypeCn() {
//		return communitytype == null ? null : PubDictValue.getPurposeNameByCode(communitytype);
//	}
	public void setCommunitytype(String communitytype) {
		this.communitytype = communitytype;
	}
	
	public String getFloorplantype() {
		return floorplantype;
	}
	public void setFloorplantype(String floorplantype) {
		this.floorplantypeCN = floorplantype == null ? null : PubDictValue.getRoomTypeNameByCode(floorplantype);
		this.floorplantype = floorplantype;
	}
	
	public Double getPower() {
		return power;
	}
	public void setPower(Double power) {
		this.power = power;
	}
	public double getPowerCaseTime() {
		return powerCaseTime;
	}
	public void setPowerCaseTime(double powerCaseTime) {
		this.powerCaseTime = powerCaseTime;
	}
	public double getPowerBuildyear() {
		return powerBuildyear;
	}
	public void setPowerBuildyear(double powerBuildyear) {
		this.powerBuildyear = powerBuildyear;
	}
	public double getPowerCurrentfloor() {
		return powerCurrentfloor;
	}
	public void setPowerCurrentfloor(double powerCurrentfloor) {
		this.powerCurrentfloor = powerCurrentfloor;
	}
	public double getPowerRoomCount() {
		return powerRoomCount;
	}
	public void setPowerRoomCount(double powerRoomCount) {
		this.powerRoomCount = powerRoomCount;
	}
	public double getPowerAspect() {
		return powerAspect;
	}
	public void setPowerAspect(double powerAspect) {
		this.powerAspect = powerAspect;
	}
	public double getPowerMianji() {
		return powerMianji;
	}
	public void setPowerMianji(double powerMianji) {
		this.powerMianji = powerMianji;
	}



	private double powerCaseTime;//案例时间
	private double powerBuildyear;//建成年代
	private double powerCurrentfloor;//所在层
	private double powerRoomCount;//居室数
	private double powerAspect;//朝向
	private double powerMianji;//面积
	
	/**
	 * 
权重参数	条件	第一项	第二项	第三项	第四项
30%	案例时间
	（3,6）	（2,3）	（1,2）	（0,1）
		50%	80%	90%	100%
25%	建成年代	（5,5以上）	（3,5）	（1,3）	（0,1）
		70%	80%	90%	100%
20%	面积	（15,20）	（10,15）	（5,10）	（0,5）
		70%	80%	90%	100%
15%	居室	[3,3以上）	2	1	0
		60%	80%	90%	100%
5%	朝向
	（0.05,0.06）	（0.03,0.04）	（0.01,0.02）	0
		70%	80%	90%	100%
5%	所在层	[4,4以上）	3	2	（0,1）
	居室	70%	80%	90%	100%

	 * @param item
	 * @return
	 */
	public double getDistances(AvmCaseData item){
		double ret = 0.0;
		if(item == null){
			return ret;
		}
		Date itemDate = StringUtil.getDate(item.getDayId(), null);
		long _c = 0l;
		if(itemDate != null){
			_c = itemDate.getTime();
		}
		long a_b = System.currentTimeMillis() - _c;
		long year_count = 99999l;
		try {
			if(this.buildyear != null && this.buildyear > 0){
				year_count = CommonHelper.subAbs(this.buildyear, StringUtil.parseInt(item.getBuildyear(), -99999), 99999l);
			}
		} catch (Exception e) {
			year_count = 99999l;
			e.printStackTrace();
		}
		long mianji_cha = 99999l;
		try {
			if(this.buildingsquare != null && this.buildingsquare > 0){
				mianji_cha = CommonHelper.subAbs(this.buildingsquare, StringUtil.parseInt(item.getBuildingsquare(), -99999), 99999l);
			}
		} catch (Exception e) {
			mianji_cha = 99999l;
			e.printStackTrace();
		}
		long ceng_cha = 99999l;
		try {
			Integer a = this.getFloorByType();
			Integer b = item.getFloorByType();
			if(a != null && b != null){
				if(a >= b){
					ceng_cha = Math.abs(a - b);
				}else{
					ceng_cha = Math.abs(b - a);
				}
			}
		} catch (Exception e) {
			ceng_cha = 99999l;
			e.printStackTrace();
		}
		long roomCount_cha = 99999l;
		try {
			if(StringUtil.isNotNullOrEmpty(this.floorplantype) && StringUtil.isNotNullOrEmpty(item.getFloorplantype())){
				//写一个公共方法，减法绝对值
				roomCount_cha = CommonHelper.subAbs(PubDictValue.getRoomCountByName(StringUtil.toString(this.floorplantype)), 
						PubDictValue.getRoomCountByCode(StringUtil.toString(item.getFloorplantype())), 99999l);

			}
		} catch (Exception e) {
			roomCount_cha = 99999l;
			e.printStackTrace();
		}
		double aspect_cha = 99999.0;
		try {
			if(StringUtil.isNotNullOrEmpty(this.aspectName) && StringUtil.isNotNullOrEmpty(item.getAspect())){
				aspect_cha = CommonHelper.subAbs(PubDictValue.getAspectValueByName(StringUtil.toString(this.aspectName))
						, PubDictValue.getAspectValueByCode(StringUtil.toString(item.getAspect())), 99999.0);
			}
		} catch (Exception e) {
			aspect_cha = 99999.0;
			e.printStackTrace();
		}
//5%	朝向
//	（0.05,0.06）	（0.03,0.04）	（0.01,0.02）	0
//		70%	80%	90%	100%
//		if(aspect_cha == 0){
//			ret += 100 * 1.0 * 0.05;
//			item.setPowerAspect(100 * 1.0 * 0.05);
//		}else if(aspect_cha >= 0.01 && aspect_cha <= 0.02){
//			ret += 100 * 0.9 * 0.05;
//			item.setPowerAspect(100 * 0.9 * 0.05);
//		}else if(aspect_cha >= 0.03 && aspect_cha <= 0.04){
//			ret += 100 * 0.8 * 0.05;
//			item.setPowerAspect(100 * 0.8 * 0.05);
//		}else if(aspect_cha >= 0.05 && aspect_cha <= 0.06){
//			ret += 100 * 0.7 * 0.05;
//			item.setPowerAspect(100 * 0.7 * 0.05);
//		}
		double aspectScroe = getAspectScore(aspect_cha);
		ret += aspectScroe;
		item.setPowerAspect(aspectScroe);
//发布时间
//		if(a_b < 2678400000l){//如果在一个月内
//			ret += 100 * 1.0 * 0.3;
//			item.setPowerCaseTime(100 * 1.0 * 0.3);
//		}else if(2678400000l <= a_b && a_b < 2678400000l*2){//两个月内
//			ret += 100 * 0.9 * 0.3;
//			item.setPowerCaseTime(100 * 0.9 * 0.3);
//		}else if(2678400000l*2 <= a_b && a_b < 2678400000l*3){//三个月内
//			ret += 100 * 0.8 * 0.3;
//			item.setPowerCaseTime(100 * 0.8 * 0.3);
//		}else if(2678400000l*3 <= a_b){//四个月内
//			ret += 100 * 0.5 * 0.3;
//			item.setPowerCaseTime(100 * 0.5 * 0.3);
//		}
		double timeScore = getTimeScore(a_b);
		ret += timeScore;
		item.setPowerCaseTime(timeScore);
//建成年代		
//		if(year_count < 1){//1年内的
//			ret += 100 * 1.0 * 0.20;
//			item.setPowerBuildyear(100 * 1.0 * 0.20);
//		}else if(year_count >= 1 && year_count < 3){//3年内的
//			ret += 100 * 0.9 * 0.20;
//			item.setPowerBuildyear(100 * 0.9 * 0.20);
//		}else if(year_count >= 3 && year_count < 5){//5年内的
//			ret += 100 * 0.8 * 0.20;
//			item.setPowerBuildyear(100 * 0.8 * 0.20);
//		}else if(year_count >= 5){//5年以上 的
//			ret += 100 * 0.7 * 0.20;
//			item.setPowerBuildyear(100 * 0.7 * 0.20);
//		}
		double yearScore = getYearScore(year_count);
		ret += yearScore;
		item.setPowerBuildyear(yearScore);
		
//20%	面积	（15,20）	（10,15）	（5,10）	（0,5）
//		70%	80%	90%	100%
//		if(mianji_cha < 5){
//			ret += 100 * 1.0 * 0.20;
//			item.setPowerMianji(100 * 1.0 * 0.20);
//		}else if(mianji_cha >= 5 && mianji_cha < 10){
//			ret += 100 * 0.9 * 0.20;
//			item.setPowerMianji(100 * 0.9 * 0.20);
//		}else if(mianji_cha >= 10 && mianji_cha < 15){
//			ret += 100 * 0.8 * 0.20;
//			item.setPowerMianji(100 * 0.8 * 0.20);
//		}else if(mianji_cha >= 15 && mianji_cha < 20){
//			ret += 100 * 0.7 * 0.20;
//			item.setPowerMianji(100 * 0.7 * 0.20);
//		}
		double mianjiScore = getMianjiScore(mianji_cha);
		ret += mianjiScore;
		item.setPowerMianji(mianjiScore);
//		5%	所在层	[4,4以上）	3	2	（0,1）
//		  		居室	70%	80%	90%	100%
//		if(ceng_cha <= 1){
//			ret += 100 * 1.0 * 0.05;
//			item.setPowerCurrentfloor(100 * 1.0 * 0.05);
//		}else if(ceng_cha ==2){
//			ret += 100 * 0.9 * 0.05;
//			item.setPowerCurrentfloor(100 * 0.9 * 0.05);
//		}else if(ceng_cha == 3){
//			ret += 100 * 0.8 * 0.05;
//			item.setPowerCurrentfloor(100 * 0.8 * 0.05);
//		}else if(ceng_cha >= 4){
//			ret += 100 * 0.7 * 0.05;
//			item.setPowerCurrentfloor(100 * 0.7 * 0.05);
//		}
		double cengScore = getCengScore(ceng_cha);
		ret += cengScore;
		item.setPowerCurrentfloor(cengScore);
		
//		15%	居室	[3,3以上）	2	1	0
//		 		60%	80%	90%	100%
//		if(roomCount_cha == 0){
//			ret += 100 * 1.0 * 0.20;
//			item.setPowerRoomCount(100 * 1.0 * 0.20);
//		}else if(roomCount_cha == 1){
//			ret += 100 * 0.9 * 0.20;
//			item.setPowerRoomCount(100 * 0.9 * 0.20);
//		}else if(roomCount_cha == 2){
//			ret += 100 * 0.8 * 0.20;
//			item.setPowerRoomCount(100 * 0.8 * 0.20);
//		}else if(roomCount_cha >= 3){
//			ret += 100 * 0.6 * 0.20;
//			item.setPowerRoomCount(100 * 0.6 * 0.20);
//		}
		
		Double roomScore = getRoomScore(roomCount_cha);
		ret += roomScore;
		item.setPowerRoomCount(roomScore);
		if(item.getJuli() != null){
			ret += item.getJuli().longValue();
		}
		item.setPower(ret);
		return ret;
	}
//	20%	面积	（18,20）	（16,18）	（14,16）	（12,14）	（10,12）	（8,10）	（6,8）	（4,6）	（2,4）	（0,2）
//	65	72	77	82	87	92	94	96	98	100
	private static Double getMianjiScore(long mianji_cha){
		Double ret = 0.0;
		if(mianji_cha <= 2){//（0,2）
			ret = 100 * 1.00 * MIANJI_POWER;
		}else if(mianji_cha > 2 && mianji_cha <= 4){//（2,4）
			ret = 100 * 0.98 * MIANJI_POWER;
		}else if(mianji_cha > 4 && mianji_cha <= 6){//（4,6）
			ret = 100 * 0.96 * MIANJI_POWER;
		}else if(mianji_cha > 6 && mianji_cha <= 8){//（6,8）
			ret = 100 * 0.94 * MIANJI_POWER;
		}else if(mianji_cha > 8 && mianji_cha <= 10){//（8,10）
			ret = 100 * 0.92 * MIANJI_POWER;
		}else if(mianji_cha > 10 && mianji_cha <= 12){//（10,12）
			ret = 100 * 0.87 * MIANJI_POWER;
		}else if(mianji_cha > 12 && mianji_cha <= 14){//（12,14）
			ret = 100 * 0.82 * MIANJI_POWER;
		}else if(mianji_cha > 14 && mianji_cha <= 16){//（14,16）
			ret = 100 * 0.77 * MIANJI_POWER;
		}else if(mianji_cha > 16 && mianji_cha <= 18){//（16,18）
			ret = 100 * 0.72 * MIANJI_POWER;
		}else if(mianji_cha > 18 && mianji_cha <= 20){//（18,20）
			ret = 100 * 0.65 * MIANJI_POWER;
		}
		return ret;
	}
	
//	20%	建成年代	（5,5以上）	（4,5）	（3,4）	（2,3）	（1,2）	（0,1）
//	70%	80%	85%	90%	95%	100%
	private static Double getYearScore(long year_count){
		Double ret = 0.0;
		if(year_count < 1){//（0,1）
			ret = 100 * 1.00 * YEAR_POWER;
		}else if(year_count >= 1 && year_count < 2){//（1,2）
			ret = 100 * 0.95 * YEAR_POWER;
		}else if(year_count >= 2 && year_count < 3){//（2,3）
			ret = 100 * 0.90 * YEAR_POWER;
		}else if(year_count >= 3 && year_count < 4){//（3,4）
			ret = 100 * 0.85 * YEAR_POWER;
		}else if(year_count >= 4 && year_count < 5){//（4,5）
			ret = 100 * 0.80 * YEAR_POWER;
		}else if(year_count >= 5){//（5,5以上）
			ret = 100 * 0.70 * YEAR_POWER;
		}
		return ret;
	}
	
	private static Double getAspectScore(double aspect_cha){
		Double ret = 0.0;
		if(aspect_cha == 0){
			ret = 100 * 1.0 * ASPECT_POWER;
		}else if(aspect_cha >= 0.01 && aspect_cha <= 0.02){
			ret = 100 * 0.9 * ASPECT_POWER;
		}else if(aspect_cha >= 0.03 && aspect_cha <= 0.04){
			ret = 100 * 0.8 * ASPECT_POWER;
		}else if(aspect_cha >= 0.05 && aspect_cha <= 0.06){
			ret = 100 * 0.7 * ASPECT_POWER;
		}
		return ret;
	}
	
//	30%	案例时间	(120天,180天)	(90天,120天)	(75天,90天)	(60天,75天)	(45天,60天)	(30天,45天)	(21天,30天)	(14天,21天)	(7天,14天)	(0,7天)
//	50%	60%	65%	70%	75	80	85	90	95	100
	private static Double getTimeScore(long sub){
		Double ret = 0.0;
		if(sub <= 86400000l * 7l){//(0,7天)
			ret = 100 * 1.00 * TIME_POWER;
		}else if(86400000l * 7l < sub && sub <= 86400000l * 14l){//(7天,14天)
			ret = 100 * 0.95 * TIME_POWER;
		}else if(86400000l * 14l < sub && sub <= 86400000l * 21l){//(14天,21天)
			ret = 100 * 0.90 * TIME_POWER;
		}else if(86400000l * 21l < sub && sub <= 86400000l * 30l){//(21天,30天)
			ret = 100 * 0.85 * TIME_POWER;
		}else if(86400000l * 30l < sub && sub <= 86400000l * 45l){//(30天,45天)
			ret = 100 * 0.80 * TIME_POWER;
		}else if(86400000l * 45l < sub && sub <= 86400000l * 60l){//(45天,60天)
			ret = 100 * 0.75 * TIME_POWER;
		}else if(86400000l * 60l < sub && sub <= 86400000l * 75l){//(60天,75天)
			ret = 100 * 0.70 * TIME_POWER;
		}else if(86400000l * 75l < sub && sub <= 86400000l * 90l){//(75天,90天)
			ret = 100 * 0.65 * TIME_POWER;
		}else if(86400000l * 90l < sub && sub <= 86400000l * 120l){//(90天,120天)
			ret = 100 * 0.60 * TIME_POWER;
		}else if(86400000l * 120l < sub && sub <= 86400000l * 180l){//(120天,180天)
			ret = 100 * 0.50 * TIME_POWER;
		}
		return ret;
	}

//	10%	所在层	（10,10以上）	9	8	7	6	5	4	3	2	（0,1）
//	55	60	65	70	75	80	85	90	95	100
	private static Double getCengScore(long ceng_cha){
		Double ret = 0.0;
		if(ceng_cha <= 1){
			ret = 100 * 1.00 * CENG_POWER;
		}else if(ceng_cha == 2){
			ret = 100 * 0.95 * CENG_POWER;
		}else if(ceng_cha == 3){
			ret = 100 * 0.90 * CENG_POWER;
		}else if(ceng_cha == 4){
			ret = 100 * 0.85 * CENG_POWER;
		}else if(ceng_cha == 5){
			ret = 100 * 0.80 * CENG_POWER;
		}else if(ceng_cha == 6){
			ret = 100 * 0.75 * CENG_POWER;
		}else if(ceng_cha == 7){
			ret = 100 * 0.70 * CENG_POWER;
		}else if(ceng_cha == 8){
			ret = 100 * 0.65 * CENG_POWER;
		}else if(ceng_cha == 9){
			ret = 100 * 0.60 * CENG_POWER;
		}else if(ceng_cha >= 10){
			ret = 100 * 0.55 * CENG_POWER;
		}
		return ret;
	}
	
	private static Double getRoomScore(long roomCount_cha){
		Double ret = 0.0;
		if(roomCount_cha == 0){
			ret = 100 * 1.0 * ROOM_COUNT_POWER;
		}else if(roomCount_cha == 1){
			ret = 100 * 0.9 * ROOM_COUNT_POWER;
		}else if(roomCount_cha == 2){
			ret = 100 * 0.8 * ROOM_COUNT_POWER;
		}else if(roomCount_cha >= 3){
			ret = 100 * 0.6 * ROOM_COUNT_POWER;
		}
		return ret;
	}
	
	private static final double CENG_POWER = 0.10;
	private static final double ROOM_COUNT_POWER = 0.15;
	private static final double MIANJI_POWER = 0.20;
	private static final double YEAR_POWER = 0.15;
	private static final double ASPECT_POWER = 0.05;
	private static final double TIME_POWER = 0.35;
	
	public String toString(){
		String aspect = this.getAspectName();
		if(aspect == null || aspect.isEmpty()){
			aspect = StringUtil.toString(this.getAspect());
		}
		Integer mianji = this.getBuildingsquare();
		String fpt = this.getFloorplantypeCn();
		if(fpt == null || fpt.isEmpty()){
			fpt = StringUtil.toString(this.getFloorplantype());
		}
		String floor = this.getCurrentfloor();
		Integer sqm = this.getSqmprice();
		Integer by = this.getBuildyear();
		String assessTime = this.assessTime == null ? "" : this.assessTime.toString();
		return "朝向：" + aspect + "(" + this.getPowerAspect() + ")" +
				"，面积：" + mianji + "(" + this.getPowerMianji() + ")" +
				"，户型：" + fpt + "(" + this.getPowerRoomCount() + ")" +
				"，当前层：" + floor + "_" + getFloorByType() + "(" + this.getPowerCurrentfloor() + ")" +
				"，年代：" + by + "(" + this.getPowerBuildyear() + ")" +
				"，评估时间：" + assessTime + "(" + this.getPowerCaseTime() + ")" +
				"，单价：" + sqm +
				"，权重得分：" + (this.getPowerAspect() + this.getPowerMianji() + this.getPowerRoomCount() + this.getPowerCurrentfloor() + this.getPowerBuildyear() + this.getPowerCaseTime())
				;
	}
    
}



