package com.awign.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	

/** 
* @author : Partheeban.moorthy@awign.com
* 
*/
	
	
	public void addData(String data) {
		try { 
		File file = new File( "C:\\work\\apiautomation-master\\logs\\abc.txt"); 
		   FileWriter fr = new FileWriter(file, true);
	       if(!(fr.toString()==null))
	            {
		              fr.append(data + "\n");
		              fr.close();
		            }else {
		            	fr.write("data");
		            	fr.close();
		            }
  	        } 
	        catch (IOException e) { 
	            System.out.println("Exception Occurred" + e); 
	        } 
	}
	
	public void cleanDirectory(String opfilepath){
		try{
		File f = new File(opfilepath);
		for (File file: f.listFiles()) if (!file.isDirectory()) file.delete();
		}catch(Exception e){}
		}

	public Boolean createFolder(String dir){
		boolean success = false;
		try{
		if(dir.length()>=2){
		File directory = new File(dir);
		       if (directory.exists()) {
		           System.out.println("Directory already exists ...");
		       } else {
		           System.out.println("Directory not exists, creating now");
		           success = directory.mkdir();
		           if (success) {
		               System.out.printf("Successfully created new directory : %s%n", dir);
		               return success=true;
		           } else {
		               System.out.printf("Failed to create new directory: %s%n", dir);
		               return success=false;
		           }
		       }
		}else{
		System.out.println("Specify right directory");
		return success=false;
		}
		}catch(Exception e){e.printStackTrace();}
		return success;
		}

}
