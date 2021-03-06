package webAutomation.Elearning.unitbv.TestSuite;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import webAutomation.Elearning.unitbv.CalendarEvent;
import webAutomation.Elearning.unitbv.LogOutPage;
import webAutomation.Elearning.unitbv.LoginPage;
import webAutomation.Elearning.unitbv.Base.Base_class;
import webAutomation.Elearning.unitbv.Base.Excel_Base;

public class RunnerCalendarEventTest extends Base_class {

	Excel_Base dataExcel1;

	// @DataProvider provides data from excel in object form - first is searching excel file name then the sheet number
	@DataProvider(name = "testDataEvent") 
	public Object[][] getData() throws IOException {
		dataExcel1 = new Excel_Base();
		Object data[][] = dataExcel1.testdata("SearchBookEvent", "input");
		return data;
	}

	@Test(dataProvider = "testDataEvent")
	public void runner_calender(String textArea, String dates, String months,
		String years, String hours, String mins) throws InterruptedException, IOException {
		test = extent.createTest("VerifyCalenderEventTest", "Calender Event Test");
		// create an object
		LoginPage log = new LoginPage(driver); 
		// prop will take value of id from config.properties file
		String userid = prop.getProperty("id"); 
		// prop will take value of password from config.properties file
		String Password = prop.getProperty("password"); 
		// call login methold from LoginPage, passed two parameters
		log.login(userid, Password); 

		CalendarEvent event = new CalendarEvent(driver);
		event.SetCalendarEvent(textArea, dates, months, years, hours, mins);
		Thread.sleep(6000);

		LogOutPage logOut = new LogOutPage(driver);
		// LogOutPage Class as an object -> logOut

		logOut.log_out();
	}

}
