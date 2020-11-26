package com.awign.test.corePlatform;
import java.io.IOException;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.awign.dataprovider.BaseController;
import com.awign.utilities.ApiMethod;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import steps.VerificationSteps;

//@FixMethodOrder(MethodSorters.DEFAULT)
//@CucumberOptions( plugin = { “usage” }) //it will record time taken for each step definition. 
//@story(Application.AppNavigation.NavigationMenu.class)
public class CorePlatformTest extends BaseController{

	// @Steps
	// public VerificationSteps verifyResponse;
	 public static BaseController basecontroller = new BaseController();	 
	// public static JsonUtil jsonUtil = new JsonUtil();

	
	@BeforeClass
		public static void init() {	
		basecontroller.setBaseData();
	
	}
	

	//@Title("Verify whether we are able to send SMS")
	public void verifySendSms(VerificationSteps verifyResponse) throws IOException {
		String apiname = "sendSMS";
		String serviceName ="core";
		//System.out.println("--------------"+jsonTestDataObject);

        JSONObject requestObj = new JSONObject();
        requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
		System.out.println("Request Object :\t"+requestObj);
		System.out.println("Expected Status code:\t"+requestObj.getInt("statusCode"));
		//JSONObject conditionObje  = requestObj.getJSONObject("requestBody").getJSONObject("sms");
		//conditionObje.put("mobile_number", jsonTestDataObject.getString("usr_contact"));
        System.out.println("Request Object:\t" +requestObj);
       	Response response = new ApiMethod().httpMethod(requestObj);
       	System.out.println("Response SMS----"+response.asString());   

       	// verifyResponse.validateExpectedStatusCode(response,);
       	//verifyResponse.searchvalidstatus(response);
       	//verifyResponse.addReq_idToTestData(response);
       	verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));

		  
	}
	
	//@Title("Verify whether we are able to send Email")
	public void verifySendEmail(VerificationSteps verifyResponse) throws IOException {
		String apiname = "sendEmail";
		String serviceName ="core";
		//System.out.println("--------------"+jsonTestDataObject);

        JSONObject requestObj = new JSONObject();
        requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
		System.out.println("Request Object :\t"+requestObj);
		System.out.println("Expected Status code:\t"+requestObj.getInt("statusCode"));
		//JSONObject conditionObje  = requestObj.getJSONObject("requestBody").getJSONObject("email");
		//conditionObje.put("to", jsonTestDataObject.getString("usr_email"));
        System.out.println("Request Object:\t" +requestObj);
       	Response response = new ApiMethod().httpMethod(requestObj);
       	verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));
       	//verifyResponse.searchvalidstatus(response);
       	//verifyResponse.addReq_idToTestData(response);
       	
       	System.out.println("------------"+response.asString());   
		  
	}

	//@Title("Verify whether we are able to Push Notification to the mobile")
	public void verifyPushNotification(VerificationSteps verifyResponse) throws IOException {
		String apiname = "sendPushNotification";
		String serviceName ="core";
		//System.out.println("--------------"+jsonTestDataObject);
        JSONObject requestObj = new JSONObject();
        requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
		System.out.println("Request Object :\t"+requestObj);
		System.out.println("Expected Status code:\t"+requestObj.getInt("statusCode"));
		JSONObject conditionObje  = requestObj.getJSONObject("requestBody").getJSONObject("notification");
		conditionObje.put("user_id", Integer.parseInt(jsonTestDataObject.getString("usr_id")));
        System.out.println("Request Object:\t" +requestObj);
       	Response response = new ApiMethod().httpMethod(requestObj);
       	System.out.println("------------"+response.asString());   

       	verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));
       	//verifyResponse.searchvalidstatus(response);
       	//verifyResponse.addReq_idToTestData(response);
       	
       	System.out.println("------------"+response.asString());   
		  
	}

	
	
}
