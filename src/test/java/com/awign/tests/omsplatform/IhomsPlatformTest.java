package com.awign.tests.omsplatform;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import com.awign.dataprovider.BaseController;
import com.awign.tests.authplatform.authPlatformTest;
import com.awign.utilities.ApiMethod;
import com.awign.utilities.DateUtil;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Title;
import steps.VerificationSteps;

//@FixMethodOrder(MethodSorters.DEFAULT)
//@CucumberOptions( plugin = { “usage” }) //it will record time taken for each step definition. 
//@story(Application.AppNavigation.NavigationMenu.class)

/**
 * @author Partheeban.moorthy@awign.com
 * @version 1.0
 */

public class IhomsPlatformTest extends BaseController {
	// @Steps
	// public VerificationSteps verifyResponse;
	public static BaseController basecontroller = new BaseController();
	// PropertyUtil prop =new PropertyUtil();
	// public static JsonUtil jsonUtil = new JsonUtil();

	@BeforeClass
	public static void init() {
		basecontroller.setBaseData();

	}

	@Title("Add requirement to the client")
	public void addRequirement(VerificationSteps verifyResponse) throws IOException {
		String apiname = "addRequirement";
		String serviceName = "oms_internal";
		System.out.println("--------------" + jsonTestDataObject);
		System.out.println(testdata.getOrg_id());
		// System.out.println("get org ------------------"+
		// jsonTestDataObject.getString("org_id"));
		JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
		System.out.println(apiname + "\t Request obj" + jsonObject);
		// Get Authentication:
		try {
			String login_email = jsonObject.getString("loginuser").toString();
			if (!(login_email == null) || login_email.isEmpty()) {
				new authPlatformTest().getUserAuthentication(verifyResponse, login_email);
			}
		} catch (Exception e) {
		}

		// new authPlatformTest().validateUser(verifyResponse);

		JSONObject requestObj = (JSONObject) jsonObject.get("requestBody");
		JSONObject clientReqObject = (JSONObject) requestObj.get("client_requirement");
		clientReqObject.put("description", fakeData.getRandommusic());
		clientReqObject.put("domain", jsonTestDataObject.getString("org_domain"));
		clientReqObject.put("org", jsonTestDataObject.getString("org_id"));
		System.out.println(apiname + "\tRequest Object:\t" + requestObj);
		Response response = new ApiMethod().httpMethod(jsonObject);
		System.out.println(apiname + " \t Api Response::::::::::::::" + response.asString());
		try {
			JSONArray requiresObj = (JSONArray) jsonObject.getJSONArray("extractResponse");
			System.out.println("Required Objects which have to be extracted from Response: \t\t" + requiresObj);
			if (requiresObj.length() > 0) {
				verifyResponse.addResponseAttributestoTestData(requiresObj, response);
			}
		} catch (Exception e) {
		}

		// System.out.println("Api Response------------"+response.asString());

		// verifyResponse.searchIsExecutedSuccesfully(response);
		// verifyResponse.searchvalidstatus(response);
		// verifyResponse.ValidateRestSpec(response);

	}

	@Title("Verify whether we are able to search the Created requirement")
	public void searchRequirement(VerificationSteps verifyResponse) throws IOException {
		String apiname = "searchRequirement";
		String serviceName = "oms_internal";
		System.out.println("--------------" + jsonTestDataObject);
		System.out.println("Searching Data for the Domain" + testdata.getOrg_domain());
		JSONObject requestObj = new JSONObject();
		requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);

