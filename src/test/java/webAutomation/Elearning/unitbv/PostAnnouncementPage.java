package webAutomation.Elearning.unitbv;

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
	
	//make text bold
		

//	@FindBy(id  = "yui_3_17_2_1_1654967124425_752")
//	WebElement fileSelection;
//	@FindBy(id  = "yui_3_17_2_1_1654967124425_751")
//	WebElement fileSelection1;
//	@FindBy(id  = "yui_3_17_2_1_1654967124425_750")
//	WebElement fileSelection2;
//	@FindBy(id  = "yui_3_17_2_1_1654967124425_749")
//	WebElement fileSelection3;
//	@FindBy(xpath  = "//div[@id='yui_3_17_2_1_1654967124425_750']")
//	WebElement fileSelection4;

//	@FindBy(xpath = "//span[@id='yui_3_17_2_1_1654966143973_1286']")
//	WebElement click_personalFiles;
//	
//	@FindBy(xpath = "//span[@id='yui_3_17_2_1_1654966143973_1322']")
//	WebElement click_File;
//	
//	@FindBy(xpath = "//button[@id='yui_3_17_2_1_1654966143973_1429']")
//	WebElement click_SaveFile;
	
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
	public void PostAnnouncement() throws InterruptedException {
		//Thread.sleep(2000);
		clickElement(click_pagesDropDnBtn);
		//Thread.sleep(2000);
		clickElement(blogLink);
		//Thread.sleep(2000);
		clickElement(addNewPost);
		//Thread.sleep(2000);
		sendKeysInElement(fieldTextTitle, "Test post message");
		Thread.sleep(2000);
		sendKeysInElement(fieldTextContent, "Test content message");
		Thread.sleep(2000);
		//clickElement(click_BoldBtn);
		//Thread.sleep(1000);
		//atach file
		//clickElement(click_Toolbar);
		//Thread.sleep(2000);
		
//		clickElement(fileSelection);
//		Thread.sleep(2000);
//		clickElement(fileSelection1);
//		Thread.sleep(2000);
//		clickElement(fileSelection2);
//		Thread.sleep(2000);
//		clickElement(fileSelection3);
//		Thread.sleep(2000);
//		clickElement(fileSelection4);
//		Thread.sleep(2000);
		
		
//		clickElement(click_personalFiles);
//		Thread.sleep(2000);
//		clickElement(click_File);
//		Thread.sleep(2000);
//		clickElement(click_SaveFile);
//		Thread.sleep(2000);
		clickElement(click_optionBt);
		Thread.sleep(2000);
		clickElement(select_onlyMe);
		Thread.sleep(2000);
		clickElement(click_SaveBtn);
	
		
		Thread.sleep(15000);

		
	}
}

//test jenkins