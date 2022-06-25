package webAutomation.Elearning.unitbv;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;

import junit.framework.Assert;
import webAutomation.Elearning.unitbv.Base.Base_class;

//adding elements in LoginPage method
//extends -> access Base_class methods
public class LoginPage extends Base_class {

	@FindBy(id = "username")
	WebElement id;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[@id='loginbtn']")
	WebElement loginBtn;

	// constructor calling driver from Base_class
	// initiallize all elements with web driver(PageFactory-> contains all the elements)
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// method login which contains user id and password and clicks on login button
	public void login(String Userid, String Password) throws InterruptedException, IOException {

		sendKeysInElement(id, Userid);
		Thread.sleep(1000);

		sendKeysInElement(password, Password);
		Thread.sleep(1000);
		String timestamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()).replaceAll(":",
				"-");
		// createScreenCaptureFromBase64String calls this MediaEntityBuilder building
		// method, capture screenshot as Base64 (convert png files to string)
		test.pass("After Inserting credentials", MediaEntityBuilder.createScreenCaptureFromBase64String(
				capturescreenshotAsBase64("SendKeysforUseridandPassword" + timestamp)).build());
		// test.pass("<a href="+capturescreenshot("SendKeysforUseridandPassword")+"><img src="+capturescreenshot("SendKeysforUseridandPassword")+" /></a>");
		clickElement(loginBtn);
		Thread.sleep(3000);
		if(loginBtn.isDisplayed()) {
			test.fail("Not Login",MediaEntityBuilder.createScreenCaptureFromBase64String(capturescreenshotAsBase64("element")).build());
			Assert.assertFalse(true);
		}
	}

}
