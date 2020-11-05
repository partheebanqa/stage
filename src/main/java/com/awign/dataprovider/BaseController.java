package com.awign.dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;
import org.json.JSONObject;
import org.json.simple.JSONArray;

import com.awign.utilities.JsonUtil;
import com.awign.utilities.PropertyUtil;
import com.awign.utilities.ReusableSpecifications;
import com.awign.utilities.StringUtil;
import com.awign.utilities.TestDataGenerator;

public class BaseController {
	 public static JsonUtil jsonUtil = new JsonUtil();

	 public static JSONObject jsonTestDataObject;
	 public static StringUtil fakeData = new StringUtil();
	 public static TestDataFactory testdata;
	 public static ReusableSpecifications restSpec;
	 
	 public BaseController(){
	 }

     public void setBaseData() {
		 testdata = new TestDataFactory();
	 	 jsonTestDataObject=jsonUtil.testData();
 		String testcaseID ="001";
 		String customermobile=new TestDataGenerator().generateRandomMobileNumber();
 		String org_domain= new TestDataGenerator().generateRandomDomainName();
 				
 		String org_name=new TestDataGenerator().generateRandomDomainName();
 		String usrname="test"+fakeData.getRandomString().name();
 		String usremail =new TestDataGenerator().generateRandomEmail();
 		String usrcontact=new TestDataGenerator().generateRandomMobileNumber();
 		String bpepname =  new TestDataGenerator().generateRandomDomainName();


    	    try {  	 
    	    	if((!(testdata.getTestCaseId()==null) )|| (testdata.getTestCaseId().isEmpty()))
		 testdata.setTestCaseId(testcaseID);
		 testdata.setCustomerMobileNumber(customermobile);
		 //testdata.setOrg_domain("test123");
		 testdata.setOrg_domain(org_domain);
		 testdata.setOrg_name(org_name);
		 testdata.setUsr_name(usrname);
		 testdata.setUsr_email(usremail);
		 testdata.setUsr_contact(usrcontact);
		 testdata.setBpep_name(bpepname);
    	    }catch(Exception e) {
    	   // 	e.printStackTrace();
     }
     }
     
     
     //To check whether the required data is present in TestData.
/*     public void getRequiredData(org.json.JSONArray requiresObj) {
         LinkedList<String> reqData = new LinkedList<String>();
         for(int i=0;i<=reqData.size();i++) {
        	 reqData.add(reqData.get(i).toString());
         }
         
         for (String header : reqData) {
             switch (header) {
                 case "access-token":
                	 if(testdata.getAccess_token()==null || testdata.getAccess_token().isEmpty()) {
                		 try {
							new NewCasPlatformTest().userSignin();
						} catch (IOException e){}	
                	 	}
                     break;
                 case "client":
                	 if(testdata.getClient()==null || testdata.getClient().isEmpty()) {
						try {new NewCasPlatformTest().userSignin();
							}catch(Exception e) {}
                	 }
              		break;

             }
         }

    	 
     }
*/     
}

