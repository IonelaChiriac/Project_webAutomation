package webAutomation.Elearning.unitbv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	public void SetCalendarEvent() throws InterruptedException {
		Thread.sleep(2000);
		clickElement(click_pagesDropDnBtn);
		Thread.sleep(2000);
		clickElement(calendarLink);
		Thread.sleep(2000);
		clickElement(click_nextEventsDropDnBtn);
		Thread.sleep(2000);
		clickElement(click_nextEvents);
		Thread.sleep(2000);
		clickElement(click_newEventBtn);
		Thread.sleep(1000);
		sendKeysInElement(fieldText, "Prezentare lucrare disertatie TIN 2022");
		Thread.sleep(1000);
		selectByValue(date,"27");
		Thread.sleep(1000);
		selectByValue(month,"6");
		Thread.sleep(1000);
		selectByValue(year,"2022");
		Thread.sleep(1000);
		selectByValue(hour,"18");
		Thread.sleep(1000);
		selectByValue(minute,"55");
		Thread.sleep(1000);
		clickElement(scroll_button);
		Thread.sleep(5000);
		clickElement(click_monthEventDropdBtn);
		clickElement(click_monthEvents);
		Thread.sleep(5000);		
	}
}


	
	