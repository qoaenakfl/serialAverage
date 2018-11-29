package serialAverage;

import java.io.*;
import java.util.Date;

public class FileIO {

	private File file;
	private BufferedWriter buffer;
	private Date logtime; 
	
	public FileIO(String s){
		try{
			file = new File(s);
			logtime = new Date();
			buffer = new BufferedWriter(new FileWriter(file, true));
		}catch(IOException e){
			System.out.println(e+"\n\n\n file create or read fail!!!");
		}
		
	}
	
	public void FileWrite(String s){
		try{
			if(file.isFile() && file.canWrite()){
				logtime.setTime(System.currentTimeMillis());
				
				buffer.write(s);
				buffer.newLine();
				buffer.flush();
				//buffer.close();
				System.out.println(logtime.toString()+"file write success!!");
			}
		}catch(IOException e){
			System.out.println(e+"\n\n\n file write fail!!");
		}finally {
//			try {
//				buffer.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}
