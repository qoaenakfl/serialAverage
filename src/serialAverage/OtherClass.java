package serialAverage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class OtherClass {
	  private String message;
	  private boolean answer = false;
	  
	  private FileIO fileio;
	  private FileIO Jsonfileio;
	  private FileIO averfileio;
	  
	  private JSONObject jsonObject;
	  private JSONArray jsonArray;
	  private JSONParser jsonparser;
	  private Parser parser;
	  
	  public OtherClass(String s1, String s2, String s3){
		  fileio = new FileIO(s1);
		  Jsonfileio = new FileIO(s2);
		  averfileio = new FileIO(s3);
		  jsonObject = new JSONObject();
		  jsonArray = new JSONArray();
		  jsonparser = new JSONParser();
		  parser = new Parser();
	  }
	  
	  public void JsonCreate(String time){
		  jsonObject.put(time, jsonArray);
		Jsonfileio.FileWrite(jsonObject.toString(), time);
		jsonArray = new JSONArray();
	  }
	  
	  public void JsonWriter(String[] s, String time) {
		  JSONObject obj = new JSONObject();
		  String[] temp;
		  
		  if(s == null) {
			  return;
		  }
		  
		  temp = s[0].split(":");  
		obj.put(temp[0], temp[1].substring(0, 4)+"."+temp[1].substring(4, 6));
		temp = s[1].split(":");
		obj.put(temp[0], temp[1].substring(1, 3)+"."+temp[1].substring(3, 5));
		temp = s[2].split(":");
		obj.put(temp[0], temp[1].substring(2, 4));
		temp = s[3].split(":");
		obj.put(temp[0], temp[1].substring(2, 4));
		
		jsonArray.add(obj);
	  }
	  
	  public String[] serialWriter(String s, String logTime){	    

		s = s.replaceAll("@", "");
	    String[] temp = s.split(",");

	    //Pattern p = Pattern.compile("[0-9]");
	    	
	    StringBuffer writeText=new StringBuffer("");
	    String[] temp2;
	    
	    if(s.length() == 0) {
	    	return null;
	    }
	   
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
	    
	    return temp;

	  }
	  
	  public void getAver(String time) {
		  String str = Jsonfileio.FileRead();
		  
		  try {
			parser.clear();  
			JSONObject obj = (JSONObject)jsonparser.parse(str);
			JSONArray arr = (JSONArray)obj.get(time);
			for(int i = 0;i<arr.size();i++){
				obj = (JSONObject) arr.get(i);
				parser.Sum(obj);
			}
			averfileio.FileWrite(parser.Aver(arr.size()), time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }

	  public void endprogram() {
		  fileio.FileClose();
	  }
	  
	  public String toString(){

	    return message;

	  }


}
