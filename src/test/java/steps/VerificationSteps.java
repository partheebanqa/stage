package steps;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Title;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.runner.RunWith;
import com.awign.dataprovider.BaseController;
import com.awign.utilities.FileUtil;
import com.awign.utilities.JsonUtil;
import com.awign.utilities.ReusableSpecifications;

/** 
* @author  Partheeban.moorthy@awign.com
* @version 1.0 
*/


//Todo: Loop the ep project details and get the execution_source of the workforce. listingsrc_execution_project_id

@RunWith(SerenityRunner.class)
public class VerificationSteps extends BaseController{
	   
	ReusableSpecifications restSpec = new ReusableSpecifications();
	JsonUtil ju= new JsonUtil();
	FileUtil futil = new FileUtil();
	   
	   @Step
	   public void verifyResponseContentbyStatuscode(String code) {
		   if(code.equalsIgnoreCase("200")) {
		   		}else if (code.equalsIgnoreCase("404")) {
			 }
	   }
	   
	   //Todo
	   public void verifyHeader() {
		   
	   }
	   //Todo
	   public void validateResponseTime() {
		   
	   }
	   
	   //Todo
	   public void validateResponseSize() {
		   
	   }
	   

	   //@Step
	   //public void searchCountryByCode(String code){
	    //   response = SerenityRest.when().get(ISO_CODE_SEARCH + code);
	  // }
	   
	   @Step 
	   public void validateExpectedStatusCode(Response response,int e_statuscode) {
	       response.then().statusCode(e_statuscode);
	   }

	   @Title("Verify whether search gets results")
	   @Step
	   public void searchIsExecutedSuccesfully(Response response){
	       response.then().statusCode(200);
	   }
	   
	   @Step
	   public void searchIsPhoneNotFoud(Response response) {
	       response.then().statusCode(404);

	   }
	   //    @Step("#actor starts with {0}")

	   @Step
	   public void searchContentinResponse(Response response) {
	      response.then().contentType("application/json; charset=utf-8");
	   }

	  
	   
	   @Step
	   public void searchstatusinResponse(Response response) {
	      response.then().statusLine("HTTP/1.1 404 Not Found");
	   }
	   
	   @Title("Verify for Valid status code")
	   @Step
	   public void searchvalidstatus(Response response) {
		   response.then().statusLine("HTTP/1.1 200 OK");
		
	   }

/*	   public void extractSignupResposeAddToTestData(Response response ) {
			JSONObject js = new JSONObject(jsonUtil.extractSignupResponse(response).toString());
            String org_id = js.getString("org_id");
            String org_name = js.getString("org_name");
            String usr_id = js.getString("usr_id");
            String client= js.getString("client");
            String access_token= js.getString("access_token");
            jsonTestDataObject.put("org_id", org_id);
            jsonTestDataObject.put("org_name", org_name);

            //jsonTestDataObject.put("usr_id", usr_id);
            jsonTestDataObject.put("usr_id", js.getString("usr_id"));
            jsonTestDataObject.put("client", client);
            jsonTestDataObject.put("access_token", access_token);
            jsonTestDataObject.put("uid", js.getString("uid"));            

            testdata.setOrg_id(org_id);
            testdata.setOrg_name(org_name);
            testdata.setUsr_id(usr_id);
            testdata.setClient(client);
            testdata.setAccess_token(access_token);
            testdata.setUid(js.getString("uid"));

            System.out.println("Updated TestData:\t ----------"+testdata.getOrg_id());
            System.out.println("Updated TestData:\t ----------"+testdata.getUsr_id());
            System.out.println("Updated TestData:\t"+jsonTestDataObject);

	   }
*/	   
	   
/*	   public void extractSigninResposeAddToTestData(Response response ) {
			JSONObject js = new JSONObject(jsonUtil.extractSigninResponse(response).toString());
            String usr_id = js.getString("usr_id");
            String client= js.getString("client");
            String access_token= js.getString("access_token");

            //jsonTestDataObject.put("usr_id", usr_id);
            jsonTestDataObject.put("usr_id", js.getString("usr_id"));
            jsonTestDataObject.put("client", client);
            jsonTestDataObject.put("access_token", access_token);
            jsonTestDataObject.put("uid", js.getString("uid"));            

            testdata.setUsr_id(usr_id);
            testdata.setClient(client);
            testdata.setAccess_token(access_token);
            testdata.setUid(js.getString("uid"));

            System.out.println("Updated TestData:\t ----------"+testdata.getOrg_id());
            System.out.println("Updated TestData:\t ----------"+testdata.getUsr_id());
            System.out.println("Updated TestData:\t"+jsonTestDataObject);

	   }

*/	   
	   
/*	   public void addReq_idToTestData(Response response ) {
			JSONObject js = new JSONObject(jsonUtil.extractReqidResponse(response).toString());
            String req_id = js.getString("req_id");
            String req_status = js.getString("req_status");
            String req_vertical = js.getString("req_vertical");

            
            jsonTestDataObject.put("req_id", req_id);
            jsonTestDataObject.put("req_status", req_status);
            jsonTestDataObject.put("req_vertical", req_vertical);


            testdata.setReq_id(req_id);
            testdata.setReq_status(req_status);
            testdata.setReq_vertical(req_vertical);
            System.out.println("Updated TestData:\t ----------"+testdata.getReq_id());
            System.out.println("Updated json TestData:\t"+jsonTestDataObject);

	   }
*/	   
	   

