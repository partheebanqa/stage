package com.awign.tests;


import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.awign.dataprovider.BaseController;
import com.awign.test.corePlatform.CorePlatformTest;
import com.awign.tests.authplatform.authPlatformTest;
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

/** 
* @author  Partheeban.moorthy@awign.com
* @version 1.0 
*/


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
	
	@Title("Search the available Listing to clone")
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test011() throws IOException {
		new WOSPlatformTest().searchListings(verifyResponse);

	}
	
	@Title("Create a listing for the newly created EP")
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test012() throws IOException {
		new WOSPlatformTest().partialCloneListing(verifyResponse);

	}

	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "wos", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: Update Basic details")
	public void test013() throws IOException {
		new WOSPlatformTest().updateListingBasicDetails(verifyResponse);
	}
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "wos", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: Update Location details")
	public void test014() throws IOException {
		new WOSPlatformTest().updateListingLocationDetails(verifyResponse);
	}
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "wos", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: Update Earnings details")
	public void test015() throws IOException {
		new WOSPlatformTest().updateListingEarningsDetails(verifyResponse);
	}
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "wos", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: Update Description details")
	public void test016() throws IOException {
		new WOSPlatformTest().updateListingDescriptionDetails(verifyResponse);
	}
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "wos", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: Review Listing Basic details")
	public void test017() throws IOException {
		new WOSPlatformTest().reviewListingBasicDetails(verifyResponse);
	}
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "wos", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: Review Listing Location details")
	public void test018() throws IOException {
		new WOSPlatformTest().reviewListingLocationDetails(verifyResponse);
	}
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "wos", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: Review Listing Earning details")
	public void test019() throws IOException {
		new WOSPlatformTest().reviewListingEarningsDetails(verifyResponse);
	}
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "wos", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: Review Listing Description details")
	public void test020() throws IOException {
		new WOSPlatformTest().reviewListingDescriptionDetails(verifyResponse);
	}
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "wos", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: Listing Application Configuration")
	public void test021() throws IOException {
		new WOSPlatformTest().ListingApplicationConfiguration(verifyResponse);
	}
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "wos", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: Listing Application Configuration")
	public void test022() throws IOException {
		new WOSPlatformTest().listingApplicationsQuestionsConfigure(verifyResponse);
	}
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "wos", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: Listing Application Configuration")
	public void test023() throws IOException {
		new WOSPlatformTest().reviewApplicationsQuestionsDetails(verifyResponse);
	}
	
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "oms", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: Listing Application Configuration")
	public void test024() throws IOException {
		new IhomsPlatformTest().getEPProject(verifyResponse);
	}
	

	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "oms", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: Offer letter add execution sourceid to the project")
	public void test025() throws IOException {
		new WOSPlatformTest().ListingAddExecutionSource_id(verifyResponse);
	}
	
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "wos", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: Listing Application Configuration")
	public void test026() throws IOException {
		new IhomsPlatformTest().setOfferLetterforES(verifyResponse);
	}
	
	
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "wos", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: Get execution source of Executive")
	public void test027() throws IOException {
		new WOSPlatformTest().markListingConfigStatus(verifyResponse);
	}
	

	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "wos", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: markListingUrlStatus")
	public void test028() throws IOException {
		new WOSPlatformTest().markListingUrlStatus(verifyResponse);
	}
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "wos", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: markListingPublishingStatus")
	public void test029() throws IOException {
		new WOSPlatformTest().markListingPublishingStatus(verifyResponse);
	}
	
	@WithTags({@WithTag("one")})
	@WithTagValuesOf({"level:Feature", "wos", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: publishListing")
	public void test030() throws IOException {
		new WOSPlatformTest().publishListing(verifyResponse);
	}
	
	
	
	
	@WithTags({@WithTag("core")})
	@WithTagValuesOf({"level:Feature", "core", "story:ListingCreation"})
	@Test
	@Title("Listing Creation: Update Basic details")
	public void test031() throws IOException {
		new CorePlatformTest().verifySendSms(verifyResponse);
	}
	
	@WithTags({@WithTag("core")})
	@WithTagValuesOf({"level:Feature", "feature:core", "story:ManageCommunications"})
	@Test
	@Title("Verify whether we are able to send email to registred member")
	public void test032() throws IOException {
		new CorePlatformTest().verifySendEmail(verifyResponse);

	}
	
	@WithTags({@WithTag("core")})
	@WithTagValuesOf({"level:Feature", "feature:core", "story:ManageCommunications"})
	@Test
	@Title("Verify whether we are able to send push notification to registred member")
	public void test033() throws IOException {
		new CorePlatformTest().verifyPushNotification(verifyResponse);
  
	}
	
	@WithTagValuesOf({"level:Feature", "feature:NewCas", "story:UserAction"})
	@Title("Verify whether user is able to sign in")
	@Test
	public void test034() throws IOException {
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
	public void test35() throws IOException {
	new NewCasPlatformTest().addUserARole(verifyResponse);
	
	}

	
	@WithTagValuesOf({"level:Feature", "feature:NewCas", "story:UserAction"})
	@Title("Verification of logout")
	@Test
	public void test36() throws IOException {
	new NewCasPlatformTest().userLogout(verifyResponse);
	
	}
	
	
	@Title("Search the available Listing to clone")
	@WithTags({@WithTag("getlisting")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test037() throws IOException {
		new WOSPlatformTest().searchListings(verifyResponse);

	}
	
	@Title("Search the available Listing to clone")
	@WithTags({@WithTag("testlogin")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test038() throws IOException {
		new authPlatformTest().verifyUserLogin(verifyResponse);
		
		
	}
	
	
	@Title("Search the available Listing to clone")
	@WithTags({@WithTag("se")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test041() throws IOException {
		new IhomsPlatformTest().offExecutionMemberSearch(verifyResponse);
	}
	
	
	@Title("Workforce search for a listing")
	@WithTags({@WithTag("se")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test039() throws IOException {
		new WOSPlatformTest().officeApplicationSearch(verifyResponse);
	}
	
	
	@Title("Workforce apply for a listing")
	@WithTags({@WithTag("se")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test040() throws IOException {
		new WOSPlatformTest().workforceApplyForAListing(verifyResponse);
	}
	
	@Title("Search the available Listing to clone")
	@WithTags({@WithTag("se")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test042() throws IOException {
		new IhomsPlatformTest().acceptOfferLetter(verifyResponse);
	}
	
	@Title("Generate testdata")
	@WithTags({@WithTag("data")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test043() throws IOException {
		//	new authPlatformTest().UserSignup(verifyResponse);

	}
	
	@Title("Generate execution")
	@WithTags({@WithTag("dyexe")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test044() throws IOException {
		int executioncount= 1;
		String EP_Project_id="";
		String EP_WF_Execution_source_id="";
		new IhomsPlatformTest().createDynamicExecutions(verifyResponse,executioncount,EP_Project_id,EP_WF_Execution_source_id);

	}
	
	@Title("Generate execution")
	@WithTags({@WithTag("static")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test045() throws IOException {
		int executioncount= 5000;
		String EP_Project_id="";
		String EP_WF_Execution_source_id="";
		new IhomsPlatformTest().createStaticExecutions(verifyResponse,executioncount,EP_Project_id,EP_WF_Execution_source_id);

	}
}
