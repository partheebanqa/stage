package com.awign.tests.wosPlatform;
import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.awign.dataprovider.BaseController;
import com.awign.test.corePlatform.CorePlatformTest;
import com.awign.tests.authplatform.authPlatformTest;
import com.awign.tests.newcasplatform.NewCasPlatformTest;
import com.awign.tests.omsplatform.IhomsPlatformTest;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.annotations.WithTags;
import steps.VerificationSteps;

@RunWith(SerenityRunner.class)
public class ProjectListingFlow extends BaseController{
	
	
	 @Steps
	 public VerificationSteps verifyResponse;
	 public static BaseController basecontroller = new BaseController();	 
	 //PropertyUtil prop =new PropertyUtil();
	// public static JsonUtil jsonUtil = new JsonUtil();

	
	@BeforeClass
		public static void init() {	
		basecontroller.setBaseData();
	
	}

	@Title("Search the available Listing to clone")
	@WithTags({@WithTag("current")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test001() throws IOException {
		new WOSPlatformTest().searchListings(verifyResponse);

	}
	
	@Title("Get the Executive role source id of an EP")
	@WithTags({@WithTag("list")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test002() throws IOException {
		new IhomsPlatformTest().getProject(verifyResponse);

	}
	
	@Title("Create a listing for the newly created EP")
	@WithTags({@WithTag("list")})
	@WithTagValuesOf({"level:Feature", "feature:wos", "story:Listing"})
	@Test()
	public void test003() throws IOException {
		new WOSPlatformTest().addListing(verifyResponse);

	}

	

}
