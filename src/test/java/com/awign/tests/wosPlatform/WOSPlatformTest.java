package com.awign.tests.wosPlatform;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import com.awign.dataprovider.BaseController;
import com.awign.tests.authplatform.authPlatformTest;
import com.awign.utilities.ApiMethod;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Title;

import steps.VerificationSteps;

//@FixMethodOrder(MethodSorters.DEFAULT)
//@CucumberOptions( plugin = { “usage” }) //it will record time taken for each step definition. 
//@story(Application.AppNavigation.NavigationMenu.class)

//ToDo
//Search listinig: update the body with the varial and pass the value.


public class WOSPlatformTest extends BaseController{
	 public static BaseController basecontroller = new BaseController();	 

	 	@BeforeClass
		public static void init() {	
		basecontroller.setBaseData();
	
	}

		
		@Title("Search a listing to clone from a existing listing to a new Execution project: with Reference to project")
		public void searchListings(VerificationSteps verifyResponse) throws IOException {
			String apiname= "searchListings";
			String serviceName= "wos";
			System.out.println("Test Data :::::::::::::: \t"+jsonTestDataObject);

	        JSONObject requestObj = new JSONObject();
	        requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
			System.out.println(apiname + "Request Obj : \t"+requestObj);
			
			//ToDo
			//Search listinig: update the body with the varial and pass the value.
			
			//Get Authentication:
			try {
			String login_email = requestObj.getString("loginuser").toString();
			if(!(login_email== null) || login_email.isEmpty()) {
				System.out.println("Login email" + login_email);
				new authPlatformTest().getUserAuthentication(verifyResponse, login_email);
				}	
			}catch(Exception e) {}

	       	Response response = new ApiMethod().httpMethod(requestObj);
	    	System.out.println(apiname + "Response Obj : \t"+response);
	        verifyResponse.extractjson(response);
	       	
	       	try {
			JSONArray requiresObj= (JSONArray) requestObj.getJSONArray("extractResponse");
			//System.out.println("Required Objects which have to be extracted from Response: \t\t"+requiresObj);
			if(requiresObj.length()>0) {
				
				verifyResponse.addResponseAttributestoTestData(requiresObj ,response);
			}
			}catch(Exception e) {}
	       	verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));
	       //	verifyResponse.searchIsExecutedSuccesfully(response);
	       //	verifyResponse.searchvalidstatus(response);
	      // 	verifyResponse.ValidateRestSpec(response);
	      //	System.out.println("------------"+response.asString());   
			  
		}
		
		
		@Title("get Listing details")
		public void getListing(VerificationSteps verifyResponse) throws IOException {
			String apiname= "getListing";
			String serviceName= "wos";
			System.out.println("Test Data :::::::::::::: \t"+jsonTestDataObject);

	        JSONObject requestObj = new JSONObject();
	        requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
			System.out.println(requestObj);
			
			//Get Authentication:
			try {
			String login_email = requestObj.getString("loginuser").toString();
			if(!(login_email== null) || login_email.isEmpty()) {
				new authPlatformTest().getUserAuthentication(verifyResponse, login_email);
			}	
			}catch(Exception e) {}
			String uri_update = null; 
			
			try {
				String worklistings_id = jsonTestDataObject.getString("worklistings_id");
				System.out.println("Worklisting_id"+worklistings_id);
				if(!(worklistings_id== null) || worklistings_id.isEmpty()) {				
				uri_update = requestObj.getString("uri").toString();
				/*-------uncomment the below line.----*/
			//	uri_update= uri_update.replace("LISTING_ID", worklistings_id);
				}
			}catch(Exception e) {}
	       	Response response = new ApiMethod().httpMethod(requestObj);
	       	
			try {
			JSONArray requiresObj= (JSONArray) requestObj.getJSONArray("extractResponse");
			System.out.println("Required Objects which have to be extracted from Response: \t\t"+requiresObj);
			if(requiresObj.length()>0) {
				verifyResponse.addResponseAttributestoTestData(requiresObj ,response);
			}
			}catch(Exception e) {}

	       	verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));

	       //	verifyResponse.searchIsExecutedSuccesfully(response);
	       //	verifyResponse.searchvalidstatus(response);
	      // 	verifyResponse.ValidateRestSpec(response);
	      //	System.out.println("------------"+response.asString());   
			  
		}

		
		@Title("Add listing to the newly created EP by cloning from existing listing.")
		public void addListing(VerificationSteps verifyResponse) throws IOException {
			String apiname = "addListing";
			String serviceName ="wos";
	        JSONObject requestObj = new JSONObject();
	        requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
			System.out.println("Request Object :\t"+requestObj);
			
			//System.out.println("user id"+jsonTestDataObject.getString("usr_id"));
			String uri_update = null; 
			
			//Get Authentication:
			try {
			String login_email = requestObj.getString("loginuser").toString();
			if(!(login_email== null) || login_email.isEmpty()) {
				new authPlatformTest().getUserAuthentication(verifyResponse, login_email);
			}	
			}catch(Exception e) {}
			
			try {
				String worklistings_id = jsonTestDataObject.getString("clone_listing_id");
				
				if(!(worklistings_id== null) || worklistings_id.isEmpty()) {				
				uri_update = requestObj.getString("uri").toString();
				uri_update= uri_update.replace("LISTING_ID", worklistings_id);
				}
			}catch(Exception e) {}
			
			//search project
			//search listing

			//System.out.println("Expected Status code:\t"+requestObj.getInt("statusCode"));
			//JSONObject uriObj = requestObj.getJSONObject("uri");
			JSONObject worklistingObj  = requestObj.getJSONObject("requestBody").getJSONObject("worklisting");
			worklistingObj.put("execution_project_id", jsonTestDataObject.getString("executionproject_id"));
			worklistingObj.put("project_execution_source_id", jsonTestDataObject.getString("ep_Executive_execution_sources_id"));
			requestObj.put("requestBody", worklistingObj);
			requestObj.put("uri", uri_update);
			System.out.println("update uri" + uri_update);
	        //System.out.println("Request Object:\t" +requestObj);
	       	Response response = new ApiMethod().httpMethod(requestObj);
	       	verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));
	       	
	       //	System.out.println("------------"+response.asString());   
			  
		}
		
		
		@SuppressWarnings("null")
		@Title("Add listing to the newly created EP by cloning from existing listing.")
		public void partialCloneListing(VerificationSteps verifyResponse) throws IOException {
			String apiname = "partialCloneListing";
			String serviceName ="wos";
	        JSONObject requestObj = new JSONObject();
	        requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
			System.out.println("Request Object :\t"+requestObj);
			String uri_update = null; 
			
			//Get Authentication:
			try {
			String login_email = requestObj.getString("loginuser").toString();
			if(!(login_email== null) || login_email.isEmpty()) {
				new authPlatformTest().getUserAuthentication(verifyResponse, login_email);
			}	
			}catch(Exception e) {}
			
			try {
				String worklistings_id = jsonTestDataObject.getString("worklistings_id");
				System.out.println("Listing_id"+ worklistings_id);

				if(!(worklistings_id== null) || worklistings_id.isEmpty()) {				
				uri_update = requestObj.getString("uri").toString();
				uri_update= uri_update.replace("LISTING_ID", worklistings_id);
				System.out.println("Updated uri"+ uri_update);
				}
			}catch(Exception e) {}
		
			JSONObject worklistingObj  = requestObj.getJSONObject("requestBody").getJSONObject("worklisting");
			String epproject = jsonTestDataObject.getString("executionproject_id");
			worklistingObj.put("execution_project_id", epproject);
			System.out.println("\t ------------------hello");
		//	requestObj.put("requestBody", worklistingObj);
			requestObj.put("uri", uri_update);
		
			System.out.println(apiname + " Update uri" + uri_update);
	        System.out.println(apiname + " Request Object:\t" +requestObj);
	       	Response response = new ApiMethod().httpMethod(requestObj);
	       	System.out.println(apiname+ " Api Response  \t------------"+response.asString()); 
	       	
	    	try {
				JSONArray requiresObj= (JSONArray) requestObj.getJSONArray("extractResponse");
				System.out.println("Required Objects which have to be extracted from Response: \t\t"+requiresObj);
				if(requiresObj.length()>0) {
					verifyResponse.addResponseAttributestoTestData(requiresObj ,response);
				}
				}catch(Exception e) {}
	       	
	       	verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));
	       	verifyResponse.printReferenceUrls();
	       //	System.out.println("------------"+response.asString());   
			  
		}


}
