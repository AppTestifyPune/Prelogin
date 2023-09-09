package PreloginTestcases;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class PreloginBaseClass 
{
	public static WebDriver driver;
	public static Logger logger;
	public int i=0;
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark= new ExtentSparkReporter("test-output/Prelogin.html");
	
	@BeforeClass()
	public void LaunchURL() throws Exception
	{
		spark.config().setTheme(Theme.DARK);	
		spark.config().setDocumentTitle("My Report");
		extent.attachReporter(spark);
	
		//WebDriverManager.chromedriver();
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://mettl.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		logger = Logger.getLogger("Prelogin");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("The URL Launch");
		
		//++ Log4j dependency need to add
		//log.info("The URL launch successfully");	
	}

	public  void Capturesceen(String fileName)
	{
			try {
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				DateFormat format00 = new SimpleDateFormat("MM/dd/yyyy hh:MM:ss");
				Date date = new Date();
				String Format01 = format00.format(date).replace("/", "").replace(":", "").replace(" ", "");
				FileUtils.copyFile(src, new File("./Preloginscreenshots/" + Format01 + ".png"));
				System.out.println(Format01);
				System.out.println("Successfully captured a screenshot");
			} catch (Exception e) 
			{
				System.out.println("Exception");
			}
			System.out.println("Screenshot saved successfully");
	}
	
	public void JavaScript_Scrolling_The_SCreen(int i) throws Exception
	{
		//this.i=i;
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		if(i==1)
		{
			js.executeScript("window.scrollBy(0,350)", "Good");
		}else if (i==2)
		{
			js.executeScript("window.scrollBy(0,600)", "Better");
			System.out.println("  600 is ok");
		}else if(i==3)
		{
			WebElement element = driver.findElement(By.xpath("//p[text()='We are ISO 27001 Certified and ISO9001 Certified']"));
			js.executeScript("arguments[0].scrollIntoView();", element);
		}
		else if(i==4)
		{
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h4[text()='Scalable Solutions']")));
		}
		else if(i==5)
		{	
			js.executeAsyncScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 css-1ewhxlw']")));
			
		}
		else if(i==6)
		{	
			js.executeAsyncScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='MuiBox-root css-1phy807']")));
			
		}
		
		//div[@class='MuiBox-root css-1phy807']
		Thread.sleep(1000);
		
		
		
	}
	
	
	@AfterClass()
	public void EndTest()
	{ extent.flush();
	  driver.quit();
	}
	
}
