package com.awign.tests.omsplatform;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.awign.dataprovider.BaseController;
import com.awign.utilities.ApiMethod;
import com.awign.utilities.PropertyUtil;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.annotations.WithTags;
import steps.VerificationSteps;

//@FixMethodOrder(MethodSorters.DEFAULT)
//@CucumberOptions( plugin = { “usage” }) //it will record time taken for each step definition. 
//@story(Application.AppNavigation.NavigationMenu.class)

public class IhomsPlatformTest extends BaseController{
	 //@Steps
	 //public VerificationSteps verifyResponse;
	 public static BaseController basecontroller = new BaseController();	 
	// PropertyUtil prop =new PropertyUtil();
	// public static JsonUtil jsonUtil = new JsonUtil();

	
	@BeforeClass
		public static void init() {	
		basecontroller.setBaseData();
	
	}
	
	@Title("Add requirement to the client")
	public void addRequirement(VerificationSteps verifyResponse) throws IOException {
		String apiname= "addRequirement";
		String serviceName= "oms_internal";
		System.out.println("--------------"+jsonTestDataObject);
        System.out.println(testdata.getOrg_id());

        //System.out.println("get org ------------------"+ jsonTestDataObject.getString("org_id"));
        JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
		System.out.println(jsonObject);
		
        JSONObject requestObj=  (JSONObject) jsonObject.get("requestBody");
        JSONObject clientReqObject=  (JSONObject) requestObj.get("client_requirement");
        clientReqObject.put("description", fakeData.getRandommusic());
        clientReqObject.put("domain", jsonTestDataObject.getString("org_domain"));
        clientReqObject.put("org", jsonTestDataObject.getString("org_id"));
        
        System.out.println("Request Object:\t" +requestObj);
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
      // 	verifyResponse.ValidateRestSpec(response);
       	System.out.println("------------"+response.asString());   
		  
	}

	//@WithTags({@WithTag("Feature")})
	//@Test
	@Title("Verify whether we are able to search the Created requirement")
	public void searchRequirement(VerificationSteps verifyResponse) throws IOException {
		String apiname= "searchRequirement";
		String serviceName= "oms_internal";
		System.out.println("--------------"+jsonTestDataObject);
        System.out.println("Searching Data for the Domain"+ testdata.getOrg_domain());

        JSONObject requestObj = new JSONObject();
        requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
		System.out.println("Request Object :\t"+requestObj);
		System.out.println("Expected Status code:\t"+requestObj.getInt("statusCode"));
		JSONObject conditionObje  = requestObj.getJSONObject("requestBody").getJSONArray("conditions").getJSONObject(0);
		JSONObject domainObj = conditionObje.getJSONObject("domain");

		System.out.println("domain object" +domainObj);
		domainObj.put("value", jsonTestDataObject.getString("org_domain"));
		
        
        System.out.println("Request Object:\t" +requestObj);
       	Response response = new ApiMethod().httpMethod(requestObj);
       	// verifyResponse.validateExpectedStatusCode(response,);
       	//verifyResponse.searchvalidstatus(response);
       	//verifyResponse.addReq_idToTestData(response);
       	
       	System.out.println("------------"+response.asString());   
		  
	}


	//@WithTags({@WithTag("Feature")})
	//@Test
	@Title("Verify whether we are able to search the newly created project")
	public void searchProject(VerificationSteps verifyResponse) throws IOException {
		String apiname = "searchProject";
		String serviceName ="oms_internal";
		//System.out.println("--------------"+jsonTestDataObject);

        JSONObject requestObj = new JSONObject();
        requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
		System.out.println("Request Object :\t"+requestObj);
		System.out.println("Expected Status code:\t"+requestObj.getInt("statusCode"));
		JSONObject conditionObje  = requestObj.getJSONObject("requestBody").getJSONArray("conditions").getJSONObject(0);

		JSONObject reqObject = conditionObje.getJSONObject("client_requirement_id");
		JSONObject projectObject = conditionObje.getJSONObject("_project_type");
		reqObject.put("value", jsonTestDataObject.getString("req_id"));
		projectObject.put("value", jsonTestDataObject.getString("req_vertical"));
        System.out.println("Request Object:\t" +requestObj);
       	Response response = new ApiMethod().httpMethod(requestObj);
       	// verifyResponse.validateExpectedStatusCode(response,);
       	//verifyResponse.searchvalidstatus(response);
       	//verifyResponse.addReq_idToTestData(response);
       	
       	System.out.println("------------"+response.asString());   
		  
	}

