package webAutomation.Elearning.unitbv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webAutomation.Elearning.unitbv.Base.Base_class;

	//adding elements in Grade method
	//extends -> access Base_class methods
public class Grade extends Base_class {

	
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
	public void gradeTest() throws InterruptedException {
		Thread.sleep(1000);
		clickElement(homePage);
		Thread.sleep(1000);
		clickElement(courseLink);
		Thread.sleep(1000);
		clickElement(gradesLink);
		Thread.sleep(1000);
		System.out.println("My Grade is : " + gradeScore.getText());

	}
	

}
