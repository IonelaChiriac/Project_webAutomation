package webAutomation.Elearning.unitbv;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webAutomation.Elearning.unitbv.Base.Base_class;

public class PostAnnouncementPage extends Base_class { 
	
	@FindBy(xpath = "//li[@class='type_course depth_2 contains_branch']//p[@class='tree_item branch']")
	WebElement click_pagesDropDnBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Blog-uri site')]")
	WebElement blogLink;
	
	@FindBy(xpath = "//a[contains(text(),'Adaugă un articol nou')]")
	WebElement addNewPost;
	
	@FindBy(name = "subject")
	WebElement fieldTextTitle;
	
	@FindBy(id = "id_summary_editoreditable")
	WebElement fieldTextContent;
	
	@FindBy(css  = ".filemanager-toolbar>div>div:nth-child(1)")
	WebElement fileSelection;

	@FindBy(css = ".fp-repo-area div:nth-child(4)")
	WebElement click_personalFiles;
//	
	@FindBy(css = "tr td:nth-child(3) .fp-filename-icon a")
	WebElement click_File;
//	
	@FindBy(css = ".fp-select-confirm.btn-primary.btn")
	WebElement click_SaveFile;
	
	@FindBy(xpath = "//div[@id='id_summary_editoreditable']")
	WebElement fieldTextContentSelect;
	
	@FindBy(xpath = "//select[@id='id_publishstate']")
	WebElement click_optionBt;
	
	@FindBy(xpath = "//option[contains(text(),'Autor (ciornă)')]")
	WebElement select_onlyMe;
	
	@FindBy(xpath = "//input[@id='id_submitbutton']")
	WebElement click_SaveBtn;
	
	
	public PostAnnouncementPage(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

	
	//calling elements from the method CalendarEvent
	public void PostAnnouncement(String postMsg,String contentMsg) throws InterruptedException, IOException {
		//Thread.sleep(2000);
		clickElement(click_pagesDropDnBtn);
		//Thread.sleep(2000);
		clickElement(blogLink);
		//Thread.sleep(2000);
		clickElement(addNewPost);
		//Thread.sleep(2000);
		sendKeysInElement(fieldTextTitle, postMsg);
		Thread.sleep(2000);
		sendKeysInElement(fieldTextContent, contentMsg);
		Thread.sleep(2000);
		clickElement(fileSelection);
		Thread.sleep(2000);				
		clickElement(click_personalFiles);
		Thread.sleep(2000);
		clickElement(click_File);
//		Thread.sleep(2000);
		clickElement(click_SaveFile);
		Thread.sleep(2000);
		clickElement(click_optionBt);
		Thread.sleep(2000);
		clickElement(select_onlyMe);
		Thread.sleep(2000);
		clickElement(click_SaveBtn);
	
		
		Thread.sleep(1000);

		
	}
}

//test jenkins