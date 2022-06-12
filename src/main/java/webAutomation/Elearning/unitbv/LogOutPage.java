package webAutomation.Elearning.unitbv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webAutomation.Elearning.unitbv.Base.Base_class;

	//adding elements in LogOutPage method
	//extends -> access Base_class methods
public class LogOutPage extends Base_class {
	
	@FindBy(xpath = "//a[@id='action-menu-toggle-0']")
	WebElement menuBtn;

	@FindBy(xpath = "//span[@id='actionmenuaction-6']")
	WebElement logoutBtn;	
	
	//constructor calling driver from Base_class
	//initiallize all elements with web driver(PageFactory-> contains all the elements)
	public LogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void log_out() throws InterruptedException {
		clickElement(menuBtn);
		Thread.sleep(2000);
		
		clickElement(logoutBtn);
		Thread.sleep(2000);
}
}
	
