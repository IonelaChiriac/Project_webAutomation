package webAutomation.Elearning.unitbv.TestSuite;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webAutomation.Elearning.unitbv.CalendarEvent;
import webAutomation.Elearning.unitbv.LogOutPage;
import webAutomation.Elearning.unitbv.LoginPage;
import webAutomation.Elearning.unitbv.Base.Base_class;
import webAutomation.Elearning.unitbv.Base.Excel_Base;

public class RunnerCalendarEventTest extends Base_class{
	
	
	Excel_Base dataExcel1;
	@DataProvider(name = "testDataEvent")
	public Object[][] getData() throws IOException {
	dataExcel1 = new Excel_Base();
	Object data[][] = dataExcel1.testdata("SearchBook","input");
	return data;
	}
	
	@Test(dataProvider ="testDataEvent")
	public void runner_calender(String user, String password,String textArea,String dates,String months,String years, String hours,String mins) throws InterruptedException, IOException {
		test = extent.createTest("VerifyCalenderEventTest","Calender Event Test");

		LoginPage log = new LoginPage(driver); //create an object
		String userid = prop.getProperty("id"); //prop will take value of id from config.properties file
		String Password = prop.getProperty("password"); //prop will take value of password from config.properties file
		log.login(user,password); //call login methold from LoginPage, passed two Parameter.
		
		CalendarEvent event = new CalendarEvent(driver);
		event.SetCalendarEvent(textArea,dates,months,years,hours,mins);
		Thread.sleep(6000);

		LogOutPage logOut = new LogOutPage(driver);
		//LogOutPage Class as an object -> logOut
		
		logOut.log_out();
	}

}
