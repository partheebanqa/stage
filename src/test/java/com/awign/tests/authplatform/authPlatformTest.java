package com.awign.tests.authplatform;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.awign.dataprovider.BaseController;
import com.awign.utilities.ApiMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.annotations.WithTags;
import steps.VerificationSteps;


//@concurent(threads="4x")
public class authPlatformTest extends BaseController{
	
	// @Steps
	// public VerificationSteps verifyResponse;
	 public static BaseController basecontroller = new BaseController();	 
	// public static JsonUtil jsonUtil = new JsonUtil();

	
	@BeforeClass
		public static void init() {	
		basecontroller.setBaseData();
	
	}
	
	
	
	//@Title("Guest user: Verify the email is already registered with Awign")
	//@WithTags({@WithTag("Feature")})
	//@Test()
	    public void verifyEmailRegistered(VerificationSteps verifyResponse) throws IOException {
		String apiname= "verifyEmailRegistered";
		String serviceName= "auth";
		JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
		
		
		String uri_update = null; 
		
		try {
			String usr_email = jsonTestDataObject.getString("usr_email");
			if(!(usr_email== null) || usr_email.isEmpty()) {
			
			uri_update = jsonObject.getString("uri").toString();
			uri_update= uri_update.replace("CLIENT_ID", usr_email);
			}
		}catch(Exception e) {}
		jsonObject.put("uri", uri_update);

		System.out.println("Request object:::" + jsonObject);
		

		Response response = new ApiMethod().httpMethod(jsonObject);
		//System.out.println("------------"+response.asString());
		verifyResponse.searchIsPhoneNotFoud(response);
		verifyResponse.searchContentinResponse(response);
		verifyResponse.searchstatusinResponse(response);


	}
	
	
	//@Title("Guest user Verify whether the Mobile number is already registered with Awign")
	//@WithTags({@WithTag("Feature")})
	//@Test
	public void verifyMobileNumberRegistered(VerificationSteps verifyResponse) throws IOException {
		String apiname= "verifyMobileNumberRegistered";
		String serviceName= "auth";
		JSONObject requestObj = new JSONObject();
		requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
		
		String uri_update = null; 
		
		try {
			String usr_contact = jsonTestDataObject.getString("usr_contact");
			if(!(usr_contact== null) || usr_contact.isEmpty()) {
			
			uri_update = requestObj.getString("uri").toString();
			uri_update= uri_update.replace("CLIENT_ID", usr_contact);
			}
		}catch(Exception e) {}
		requestObj.put("uri", uri_update);

		System.out.println("Request:::::::::\t"+requestObj);
		System.out.println("Expected Status code:\t"+requestObj.getInt("statusCode"));


		Response response = new ApiMethod().httpMethod(requestObj);
		System.out.println("Response 0::::::::::::::::::\t"+response.toString());

		//verifyResponse.searchIsPhoneNotFoud(response);
		//verifyResponse.searchContentinResponse(response);
		//verifyResponse.searchstatusinResponse(response);
       	verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));

		System.out.println("Response 1::::::::::::::::::\t"+response.toString());
	}

	/*@WithTags({@WithTag("Feature")})
	@Test
	@Title("Guest user: Verify whether new client is able to register with Awign")
	public void test003() throws IOException {
		String apiname= "NewClient_sign_up";
		String serviceName= "auth";
		JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
        //String nameofCurrMethod = new Object() {}.getClass() .getEnclosingMethod() .getName(); 
        //String nameofCurrClass  = this.getClass().getSimpleName();

        JSONObject reqObj=  (JSONObject) jsonObject.get("requestBody");
        JSONObject orgdomainObj=  (JSONObject) reqObj.get("organisation");
        JSONObject userObj=  (JSONObject) reqObj.get("user");

        orgdomainObj.put("name", jsonTestDataObject.getString("org_name"));
        orgdomainObj.put("domain", jsonTestDataObject.getString("org_domain"));
        userObj.put("contact", jsonTestDataObject.getString("usr_contact"));
        userObj.put("name", jsonTestDataObject.getString("usr_name"));
        userObj.put("email", jsonTestDataObject.getString("usr_email"));
        System.out.println(" Updated Request Object : \t"+jsonObject);
       	Response response = new ApiMethod().httpMethod(jsonObject);
		try {
		JSONArray requiresObj= (JSONArray) jsonObject.getJSONArray("extractResponse");
		System.out.println("Required Objects which have to be extracted from Response: \t\t"+requiresObj);
		if(requiresObj.length()>0) {
			verifyResponse.addResponseAttributestoTestData(requiresObj ,response);
		}
		}catch(Exception e) {}

       	verifyResponse.searchIsExecutedSuccesfully(response);
       	verifyResponse.searchvalidstatus(response);
      //	verifyResponse.extractSignupResposeAddToTestData(response);
       	
	}
*/	
	//@WithTags({@WithTag("Feature")})
	//@Test
	//@Title("Verify we are able to add requirement to the newly registered client")

	
	
	
	/*public void verifyUserLogin() throws IOException {
		String apiname = "Member_login";
		String serviceName ="auth";
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

       	verifyResponse.validateExpectedStatusCode(response,200);
       	//verifyResponse.searchvalidstatus(response);
       	//verifyResponse.addReq_idToTestData(response);
       	verifyResponse.extractSigninResposeAddToTestData(response);
       	System.out.println("------------"+response.asString());   
		  
	}
*/	
//

/*	RestAssured.given()
	.when().get("/users").then().log().all()
	.statusCode(200);
*/

	//project type: name="Business Develpment" name="Due Diligence"name="Data Moderation" name="Auditing" name="Custom"
}
