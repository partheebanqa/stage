package com.awign.registerclient.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class CleintRegisterSteps {
	
	public Response checkRegisteredMobile(String mobile_number) {
		RestAssured.baseURI="https://auth-api.awigntest.com/central/api/v1/";
		return (Response) RestAssured.given()
		.when().get("/users/".concat("+91").concat(mobile_number)).then().extract();
	}
	
	public Response checkRegisteredEmail(String email_id) {
		RestAssured.baseURI="https://auth-api.awigntest.com/central/api/v1/";
		return (Response) RestAssured.given()
		.when().get("/users/".concat(email_id)).then().extract();
	
	}
	
	public Response userSignup() {
		RestAssured.baseURI="https://auth-api.awigntest.com/client/auth/email/sign_up";
		return (Response) RestAssured.given()
		.when().post().then().extract();
		//{"user":{"name":"testqaproject","email":"partheeban.moorthyone@awign.com","contact":"9742399455"},"organisation":{"name":"testawigncomp","domain":"testawigncomp"}}
	}
	
	public Response createRequirement() {
	RestAssured.baseURI="https://ih-oms-api.awigntest.com/clients/api/v1/requirements/";	
		return (Response) RestAssured.given()
		.when().post().then().extract();
		//{"client_requirement":{"description":"hello world , want to plan for hello world","domain":"testawigncomp","org":125,"vertical":"Due Diligence"}}
		
	}
	
	public Response validateRequirement() {
		RestAssured.baseURI="https://auth-api.awigntest.com/central/auth/validate";	
		return (Response) RestAssured.given()
		.when().get().then().extract();

	}
	
	public Response requirementSearch() {
		RestAssured.baseURI="https://ih-oms-api.awigntest.com/clients/api/v1/requirements/search";
		return (Response) RestAssured.given()
		.when().post().then().extract();
////'{"conditions":[{"domain":{"operator":"eq","value":"testawigncomp"}}],"limit":8,"page":1}

	}
		
	

	
	
	/*@Step
	public ValidatableResponse registerClient() {
		
		return (ValidatableResponse) SerenityRest.rest().given()
				.log()
				.all()
				.when()
				.body("")
				.post().then();
		
	}*/

}
