package serialAverage;

import java.io.*;

public class FileIO {

	private File file;
	private BufferedWriter Wbuffer;
	private BufferedReader Rbuffer;
	
	public FileIO(String s){
		try{
			file = new File(s);
			Wbuffer = new BufferedWriter(new FileWriter(file, true));
			Rbuffer = new BufferedReader(new FileReader(file));
		}catch(IOException e){
			System.out.println(e+"\n\n\n file create or read fail!!!");
		}
		
	}
	
	public void FileWrite(String s, String time){
		try{
			if(file.isFile() && file.canWrite()){
				Wbuffer.write(s);
				Wbuffer.newLine();
				Wbuffer.flush();
				//buffer.close();
				System.out.println(time+"file write success!!");
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
	
	public void FileRead() {
		String str = "";
		if(file.isFile() && file.canRead()) {
			
			while(str!=null) {
				try {
					str = Rbuffer.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void FileClose() {
		try {
			Wbuffer.close();
			Rbuffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
