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
		}catch(IOException e){
			System.out.println(e+"\n\n\n file create or read fail!!!");
		}
		
	}
	
	public void FileWrite(String s, String time){
		try{
			if(file.isFile() && file.canWrite()){
				Wbuffer.write(s);
				Wbuffer.newLine();
				
				//buffer.close();
				System.out.println(time+"file write success!!");
			}
		}catch(IOException e){
			System.out.println(e+"\n\n\n file write fail!!");
		}finally {
			try {
				Wbuffer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			try {
//				buffer.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
	
	public String FileRead() {
		try {
			Rbuffer = new BufferedReader(new FileReader(file));
			
			String str = "";

			if(file.isFile() && file.canRead()) {
				
				try {
					String lastStr = "";
					while(str != null){
						lastStr = str;
						str = Rbuffer.readLine();
						if(str == null){
							try {
								Rbuffer.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return lastStr;
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return "";
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
