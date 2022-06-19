package webAutomation.Elearning.unitbv;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;

import webAutomation.Elearning.unitbv.Base.Base_class;

	//adding elements in Grade method
	//extends -> access Base_class methods
public class Grade extends Base_class {

	//Element Locators
	@FindBy(xpath ="//span[text()='Pagina principală']")
	WebElement homePage;
	
	@FindBy(xpath ="//a[@title='DAW2']")
	WebElement courseLink;
	
	
	@FindBy(xpath ="//span[@class='item-content-wrap'][normalize-space()='Note']")
	WebElement gradesLink;
	
	@FindBy(xpath ="//tbody/tr[3]/td[2]")
	WebElement gradeScore;
	
	//constructor calling driver from Base_class
	//initiallize all elements with web driver(PageFactory-> contains all the elements)
	public Grade(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//calling elements from the method Grade
	public void gradeTest() throws InterruptedException, IOException {
		Thread.sleep(1000);
		clickElement(homePage);
		Thread.sleep(1000);
		clickElement(courseLink);
		test.pass("Course Page",MediaEntityBuilder.createScreenCaptureFromBase64String(capturescreenshotAsBase64("CoursePage")).build());
//		test.pass("<a href="+capturescreenshot("OnCoursePage")+"><img src="+capturescreenshot("CoursePage")+" /></a>");

		Thread.sleep(1000);
		clickElement(gradesLink);
		test.pass("Grades Screen",MediaEntityBuilder.createScreenCaptureFromBase64String(capturescreenshotAsBase64("GradesScreen")).build());

		//test.pass("<a href="+capturescreenshot("GradesScreen")+"><img src="+capturescreenshot("GradesScreen")+" /></a>");

		Thread.sleep(1000);
		test.pass(gradeScore.getText());
		System.out.println("My Grade is : " + gradeScore.getText());

	}
	

}
