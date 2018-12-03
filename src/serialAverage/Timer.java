package serialAverage;

import java.io.StreamTokenizer;
import java.util.Date;

public class Timer {

	private long startTime;
	private long nowTime;
//	private SimpleDateFormat dayTime;
	private Date startDate;
//	private Date nowTime;
	private int benchmark;
	
	public Timer(int t){
		startTime = System.currentTimeMillis();
		nowTime = System.currentTimeMillis();
		startDate = new Date(startTime);
//		dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		startTime = new Date(time);
//		nowTime  = new Date(time);
		benchmark = t*1000;
	}
	
	public boolean checkTime(){
		
		//nowTime.setTime(System.currentTimeMillis());
		
		nowTime = System.currentTimeMillis();
		
		if(nowTime-startTime>=benchmark){
			System.out.println("Passed 1Hour! Start Time : "+startDate.toString()); 
			return true;
		}
		
		return false;
	}
	
	public void changeStarttime(){
		startTime = nowTime;
	}
	
	public long getStartTime_mil(){
		return startTime;
	}	
	public Date getStartTime() {
		return startDate;
	}
}