	   @Step
	   public void ValidateRestSpec(Response response) {
		   response.then().spec(new ReusableSpecifications().getGenricResponseSpec());
	   }
	   
	   public void VerifyResponseText(Response response,String path, String arguments) {
		   String extractedString = response.then().extract().path(path, arguments);
	   }
	   
	   
	   public void validatePostBodyResponse(Response response) {
		   JSONObject responseObj = new JSONObject();
		//   response.then().body(matcher, additionalMatchers);
		//   assertThat(responseObj.equals(matchesJsonSchemaInClasspath()));
		  
		 // ValidatableResponse rt = (ValidatableResponse) response.then().extract();
		// assertThat(rt,matchesJsonSchemaInClasspath("abc.json"));
	   } 

	  // @Step
	//   public void iShouldFindCountry(String country){
	//       response.then().body("RestResponse.title", is(country));
	 //  }
	   
	   //TODO need to update the code
/*	   public void validateScehma(String inputFile,String referenceSchema) throws ProcessingException, IOException {
		   
		    File schemaFile = new File("/Users/XYZ/schema.json");
		    File responsejsonFile = new File("/Users/XYZ/data.json");
		    	
		    if (ValidationUtils.isJsonValid(schemaFile, responsejsonFile)){
		    	System.out.println("Valid!");
		    }else{
		    	System.out.println("NOT valid!");
		    }

	   }
*/	   
	   


	   
	   	@Step
	    	public void addResponseAttributestoTestData(org.json.JSONArray extractlist,Response response) {
	        LinkedList<String> extractObj = new LinkedList<String>();
	        JsonPath jp = response.jsonPath();

	         // System.out.println("-----------hello");
			for(int i = 0; i<extractlist.length();i++) {
				System.out.println("input "+extractlist.get(i).toString());
				extractObj.add(extractlist.get(i).toString());
			}
	        for (String reqobj : extractObj) {
	            switch (reqobj) {
	            
	            	case "ih_oms_id" :
             	   			String ih_oms_id = jp.get("data.user.ih_oms_id").toString();
             	   			jsonTestDataObject.put("ih_oms_id", ih_oms_id);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
             	   			testdata.setIh_oms_id(ih_oms_id);//update
             	   			break;
                    case "org_id":
	            	   		String org_id = jp.get("data.user.memberships[0].org_id").toString();
	            	   		jsonTestDataObject.put("org_id", org_id);
	            	   		testdata.setOrg_id(org_id);
	            	   		break;
	                case "org_name":
	                		String org_name=jp.get("data.user.memberships[0].name").toString();
	                		jsonTestDataObject.put("org_name", org_name);
	                		testdata.setOrg_name(org_name);
	                		break;
	                case "client":
	                		String client = jp.get("data.headers.client").toString();
	                	    jsonTestDataObject.put("client", client);
	                	    testdata.setClient(client);
	            	    	break;
	                case "access-token":
	                    	String access_token=jp.get("data.headers.access-token").toString();
	                    	jsonTestDataObject.put("access_token", access_token);
	                    	testdata.setAccess_token(access_token);
		    				break;
	                case "usr_id":
	                		String usr_id = jp.get("data.user.id").toString();
	                	    jsonTestDataObject.put("usr_id", usr_id);
	                	    testdata.setUsr_id(usr_id);
	    					break;     
	                case "uid":
	                		String uid=jp.get("data.headers.uid").toString();
	                	    jsonTestDataObject.put("uid", uid);            
	                	    testdata.setUid(uid);
	                	    break;
	                case "ad_uid":
                			String ad_uid=jp.get("data.headers.uid").toString();
                			jsonTestDataObject.put("ad_uid", ad_uid);            
                			testdata.setAd_uid(ad_uid);
                			break;   
                	    
	                case "ad_client":
                			String ad_client = jp.get("data.headers.client").toString();
                			jsonTestDataObject.put("ad_client", ad_client);
                			testdata.setAd_client(ad_client);
                			break;
            	    	
	                case "adaccesstoken":
                    		String adaccesstoken=jp.get("data.headers.access-token").toString();
                    		jsonTestDataObject.put("adaccesstoken", adaccesstoken);
                    		testdata.setAdaccesstoken(adaccesstoken);
                    		break;
	                case "req_id":
	                		String  req_id = jp.get("data.client_requirement._id").toString();
	                		jsonTestDataObject.put("req_id", req_id);
	                		testdata.setReq_id(req_id);
	                		break;
	                case "req_status":
	                		String req_status = jp.get("data.client_requirement._status").toString();
	                		jsonTestDataObject.put("req_status", req_status);
	                		testdata.setReq_status(req_status);
	                		break;
	                case "req_vertical":
	                		String req_vertical = jp.get("data.client_requirement.vertical").toString();
	                		jsonTestDataObject.put("req_vertical", req_vertical);
	                		testdata.setReq_vertical(req_vertical);
	                		break;
	                		
	                case "billingproject_id":
	                		String billing_project_id = jp.get("data.project._id").toString();
	                		System.out.println(":::::::::::"+billing_project_id);
	                    	jsonTestDataObject.put("billingproject_id", billing_project_id);
	                    	testdata.setBillingproject_id(billing_project_id);
	                    	break;
	                case "executionproject_id":
	                		String execution_project_id = jp.get("data.project._id").toString();
		                	System.out.println("execution_project_id:::::::::::"+execution_project_id);
		                	jsonTestDataObject.put("executionproject_id", execution_project_id);
		                	testdata.setExecutionproject_id(execution_project_id);
		                	//   System.out.println("Created Execution project:\t"+execution_project_id);
		                	break;
	                case "worklistings_id":
	                	try {
                			String worklistings_id = jp.get("worklistings[0].id").toString();
                			jsonTestDataObject.put("worklistings_id", worklistings_id);
                			testdata.setWorklistings_id(worklistings_id);
	                	}catch(Exception e) {e.printStackTrace();}
                    break;
	                case "worklistings_name":
            				String worklistings_name = jp.get("worklistings[0].name").toString();
            				jsonTestDataObject.put("worklistings_name", worklistings_name);
            				testdata.setWorklistings_name(worklistings_name);
            			break;
	                case "listing_type":
            				String listing_type = jp.get("worklistings[0].listing_type").toString();
            				jsonTestDataObject.put("listing_type", listing_type);
            				testdata.setWorklistings_name(listing_type);
            				break;
	                case "execution_type":
            				String execution_type = jp.get("worklistings[0].execution_type").toString();
            				jsonTestDataObject.put("execution_type", execution_type);
            				testdata.setWorklistings_listing_type(execution_type);
            				break;
	                case "project_execution_source_id":
	                		try {
            				String project_execution_source_id = jp.get("worklistings[0].project_execution_source_id").toString();
            				System.out.println("Check for Null "+ project_execution_source_id);
            				jsonTestDataObject.put("project_execution_source_id", project_execution_source_id);
            				testdata.setProject_execution_source_id(project_execution_source_id);
	                		}catch(Exception e) {
	                			System.out.println("------------------project_execution_source_id is null");
	                		}
            				break;
	                case "listingsrc_execution_project_id":
    						String listingsrc_execution_project_id = jp.get("worklistings[0].execution_project_id").toString();
    						jsonTestDataObject.put("listingsrc_execution_project_id", listingsrc_execution_project_id);
    						testdata.setListingsrc_execution_project_id(listingsrc_execution_project_id);
    						break;
	                case "ep_Executive_execution_sources_id": //The roles which we create a EP, generally it will be executive and po
							String ep_Executive_execution_sources_id = jp.get("data.project.execution_sources[0]._id").toString();
							jsonTestDataObject.put("ep_Executive_execution_sources_id", ep_Executive_execution_sources_id);
							testdata.setEp_Executive_execution_sources_id(ep_Executive_execution_sources_id);
							break;
	                case "project_role_id":
	                		String project_role_id = jp.get("data.project.execution_sources[0].project_role_id").toString();
	                		jsonTestDataObject.put("project_wf_role_id", project_role_id);
	                		testdata.setEp_wf_project_role_id(project_role_id);
					
	                case "ep_projectowner_execution_sources_id": //The roles which we create a EP, generally it will be executive and po
							String ep_projectowner_execution_sources_id = jp.get("data.project.execution_sources[0]._id").toString();
							jsonTestDataObject.put("ep_projectowner_execution_sources_id", ep_projectowner_execution_sources_id);
							testdata.setEp_projectowner_execution_sources_id(ep_projectowner_execution_sources_id);
							break;
	                case "getListing_execution_project_id": 
	                		System.out.println("--------Fetching listing which is active from the harcoded project in the WOS - Search listing ");
	        				String getListing_execution_project_id = jp.get("execution_project_id").toString();
							jsonTestDataObject.put("listingsrc_execution_project_id", getListing_execution_project_id);
							testdata.setListingsrc_execution_project_id(getListing_execution_project_id);
	                		break;
	                case "newly_created_listing_id" :
	                		String newlycreated_listing_id = jp.get("id").toString();
	                		jsonTestDataObject.put("newly_created_listing_id", newlycreated_listing_id);
	                		testdata.setNewly_created_listing_id(newlycreated_listing_id);
	                		break;
	                case "loginuserid":
	                	   String loginuserid = jp.get("data.user.id").toString();
	                	   jsonTestDataObject.put("loginuserid", loginuserid);
	                	   testdata.setLoginuserid(loginuserid);
	                	   break;
	              
	                case "supply_id" :
	                	   String supply_id = jp.get("data.user.supply_id").toString();
	                	   jsonTestDataObject.put("supply_id", supply_id);
	                	   testdata.setSupply_id(supply_id);//update
	                	   break;
	                      	//add execution_id. //search with respect to member and get th execution.
	                case "application_id":
	                	   String application_id = jp.get("id").toString();
	                	   jsonTestDataObject.put("application_id", application_id);
	                	   testdata.setApplication_id(application_id);
	                	   break;
	              	}
	        }
			System.out.println("--------------Update test data:\t "+ jsonTestDataObject);
		}
	   
	   	
	   	public void printReferenceUrls() {
	   		try {
			   		String projExecution_id = jsonTestDataObject.getString("executionproject_id");
			   		String listing_id = jsonTestDataObject.getString("newly_created_listing_id");
			   		String listingurl ="https://listings.awigntest.com/projects/listingsrc_execution_project_id/listings/newly_created_listing_id/edit?category=listingDetails&tab=basicDetails";
			   		String Bpulr ="https://projects.awigntest.com/projects/billing/5fc0a7c76b70160043b46c88";
			   		String Epulr ="https://projects.awigntest.com/projects/execution/5fc0b9226b7016002bb46c86\n" ;
			   		listingurl = listingurl.replace("listingsrc_execution_project_id", projExecution_id);
			   		listingurl = listingurl.replace("newly_created_listing_id", listing_id);
			   		System.out.println("Requirement name \t :");
			   		System.out.println("EP Project name \t :");
			   		System.out.println("Refer Listing URL : \t "+listingurl);
	   		}catch(Exception e) {}
	   	}
	  
