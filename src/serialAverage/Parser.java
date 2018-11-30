package serialAverage;

import org.json.simple.*;

public class Parser {
	
	private float t;
	private float h;
	private int pm25;
	private int pm10;
	
	public void clear(){
		t = h = pm25 = pm10 = 0;
	}
	
	public String Aver(int size){
		StringBuffer str = new StringBuffer();
		
		str.append("T :");
		str.append(t/size);
		str.append("µµ");
		
		str.append("H :");
		str.append(h/size);
		str.append("&");
		
		str.append("PM25 :");
		str.append(pm25/size);
		str.append("¥ìg/m3");
		
		str.append("PM10 :");
		str.append(pm10/size);
		str.append("¥ìg/m3");
		
		return str.toString();
	}

	public void Sum(JSONObject obj){
		String temp = obj.get("T").toString();
		
		if(temp.charAt(0) == '+'){
			t += Float.parseFloat(temp.substring(1, 7));
		}else{
			t += Float.parseFloat("-"+temp.substring(1, 7));
		}
		
		temp = obj.get("H").toString();
		h += Float.parseFloat(temp);
		
		temp = obj.get("PM25").toString();
		pm25 += Integer.parseInt(temp);
		
		temp = obj.get("PM10").toString();
		pm25 += Integer.parseInt(temp);
	}
}
