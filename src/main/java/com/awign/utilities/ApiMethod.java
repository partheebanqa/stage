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
        
        System.out.println("Api spec\t"+requestSpec.toString());
        Response response = null;
        try {
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
        }catch(Exception e) {e.printStackTrace();}
      JSONObject responseBody = null;      
      responseBody = new JSONObject(response.body().asString());
        return response;
    }
    
  

    
}