package webAutomation.Elearning.unitbv.TestSuite;

import webAutomation.Elearning.unitbv.LoginPage;
import org.testng.annotations.Test;
import webAutomation.Elearning.unitbv.CalendarEvent;
import webAutomation.Elearning.unitbv.Grade;
import webAutomation.Elearning.unitbv.Base.Base_class;
import webAutomation.Elearning.unitbv.PostAnnouncementPage;
import webAutomation.Elearning.unitbv.LogOutPage;


public class TestRunner extends Base_class {
	
	@Test
	public void runner() throws InterruptedException {
		
		LoginPage log = new LoginPage(driver); //create an object
		String userid = prop.getProperty("id"); //prop will take value of id from config.properties file
		String Password = prop.getProperty("password"); //prop will take value of password from config.properties file
		log.login(userid,Password); //call login methold from LoginPage, passed two Parameter.		

		LogOutPage logOut = new LogOutPage(driver);
		//LogOutPage Class as an object -> logOut
		
		logOut.log_out();	
	}
	
	@Test
	public void runner_grade() throws InterruptedException {
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
	
	@Test
	public void runner_calender() throws InterruptedException {
		LoginPage log = new LoginPage(driver); //create an object
		String userid = prop.getProperty("id"); //prop will take value of id from config.properties file
		String Password = prop.getProperty("password"); //prop will take value of password from config.properties file
		log.login(userid,Password); //call login methold from LoginPage, passed two Parameter.
		
		CalendarEvent event = new CalendarEvent(driver);
		event.SetCalendarEvent();
		Thread.sleep(6000);

		LogOutPage logOut = new LogOutPage(driver);
		//LogOutPage Class as an object -> logOut
		
		logOut.log_out();
	}
	

	@Test
	public void runner_postAnnouncement() throws InterruptedException {
		LoginPage log = new LoginPage(driver); //create an object
		String userid = prop.getProperty("id"); //prop will take value of id from config.properties file
		String Password = prop.getProperty("password"); //prop will take value of password from config.properties file
		log.login(userid,Password); //call login methold from LoginPage, passed two Parameter.
		
		PostAnnouncementPage postObj = new PostAnnouncementPage(driver);
		postObj.PostAnnouncement();
		Thread.sleep(6000);

		LogOutPage logOut = new LogOutPage(driver); //LogOutPage Class as an object -> logOut		
		logOut.log_out();
	}
	
}
