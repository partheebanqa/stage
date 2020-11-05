package com.awign.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.awign.dataprovider.BaseController;
import com.awign.dataprovider.DataConstants;


public class PropertyUtil {
	public static DataConstants dp = new DataConstants();
	 public static BaseController basecontroller = new BaseController();	 


    public void ConfigfileReader() {
	 	//properties = new Properties();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(dp.ATTRIBUTE_PATH));
		//	basecontroller.prop = new Properties();
			try {
		//		basecontroller.prop.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + DataConstants.ATTRIBUTE_PATH);
		}		
		


 }


}
