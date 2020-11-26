package com.awign.tests.authplatform;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import com.awign.dataprovider.BaseController;
import com.awign.utilities.ApiMethod;
import io.restassured.response.Response;
import steps.VerificationSteps;

//@concurent(threads="4x")
public class authPlatformTest extends BaseController {

	// @Steps
	// public VerificationSteps verifyResponse;
	public static BaseController basecontroller = new BaseController();
	// public static JsonUtil jsonUtil = new JsonUtil();

	@BeforeClass
	public static void init() {
		basecontroller.setBaseData();

	}

	@SuppressWarnings("null")
	public void verifyEmailRegistered(VerificationSteps verifyResponse) throws IOException {
		//Log.startTestCase("verifyEmailRegistered");

		String apiname = "verifyEmailRegistered";
		String serviceName = "auth";
		JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);

		String uri_update = null;
		try {
			String usr_email = jsonTestDataObject.getString("usr_email");
			if (!(usr_email == null) || usr_email.isEmpty()) {

				uri_update = jsonObject.getString("uri").toString();
				uri_update = uri_update.replace("CLIENT_ID", usr_email);
			}
		} catch (Exception e) {	}
		jsonObject.put("uri", uri_update);
		System.out.println("Request object:::" + jsonObject);	

		Response response = new ApiMethod().httpMethod(jsonObject);
		// System.out.println("------------"+response.asString());
		verifyResponse.searchIsPhoneNotFoud(response);
		verifyResponse.searchContentinResponse(response);
		verifyResponse.searchstatusinResponse(response);

	}

	@SuppressWarnings("null")
	public void verifyMobileNumberRegistered(VerificationSteps verifyResponse) throws IOException {
		String apiname = "verifyMobileNumberRegistered";
		String serviceName = "auth";
		JSONObject requestObj = new JSONObject();
		requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);

		String uri_update = null;
		try {
			String usr_contact = jsonTestDataObject.getString("usr_contact");
			if (!(usr_contact == null) || usr_contact.isEmpty()) {

				uri_update = requestObj.getString("uri").toString();
				uri_update = uri_update.replace("CLIENT_ID", usr_contact);
			}
		} catch (Exception e) {	}
		requestObj.put("uri", uri_update);

		System.out.println("Request:::::::::\t" + requestObj);
		System.out.println("Expected Status code:\t" + requestObj.getInt("statusCode"));
		Response response = new ApiMethod().httpMethod(requestObj);
		System.out.println("Response 0::::::::::::::::::\t" + response.toString());

		// verifyResponse.searchIsPhoneNotFoud(response);
		// verifyResponse.searchContentinResponse(response);
		// verifyResponse.searchstatusinResponse(response);
		verifyResponse.validateExpectedStatusCode(response, requestObj.getInt("statusCode"));
		System.out.println("Response 1::::::::::::::::::\t" + response.toString());
	}

	

	public void verifyUserLogin(VerificationSteps verifyResponse) throws IOException {
		String apiname = "Member_login";
		String serviceName = "auth";
		System.out.println(" Test data--------------" + jsonTestDataObject);
		JSONObject requestObj = new JSONObject();
		requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
		System.out.println("Request Object :\t" + requestObj);
		// System.out.println("Expected Status
		// code:\t"+requestObj.getInt("statusCode"));
		// JSONObject conditionObje =
		// requestObj.getJSONObject("requestBody").getJSONObject("user");
		// conditionObje.put("email", jsonTestDataObject.getString("usr_email"));
		System.out.println("Request Object:\t" + requestObj);
		Response response = new ApiMethod().httpMethod(requestObj);
		System.out.println("----------------" + response.asString());
		try {
			JSONArray requiresObj = (JSONArray) requestObj.getJSONArray("extractResponse");
			System.out.println("Required Objects which have to be extracted from Response: \t\t" + requiresObj);
			if (requiresObj.length() > 0) {
				verifyResponse.addResponseAttributestoTestData(requiresObj, response);
			}
		} catch (Exception e) {			e.printStackTrace(); 		}
		System.out.println("Test data--------------" + jsonTestDataObject);

	}
	
	
	public void getUserAuthentication(VerificationSteps verifyResponse,String login_email) throws IOException {
		String apiname = "Member_login";
		String serviceName = "auth";
		System.out.println(" Test data--------------" + jsonTestDataObject);
		JSONObject requestObj = new JSONObject();
		requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
		System.out.println(apiname + "\t Request Object :\t" + requestObj);
		try {
			if(!(login_email== null)) {
			     JSONObject reqObj=  (JSONObject) requestObj.get("requestBody");
			     JSONObject userObj=  (JSONObject) reqObj.get("user");
			     userObj.put("email", login_email);
			}
		}catch (Exception e) {	e.printStackTrace(); 	}
		
		Response response = new ApiMethod().httpMethod(requestObj);
		System.out.println(apiname + "\t ResponseApi:::" + response.asString()  + response.toString());
		try {
			JSONArray requiresObj = (JSONArray) requestObj.getJSONArray("extractResponse");
			System.out.println("Required Objects which have to be extracted from Response: \t\t" + requiresObj);
			if (requiresObj.length() > 0) {
				verifyResponse.addResponseAttributestoTestData(requiresObj, response);
			}
		} catch (Exception e) {
			e.printStackTrace(); }
		System.out.println("Test data--------------" + jsonTestDataObject);
	}

	
	public void validateUser(VerificationSteps verifyResponse) throws IOException {
		String apiname = "ValidateUser";
		String serviceName = "auth";
		System.out.println(" Test data--------------" + jsonTestDataObject);
		JSONObject requestObj = new JSONObject();
		requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
		System.out.println(apiname + "\tRequest Object :\t" + requestObj);
		Response response = new ApiMethod().httpMethod(requestObj);
		System.out.println(apiname + "\t ResponseApi:::" + response.asString()  + response.toString());
	}

}
