package webAutomation.Elearning.unitbv;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;

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
		clickElement(click_pagesDropDnBtn);
		clickElement(blogLink);
		test.pass("Blog Post Page",MediaEntityBuilder.createScreenCaptureFromBase64String(capturescreenshotAsBase64("BlogPostAnnouncement")).build());

		//test.pass("<a href="+capturescreenshot("BlogPostAnnouncement")+"><img src="+capturescreenshot("BlogPostAnnouncement")+" /></a>");
		clickElement(addNewPost);
		sendKeysInElement(fieldTextTitle, postMsg);
		Thread.sleep(1000);
		sendKeysInElement(fieldTextContent, contentMsg);
		test.pass("After Inserrting Message",MediaEntityBuilder.createScreenCaptureFromBase64String(capturescreenshotAsBase64("AfterInsertingMessage")).build());

		//test.pass("<a href="+capturescreenshot("AfterInsertingMessage")+"><img src="+capturescreenshot("AfterInsertingMessage")+" /></a>");

		Thread.sleep(1000);
		clickElement(fileSelection);
		Thread.sleep(1000);				
		clickElement(click_personalFiles);
		Thread.sleep(1000);
		clickElement(click_File);
		clickElement(click_SaveFile);
		test.pass("SelectionFile",MediaEntityBuilder.createScreenCaptureFromBase64String(capturescreenshotAsBase64("SelectionFile")).build());

		//test.pass("<a href="+capturescreenshot("SelectionFile")+"><img src="+capturescreenshot("SelectionFile")+" /></a>");
		Thread.sleep(1000);
		clickElement(click_optionBt);
		test.pass("After Click on option button",MediaEntityBuilder.createScreenCaptureFromBase64String(capturescreenshotAsBase64("click_optionBt")).build());

		//test.pass("<a href="+capturescreenshot("click_optionBt")+"><img src="+capturescreenshot("click_optionBt")+" /></a>");
		Thread.sleep(1000);
		clickElement(select_onlyMe);
		Thread.sleep(1000);
		clickElement(click_SaveBtn);
		test.pass("After Submit",MediaEntityBuilder.createScreenCaptureFromBase64String(capturescreenshotAsBase64("SubmitAnnouncement")).build());

		//test.pass("<a href="+capturescreenshot("SubmitAnnouncement")+"><img src="+capturescreenshot("SubmitAnnouncement")+" /></a>");	
		Thread.sleep(1000);

		
	}
}
