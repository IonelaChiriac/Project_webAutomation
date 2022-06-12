package webAutomation.Elearning.unitbv.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_class {

	public WebDriver driver;
	public Properties prop;

	public Base_class() {
		String current = System.getProperty("user.dir"); //path to directory of the project
		
		
		prop = new Properties(); //obj of properties which is an extension of a file accessing config file
		FileInputStream ip;
		try {
			ip = new FileInputStream(current + "\\src\\main\\java\\webAutomation\\Elearning\\unitbv\\Utillities\\config.properties"); // FileInputStream will access the path of the directory
			prop.load(ip); //after loading file is ready to use
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeTest
	public void Setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://elearning.unitbv.ro/login/index.php");

	}

	public void sendKeysInElement(WebElement ele, String text) {
		ele.clear();
		ele.sendKeys(text);
	}

	public void clickElement(WebElement ele) {
		ele.click();
	}
	public void selectByValue(WebElement element,String val) {
		Select select = new Select(element);
		select.selectByValue(val);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}