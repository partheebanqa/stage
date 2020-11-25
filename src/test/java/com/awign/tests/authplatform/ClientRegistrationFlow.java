package com.awign.tests.authplatform;


import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.awign.dataprovider.BaseController;
import com.awign.test.corePlatform.CorePlatformTest;
import com.awign.tests.newcasplatform.NewCasPlatformTest;
import com.awign.tests.omsplatform.IhomsPlatformTest;
import com.awign.tests.wosPlatform.WOSPlatformTest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.annotations.WithTags;
import steps.VerificationSteps;

@RunWith(SerenityRunner.class)
//@FixMethodOrder(MethodSorters.DEFAULT)
//@CucumberOptions( plugin = { “usage” }) //it will record time taken for each step definition. 
//@story(Application.AppNavigation.NavigationMenu.class)

@WithTagValuesOf({"level:clientRegister", "feature:Client", "story:Client onboard"})
public class ClientRegistrationFlow extends BaseController{
	

	 @Steps
	 public VerificationSteps verifyResponse;
	 public static BaseController basecontroller = new BaseController();	 
	 //PropertyUtil prop =new PropertyUtil();
	// public static JsonUtil jsonUtil = new JsonUtil();

	
	@BeforeClass
		public static void init() {	
		basecontroller.setBaseData();
	
	}
	
	
	
	@Title("Guest user: Verify the email is already registered with Awign")
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "feature:Auth", "story:UserAction"})
	@Test()
	public void test001() throws IOException {
		new authPlatformTest().verifyEmailRegistered(verifyResponse);

	}
	
	
	@WithTags({@WithTag("one")})
	@Title("Guest user Verify whether the Mobile number is already registered with Awign")
	@WithTagValuesOf({"level:Feature", "feature:Auth", "story:UserAction"})
	@Test()
	public void test002() throws IOException {
		new authPlatformTest().verifyMobileNumberRegistered( verifyResponse);
	}

	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "feature:NewCas", "story:UserAction"})
	@Test
	@Title("Guest user: Verify whether new client is able to register with Awign")
	public void test003() throws IOException {
		new NewCasPlatformTest().verifyNewClientSignup(verifyResponse);
	}
	
	
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "feature:oms", "story:ManageRequirement"})
	@Test
	@Title("Verify we are able to add requirement to the newly registered client")
	public void test004() throws IOException {
		new IhomsPlatformTest().addRequirement(verifyResponse);
	}

	@WithTagValuesOf({"level:Feature", "feature:oms", "story:ManageRequirement"})
	@Test
	@Title("Verify whether we are able to search the Created requirement")
	public void test005() throws IOException {
		new IhomsPlatformTest().searchRequirement(verifyResponse);

	}

	@WithTagValuesOf({"level:Feature", "feature:oms", "story:ManageProject"})
	@Test
	@Title("Verify whether we are able to search the newly created project")
	public void test006() throws IOException {
		new IhomsPlatformTest().searchProject(verifyResponse);

	}
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "feature:oms", "story:ManageProject"})
	@Test
	@Title("Create Billing project for the requirement")
	public void test007() throws IOException {
		new IhomsPlatformTest().createBillingProject(verifyResponse);

	}

	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "feature:oms", "story:ManageProject"})
	@Test
	@Title("Create Execution project for the requirement")
	public void test008() throws IOException {
		new IhomsPlatformTest().createExecutionProject(verifyResponse);

	}

	
	
	@Title("Search the available Listing to clone")
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test009() throws IOException {
		new WOSPlatformTest().searchListings(verifyResponse);

	}
	
	@Title("Get the Executive role source id of an EP")
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test010() throws IOException {
		new IhomsPlatformTest().getProject(verifyResponse);

	}
	
	@Title("Create a listing for the newly created EP")
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test011() throws IOException {
		new WOSPlatformTest().addListing(verifyResponse);

	}

	
	
	
	@WithTagValuesOf({"level:Feature", "feature:core", "story:ManageCommunications"})
	@Test
	@Title("Verify whether we are able to send sms to member")
	public void test012() throws IOException {
		new CorePlatformTest().verifySendSms(verifyResponse);
	}
	
	@WithTagValuesOf({"level:Feature", "feature:core", "story:ManageCommunications"})
	@Test
	@Title("Verify whether we are able to send email to registred member")
	public void test013() throws IOException {
		new CorePlatformTest().verifySendEmail(verifyResponse);

	}
	
	
	@WithTagValuesOf({"level:Feature", "feature:core", "story:ManageCommunications"})
	@Test
	@Title("Verify whether we are able to send push notification to registred member")
	public void test014() throws IOException {
		new CorePlatformTest().verifyPushNotification(verifyResponse);
  
	}
	
	@WithTagValuesOf({"level:Feature", "feature:NewCas", "story:UserAction"})
	@Title("Verify whether user is able to sign in")
	@Test
	public void test015() throws IOException {
	new NewCasPlatformTest().verifyUserSignin(verifyResponse);
	
	}
	
	
	/*@WithTagValuesOf({"level:Feature", "feature:NewCas", "story:UserAction"})
	@Title("Client Validate ")
	@Test
	public void test16() throws IOException {
	new NewCasPlatformTest().clientValidate(verifyResponse);
	
	}*/

	@WithTagValuesOf({"level:Feature", "feature:NewCas", "story:UserAction"})
	@Title("Add Role to a user ")
	@Test
	public void test17() throws IOException {
	new NewCasPlatformTest().addUserARole(verifyResponse);
	
	}

	
	@WithTagValuesOf({"level:Feature", "feature:NewCas", "story:UserAction"})
	@Title("Verification of logout")
	@Test
	public void test18() throws IOException {
	new NewCasPlatformTest().userLogout(verifyResponse);
	
	}
	
	
	@Title("Search the available Listing to clone")
	@WithTags({@WithTag("sample")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test019() throws IOException {
		new WOSPlatformTest().searchListings(verifyResponse);

	}
	
	@Title("Search the available Listing to clone")
	@WithTags({@WithTag("login")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test020() throws IOException {
		new authPlatformTest().verifyUserLogin(verifyResponse);
	}
	
	
}
