package com.awign.utilities;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;
import com.awign.dataprovider.BaseController;
import com.awign.dataprovider.DataConstants;
import com.awign.dataprovider.TestDataFactory;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class JsonUtil {
	BaseController bs = new BaseController();
	 public static StringUtil fakeData = new StringUtil();

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	//	JsonUtil je = new JsonUtil();
		//je.getServicesNames(DataConstants.IHOMS_JSON_PATH);
		//System.out.println(		je.getServicesNames(DataConstants.AUTH_JSON_PATH));	
		//System.out.println(je.getServiceFilebyName("auth"));
//je.test003();
    }	
	
	
	
	public void extractjosn(Response response) throws IOException {
		JSONObject responsejson =(JSONObject) response;
		JSONObject listingarray = responsejson.getJSONObject("worklistings");

		System.out.println(listingarray.length());		

	}
	
	
	
/*	public void test003() throws IOException {
		bs.setBaseData();

		String apiname= "NewClient_sign_up";
		String serviceName= "auth";
		JSONObject requestObj = new JSONObject();
		requestObj = apiJSONReader((getServiceFilebyName(serviceName)),apiname);
		//System.out.println(jsonObject);
        String nameofCurrMethod = new Object() {}.getClass() .getEnclosingMethod() .getName(); 
        String nameofCurrClass  = this.getClass().getSimpleName();
        
        JSONObject reqObj=  (JSONObject) requestObj.get("requestBody");
        JSONObject orgdomainObj=  (JSONObject) reqObj.get("organisation");
        JSONObject userObj=  (JSONObject) reqObj.get("user");

        orgdomainObj.put("name", bs.jsonTestDataObject.getString("org_name"));
        orgdomainObj.put("domain", bs.jsonTestDataObject.getString("org_domain"));
        userObj.put("contact", bs.jsonTestDataObject.getString("usr_contact"));
        userObj.put("name", bs.jsonTestDataObject.getString("usr_name"));
        userObj.put("email", bs.jsonTestDataObject.getString("usr_email"));
        System.out.println("------"+reqObj);
       	Response response = new ApiMethod().httpMethod(reqObj);

 

        System.out.println(nameofCurrClass);
		try {
		JSONArray requiresObj= requestObj.getJSONArray("extractResponse");
		if(requiresObj.length()>0) {
		//	addResponseAttributestoTestData(nameofCurrClass,nameofCurrMethod,requiresObj ,response);
		}
		}catch(Exception e) {}


	}
*/	
	
	
	/*public void testpost() throws IOException {
		BaseController bc = new BaseController();
		String apiname= "NewClient_sign_up";
		String serviceName= "auth";
		JSONObject jsonObject = new JSONObject();
		jsonObject = apiJSONReader((getServiceFilebyName(serviceName)),apiname);
		//System.out.println(jsonObject);
		
        JSONObject orgname=  (JSONObject) jsonObject.get("requestBody");
        JSONObject orgdomainObj=  (JSONObject) orgname.get("organisation");
        JSONObject userObj=  (JSONObject) orgname.get("user");

        orgdomainObj.put("name", bc.jsonTestDataObject.getString("org_name"));
        orgdomainObj.put("domain", bc.jsonTestDataObject.getString("org_domain"));
        userObj.put("contact", bc.jsonTestDataObject.getString("usr_contact"));
        userObj.put("name", bc.jsonTestDataObject.getString("usr_name"));
        userObj.put("email", bc.jsonTestDataObject.getString("usr_email"));
       	Response response = new ApiMethod().httpMethod(jsonObject);

    		System.out.println("------------"+response.asString());
    		System.out.println(response.statusCode());
    		System.out.println(response.getStatusLine());
    		System.out.println(response.getBody().asString());
        try {
    			JSONObject js = new JSONObject(extractSignupResponse(response).toString());
            String org_id = js.getString("org_id");
            System.out.println("-----org_id"+org_id);
        }catch(Exception e) {}
        
		
	}
*/	
	
	
/*	public JSONObject testData() {
		JSONObject jsonObject = new JSONObject();
		 TestDataFactory testdata = new TestDataFactory();

	
 		String testcaseID ="001";
 		String customermobile=new TestDataGenerator().generateRandomMobileNumber();
 		String org_domain=fakeData.getRandomString().name();
 		String org_name=fakeData.getRandomString().profession();
 		String usrname="test"+fakeData.getRandomString().name();
 		String usremail =new TestDataGenerator().generateRandomEmail();
 		String usrcontact=new TestDataGenerator().generateRandomMobileNumber();
 		String bpepname =  fakeData.getRandomString().industry();


    	    try {  	 
    	    	if((!(testdata.getTestCaseId()==null) )|| (testdata.getTestCaseId().isEmpty())) {
		 testdata.setTestCaseId(testcaseID);
		 testdata.setCustomerMobileNumber(customermobile);
		 testdata.setOrg_domain(org_domain);
		 testdata.setOrg_name(org_name);
		 testdata.setUsr_name(usrname);
		 testdata.setUsr_email(usremail);
		 testdata.setUsr_contact(usrcontact);
		 testdata.setBpep_name(bpepname);
		 jsonObject.put("usr_name",usrname);
		 jsonObject.put("usr_email", usremail);
		 jsonObject.put("usr_contact",usrcontact);
		 jsonObject.put("org_name",org_name);
		 jsonObject.put("org_domain",org_domain);
		 jsonObject.put("bpep_name",bpepname);
    	    }
	
	}catch(Exception e) {
 	   // 	e.printStackTrace();
  }
	        return jsonObject;

	}
*/	public JSONObject testData() {
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("usr_name",new TestDataGenerator().generateRandomName().toLowerCase());
        jsonObject.put("usr_email", new TestDataGenerator().generateRandomEmail());
        jsonObject.put("usr_contact",new TestDataGenerator().generateRandomMobileNumber());
        jsonObject.put("org_name",new TestDataGenerator().generateRandomDomainName().toLowerCase());
        jsonObject.put("org_domain",new TestDataGenerator().generateRandomDomainName().toLowerCase());
        jsonObject.put("bpep_name",fakeData.getRandomString().name().toLowerCase());       
		// testdata.setBpep_name(new TestDataGenerator().generateRandomMobileNumber());
        System.out.println("Generated Test data : \t --------------"+jsonObject);
        return jsonObject;

	}

	
	
