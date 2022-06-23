package webAutomation.Elearning.unitbv;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.MediaEntityBuilder;
import webAutomation.Elearning.unitbv.Base.Base_class;

//adding elements in LogOutPage method
//extends -> access Base_class methods
public class LogOutPage extends Base_class {

	@FindBy(xpath = "//a[@id='action-menu-toggle-0']")
	WebElement menuBtn;

	@FindBy(xpath = "//span[@id='actionmenuaction-6']")
	WebElement logoutBtn;

	// constructor calling driver from Base_class
	// initiallize all elements with web driver(PageFactory-> contains all the
	// elements)
	public LogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// method log_out open the config menu and log out
	public void log_out() throws InterruptedException {
		// timestamps is getting the current time and adds it to the caption of screenshots
		String timestamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()).replaceAll(":","-");

		try {
			if (menuBtn.isDisplayed()) {

				clickElement(menuBtn);
				// createScreenCaptureFromBase64String calls this MediaEntityBuilder building
				// method, capture screenshot as Base64 (convert png files to string)
				test.pass("opening Config Menu", MediaEntityBuilder
						.createScreenCaptureFromBase64String(capturescreenshotAsBase64("ConfigMenu" + timestamp))
						.build());
				// test.pass("<a href="+capturescreenshot("ConfigMenu"+timestamp)+"><img src="+capturescreenshot("ConfigMenu"+timestamp)+" /></a>");
				Thread.sleep(1000);
				clickElement(logoutBtn);
				Thread.sleep(1000);
				// createScreenCaptureFromBase64String calls this MediaEntityBuilder building
				// method, capture screenshot as Base64 (convert png files to string)
				test.pass("After Logout", MediaEntityBuilder.createScreenCaptureFromBase64String(capturescreenshotAsBase64("AfterLogout" + timestamp)).build());
				// test.pass("<a href="+capturescreenshot("AfterLogout")+"><img src="+capturescreenshot("AfterLogout")+" /></a>");
			}
		}
		// for any error it will catch the error and display
		catch (Exception e) {

		}
	}
}
