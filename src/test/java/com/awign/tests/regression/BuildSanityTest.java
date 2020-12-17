package com.awign.tests.regression;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

/** 
* @author  Partheeban.moorthy@awign.com
* @version 1.0 
*/


@RunWith(SerenityRunner.class)
public class BuildSanityTest {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";

	}

	@WithTags({@WithTag("eee")})
	@Test
	public void getData() {

		ValidatableResponse vr = RestAssured.given()
		.when().get("/users").then();
		vr.statusCode(200);
	}
	
	@Pending
	@Test
	public void currentsprintfeature1() {
		
	}
	
	@Ignore
	@Test
	public void currentSprintFeature2() {
		
	}
	
	@Test
	public void healthcheck() {
		
		//@FixMethodOrder(MethodSorters.Name_ASCENDING)
		//HashMap<Strint, object> value = response.extract()
		
		//@steps
		//CleintRegisterSteps clientsteps
		//serenity.compromised.on=java.io.FilenotFoundException

		
		
	}
	
	@Title("Let us have the detailed test purpose")
	@Test
	public void CheckDivideByzero() {
		System.out.println("Verify Divide by Zero" + (5/0));
	}

}
