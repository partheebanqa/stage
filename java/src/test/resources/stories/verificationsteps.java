package src.test.resources.stories;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.Matchers.is;



public class verificationsteps {
	   private String ISO_CODE_SEARCH = "https://ih-oms-api.awign.com/clients/api/v1/requirements/5e4b83fc0610df2ec9cb47de";
	   private Response response;
	   

	   @Step
	   public void searchCountryByCode(String code){
	       response = SerenityRest.when().get(ISO_CODE_SEARCH + code);
	   }

	   @Step
	   public void searchIsExecutedSuccesfully(){
	       response.then().statusCode(200);
	   }

	   @Step
	   public void iShouldFindCountry(String country){
	       response.then().body("RestResponse.result.name", is(country));
	   }
	}