/*	public JSONObject extractSignupResponse(Response response) {
		String org_id="";
		String org_name="";
		String usr_id="";
		String client="";
		String access_token="";
		String uid="";

        JsonPath jp = response.jsonPath();
		JSONObject jsonObject = new JSONObject();
        org_id = jp.get("data.user.memberships[0].org_id").toString();
        org_name=jp.get("data.user.memberships[0].name").toString();
        client = jp.get("data.headers.client").toString();
        access_token=jp.get("data.headers.access-token").toString();
        uid=jp.get("data.headers.access-token").toString();
        usr_id = jp.get("data.user.id").toString();
        jsonObject.put("org_id",org_id);
        jsonObject.put("org_name",org_name);
        jsonObject.put("usr_id",usr_id);   
        jsonObject.put("client",client);
        jsonObject.put("access_token",access_token);
        jsonObject.put("uid",uid);
        

        return jsonObject;

	}
	
	public JSONObject extractSigninResponse(Response response) {
		String usr_id="";
		String client="";
		String access_token="";
		String uid="";

        JsonPath jp = response.jsonPath();
		JSONObject jsonObject = new JSONObject();
        client = jp.get("data.headers.client").toString();
        access_token=jp.get("data.headers.access-token").toString();
        uid=jp.get("data.headers.access-token").toString();
        usr_id = jp.get("data.user.id").toString();
        jsonObject.put("usr_id",usr_id);   
        jsonObject.put("client",client);
        jsonObject.put("access_token",access_token);
        jsonObject.put("uid",uid);

        return jsonObject;

	}

*/	
/*	public JSONObject extractReqidResponse(Response response) {
		String req_id="";
		String req_status="";
		String req_vertical;
        JsonPath jp = response.jsonPath();
		JSONObject currjsonObject = new JSONObject();
        req_id = jp.get("data.client_requirement._id").toString();
        req_status = jp.get("data.client_requirement._status").toString();
        req_vertical = jp.get("data.client_requirement.vertical").toString();
        currjsonObject.put("req_id",req_id);
        currjsonObject.put("req_status", req_status);
        currjsonObject.put("req_vertical", req_vertical);     
        return currjsonObject;

	}
*/	
	
	public String getServiceFilebyName(String servicename) {
        
        if(servicename.equalsIgnoreCase("oms_internal")) {
        	return DataConstants.IHOMS_JSON_PATH;

        }else         if(servicename.equalsIgnoreCase("auth")) {
        	return DataConstants.AUTH_JSON_PATH;

        }else  if(servicename.equalsIgnoreCase("oms_external")) {
        	return DataConstants.SSOMS_JSON_PATH;

        }		
        else if(servicename.equalsIgnoreCase("core")) {
        	return DataConstants.CORE_JSON_PATH;
        }
        else if(servicename.equalsIgnoreCase("newcas")) {
        	return DataConstants.NEWCAS_JSON_PATH;
        }
        else if(servicename.equalsIgnoreCase("wos")) {
        	return DataConstants.WOS_JSON_PATH;
        }
        
        return servicename;        
      				
	}
	
	public ArrayList<String> getServicesNames(String jsonFilePath) throws IOException {
		File file = new File(jsonFilePath);
		String content = FileUtils.readFileToString(new File(file.getCanonicalPath()), "utf-8");
		JSONObject apiObject = new JSONObject(content);
		ArrayList<String> apilist = new ArrayList<String>();
		JSONArray serviceApi = new JSONArray(apiObject.get("services").toString());
		String httpmethod =null;
		for (int i = 0; i < serviceApi.length(); i++) {
			String api_names = serviceApi.getJSONObject(i).names().toString();
			api_names=api_names.replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", "");
			httpmethod=getServiceMethod(jsonFilePath,api_names);
			apilist.add(api_names+"_"+httpmethod);
			//System.out.println(api_names);
		}
		return apilist;
	}
	
	public String getServiceMethod(String filename, String apiName) throws IOException {
		JSONObject requestObj =apiJSONReader(filename,apiName);
	//	System.out.println(requestObj);
        	return requestObj.getString("httpMethod");
	}
	
	
