package com.awign.utilities;

import java.util.concurrent.TimeUnit;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;
public class ReusableSpecifications {
	public static RequestSpecBuilder rspec;
	public static ResponseSpecBuilder rspecresponse;

	public static RequestSpecification requestspecification;
	public static ResponseSpecification responsespec;
	
	public static RequestSpecification getGenericRequestSpec() {
	
		rspec = new RequestSpecBuilder();
		rspec.setContentType(ContentType.JSON);
		requestspecification = rspec.build();
		return requestspecification;
	}
	
	public static ResponseSpecification getGenricResponseSpec() {
		rspecresponse = new ResponseSpecBuilder();
		rspecresponse.expectHeader("Content-Type", "application/json; charset=utf-8");
		rspecresponse.expectHeader("Connection", "keep-alive");
		rspecresponse.expectStatusCode(200);
		rspecresponse.expectResponseTime(lessThan(5L) , TimeUnit.SECONDS);
		responsespec = rspecresponse.build();
		return responsespec;
	}

}
