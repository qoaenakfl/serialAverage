package serialAverage;
import java.util.Scanner;
import java.util.Date;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date logTime = new Date();
		
		Scanner scanner = new Scanner(System.in);
		OtherClass myObject = new OtherClass("serial.txt", "Json.txt");
		
		String sec;
		System.out.println("input timer per sec : ");
		sec = scanner.nextLine();
		Timer timer = new Timer(Integer.parseInt(sec));
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run(){

				while(true){
					
					if(timer.checkTime()){
						logTime.setTime(System.currentTimeMillis());
						myObject.serialWriter("@@T:+0201205,H:041291A,PM25:0037:,PM10:00505", logTime.toString());
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