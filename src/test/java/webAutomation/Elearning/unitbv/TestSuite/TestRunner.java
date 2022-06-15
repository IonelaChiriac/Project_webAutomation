//package webAutomation.Elearning.unitbv.TestSuite;
//
//import webAutomation.Elearning.unitbv.LoginPage;
//
//import java.io.IOException;
//
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import webAutomation.Elearning.unitbv.CalendarEvent;
//import webAutomation.Elearning.unitbv.Grade;
//import webAutomation.Elearning.unitbv.Base.Base_class;
//import webAutomation.Elearning.unitbv.Base.Excel_Base;
//import webAutomation.Elearning.unitbv.PostAnnouncementPage;
//import webAutomation.Elearning.unitbv.LogOutPage;
//
//
//public class TestRunner extends Base_class {
//	
//	Excel_Base dataExcel;
//	@DataProvider(name = "testdataPost")
//	public Object[][] getData() throws IOException {
//	dataExcel = new Excel_Base();
//	Object data[][] = dataExcel.testdata("SearchBookPost","input");
//	return data;
//	}
//	
//	@DataProvider(name = "testdata")
//	public Object[][] getData1() throws IOException {
//	dataExcel = new Excel_Base();
//	Object data[][] = dataExcel.testdata("SearchBook","input");
//	return data;
//	}
//	
//	
//	@Test(dataProvider = "testdata")
//	public void runner(String user, String password) throws InterruptedException, IOException {
//		
//		LoginPage log = new LoginPage(driver); //create an object
//		String userid = prop.getProperty("id"); //prop will take value of id from config.properties file
//		String Password = prop.getProperty("password"); //prop will take value of password from config.properties file
//		log.login(user,password); //call login methold from LoginPage, passed two Parameter.		
//		Thread.sleep(2000);
//		LogOutPage logOut = new LogOutPage(driver);
//		//LogOutPage Class as an object -> logOut
//		
//		logOut.log_out();	
//	}
//	
//	@Test
//	public void runner_grade() throws InterruptedException, IOException {
//		LoginPage log = new LoginPage(driver); //create an object
//		String userid = prop.getProperty("id"); //prop will take value of id from config.properties file
//		String Password = prop.getProperty("password"); //prop will take value of password from config.properties file
//		log.login(userid,Password); //call login methold from LoginPage, passed two Parameter.
//		
//		Grade gradeObj = new Grade(driver);
//		gradeObj.gradeTest();
//		Thread.sleep(6000);
//
//		LogOutPage logOut = new LogOutPage(driver);
//		//LogOutPage Class as an object, what is object - logOut
//		
//		logOut.log_out();
//	}
//	
//	@Test(dataProvider ="testdata")
//	public void runner_calender(String user, String password,String textArea,String dates,String months,String years, String hours,String mins) throws InterruptedException, IOException {
//		LoginPage log = new LoginPage(driver); //create an object
//		String userid = prop.getProperty("id"); //prop will take value of id from config.properties file
//		String Password = prop.getProperty("password"); //prop will take value of password from config.properties file
//		log.login(user,password); //call login methold from LoginPage, passed two Parameter.
//		
//		CalendarEvent event = new CalendarEvent(driver);
//		event.SetCalendarEvent(textArea,dates,months,years,hours,mins);
//		Thread.sleep(6000);
//
//		LogOutPage logOut = new LogOutPage(driver);
//		//LogOutPage Class as an object -> logOut
//		
//		logOut.log_out();
//	}
//	
//
//	@Test(dataProvider = "testdataPost")
//	public void runner_postAnnouncement(String user, String password,String postMsg,String contentMsg) throws InterruptedException, IOException {
//		LoginPage log = new LoginPage(driver); //create an object
//		String userid = prop.getProperty("id"); //prop will take value of id from config.properties file
//		String Password = prop.getProperty("password"); //prop will take value of password from config.properties file
//		log.login(user,password); //call login methold from LoginPage, passed two Parameter.
//		
//		PostAnnouncementPage postObj = new PostAnnouncementPage(driver);
//		postObj.PostAnnouncement(postMsg,contentMsg);
//		Thread.sleep(6000);
//
//		LogOutPage logOut = new LogOutPage(driver); //LogOutPage Class as an object -> logOut		
//		logOut.log_out();
//	}
//	
//}
