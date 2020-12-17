package com.awign.tests.newcasplatform;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import com.awign.dataprovider.BaseController;
import com.awign.utilities.ApiMethod;
import io.restassured.response.Response;
import steps.VerificationSteps;


/** 
* @author  Partheeban.moorthy@awign.com
* @version 1.0 
*/


//@FixMethodOrder(MethodSorters.DEFAULT)
//@CucumberOptions( plugin = { “usage” }) //it will record time taken for each step definition. 
//@story(Application.AppNavigation.NavigationMenu.class)
public class NewCasPlatformTest extends BaseController{
	String serviceName= "newcas";
 
	//@Steps
	 //public VerificationSteps verifyResponse;
	 public static BaseController basecontroller = new BaseController();	 
	// public static JsonUtil jsonUtil = new JsonUtil();

	
	@BeforeClass
		public static void init() {	
		basecontroller.setBaseData();
	
	}

	
	public void verifyNewClientSignup(VerificationSteps verifyResponse) throws IOException {
		String apiname= "verifyNewClientSignup";
		String serviceName= "newcas";
		JSONObject requestObj = new JSONObject();
		requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
        //String nameofCurrMethod = new Object() {}.getClass() .getEnclosingMethod() .getName(); 
        //String nameofCurrClass  = this.getClass().getSimpleName();

        JSONObject reqObj=  (JSONObject) requestObj.get("requestBody");
        JSONObject orgdomainObj=  (JSONObject) reqObj.get("organisation");
        JSONObject userObj=  (JSONObject) reqObj.get("user");

        orgdomainObj.put("name", jsonTestDataObject.getString("org_name"));
        orgdomainObj.put("domain", jsonTestDataObject.getString("org_domain"));
        userObj.put("contact", jsonTestDataObject.getString("usr_contact"));
        userObj.put("name", jsonTestDataObject.getString("usr_name"));
        userObj.put("email", jsonTestDataObject.getString("usr_email"));
        System.out.println(" Updated Request Object : \t"+requestObj);
       	Response response = new ApiMethod().httpMethod(requestObj);
       //	System.out.println(response.statusCode());
       //	System.out.println("Response body"+ response.asString());
		try {
		JSONArray requiresObj= (JSONArray) requestObj.getJSONArray("extractResponse");
		System.out.println("Required Objects which have to be extracted from Response: \t\t"+requiresObj);
		if(requiresObj.length()>0) {
			verifyResponse.addResponseAttributestoTestData(requiresObj ,response);
		}
		}catch(Exception e) {}

       	verifyResponse.searchIsExecutedSuccesfully(response);
       	verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));
      //	verifyResponse.extractSignupResposeAddToTestData(response);
       	
	}
	
	
	public void verifyUserSignin(VerificationSteps verifyResponse) throws IOException {
		String apiname = "userSignin";
		String serviceName ="newcas";
		//System.out.println("--------------"+jsonTestDataObject);
        JSONObject requestObj = new JSONObject();
        requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
		System.out.println("Request Object :\t"+requestObj);
		System.out.println("Expected Status code:\t"+requestObj.getInt("statusCode"));
	//	JSONObject conditionObje  = requestObj.getJSONObject("requestBody").getJSONObject("user");
	//	conditionObje.put("email", jsonTestDataObject.getString("usr_email"));
        System.out.println("Request Object:\t" +requestObj);
       	Response response = new ApiMethod().httpMethod(requestObj);
       	
       	
		try {
		JSONArray requiresObj= (JSONArray) requestObj.getJSONArray("extractResponse");
		System.out.println("Required Objects which have to be extracted from Response: \t\t"+requiresObj);
		if(requiresObj.length()>0) {
			verifyResponse.addResponseAttributestoTestData(requiresObj ,response);
		}
		}catch(Exception e) {}

       	verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));
       	//verifyResponse.searchvalidstatus(response);
       	//verifyResponse.addReq_idToTestData(response);
       	System.out.println("Response ----"+response.asString());   
		  
	}

	//@WithTagValuesOf({"level:tutorial", "feature:battle", "story:battle start"})
	public void userLogout(VerificationSteps verifyResponse) throws IOException {
		String apiname = "userLogout";
		String serviceName ="newcas";
		//System.out.println("--------------"+jsonTestDataObject);
        JSONObject requestObj = new JSONObject();
        requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
		System.out.println("Request Object :\t"+requestObj);
		System.out.println("Expected Status code:\t"+requestObj.getInt("statusCode"));
	//	JSONObject conditionObje  = requestObj.getJSONObject("requestBody").getJSONObject("user");
	//	conditionObje.put("email", jsonTestDataObject.getString("usr_email"));
        System.out.println("Request Object:\t" +requestObj);
       	Response response = new ApiMethod().httpMethod(requestObj);
       	verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));
       	verifyResponse.searchvalidstatus(response);
       	
       	System.out.println("------------"+response.asString());   
		  
	}
	
/*	@WithTagValuesOf({"level:UserValidate", "feature:LoginLogout", "story:CustomerAthenticate"})
	@Title("Validate the given user with header details")
	@Test
	public void clientValidate(VerificationSteps verifyResponse) throws IOException   {
		String apiname = "clientValidate";
		String serviceName ="newcas";
		//System.out.println("--------------"+jsonTestDataObject);
        JSONObject requestObj = new JSONObject();
        requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
		System.out.println("Request Object :\t"+requestObj);
       	Response response = new ApiMethod().httpMethod(requestObj);
       	System.out.println("Response Client validate" + response);
       	verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));
       	verifyResponse.searchvalidstatus(response);       	
		  
	}
*/

	@SuppressWarnings("null")
	public void addUserARole(VerificationSteps verifyResponse) throws IOException {
		String apiname = "addUserARole";
		String serviceName ="newcas";
		//System.out.println("--------------"+jsonTestDataObject);
        JSONObject requestObj = new JSONObject();
        requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
		System.out.println("Request Object :\t"+requestObj);
		String newRole = requestObj.getString("newRole").toString();
		System.out.println("Role to be added to the uesr " + newRole + "to User: \t" +jsonTestDataObject.getString("usr_id"));
		//System.out.println("user id"+jsonTestDataObject.getString("usr_id"));
		String uri_update = null; 
		
		try {
			String usr_id = jsonTestDataObject.getString("usr_id");
			if(!(usr_id== null) || usr_id.isEmpty()) {
			
			uri_update = requestObj.getString("uri").toString();
			uri_update= uri_update.replace("CLIENT_ID", usr_id);
			}
		}catch(Exception e) {}

		//System.out.println("Expected Status code:\t"+requestObj.getInt("statusCode"));
		//JSONObject uriObj = requestObj.getJSONObject("uri");
		JSONObject roleObj  = requestObj.getJSONObject("requestBody").getJSONObject("user");
		roleObj.put("role", newRole);
		requestObj.put("uri", uri_update);
		System.out.println("update uri" + uri_update);
        //System.out.println("Request Object:\t" +requestObj);
       	Response response = new ApiMethod().httpMethod(requestObj);
       	verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));
       	//verifyResponse.searchvalidstatus(response);
       	
       //	System.out.println("------------"+response.asString());   
		  
	}

}
