package serialAverage;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String filename;
		System.out.println("input file name : ");
		filename = scanner.nextLine();
		OtherClass myObject = new OtherClass("/Users/chinae/Desktop/"+filename+".txt");
		
		String sec;
		System.out.println("input timer per sec : ");
		sec = scanner.nextLine();
		Timer timer = new Timer(Integer.parseInt(sec));
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run(){

				while(true){
					
					if(timer.checkTime()){
						myObject.averText("@@T:+0201205,H:041291A,PM25:0037:,PM10:00505");
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