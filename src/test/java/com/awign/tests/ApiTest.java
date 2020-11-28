package com.awign.tests;
import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.awign.dataprovider.BaseController;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.annotations.WithTags;
import steps.VerificationSteps;

/** 
* @author  Partheeban.moorthy@awign.com
* @version 1.0 
*/


@RunWith(SerenityRunner.class)
@WithTagValuesOf({"level:clientRegister", "feature:Client", "story:Client onboard"})
public class ApiTest extends BaseController{

	 @Steps
	 public VerificationSteps verifyResponse;
	 public static BaseController basecontroller = new BaseController();	 
		
	 @BeforeClass
	 public static void init() {	
		 basecontroller.setBaseData();
	 }
	
	
	@Title("Services: Core Health Check")
	@WithTags({@WithTag("HealthCheck")})
	@WithTagValuesOf({"level:Services HealthCheck", "feature:core", "story:HealthCheck"})
	@Test()
	public void test001() throws IOException {
		//new CorePlatformTest().verifySendSms(verifyResponse);
	}
	
	
	@Title("Services: Auth Health Check")
	@WithTags({@WithTag("Healthcheck")})
	@WithTagValuesOf({"level:Services HealthCheck", "feature:core", "story:HealthCheck"})
	@Test()
	public void test002() throws IOException {
		//new CorePlatformTest().verifySendEmail( verifyResponse);
	}

	@Title("Services: wos Health Check")
	@WithTags({@WithTag("HealthCheck")})
	@WithTagValuesOf({"level:Services HealthCheck", "feature:core", "story:HealthCheck"})
	@Test
	public void test003() throws IOException {
		//new CorePlatformTest().verifyPushNotification(verifyResponse);
	}
	

	@Title("Services: oms Health Check")
	@WithTags({@WithTag("HealthCheck")})
	@WithTagValuesOf({"level:Services HealthCheck", "feature:core", "story:HealthCheck"})
	@Test
	public void test004() throws IOException {
		//new CorePlatformTest().verifyPushNotification(verifyResponse);
	}
	

	@Title("Services: Apps Health Check")
	@WithTags({@WithTag("HealthCheck")})
	@WithTagValuesOf({"level:Services HealthCheck", "feature:core", "story:HealthCheck"})
	@Test
	public void test005() throws IOException {
		//new CorePlatformTest().verifyPushNotification(verifyResponse);
	}
	
}
