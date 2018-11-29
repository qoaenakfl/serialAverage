package serialAverage;

import java.util.Date;

public class Timer {

	private long startTime;
	private long nowTime;
//	private SimpleDateFormat dayTime;
//	private Date startTime;
//	private Date nowTime;
	private int benchmark;
	
	public Timer(int t){
		startTime = System.currentTimeMillis();
		nowTime = System.currentTimeMillis();
//		dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		startTime = new Date(time);
//		nowTime  = new Date(time);
		benchmark = t*1000;
	}
	
	public boolean checkTime(){
		
		//nowTime.setTime(System.currentTimeMillis());
		
		nowTime = System.currentTimeMillis();
		
		if(nowTime-startTime>=benchmark){
			startTime = nowTime;
			return true;
		}
		
		return false;
	}
	
	public Date getStartTime() {
		return new Date(startTime);
	}
}
