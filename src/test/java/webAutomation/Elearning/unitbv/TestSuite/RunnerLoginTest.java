package webAutomation.Elearning.unitbv.TestSuite;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import webAutomation.Elearning.unitbv.LogOutPage;
import webAutomation.Elearning.unitbv.LoginPage;
import webAutomation.Elearning.unitbv.Base.Base_class;
import webAutomation.Elearning.unitbv.Base.Excel_Base;

public class RunnerLoginTest extends Base_class {
	Excel_Base dataExcel;
	@DataProvider(name = "testdata")
	public Object[][] getData() throws IOException {
	dataExcel = new Excel_Base();
	Object data[][] = dataExcel.testdata("LoginTest","input");
	return data;
	}
	
	@Test(dataProvider = "testdata")
	public void runner(String user, String password) throws InterruptedException, IOException {
		
		LoginPage log = new LoginPage(driver); //create an object
		String userid = prop.getProperty("id"); //prop will take value of id from config.properties file
		String Password = prop.getProperty("password"); //prop will take value of password from config.properties file
		log.login(user,password); //call login methold from LoginPage, passed two Parameter.		
		Thread.sleep(2000);
		LogOutPage logOut = new LogOutPage(driver);
		//LogOutPage Class as an object -> logOut
		
		logOut.log_out();	
	}

}
