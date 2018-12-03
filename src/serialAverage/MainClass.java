package serialAverage;
import java.util.Scanner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.loadLibrary("rxtxSerial.dll");
		
		Date logTime = new Date();
		
		Scanner scanner = new Scanner(System.in);
		String port;
		System.out.println("input port : ");
		port = scanner.nextLine();
		Timer timer = new Timer(3600);
		
		DateFormat form = new SimpleDateFormat("YYYY-MM-dd");
		
		OtherClass myObject = new OtherClass("serial"+form.format(timer.getStartTime())+".txt", 
				                             "Json"+form.format(timer.getStartTime())+".txt",
				                             "aver"+form.format(timer.getStartTime())+".txt");
		
		final SerialConnect serial = new SerialConnect();
		
	     try{
	            serial.connect("COM"+port); //입력한 포트로 연결
	        }catch(Exception e){
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run(){

				while(true){
				
					try{
						if(serial.getSerial().length() > 0){
							logTime.setTime(System.currentTimeMillis());
							myObject.JsonWriter(
							myObject.serialWriter(serial.getSerial(), logTime.toString()), 
							String.valueOf(timer.getStartTime_mil()));
							serial.setSerial();						
						}
						
						if(timer.checkTime()){
							myObject.JsonCreate(String.valueOf(timer.getStartTime_mil()));
							myObject.getAver(String.valueOf(timer.getStartTime_mil()));
							timer.changeStarttime();
						}
					}catch(Exception e){
						System.out.println(e);
					}
					
					
//					try {
//						Thread.sleep(1000);
//						
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
				}
			}
		});
		
		thread.start();
	}
}