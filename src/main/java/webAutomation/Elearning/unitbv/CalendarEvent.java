package webAutomation.Elearning.unitbv;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;

import webAutomation.Elearning.unitbv.Base.Base_class;

 	//adding elements in CalendarEvent method
	//extends -> access Base_class methods
public class CalendarEvent extends Base_class{ 
	
	@FindBy(xpath = "//li[@class='type_course depth_2 contains_branch']//p[@class='tree_item branch']")
	WebElement click_pagesDropDnBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Calendar']")
	WebElement calendarLink;
	
	@FindBy(xpath = "//button[@id='calendarviewdropdown']")
	WebElement click_nextEventsDropDnBtn;
		
	@FindBy(xpath = "//a[normalize-space()='Evenimente viitoare']")
	WebElement click_nextEvents;
	
	@FindBy(xpath = "//button[contains(text(),'Eveniment nou')]")
	WebElement click_newEventBtn;
	
	@FindBy(name = "name")
	WebElement fieldText;
	
	@FindBy(xpath = "//select[@id='id_timestart_day']")
	WebElement date;
	
	@FindBy(xpath = "//select[@id='id_timestart_month']")
	WebElement month;
	
	@FindBy(xpath = "//select[@id='id_timestart_year']")
	WebElement year;
	
	@FindBy(xpath = "//select[@id='id_timestart_hour']")
	WebElement hour;
	
	@FindBy(xpath = "//select[@id='id_timestart_minute']")
	WebElement minute;
	
	@FindBy(xpath = "//button[contains(text(),'Salvare')]")
	WebElement scroll_button;
	
	@FindBy(xpath = "//button[@id='calendarviewdropdown']")
	WebElement click_monthEventDropdBtn;

	@FindBy(xpath = "//a[contains(text(),'Lună')]")
	WebElement click_monthEvents;
	
	//constructor calling driver from Base_class
	//initiallize all elements with web driver(PageFactory-> contains all the elements)
	public CalendarEvent(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	//calling elements from the method CalendarEvent
	public void SetCalendarEvent(String textArea,String dates,String months,String years, String hours,String mins) throws InterruptedException, IOException {
		Thread.sleep(1000);
		clickElement(click_pagesDropDnBtn);
		Thread.sleep(1000);
		clickElement(calendarLink);
		test.pass("Calendar Page Screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(capturescreenshotAsBase64("CalendarLinkPage")).build());

		//test.pass("<a href="+capturescreenshot("CalenderLinkPage")+"><img src="+capturescreenshot("CalenderLinkPage")+" /></a>");

		Thread.sleep(1000);
		clickElement(click_nextEventsDropDnBtn);
		Thread.sleep(1000);
		clickElement(click_nextEvents);
		Thread.sleep(1000);
		clickElement(click_newEventBtn);
		Thread.sleep(1000);
		sendKeysInElement(fieldText, textArea);
		Thread.sleep(1000);
		selectByValue(date,dates);
		Thread.sleep(1000);
		selectByValue(month,months);
		Thread.sleep(1000);
		selectByValue(year,years);
		Thread.sleep(1000);
		selectByValue(hour,hours);
		Thread.sleep(1000);
		selectByValue(minute,mins);
		test.pass("After Inserting field values",MediaEntityBuilder.createScreenCaptureFromBase64String(capturescreenshotAsBase64("AfterInsertingallfieldsValues")).build());

		//test.pass("<a href="+capturescreenshot("AfterInsertingallfieldsValues")+"><img src="+capturescreenshot("AfterInsertingallfieldsValues")+" /></a>");

		Thread.sleep(1000);
		clickElement(scroll_button);
		Thread.sleep(1000);
		clickElement(click_monthEventDropdBtn);
		clickElement(click_monthEvents);
		test.pass("After Calendar Event",MediaEntityBuilder.createScreenCaptureFromBase64String(capturescreenshotAsBase64("AfterEvent")).build());

		//test.pass("<a href="+capturescreenshot("AfterEvent")+"><img src="+capturescreenshot("AfterEvent")+" /></a>");

		Thread.sleep(1000);		
	}
}


	
	