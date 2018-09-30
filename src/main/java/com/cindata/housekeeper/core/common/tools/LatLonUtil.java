package com.cindata.housekeeper.core.common.tools;

public class LatLonUtil {
	private static double PI = 3.14159265;
	private static double EARTH_RADIUS = 6378137;
	private static double RAD = Math.PI / 180.0;

	public static void main(String[] args) {
		//126.52573440062511,45.80585165463168
		//126.52573440062511,45.80585165463168
		double[] res = GetAround(45.80585165463168, 126.52573440062511, 800);
		double[] res0 = findNeighPosition(45.80585165463168, 126.52573440062511, 800);
		
		//126.51284479458799(Double), 126.53862400666223(Double), 45.7968664149096(Double), 45.81483689435376(Double)
		//126.51284479458799(Double), 126.53862400666223(Double), 45.7968664149096(Double), 45.81483689435376(Double)
		System.out.println(GetDistance(45.7968664149096, 126.51284479458799, 45.81483689435376, 126.53862400666223));
		System.out.println(GetDistance(res[0], res[1], res[2], res[3]));
		System.out.println(res[0] + "," + res[1] + "," + res[2] + "," + res[3]);
		System.out.println(res0[0] + "," + res0[1] + "," + res0[2] + "," + res0[3]);
		System.out.println(GetDistance(res0[0], res0[1], res0[2], res0[3]));
		
		//126.555331163527,45.81140146216261
		//126.63828891547449,45.70177634452192
		double a = getAngle1( 45.75977634452192, 126.64928891547449, 45.81140146216261, 126.555331163527);
		double b = gps2d(126.555331163527, 45.81140146216261, 126.63828891547449, 45.70177634452192);
		System.out.println(a);
		System.out.println(b);
		//126.45928891547449,45.65977634452192
		a = getAngle1(45.81140146216261, 126.555331163527, 45.65977634452192, 126.45928891547449);
		System.out.println(a);
	}

	public static double[] findNeighPosition(double latitude,double longitude, int range){  
        //先计算查询点的经纬度范围  
        double r = 6378137;//地球半径千米  
        double dis = range;//0.5千米距离  
        double dlng =  2*Math.asin(Math.sin(dis/(2*r))/Math.cos(latitude*Math.PI/180));  
        dlng = dlng*180/Math.PI;//角度转为弧度  
        double dlat = dis/r;  
        dlat = dlat*180/Math.PI;          
        double minlat =latitude-dlat;  
        double maxlat = latitude+dlat;  
        double minlng = longitude -dlng;  
        double maxlng = longitude + dlng;  
          
        double[] values = {minlat,minlng,maxlat,maxlng};
          
        return values;  
    }  
	
	// / <summary>
	// / 根据提供的经度和纬度、以及半径，取得此半径内的最大最小经纬度
	// / </summary>
	// / <param name="lat">纬度</param>
	// / <param name="lon">经度</param>
	// / <param name="raidus">半径(米)</param>
	// / <returns></returns>
	public static double[] GetAround(double lat, double lon, int raidus) {

		Double latitude = lat;
		Double longitude = lon;

		Double degree = (24901 * 1609) / 360.0;
		double raidusMile = raidus;

		Double dpmLat = 1 / degree;
		Double radiusLat = dpmLat * raidusMile;
		Double minLat = latitude - radiusLat;
		Double maxLat = latitude + radiusLat;

		Double mpdLng = degree * Math.cos(latitude * (PI / 180));
		Double dpmLng = 1 / mpdLng;
		Double radiusLng = dpmLng * raidusMile;
		Double minLng = longitude - radiusLng;
		Double maxLng = longitude + radiusLng;
		return new double[] { minLat, minLng, maxLat, maxLng };
	}

	// / <summary>
	// / 根据提供的两个经纬度计算距离(米)
	// / </summary>
	// / <param name="lng1">经度1</param>
	// / <param name="lat1">纬度1</param>
	// / <param name="lng2">经度2</param>
	// / <param name="lat2">纬度2</param>
	// / <returns></returns>
	public static double GetDistance(double lng1, double lat1, double lng2,
			double lat2) {
		double radLat1 = lat1 * RAD;
		double radLat2 = lat2 * RAD;
		double a = radLat1 - radLat2;
		double b = (lng1 - lng2) * RAD;
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}

	public static double gps2d(double lng_a, double lat_a, double lng_b, double lat_b) {
		double d = 0;
		lat_a = lat_a * Math.PI / 180;
		lng_a = lng_a * Math.PI / 180;
		lat_b = lat_b * Math.PI / 180;
		lng_b = lng_b * Math.PI / 180;

		d = Math.sin(lat_a) * Math.sin(lat_b) + Math.cos(lat_a)
				* Math.cos(lat_b) * Math.cos(lng_b - lng_a);
		d = Math.sqrt(1 - d * d);
		d = Math.cos(lat_b) * Math.sin(lng_b - lng_a) / d;
		d = Math.asin(d) * 180 / Math.PI;
		return d;
	}
	
	
	
    public static double getAngle1(double lat_a, double lng_a, double lat_b, double lng_b) {  
    	  
        double y = Math.sin(lng_b-lng_a) * Math.cos(lat_b);  
        double x = Math.cos(lat_a)*Math.sin(lat_b) - Math.sin(lat_a)*Math.cos(lat_b)*Math.cos(lng_b-lng_a);  
        double brng = Math.atan2(y, x);  
  
        brng = Math.toDegrees(brng);  
        //if(brng < 0)  
            //brng = brng +360;  
        return brng;  
  
    } 
	
	/**
	 * 根据方位角获取方向
	 */
	public static String getDirection(double az){
		String val = null;
		if(az >= 340 || az <= 20){
			val = "北";
		}else if(az >= 20 && az <= 70){
			val = "东北";
		}else if(az >= 70 && az <= 110){
			val = "东";
		}else if(az >= 110 && az <= 160){
			val = "东南";
		}else if(az >= 160 && az <= 200){
			val = "南";
		}else if(az >= 200 && az <= 250){
			val = "西南";
		}else if(az >= 250 && az <= 290){
			val = "西";
		}else if(az >= 290 && az <= 340){
			val = "西北";
		}
		return val;
	}
}