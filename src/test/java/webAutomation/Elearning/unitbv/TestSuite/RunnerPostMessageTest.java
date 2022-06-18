package webAutomation.Elearning.unitbv.TestSuite;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import webAutomation.Elearning.unitbv.LogOutPage;
import webAutomation.Elearning.unitbv.LoginPage;
import webAutomation.Elearning.unitbv.PostAnnouncementPage;
import webAutomation.Elearning.unitbv.Base.Base_class;
import webAutomation.Elearning.unitbv.Base.Excel_Base;

public class RunnerPostMessageTest extends Base_class{
	
	Excel_Base dataExcel3;
	@DataProvider(name = "testdataPost")
	public Object[][] getData() throws IOException {
	dataExcel3 = new Excel_Base();
	Object data[][] = dataExcel3.testdata("SearchBookPost","input");
	return data;
	}
	
	@Test(dataProvider = "testdataPost")
	public void runner_postAnnouncement(String user, String password,String postMsg,String contentMsg) throws InterruptedException, IOException {
		test = extent.createTest("VerifyPostMessage","Post Annoucement Test");

		LoginPage log = new LoginPage(driver); //create an object
		String userid = prop.getProperty("id"); //prop will take value of id from config.properties file
		String Password = prop.getProperty("password"); //prop will take value of password from config.properties file
		log.login(user,password); //call login methold from LoginPage, passed two Parameter.
		
		PostAnnouncementPage postObj = new PostAnnouncementPage(driver);
		postObj.PostAnnouncement(postMsg,contentMsg);
		Thread.sleep(6000);

		LogOutPage logOut = new LogOutPage(driver); //LogOutPage Class as an object -> logOut		
		logOut.log_out();
	}

}
