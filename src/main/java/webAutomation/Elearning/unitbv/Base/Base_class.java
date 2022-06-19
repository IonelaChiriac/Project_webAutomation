package webAutomation.Elearning.unitbv.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_class {

	public WebDriver driver;
	public Properties prop;
	
	//three objects of extent report

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test; // from test object we define every step log, by using keyword like test.log or test.pass

	int count =1;
	int key=1;
	int clic = 1;
	int dd =1;
	
	public Base_class() {
		String current = System.getProperty("user.dir"); //path to directory of the project
		
		
		prop = new Properties(); //obj of properties which is an extension of a file accessing config file
		FileInputStream ip;
		try {
			ip = new FileInputStream(current + "\\src\\main\\java\\webAutomation\\Elearning\\unitbv\\Utillities\\config.properties"); // FileInputStream will access the path of the directory
			prop.load(ip); //after loading file is ready to use
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();			
		}
		  String timestamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()).replaceAll(":", "-");



		//String outputDirectory = System.getProperty("user.dir")+"\\reports\\ExtentReport"+".html";
		String outputDirectory = System.getProperty("user.dir")+"\\reports\\ExtentReport"+timestamp+".html";
		htmlReporter = new ExtentSparkReporter(outputDirectory);
		htmlReporter.config().setReportName("TesResults");
		htmlReporter.config().setDocumentTitle("TesResults");
				
	}

	@BeforeMethod
	public void Setup() {

	
	
		

		getInstance();
		
	
		WebDriverManager.chromedriver().setup();
		test = extent.createTest("BrowserLaunchForTest","BrowserLaunch and Successfully Loaded");

		
		//execution in background with headless, window browser will not open -> chromeOptions.addArguments("--headless");
		ChromeOptions chromeOptions = new ChromeOptions();
		//in headless there might appear some cookie window or pop notification, for that the below things are disabled
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.addArguments("--disable-gpu");
		chromeOptions.addArguments("--disable-extensions");
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--disable-dev-shm-usage");
		//chromeOptions.addArguments("--headless");
		test.info("Headless execution");
		chromeOptions.addArguments("--window-size=1580,1280");
		
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		
		driver.get("https://elearning.unitbv.ro/login/index.php");
		test.info("Opening URL");

	}
	
	public String capturescreenshot(String ScreenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;

		File SRC= ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\reports\\screenshots\\"+ScreenshotName+".png";
		File destination = new File(path);
		FileUtils.copyFile(SRC,destination );


		return path;
		}

	public void sendKeysInElement(WebElement ele, String text) throws IOException {
		
		try{ele.clear();
		ele.sendKeys(text);
		test.pass("user successfuly enter the text : "+text +" on this element :"+ ele);
		
		++key;
		}
		catch(Exception e) {
			
		}
	}

	public void clickElement(WebElement ele) throws IOException {
		ele.click();
		test.pass("user successfully clicked on this element "+ ele);
		++clic;

	}
	public void selectByValue(WebElement element,String val) throws IOException {
		Select select = new Select(element);
		select.selectByValue(val);
		test.pass("user successfully set the drop down value of "+ val +" on this element "+element);
		test.pass("<a href="+capturescreenshot("dropDownSet"+dd)+"><img src="+capturescreenshot("DropdownSet"+dd+".png")+" /></a>");
		++dd;
	}
	
	
	public static ExtentReports getInstance() {
	        if(extent == null) {
	        	extent = new ExtentReports();
	    		extent.attachReporter(htmlReporter);
	    		extent.setSystemInfo("TesResults","Elearning.unitbv");

	        }   
	        return extent;
	    }


		
	@AfterSuite
	public void tearDown() {
		count++;
		extent.flush();
		driver.quit();
	}
	
	@AfterMethod
	public void closeTests() {
		driver.close(); //closes the browsers for all the tests
		
	}

}
//