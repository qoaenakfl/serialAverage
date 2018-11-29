package serialAverage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.simple.*;
import org.json.JSONException;
import org.json.JSONObject;

public class OtherClass {
	  private String message;
	  private boolean answer = false;
	  private FileIO fileio;
	  private FileIO Jsonfileio;
	  private JSONObject jsonObject;
	  
	  public OtherClass(String s1, String s2){
		  fileio = new FileIO(s1);
		  Jsonfileio = new FileIO(s2);
	  }
	  
	  private void JsonWriter(String[] s, String time) {
		  jsonObject = new JSONObject();
		  JSONObject obj = new JSONObject();
		  String[] temp;
		  
		  try {
			temp = s[0].split(":");  
			obj.put(temp[0], temp[1].substring(0, 4)+"."+temp[1].substring(4, 6));
			temp = s[1].split(":");
			obj.put(temp[0], temp[1].substring(1, 3)+"."+temp[1].substring(3, 5));
			temp = s[2].split(":");
			obj.put(temp[0], temp[1].substring(2, 4));
			temp = s[3].split(":");
			obj.put(temp[0], temp[1].substring(2, 4));
			
			jsonObject.put(time, obj);
			Jsonfileio.FileWrite(jsonObject.toString(), time);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  public String[] serialWriter(String s, String logTime){	    

		s = s.replaceAll("@", "");
	    String[] temp = s.split(",");

	    //Pattern p = Pattern.compile("[0-9]");
	    	
	    StringBuffer writeText=new StringBuffer("");
	    String[] temp2;
	    
	   
		temp2 = temp[0].split(":");
		writeText.append(temp2[0]);
		writeText.append(" : ");
		writeText.append(temp2[1].substring(0, 4));
		writeText.append(".");
		writeText.append(temp2[1].substring(4, 6));
		writeText.append("µµ");
		writeText.append(" \n");
		
		temp2 = temp[1].split(":");
		writeText.append(temp2[0]);
		writeText.append(" : ");
		writeText.append(temp2[1].substring(1, 3));
		writeText.append(".");
		writeText.append(temp2[1].substring(3, 5));
		writeText.append("%");
		writeText.append(" \n");
		
		temp2 = temp[2].split(":");
		writeText.append(temp2[0]);
		writeText.append(" : ");
		writeText.append(temp2[1].substring(2, 4));
		writeText.append("¥ìg/m3");
		writeText.append(" \n");
		
		temp2 = temp[3].split(":");
		writeText.append(temp2[0]);
		writeText.append(" : ");
		writeText.append(temp2[1].substring(2, 4));
		writeText.append("¥ìg/m3");
		writeText.append(" \n");
	   
	   writeText.append("\n");
	   
	   System.out.println(writeText);
	   fileio.FileWrite(writeText.toString(), logTime);
	    
	      
//	    fileio.FileWrite(temp[i]);
//	    fileio.FileWrite(val);
//	    System.out.println(val);

	    fileio.FileWrite("", logTime);

	    JsonWriter(temp, logTime);
	    
	    return temp;

	  }

	  public void endprogram() {
		  fileio.FileClose();
	  }
	  
	  public String toString(){

	    return message;

	  }


}
