package com.awign.utilities;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiMethod {

    public Response httpMethod( JSONObject requestObj) {
        String httpMethod = requestObj.getString("httpMethod");
        JSONArray apiHeader = requestObj.getJSONArray("apiHeader");
        String requestBody = requestObj.getJSONObject("requestBody").toString();
        String serviceUrl = null;
        serviceUrl = requestObj.getString("uri");   
        
        RequestSpecBuilder builder = new RequestSpecBuilder();
        if (httpMethod.equalsIgnoreCase("POST") || httpMethod.equalsIgnoreCase("PUT")) {
            builder.setBody(requestBody);
        }
        RequestSpecification requestSpec = builder.build();
        new ApiHeader().setHeaders( apiHeader, builder);
        RestAssured.useRelaxedHTTPSValidation();
        Response response = null;
        switch (httpMethod) {
            case "POST":
           	       response = SerenityRest.given().spec(requestSpec).when().post(serviceUrl);
                    break;
            case "PUT":
        	       		response = SerenityRest.given().spec(requestSpec).when().put(serviceUrl);
        	       		break;
            case "GET":
       	       		response = SerenityRest.given().spec(requestSpec).when().get(serviceUrl);
       	       		break;
            case "DELETE":
        	       		response = SerenityRest.given().spec(requestSpec).when().delete(serviceUrl);	
        	       		break;
        }
      JSONObject responseBody = null;      
    //  Assert.assertEquals(response.getStatusCode(), requestObj.getInt("statusCode"),
     //       "API: " + serviceUrl + " " + response.jsonPath().getString("errorMessage")
      //               + " " + response.jsonPath().getString("errorCode"));
       responseBody = new JSONObject(response.body().asString());
        return response;
    }
    
   
   /* public Response httpMethod( JSONObject requestObj ,String param) {
        String httpMethod = requestObj.getString("httpMethod");
        JSONArray apiHeader = requestObj.getJSONArray("apiHeader");
        String requestBody = requestObj.getJSONObject("requestBody").toString();
        String serviceUrl = null;
        serviceUrl = requestObj.getString("uri");   
        
        RequestSpecBuilder builder = new RequestSpecBuilder();
        if (httpMethod.equalsIgnoreCase("POST") || httpMethod.equalsIgnoreCase("PUT")) {
            builder.setBody(requestBody);
        }
        RequestSpecification requestSpec = builder.build(); //to do: has to be used for post and put
        new ApiHeader().setHeaders( apiHeader, builder);
        
        RestAssured.useRelaxedHTTPSValidation();
        Response response = null;
        serviceUrl = serviceUrl+param;
        switch (httpMethod) {
            case "POST":
                    response = given().spec(requestSpec).when().post(serviceUrl);
                    break;
            case "PUT":
                    response = given().spec(requestSpec).when().put(serviceUrl);
                break;
            case "GET":
                response = given().spec(requestSpec).when().get(serviceUrl);
                break;
            case "DELETE":
                response = given().spec(requestSpec).when().delete(serviceUrl);
                break;
        }
        JSONObject responseBody = null;      

      //Assert.assertEquals(response.getStatusCode(), requestObj.getInt("statusCode"),
        //     "API: " + serviceUrl + " " + response.jsonPath().getString("errorMessage")
         //          + " " + response.jsonPath().getString("errorCode"));
        responseBody = new JSONObject(response.body().asString());
        return response;
    }
*/    

    
}