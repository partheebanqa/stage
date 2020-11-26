package com.awign.tests.authplatform;


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

@RunWith(SerenityRunner.class)
//@FixMethodOrder(MethodSorters.DEFAULT)
//@CucumberOptions( plugin = { “usage” }) //it will record time taken for each step definition. 
//@story(Application.AppNavigation.NavigationMenu.class)

@WithTagValuesOf({"level:clientRegister", "feature:Client", "story:Client onboard"})
public class CorePlatformRegressionTest extends BaseController{
	

	 @Steps
	 public VerificationSteps verifyResponse;
	 public static BaseController basecontroller = new BaseController();	 
	 //PropertyUtil prop =new PropertyUtil();
	// public static JsonUtil jsonUtil = new JsonUtil();

	
	@BeforeClass
		public static void init() {	
		basecontroller.setBaseData();
	
	}
	
	
	
	@Title("User: Verify the email is Send to the user")
	@WithTags({@WithTag("core")})
	@WithTagValuesOf({"level:Feature", "feature:Auth", "story:UserAction"})
	@Test()
	public void test001() throws IOException {
		new CorePlatformTest().verifySendSms(verifyResponse);
	}
	
	
	@WithTags({@WithTag("core")})
	@Title("User Verify whether , we are able to send email")
	@WithTagValuesOf({"level:Feature", "feature:Auth", "story:UserAction"})
	@Test()
	public void test002() throws IOException {
		new CorePlatformTest().verifySendEmail( verifyResponse);
	}

	@WithTags({@WithTag("core")})
	@WithTagValuesOf({"level:Feature", "feature:NewCas", "story:UserAction"})
	@Test
	@Title("User: Verify whether we are able to send notification to user")
	public void test003() throws IOException {
		new CorePlatformTest().verifyPushNotification(verifyResponse);
	}
	



	
}