/*	public void getserviceApi() throws IOException{
		JSONObject requestObj =apiJSONReader(DataConstants.IHOMS_JSON_PATH,"Requirement_Search");
        String httpMethod = requestObj.getString("httpMethod");
        String httpuri = requestObj.getString("uri");
        String requestBody = requestObj.getJSONObject("requestBody").toString();

		JSONArray Headerarray = (JSONArray) requestObj.get("apiHeader");

        System.out.println(httpMethod);
        System.out.println(httpuri);
        System.out.println(Headerarray);
        System.out.println(requestBody);

	}
*/	
	
/*	public void exeuteMethodtype() throws Exception {
        JSONObject obj = readJsonFile(DataConstants.AUTH_JSON_PATH);

		JSONArray arr = obj.getJSONArray("services");
		JSONArray serviceApi = new JSONArray(obj.get("services").toString());

		for (int i = 0; i < arr.length(); i++) {
			JSONObject data = (JSONObject) serviceApi.get(i);
			
			String req_type = (String) data.get("httpMethod");
			String req_uri = (String) data.get("uri");

			Integer req_statuscode = (Integer) data.get("statusCode");

			JSONArray Headerarray = (JSONArray) data.get("apiHeader");
			if(req_type.equals("POST")) {
				JSONObject req_body = (JSONObject) data.get("requestBody");
				System.out.println(req_body);
				
			}
			JSONObject headerobj = (JSONObject) Headerarray.get(0);
			System.out.println(headerobj);
			System.out.println(req_type +":\t"+ req_uri);
			System.out.println(req_statuscode);
		}

	}
*/	
	public String getValueByJpath(String jpath,Response response) {

		JSONObject responsejson =(JSONObject) response;
		Object obj =responsejson;
		for(String s:jpath.split("/"))
			if(!s.isEmpty())
			if(!s.contains("[")|| (!s.contains("]")))
					obj = ((JSONObject) obj).get(s);
				else if (s.contains("[")|| s.contains("]"))
				    obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]","")));
			return obj.toString();
	}			
	
	
	public static  JSONObject readJsonFile(String filename) throws Exception {
		FileReader reader = new FileReader(filename);
		JSONParser jsonParser = new JSONParser();
		return objectToJSONObject(jsonParser.parse(reader));
	}

	public static JSONObject objectToJSONObject(Object object) {
		Object json = null;
		JSONObject jsonObject = null;
		try {
			json = new JSONTokener(object.toString()).nextValue();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if (json instanceof JSONObject) {
			jsonObject = (JSONObject) json;
		}
		return jsonObject;
	}


	public JSONObject apiJSONReader(String jsonFilePath, String apiName) throws IOException {
		File file = new File(jsonFilePath);
		String content = FileUtils.readFileToString(new File(file.getCanonicalPath()), "utf-8");
		JSONObject apiObject = new JSONObject(content);
		JSONArray serviceApi = new JSONArray(apiObject.get("services").toString());
		JSONObject serviceObj = new JSONObject();
		for (int i = 0; i < serviceApi.length(); i++) {
			if (serviceApi.getJSONObject(i).names().toString().contains(apiName)) {
				JSONObject data = (JSONObject) serviceApi.get(i);
				serviceObj = (JSONObject) data.get(apiName);
			}
		}
		return serviceObj;
	}

}
