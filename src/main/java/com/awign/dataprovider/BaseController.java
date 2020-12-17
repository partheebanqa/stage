package com.awign.dataprovider;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONObject;
import com.awign.utilities.JsonUtil;
import com.awign.utilities.ReusableSpecifications;
import com.awign.utilities.StringUtil;
import com.awign.utilities.TestDataGenerator;

/** 
* @author  Partheeban.moorthy@awign.com
* @version 1.0 
*/

public class BaseController {
	 public static JsonUtil jsonUtil = new JsonUtil();
	 public static JSONObject jsonTestDataObject;
	 public static StringUtil fakeData = new StringUtil();
	 public static TestDataFactory testdata;
	 public static ReusableSpecifications restSpec;
	 public static String ENV = "awigntest.com";
	 public String data_file ="member_id.txt";
	 public static String file_path=null;
	 
	 
	
	
	  
	 //Todo:
	 //Control url :stage and dev, using variable
	 
	 public BaseController(){
		
	 }
	 
	 public void setFilepath() {
		 Path currentRelativePath = Paths.get(""); 
		 String current_project_path = currentRelativePath.toAbsolutePath().toString();
		 file_path = current_project_path+"\\"+"data"+"\\"+data_file;
		 file_path=file_path.replace("\'", "\\'");
		 System.out.println("Data file path :\t"+ file_path);
	 }

     public void setBaseData() {
    	 testdata = new TestDataFactory();
		 jsonTestDataObject=jsonUtil.testData();
    	
	 //	testdata.setTestCaseId(null);
 		String testcaseID ="001";
 		String customermobile=new TestDataGenerator().generateRandomMobileNumber();
 		String org_domain= new TestDataGenerator().generateRandomDomainName();
 		String org_name=new TestDataGenerator().generateRandomDomainName();
 		String usrname="test"+fakeData.getRandomString().name();
 		String usremail =new TestDataGenerator().generateRandomEmail();
 		String usrcontact=new TestDataGenerator().generateRandomMobileNumber();
 		String bpepname =  new TestDataGenerator().generateRandomDomainName();
  	    try {  	 
    	    	if(((testdata.getOrg_id()==null) )|| (testdata.getOrg_id().isEmpty())) {
    	    		
    	    		 setFilepath();
					 testdata.setTestCaseId(testcaseID);
					 testdata.setCustomerMobileNumber(customermobile);
					 //testdata.setOrg_domain("test123");
					 testdata.setOrg_domain(org_domain);
					 testdata.setOrg_name(org_name);
					 testdata.setUsr_name(usrname);
					 testdata.setUsr_email(usremail);
					 testdata.setUsr_contact(usrcontact);
					 testdata.setBpep_name(bpepname);
    	    		
    	    	}else {
    	    		
    	    	}
    	    }catch(Exception e) {
			
    	    	    	
    	    }
     }

}

