package webAutomation.Elearning.unitbv.TestSuite;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import webAutomation.Elearning.unitbv.LogOutPage;
import webAutomation.Elearning.unitbv.LoginPage;
import webAutomation.Elearning.unitbv.Base.Base_class;
import webAutomation.Elearning.unitbv.Base.Excel_Base;

public class RunnerLoginTest extends Base_class {
	Excel_Base dataExcel2;

	

	@Test
	public void runner() throws InterruptedException, IOException {
		test = extent.createTest("LoginTest", "Login Work");

		LoginPage log = new LoginPage(driver); // create an object
		//test.pass("<a href="+capturescreenshot("BeforeLogin")+"><img src="+capturescreenshot("BeforeLogin"+".png")+" /></a>");
		test.pass("Before Login Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(capturescreenshotAsBase64("BeforeLogin")).build());
		String userid = prop.getProperty("id"); // prop will take value of id from config.properties file
		String Password = prop.getProperty("password"); // prop will take value of password from config.properties file
		log.login(userid, Password); // call login methold from LoginPage, passed two Parameter.
		test.pass("Student Enter Student email and Password Successfully");
		test.pass("After Login Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(capturescreenshotAsBase64("AfterLogin")).build());
		// test.pass("<a href="+capturescreenshot("AfterLogin")+"><img src="+capturescreenshot("AfterLogin"+".png")+" /></a>");
		Thread.sleep(2000);
		LogOutPage logOut = new LogOutPage(driver);
		// LogOutPage Class as an object -> logOut

		logOut.log_out();
	}

}
