package serialAverage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;


public class OtherClass {
	  private String message;
	  private boolean answer = false;
	  private FileIO fileio;
	  
	  public OtherClass(String s){
		  fileio = new FileIO(s);
	  }
	  
	  public String[] averText(String s){	    

		s = s.replaceAll("@", "");
	    String[] temp = s.split(",");

	    //Pattern p = Pattern.compile("[0-9]");
	    	
	    StringBuffer writeText=new StringBuffer("");
	    String[] temp2;
	    
	   
		temp2 = temp[i].split(":");
		writeText.append(temp2[0]);
		writeText.append(" : ");
		writeText.append(temp2[1]);
		writeText.append("\n");
	   
	   writeText.append("\n");
	   System.out.println(writeText);
	   fileio.FileWrite(writeText.toString());
	    
	      
//	    fileio.FileWrite(temp[i]);
//	    fileio.FileWrite(val);
//	    System.out.println(val);

	    fileio.FileWrite("");

	    return temp;

	  }

	  public String toString(){

	    return message;

	  }


}
