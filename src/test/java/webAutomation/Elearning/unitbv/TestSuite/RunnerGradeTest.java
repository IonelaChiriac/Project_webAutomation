package webAutomation.Elearning.unitbv.TestSuite;

import java.io.IOException;

import org.testng.annotations.Test;

import webAutomation.Elearning.unitbv.Grade;
import webAutomation.Elearning.unitbv.LogOutPage;
import webAutomation.Elearning.unitbv.LoginPage;
import webAutomation.Elearning.unitbv.Base.Base_class;

public class RunnerGradeTest extends Base_class {
	
	
	@Test
	public void runner_grade() throws InterruptedException, IOException {
		test = extent.createTest("VerifyGradeTest","Grade Test");

		LoginPage log = new LoginPage(driver); //create an object
		String userid = prop.getProperty("id"); //prop will take value of id from config.properties file
		String Password = prop.getProperty("password"); //prop will take value of password from config.properties file
		log.login(userid,Password); //call login methold from LoginPage, passed two Parameter.
		
		Grade gradeObj = new Grade(driver);
		gradeObj.gradeTest();
		Thread.sleep(6000);

		LogOutPage logOut = new LogOutPage(driver);
		//LogOutPage Class as an object, what is object - logOut
		
		logOut.log_out();
	}

}
