package com.awign.tests.authplatform;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.apache.log4j.Logger;

import com.awign.dataprovider.BaseController;
import com.awign.utilities.ApiMethod;
import io.restassured.response.Response;
import steps.VerificationSteps;

//@concurent(threads="4x")
public class authPlatformTest extends BaseController {

	// @Steps
	// public VerificationSteps verifyResponse;
	public static BaseController basecontroller = new BaseController();
    Logger log = Logger.getLogger(authPlatformTest.class);
	// public static JsonUtil jsonUtil = new JsonUtil();

	@BeforeClass
	public static void init() {
		basecontroller.setBaseData();

	}

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
		} catch (Exception e) {
		}
		jsonObject.put("uri", uri_update);
		log.info(apiname+" log4j Request object:::" + jsonObject);
		System.out.println("Request object:::" + jsonObject);

		Response response = new ApiMethod().httpMethod(jsonObject);
		// System.out.println("------------"+response.asString());
		verifyResponse.searchIsPhoneNotFoud(response);
		verifyResponse.searchContentinResponse(response);
		verifyResponse.searchstatusinResponse(response);

	}

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
		} catch (Exception e) {
		}
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

	/*
	 * @WithTags({@WithTag("Feature")})
	 * 
	 * @Test
	 * 
	 * @Title("Guest user: Verify whether new client is able to register with Awign"
	 * ) public void test003() throws IOException { String apiname=
	 * "NewClient_sign_up"; String serviceName= "auth"; JSONObject jsonObject = new
	 * JSONObject(); jsonObject =
	 * jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
	 * //String nameofCurrMethod = new Object() {}.getClass() .getEnclosingMethod()
	 * .getName(); //String nameofCurrClass = this.getClass().getSimpleName();
	 * 
	 * JSONObject reqObj= (JSONObject) jsonObject.get("requestBody"); JSONObject
	 * orgdomainObj= (JSONObject) reqObj.get("organisation"); JSONObject userObj=
	 * (JSONObject) reqObj.get("user");
	 * 
	 * orgdomainObj.put("name", jsonTestDataObject.getString("org_name"));
	 * orgdomainObj.put("domain", jsonTestDataObject.getString("org_domain"));
	 * userObj.put("contact", jsonTestDataObject.getString("usr_contact"));
	 * userObj.put("name", jsonTestDataObject.getString("usr_name"));
	 * userObj.put("email", jsonTestDataObject.getString("usr_email"));
	 * System.out.println(" Updated Request Object : \t"+jsonObject); Response
	 * response = new ApiMethod().httpMethod(jsonObject); try { JSONArray
	 * requiresObj= (JSONArray) jsonObject.getJSONArray("extractResponse");
	 * System.out.
	 * println("Required Objects which have to be extracted from Response: \t\t"
	 * +requiresObj); if(requiresObj.length()>0) {
	 * verifyResponse.addResponseAttributestoTestData(requiresObj ,response); }
	 * }catch(Exception e) {}
	 * 
	 * verifyResponse.searchIsExecutedSuccesfully(response);
	 * verifyResponse.searchvalidstatus(response); //
	 * verifyResponse.extractSignupResposeAddToTestData(response);
	 * 
	 * }
	 */

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
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Test data--------------" + jsonTestDataObject);

		/*
		 * Map<String, String> allcookies = response.cookies();
		 * 
		 * for(String header : allcookies) { System.out.println("Key: " +
		 * header.getName() + " Value: " + header.getValue()); }
		 * 
		 * 
		 * JsonPath jp = response.jsonPath(); String client =
		 * jp.get("data.headers.client").toString(); String accesstoken =
		 * jp.get("data.headers.client").toString();
		 * System.out.println("client:\t"+client);
		 */
// Cookie cookie = allcookies
		// System.out.println("Cookie set : "+cookie.getValue());

		/*
		 * System.out.println(" Response header access token" +
		 * response.getCookie("Set-Cookie")); System.out.println(" Response header uid "
		 * + response.getCookie("uid")); System.out.println(" Response header client" +
		 * response.getCookie("	")); System.out.println(response.getCookies().values());
		 */
		/*
		 * Map<String, String> cookies = response.getCookies();
		 * 
		 * 
		 * for (String aCookie : cookies) { String name = aCookie.getName(); String
		 * value = aCookie.getValue();
		 * 
		 * System.out.println(name + " = " + value); }
		 */

		/*
		 * try { JSONArray requiresObj= (JSONArray)
		 * requestObj.getJSONArray("extractResponse"); System.out.
		 * println("Required Objects which have to be extracted from Response: \t\t"
		 * +requiresObj); if(requiresObj.length()>0) {
		 * verifyResponse.addResponseAttributestoTestData(requiresObj ,response); }
		 * }catch(Exception e) {}
		 * 
		 * verifyResponse.validateExpectedStatusCode(response,200);
		 * //verifyResponse.searchvalidstatus(response);
		 * //verifyResponse.addReq_idToTestData(response);
		 * verifyResponse.extractSigninResposeAddToTestData(response);
		 * System.out.println("------------"+response.asString());
		 */

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
	
		}catch (Exception e) {	e.printStackTrace();
		}
		
		Response response = new ApiMethod().httpMethod(requestObj);
		System.out.println(apiname + "\t ResponseApi:::" + response.asString()  + response.toString());
		try {
			JSONArray requiresObj = (JSONArray) requestObj.getJSONArray("extractResponse");
			System.out.println("Required Objects which have to be extracted from Response: \t\t" + requiresObj);
			if (requiresObj.length() > 0) {
				verifyResponse.addResponseAttributestoTestData(requiresObj, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

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
//

	/*
	 * RestAssured.given() .when().get("/users").then().log().all()
	 * .statusCode(200);
	 */

	// project type: name="Business Develpment" name="Due Diligence"name="Data
	// Moderation" name="Auditing" name="Custom"
}