	@Title("Get project details - Execution project execution source_id for executive role")
	public void getProject(VerificationSteps verifyResponse)throws IOException {
		String apiname = "getProject";
		String serviceName ="oms_internal";
        JSONObject requestObj = new JSONObject();
        requestObj = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
		System.out.println("Request Object :\t"+requestObj);
		
		String uri_update = null; 
		
		try {
			String listingexecutionproject_id = jsonTestDataObject.getString("listingsrc_execution_project_id");
			if(!(listingexecutionproject_id== null) || listingexecutionproject_id.isEmpty()) {				
			uri_update = requestObj.getString("uri").toString();
			uri_update= uri_update.replace("PROJECT_ID", listingexecutionproject_id);
			}
		}catch(Exception e) {}
		requestObj.put("uri", uri_update);
		
		System.out.println("update uri" + uri_update);
       	Response response = new ApiMethod().httpMethod(requestObj);
       	
		try {
		JSONArray requiresObj= (JSONArray) requestObj.getJSONArray("extractResponse");
		System.out.println("Required Objects which have to be extracted from Response: \t\t"+requiresObj);
		if(requiresObj.length()>0) {
			verifyResponse.addResponseAttributestoTestData(requiresObj ,response);
		}
		}catch(Exception e) {}

       	verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));

	}

	
	@Title("Get Requirement for the requirement id")
	public void getRequirement(VerificationSteps verifyResponse) throws IOException {
		String apiname= "getRequirement";
		String serviceName= "oms_internal";

        JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
		System.out.println(jsonObject);
		
		String uri_update = null; 
		System.out.println("req d:::::::"+ testdata.getReq_id());
		try {
			String req_id = testdata.getReq_id();
			System.out.println(testdata.getReq_id());

			if(!(req_id== null) || req_id.isEmpty()) {
			
			uri_update = jsonObject.getString("uri").toString();
			System.out.println();
			uri_update= uri_update.replace("REQUIREMENT_ID", req_id);
			}
		}catch(Exception e) {}

        
		jsonObject.put("uri", uri_update);
		System.out.println("update uri" + uri_update);
        
        System.out.println("Request Object" +jsonObject);
       	Response response = new ApiMethod().httpMethod(jsonObject);
       	
       	System.out.println("Response::::::::: " + response.asString());
       	
		try {
		JSONArray requiresObj= (JSONArray) jsonObject.getJSONArray("extractResponse");
		System.out.println("Required Objects which have to be extracted from Response: \t\t"+requiresObj);
		if(requiresObj.length()>0) {
			verifyResponse.addResponseAttributestoTestData(requiresObj ,response);
		}
		}catch(Exception e) {}

       	verifyResponse.validateExpectedStatusCode(response,jsonObject.getInt("statusCode"));       	
		  
	}

	
	
	
	@Title("Create Billing project for the requirement")
	public void createBillingProject(VerificationSteps verifyResponse) throws IOException {
		String apiname= "createBillingProject";
		String serviceName= "oms_internal";
		System.out.println("--------------"+jsonTestDataObject);

        JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
		System.out.println(jsonObject);
		
        JSONObject requestObj=  (JSONObject) jsonObject.get("requestBody");
        JSONObject projectObject=  (JSONObject) requestObj.get("project");
		String uri_update = null; 
		System.out.println("req d:::::::"+ testdata.getReq_id());
		try {
			String req_id = testdata.getReq_id();
			System.out.println(testdata.getReq_id());

			if(!(req_id== null) || req_id.isEmpty()) {
			
			uri_update = jsonObject.getString("uri").trim().toString();
			System.out.println();
			uri_update= uri_update.replace("REQUIREMENT_ID", req_id);
			}
		}catch(Exception e) {}

        
		projectObject.put("name", "test bp"+testdata.getOrg_name());
		projectObject.put("client_requirement_id", testdata.getReq_id());
		projectObject.put("_project_type",testdata.getReq_vertical());
		jsonObject.put("uri", uri_update);
		//System.out.println("update uri" + uri_update);
        
        System.out.println("Request Object:::::" +requestObj);
       	Response response = new ApiMethod().httpMethod(jsonObject);
       	
       	System.out.println("Response::::::::: " + response.asString());
       	

		try {
		JSONArray requiresObj= (JSONArray) jsonObject.getJSONArray("extractResponse");
		System.out.println("Required Objects which have to be extracted from Response: \t\t"+requiresObj);
		if(requiresObj.length()>0) {
			verifyResponse.addResponseAttributestoTestData(requiresObj ,response);
		}
		}catch(Exception e) {}
		System.out.println("\n any exception \n");
       	verifyResponse.validateExpectedStatusCode(response,jsonObject.getInt("statusCode"));       	


		  
	}

	@Title("Create execution project for the requirement")
	public void createExecutionProject(VerificationSteps verifyResponse) throws IOException {
		String apiname= "createExecutionProject";
		String serviceName= "oms_internal";
		System.out.println("--------------"+jsonTestDataObject);

        JSONObject jsonObject = new JSONObject();
		jsonObject = jsonUtil.apiJSONReader((jsonUtil.getServiceFilebyName(serviceName)),apiname);
		System.out.println(jsonObject);
		
        JSONObject requestObj=  (JSONObject) jsonObject.get("requestBody");
        JSONObject projectObject=  (JSONObject) requestObj.get("project");
		String uri_update = null; 
		
		try {
			String req_id = testdata.getReq_id();
			if(!(req_id== null) || req_id.isEmpty()) {
			
			uri_update = jsonObject.getString("uri").toString();
			uri_update= uri_update.replace("REQUIREMENT_ID", req_id);
			}
		}catch(Exception e) {}

        
		projectObject.put("name", "test EP"+testdata.getOrg_name());
		projectObject.put("client_requirement_id", testdata.getReq_id());
		projectObject.put("_project_type",testdata.getReq_vertical());
		jsonObject.put("uri", uri_update);
		System.out.println("update uri" + uri_update);
        
        System.out.println("Request Object" +requestObj);
       	Response response = new ApiMethod().httpMethod(jsonObject);

		try {
		JSONArray requiresObj= (JSONArray) jsonObject.getJSONArray("extractResponse");
		System.out.println("Required Objects which have to be extracted from Response: \t\t"+requiresObj);
		if(requiresObj.length()>0) {
			verifyResponse.addResponseAttributestoTestData(requiresObj ,response);
		}
		}catch(Exception e) {}
       //	verifyResponse.validateExpectedStatusCode(response,requestObj.getInt("statusCode"));
       	verifyResponse.validateExpectedStatusCode(response,jsonObject.getInt("statusCode"));       	

	}


	
	
	}