	   	public void extractjson(Response response) {

			JSONObject apiObject = new JSONObject(response.getBody().asString());
			JSONArray serviceApi = new JSONArray(apiObject.get("worklistings").toString());
			int listing_id = 0;
			System.out.println("Number of listing in given project : \t"+ serviceApi.length());
			for (int i = 0; i < serviceApi.length(); i++) {
				String configuration_status = serviceApi.getJSONObject(i).getString("configuration_status").toString();
				String url_status = serviceApi.getJSONObject(i).getString("url_status");
				if(configuration_status.matches("approved") && url_status.matches("active") ){
					listing_id = serviceApi.getJSONObject(i).getInt("id");
					jsonTestDataObject.put("clone_listing_id", listing_id);
					testdata.setclone_listing_id(listing_id);
					System.out.println("Listing found for the project:\t"+listing_id);
					break;
					}else {
						System.out.println("No listing found with Approved and Active status");
					}
				}
			}
	   	
	   public void extractExecutionofMember(Response response) {
		   JSONObject jo = new JSONObject(response.getBody().asString());
		   JSONObject execution = new JSONObject(jo.get("data").toString());
		   String searchEPProject_id =null;
		   String testdataEPProject_id = null;
		   
		   try {
			   
			   System.out.println("oooooooooooooooooooooooooooooooooooooooooooo");
			   testdataEPProject_id =  jsonTestDataObject.getString("executionproject_id");
			   System.out.println("oooooooooooooooooooooooooooooooooooooooooooo"+testdataEPProject_id);

	/*		 //  getExecutions(executions,testdataEPProject_id);
		   }catch(Exception e) {e.printStackTrace();}
		
		  if(!(searchEPProject_id==null)&&(searchEPProject_id.length()>0)) { //if user passed  executionid/
		  System.out.println("=------------------No Execution id given by user");
		  searchEPProject_id = searchEPProject_id;
		//  getExecutions(executions,searchEPProject_id); 

		  }else if (!(testdataEPProject_id==null)&&((testdataEPProject_id.length()>0))){ //pass  the testdata execution_id. 
			  System.out. println("=------------------Execution id present in test data factory");*/
			  
			
					 JSONArray serviceApi = new JSONArray(execution.get("executions").toString());
					 for (int j = 0; j < serviceApi.length(); j++) { 
					 JSONObject fields = serviceApi.getJSONObject(j); 
				 		if(fields.getString("project_id").equals(testdataEPProject_id)){
				 		System.out.println("Project name:\t "+ fields.getString("project_name") +"\t Proj id \t"+ fields.getString("project_id") +"\t Exe id:: \t"+fields.getString("_id")); 
				 		jsonTestDataObject.put("WFProj_execution_id", fields.getString("_id"));
				 		testdata.setWFProj_execution_id(fields.getString("_id"));
			 			System.out.println("--------------Update test data:\t "+ jsonTestDataObject);
				 		return;
				 		 }   
				       }
		           }
	   catch(Exception e) {}  
			  
		/*	  
			  
		//  getExecutions(executions,testdataEPProject_id); 
		  }else { 
			  System.out.println("=------------------No Execution id present in Test data factory and input" ); 
			  
			  
		//  getExecutions(executions,searchEPProject_id);//return the recent   execution. }
		 
	   }
	   */
	   }
	/*
	 * public void getExecutions(JSONObject execution,String epproject_id) { if
	 * (epproject_id==null) { JSONArray serviceApi = new
	 * JSONArray(execution.get("executions").toString()); for (int j = 0; j <
	 * serviceApi.length(); j++) { JSONObject fields = serviceApi.getJSONObject(j);
	 * System.out.println("Project name:\t "+ fields.getString("project_name")
	 * +"\t Proj id \t"+ fields.getString("project_id")
	 * +"\t Exe id:: \t"+fields.getString("_id"));
	 * jsonTestDataObject.put("WFProj_execution_id", fields.getString("_id"));
	 * testdata.setWFProj_execution_id(fields.getString("_id"));
	 * testdata.setEp_name(fields.getString("project_name")); //Setting ep
	 * project_name
	 * jsonTestDataObject.put("ep_name",fields.getString("project_name"));
	 * testdata.setExecutionproject_id(fields.getString("project_id")); //set
	 * execution project_id jsonTestDataObject.put("executionproject_id",
	 * fields.getString("project_id"));
	 * System.out.println(" --------------Update test data:\t "+
	 * jsonTestDataObject); return; } } else{ try { JSONArray serviceApi = new
	 * JSONArray(execution.get("executions").toString()); for (int j = 0; j <
	 * serviceApi.length(); j++) { JSONObject fields = serviceApi.getJSONObject(j);
	 * if(fields.getString("project_id").equals(epproject_id)){
	 * System.out.println("Project name:\t "+ fields.getString("project_name")
	 * +"\t Proj id \t"+ fields.getString("project_id")
	 * +"\t Exe id:: \t"+fields.getString("_id"));
	 * jsonTestDataObject.put("WFProj_execution_id", fields.getString("_id"));
	 * testdata.setWFProj_execution_id(fields.getString("_id"));
	 * System.out.println("--------------Update test data:\t "+ jsonTestDataObject);
	 * return; } } } catch(Exception e) {} } }
	 */
	   
	   public String getihomsid(Response response) {
		   JsonPath jp = response.jsonPath();
		   return jp.get("data.user.ih_oms_id").toString();
	   }

	}