		// Get Authentication:
		try {
			String login_email = requestObj.getString("loginuser").toString();
			if (!(login_email == null) || login_email.isEmpty()) {
				new authPlatformTest().getUserAuthentication(verifyResponse, login_email);
			}
		} catch (Exception e) {
		}
		System.out.println("Request Object :\t" + requestObj);
		System.out.println("Expected Status code:\t" + requestObj.getInt("statusCode"));
		JSONObject conditionObje = requestObj.getJSONObject("requestBody").getJSONArray("conditions").getJSONObject(0);
		JSONObject domainObj = conditionObje.getJSONObject("domain");
		System.out.println("domain object" + domainObj);
		domainObj.put("value", jsonTestDataObject.getString("org_domain"));
		System.out.println("Request Object:\t" + requestObj);
		Response response = new ApiMethod().httpMethod(requestObj);
		// verifyResponse.validateExpectedStatusCode(response,);
		// verifyResponse.searchvalidstatus(response);
		// verifyResponse.addReq_idToTestData(response);
		System.out.println("Api Response------------" + response.asString());
	}

	@Title("Verify whether we are able to search the newly created project")
	public void searchProject(VerificationSteps verifyResponse) throws IOException {
		String apiname = "searchProject";
		String serviceName = "oms_internal";
		// System.out.println("--------------"+jsonTestDataObject);
		JSONObject requestObj = new JSONObject();
		requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);

		// Get Authentication:
		try {
			String login_email = requestObj.getString("loginuser").toString();
			if (!(login_email == null) || login_email.isEmpty()) {
				new authPlatformTest().getUserAuthentication(verifyResponse, login_email);
			}
		} catch (Exception e) {
		}

		System.out.println("Request Object :\t" + requestObj);
		System.out.println("Expected Status code:\t" + requestObj.getInt("statusCode"));
		JSONObject conditionObje = requestObj.getJSONObject("requestBody").getJSONArray("conditions").getJSONObject(0);
		JSONObject reqObject = conditionObje.getJSONObject("client_requirement_id");
		JSONObject projectObject = conditionObje.getJSONObject("_project_type");
		reqObject.put("value", jsonTestDataObject.getString("req_id"));
		projectObject.put("value", jsonTestDataObject.getString("req_vertical"));
		System.out.println("Request Object:\t" + requestObj);
		Response response = new ApiMethod().httpMethod(requestObj);
		// verifyResponse.validateExpectedStatusCode(response,);
		// verifyResponse.searchvalidstatus(response);
		// verifyResponse.addReq_idToTestData(response);
		System.out.println("------------" + response.asString());

	}

	@Title("Get project details - Execution project execution source_id for executive role")
	public void getProject(VerificationSteps verifyResponse) throws IOException {
		String apiname = "getProject";
		String serviceName = "oms_internal";
		JSONObject requestObj = new JSONObject();
		requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
		System.out.println(apiname + " \tRequest Object :\t" + requestObj);

		// Get Authentication:
		try {
			String login_email = requestObj.getString("loginuser").toString();
			if (!(login_email == null) || login_email.isEmpty()) {
				new authPlatformTest().getUserAuthentication(verifyResponse, login_email);
			}
		} catch (Exception e) {
		}

		String uri_string = null;
		try {
			String listingexecutionproject_id = jsonTestDataObject.getString("listingsrc_execution_project_id");
			System.out.println(" EP Project id \t" + listingexecutionproject_id);
			if (!(listingexecutionproject_id == null) || listingexecutionproject_id.isEmpty()) {
				uri_string = requestObj.getString("uri").toString();
				uri_string = uri_string.replace("PROJECT_ID", listingexecutionproject_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		requestObj.put("uri", uri_string);
		System.out.println(apiname + " Request obj--------------" + requestObj);
		Response response;
		if ((uri_string == null) || uri_string.isEmpty()) {
			System.out.println("Update uri is null, Please Check" + uri_string);
			response = new ApiMethod().httpMethod(requestObj);
		} else {
			response = new ApiMethod().httpMethod(requestObj);
		}
		System.out.println(apiname + "API Response------------\t" + response.asString());
		try {
			JSONArray requiresObj = (JSONArray) requestObj.getJSONArray("extractResponse");
			System.out.println("Required Objects which have to be extracted from Response: \t\t" + requiresObj);
			if (requiresObj.length() > 0) {
				verifyResponse.addResponseAttributestoTestData(requiresObj, response);
			}
		} catch (Exception e) {
		}
		verifyResponse.validateExpectedStatusCode(response, requestObj.getInt("statusCode"));
	}

	@Title("Get EP project details - Execution project execution source_id for executive role")
	public void getEPProject(VerificationSteps verifyResponse) throws IOException {
		String apiname = "getProject";
		String serviceName = "oms_internal";
		JSONObject requestObj = new JSONObject();
		requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
		System.out.println(apiname + " \tRequest Object :\t" + requestObj);
		// Get Authentication:
		try {
			String login_email = requestObj.getString("loginuser").toString();
			if (!(login_email == null) || login_email.isEmpty()) {
				new authPlatformTest().getUserAuthentication(verifyResponse, login_email);
			}
		} catch (Exception e) {
		}

		String uri_string = null;
		try {
			String listingexecutionproject_id = jsonTestDataObject.getString("executionproject_id");
			System.out.println(" EP Project id \t" + listingexecutionproject_id);
			if (!(listingexecutionproject_id == null) || listingexecutionproject_id.isEmpty()) {
				uri_string = requestObj.getString("uri").toString();
				uri_string = uri_string.replace("PROJECT_ID", listingexecutionproject_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		requestObj.put("uri", uri_string);
		System.out.println(apiname + " Request obj--------------" + requestObj);

		Response response;
		if ((uri_string == null) || uri_string.isEmpty()) {
			System.out.println("Update uri is null, Please Check" + uri_string);
			response = new ApiMethod().httpMethod(requestObj);
		} else {
			response = new ApiMethod().httpMethod(requestObj);
		}

		System.out.println(apiname + "API Response------------\t" + response.asString());
		try {
			JSONArray requiresObj = (JSONArray) requestObj.getJSONArray("extractResponse");
			System.out.println("Required Objects which have to be extracted from Response: \t\t" + requiresObj);
			if (requiresObj.length() > 0) {
				verifyResponse.addResponseAttributestoTestData(requiresObj, response);
			}
		} catch (Exception e) {
		}
		verifyResponse.validateExpectedStatusCode(response, requestObj.getInt("statusCode"));

	}

	@Title("Get Requirement for the requirement id")
	public void getRequirement(VerificationSteps verifyResponse) throws IOException {
		String apiname = "getRequirement";
		String serviceName = "oms_internal";
		JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
		System.out.println(jsonObject);

		// Get Authentication:
		try {
			String login_email = jsonObject.getString("loginuser").toString();
			if (!(login_email == null) || login_email.isEmpty()) {
				new authPlatformTest().getUserAuthentication(verifyResponse, login_email);
			}
		} catch (Exception e) {
		}

		String uri_update = null;
		System.out.println("req d:::::::" + testdata.getReq_id());
		try {
			String req_id = testdata.getReq_id();
			System.out.println(testdata.getReq_id());
			if (!(req_id == null) || req_id.isEmpty()) {
				uri_update = jsonObject.getString("uri").toString();
				System.out.println();
				uri_update = uri_update.replace("REQUIREMENT_ID", req_id);
			}
		} catch (Exception e) {
		}

		jsonObject.put("uri", uri_update);
		System.out.println("update uri" + uri_update);
		System.out.println("Request Object" + jsonObject);
		Response response = new ApiMethod().httpMethod(jsonObject);
		System.out.println("Response::::::::: " + response.asString());
		try {
			JSONArray requiresObj = (JSONArray) jsonObject.getJSONArray("extractResponse");
			System.out.println("Required Objects which have to be extracted from Response: \t\t" + requiresObj);
			if (requiresObj.length() > 0) {
				verifyResponse.addResponseAttributestoTestData(requiresObj, response);
			}
		} catch (Exception e) {
		}
		verifyResponse.validateExpectedStatusCode(response, jsonObject.getInt("statusCode"));

	}

	@Title("Create Billing project for the requirement")
	public void createBillingProject(VerificationSteps verifyResponse) throws IOException {
		String apiname = "createBillingProject";
		String serviceName = "oms_internal";
		System.out.println("Test Data--------------" + jsonTestDataObject);
		JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
		System.out.println(apiname + "\t Request object" + jsonObject);

		// Get Authentication:
		try {
			String login_email = jsonObject.getString("loginuser").toString();
			if (!(login_email == null) || login_email.isEmpty()) {
				new authPlatformTest().getUserAuthentication(verifyResponse, login_email);
				System.out.println("Test Data--------------" + jsonTestDataObject);
			}
		} catch (Exception e) {
		}

		JSONObject requestObj = (JSONObject) jsonObject.get("requestBody");
		JSONObject projectObject = (JSONObject) requestObj.get("project");
		String uri_update = null;
		System.out.println(" Project Requirement Id :::::::" + testdata.getReq_id());
		try {
			String req_id = testdata.getReq_id();
			System.out.println(testdata.getReq_id());
			if (!(req_id == null) || req_id.isEmpty()) {
				uri_update = jsonObject.getString("uri").trim().toString();
				uri_update = uri_update.replace("REQUIREMENT_ID", req_id);
			}
		} catch (Exception e) {
		}
		projectObject.put("name", "test bp" + testdata.getOrg_name());
		projectObject.put("client_requirement_id", testdata.getReq_id());
		projectObject.put("_project_type", testdata.getReq_vertical());
		jsonObject.put("uri", uri_update);
		System.out.println("Request Object:::::" + requestObj);
		Response response = new ApiMethod().httpMethod(jsonObject);
		System.out.println(apiname + "\t Response::::::::: " + response.asString());
		try {
			JSONArray requiresObj = (JSONArray) jsonObject.getJSONArray("extractResponse");
			System.out.println("Required Objects which have to be extracted from Response: \t\t" + requiresObj);
			if (requiresObj.length() > 0) {
				verifyResponse.addResponseAttributestoTestData(requiresObj, response);
			}
		} catch (Exception e) {
		}
		verifyResponse.validateExpectedStatusCode(response, jsonObject.getInt("statusCode"));
	}

	@Title("Create execution project for the requirement")
	public void createExecutionProject(VerificationSteps verifyResponse) throws IOException {
		String apiname = "createExecutionProject";
		String serviceName = "oms_internal";
		System.out.println("Test Data --------------" + jsonTestDataObject);
		JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
		System.out.println(apiname + "\t Request object" + jsonObject);

		// Get Authentication:
		try {
			String login_email = jsonObject.getString("loginuser").toString();
			if (!(login_email == null) || login_email.isEmpty()) {
				new authPlatformTest().getUserAuthentication(verifyResponse, login_email);
			}
		} catch (Exception e) {
		}
		JSONObject requestObj = (JSONObject) jsonObject.get("requestBody");
		JSONObject projectObject = (JSONObject) requestObj.get("project");
		String uri_update = null;
		try {
			String req_id = testdata.getReq_id();
			if (!(req_id == null) || req_id.isEmpty()) {

				uri_update = jsonObject.getString("uri").toString();
				uri_update = uri_update.replace("REQUIREMENT_ID", req_id);
			}
		} catch (Exception e) {
		}

		// Setting epname to datafactory.
		String ep_name = "test EP" + testdata.getOrg_name();
		testdata.setEp_name(ep_name);
		jsonTestDataObject.put("ep_name", ep_name);
		projectObject.put("name", ep_name);
		projectObject.put("client_requirement_id", testdata.getReq_id());
		projectObject.put("_project_type", testdata.getReq_vertical());
		jsonObject.put("uri", uri_update);
		System.out.println(apiname + "\tUpdate uri" + uri_update);
		System.out.println(apiname + "\tRequest Object" + requestObj);
		Response response = new ApiMethod().httpMethod(jsonObject);
		System.out.println(apiname + " Api Response::::::::::::::" + response.asString());

		try {
			JSONArray requiresObj = (JSONArray) jsonObject.getJSONArray("extractResponse");
			System.out.println("Required Objects which have to be extracted from Response: \t\t" + requiresObj);
			if (requiresObj.length() > 0) {
				verifyResponse.addResponseAttributestoTestData(requiresObj, response);
			}
		} catch (Exception e) {
		}
		// verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));
		verifyResponse.validateExpectedStatusCode(response, jsonObject.getInt("statusCode"));
	}

	@Title("Add offer letter for the workforce execution source.")
	public void patchOfferLetterES(VerificationSteps verifyResponse) throws IOException {
		String apiname = "patchOfferLetterES";
		String serviceName = "oms_internal";
		System.out.println("Test Data --------------" + jsonTestDataObject);
		JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
		System.out.println(apiname + "\t Request object" + jsonObject);

		// Get Authentication:
		try {
			String login_email = jsonObject.getString("loginuser").toString();
			if (!(login_email == null) || login_email.isEmpty()) {
				new authPlatformTest().getUserAuthentication(verifyResponse, login_email);
			}
		} catch (Exception e) {
		}
		String uri_update = null;
		try {
			String req_id = testdata.getReq_id();
			if (!(req_id == null) || req_id.isEmpty()) {
				uri_update = jsonObject.getString("uri").toString();
				uri_update = uri_update.replace("REQUIREMENT_ID", req_id);
			}
		} catch (Exception e) {
		}

		jsonObject.put("uri", uri_update);
		System.out.println(apiname + "\tUpdate uri" + uri_update);
		JSONObject requestObj = (JSONObject) jsonObject.get("requestBody");
		JSONObject projectObject = (JSONObject) requestObj.get("project");
		projectObject.put("name", testdata.getEp_name());
		projectObject.put("client_requirement_id", testdata.getReq_id());
		System.out.println(apiname + "\tRequest Object" + requestObj);
		Response response = new ApiMethod().httpMethod(jsonObject);
		System.out.println(apiname + " Api Response::::::::::::::" + response.asString());
		try {
			JSONArray requiresObj = (JSONArray) jsonObject.getJSONArray("extractResponse");
			System.out.println("Required Objects which have to be extracted from Response: \t\t" + requiresObj);
			if (requiresObj.length() > 0) {
				verifyResponse.addResponseAttributestoTestData(requiresObj, response);
			}
		} catch (Exception e) {
		}
		// verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));
		verifyResponse.validateExpectedStatusCode(response, jsonObject.getInt("statusCode"));
	}

	// Have to get the execution source, execution_rile_id and executions.
	@Title("se offer letter for the execution source.")
	public void setOfferLetterforES(VerificationSteps verifyResponse) throws IOException {
		String apiname = "setOfferLetterforES";
		String serviceName = "oms_internal";
		System.out.println("Test Data --------------" + jsonTestDataObject);
		JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
		System.out.println(apiname + "\t Request object" + jsonObject);

		// Get Authentication:
		try {
			String login_email = jsonObject.getString("loginuser").toString();
			if (!(login_email == null) || login_email.isEmpty()) {
				new authPlatformTest().getUserAuthentication(verifyResponse, login_email);
			}
		} catch (Exception e) {
		}

		// Update the url with the EP_id, Execution source_id, projectRole

		// handlle ep_id

		String uri_update = null;
		try {
			String EP_project_id = testdata.getExecutionproject_id();
			String EP_project_role = testdata.getEp_wf_project_role_id();
			String Execution_source_id = testdata.getEp_Executive_execution_sources_id();
			if (!(EP_project_id == null) || !(EP_project_role == null) || !(Execution_source_id == null)) {
				uri_update = jsonObject.getString("uri").toString();
				uri_update = uri_update.replace("EXECUTION_PROJECT_ID", EP_project_id);
				uri_update = uri_update.replace("PROJECTROLE", EP_project_role);
				uri_update = uri_update.replace("EXECUTION_SOURCE", Execution_source_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("uri", uri_update);
		System.out.println(apiname + "\tUpdate uri" + uri_update);
		System.out.println(apiname + "\tRequest Object" + jsonObject);
		Response response = new ApiMethod().httpMethod(jsonObject);
		System.out.println(apiname + " Api Response::::::::::::::" + response.asString());
		// verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));
		verifyResponse.validateExpectedStatusCode(response, jsonObject.getInt("statusCode"));
	}

	@Title("Search Executions for a Workforce")
	public void offExecutionMemberSearch(VerificationSteps verifyResponse) throws IOException {
		String apiname = "offExecutionMemberSearch";
		String serviceName = "oms_internal";
		System.out.println("Test Data --------------" + jsonTestDataObject);
		JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
		System.out.println(apiname + "\t Request object" + jsonObject);

		// Get Authentication:
		String login_email = null;

		
		  try { login_email = jsonObject.getString("loginuser").toString(); if
		  (!(login_email == null) || login_email.isEmpty()) { new
		  authPlatformTest().getUserAuthentication(verifyResponse, login_email); } }
		  catch (Exception e) { }
		 
		  System.out.println("--------------Update test data:\t "+ jsonTestDataObject);
		// Update the url with the member_id WFMEMBERID me: 5e70698fec4f151a2b11d46b
		// Ih_oms_id is member id of an workforce
	
		String uri_update = null;
		try {
			uri_update = jsonObject.getString("uri").toString();
			String ih_oms_id = testdata.getIh_oms_id();
			if (!(ih_oms_id == null)) {
				uri_update = jsonObject.getString("uri").toString();
				uri_update = uri_update.replace("WFMEMBERID", ih_oms_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		jsonObject.put("uri", uri_update);
		System.out.println(apiname + "\t Update uri" + uri_update);
		System.out.println(apiname + "\tRequest Object \t" + jsonObject);
		Response response = new ApiMethod().httpMethod(jsonObject);
		System.out.println(apiname + "\tResponse Object \t" + response.asString());
		verifyResponse.extractExecutionofMember(response);
	}

	@Title("Accept offer letter for an execution")
	public void acceptOfferLetter(VerificationSteps verifyResponse) throws IOException {
		String apiname = "acceptOfferLetter";
		String serviceName = "oms_internal";
		System.out.println("Test Data --------------" + jsonTestDataObject);
		JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
		System.out.println(apiname + "\t Request object" + jsonObject);

		/*
		 * // Get Authentication: String login_email = null;
		 * 
		 * try { login_email = jsonObject.getString("loginuser").toString(); if
		 * (!(login_email == null) || login_email.isEmpty()) { new
		 * authPlatformTest().getUserAuthentication(verifyResponse, login_email); } }
		 * catch (Exception e) { }
		 */

		String ep_project_id = null;
		String ep_wf_execution_id = null;
		ep_project_id = testdata.getExecutionproject_id();
		ep_wf_execution_id = testdata.getWFProj_execution_id();
		String uri_update = null;
		try {
			uri_update = jsonObject.getString("uri").toString();
			if (!(ep_project_id == null) && !(ep_wf_execution_id == null)) {
				uri_update = uri_update.replace("EPProjectID", ep_project_id);
				uri_update = uri_update.replace("WFEXECUTIONID", ep_wf_execution_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		jsonObject.put("uri", uri_update);
		System.out.println(apiname + "\t Update uri" + uri_update);
		System.out.println(apiname + "\t Request Object \t" + jsonObject);
		Response response = new ApiMethod().httpMethod(jsonObject);
		System.out.println(apiname + "Response" + response.asString());

		verifyResponse.validateExpectedStatusCode(response, jsonObject.getInt("statusCode"));

	}
	
	
	@Title("Create Dynamic execution by creating a user and adding to the project")
	public void createDynamicExecutions(VerificationSteps verifyResponse, int totalcount,String EP_Project_id,String EP_WF_Execution_source_id) throws IOException {
		String apiname = "addExecutions";
		String serviceName = "oms_internal";
		JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
		//System.out.println(apiname + "\t Request object" + jsonObject);
		String login_email=null;
		  
		// Get Authentication: String login_email = null;
		  
		  try { login_email = jsonObject.getString("loginuser").toString(); if
		  (!(login_email == null) || login_email.isEmpty()) { new
		  authPlatformTest().getUserAuthentication(verifyResponse, login_email); } }
		  catch (Exception e) { }
		  String curr_member = null;
		  String prev_member = null;
				  
		  int i = 0; 
			do { 
				System.out.println("Iteration :\t"+i +"\t" + new DateUtil().getcurrentTime()); 
				i++; 
				//Create a new user 
				String mem;
				mem = new authPlatformTest().UserSignup(verifyResponse, i);
				
				
				jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
				//System.out.println(apiname + "\t Request object" + jsonObject);
				
				
				if(!(mem==null)) {
				
				//Adding the created user to the project.
				String wf_member_id = mem;
				//System.out.println("--------------Update test data:\t "+ jsonTestDataObject);
			/*
			 * wf_member_id = testdata.getIh_oms_id(); curr_member = wf_member_id;
			 *
			 */
		        
			/*
			 * int j=0; do {
			 * 
			 * if((curr_member==prev_member)|| (curr_member==null)) { try { Thread.sleep(2);
			 * } catch (InterruptedException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } wf_member_id = testdata.getIh_oms_id(); curr_member =
			 * wf_member_id;
			 * System.out.println("Fetched new-------------member_id "+wf_member_id ); }else
			 * { break; } j++; }while(j<=10);
			 */
				 System.out.println("-------------member_id "+wf_member_id );
		       String uri_update = null; 
		       try { 
		    	   uri_update = jsonObject.getString("uri").toString(); 
		    	   if (!(wf_member_id == null) &&  !(wf_member_id == null)) 
		    	   { 
		    		   uri_update = uri_update.replace("MEMBERID", wf_member_id); } 
		       		} catch (Exception e) { e.printStackTrace(); }
		       		jsonObject.put("uri", uri_update);
	         		
		       		System.out.println(apiname + "\t Request Object \t" + jsonObject);
		       		Response response = new ApiMethod().httpMethod(jsonObject);
		       		System.out.println(apiname + "Response" + response.asString());
		       		if(response.getStatusCode()==200) {
		       			prev_member =	curr_member;
		       			curr_member=null;
		       		}
		       		
				}else {
					System.out.println("----------member_id is null");
				}
		       		//Replacing the WF id with String MEMBERID
		       	//	uri_update = uri_update.replace(wf_member_id,"MEMBERID");

		}while (i<=totalcount);
		
		
	}
	
	
	
	@Title("Create Dynamic execution by creating a user and adding to the project")
	public void createStaticExecutions(VerificationSteps verifyResponse, int totalcount,String EP_Project_id,String EP_WF_Execution_source_id) throws IOException {
		String apiname = "addExecutionsActive";
		String serviceName = "oms_internal";
		JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
		String login_email=null;
		int i=0;
 
		// Get Authentication: String login_email = null;
		  
		  try { login_email = jsonObject.getString("loginuser").toString(); if
		  (!(login_email == null) || login_email.isEmpty()) { new
		  authPlatformTest().getUserAuthentication(verifyResponse, login_email); } }
		  catch (Exception e) { }
		  try {
				List<String> lines = Files.readAllLines(Paths.get(file_path));
		        for (String line : lines) {
		        	i++;
		        	String mem_id= line.trim();
		        	System.out.println("Iteration:\t"+ i +"Add member id :\t "+mem_id+"\t " + new DateUtil().getcurrentTime());
		        	
		        	
		    			if(!(mem_id==null)) {
		        	
		           		   jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)), apiname);
		        		   String uri_update = null; 
	 	 
		 	        	 try { 
		 	        		 uri_update = jsonObject.getString("uri").toString();
		 	        		 if (!(mem_id == null) && !(mem_id == null))
		 	        		 { uri_update = uri_update.replace("MEMBERID", mem_id); } 
		 	        		 }catch (Exception e) {  e.printStackTrace(); } 
		        		 
		        		 	  jsonObject.put("uri", uri_update);
		        			  System.out.println(apiname + "\t Request Object \t" + jsonObject); 
		        			  Response response = new ApiMethod().httpMethod(jsonObject); 
		        			  System.out.println(apiname + "Response" + response.asString()); 
		    			}
		        }
			}catch(Exception e) {}
	
	}
}


