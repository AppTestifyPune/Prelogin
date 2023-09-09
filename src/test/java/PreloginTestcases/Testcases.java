package PreloginTestcases;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import PreloginPageObject.PreloginHeaderPageObject;
import junit.framework.Assert;

public class Testcases extends PreloginBaseClass
{  	
	PreloginHeaderPageObject PreloginHead= new PreloginHeaderPageObject();
	SoftAssert softassert= new SoftAssert();
	boolean Case=true;

	@Test( enabled=true,testName="Test01",priority=01, description="Test case 01: Language Drop down Verification" )
	public void HeaderVerificationLangauage() throws Exception
	{   
		ExtentTest test= extent.createTest(" Test case 01 ").assignAuthor("Sagar").assignCategory("Functional");
		test.info("Language Drop down Verification");
		
		PreloginHead.LangaugeDropDown(driver).click();
		Thread.sleep(3000);
		String ColleLang = PreloginHead.AllLanguages(driver).getText();
		System.out.println(ColleLang);
		//################################### DATA ################################################
		String[] Langauges={"English","German","Spanish","Portuguese","Indonesian","French"};
		int Y=(Langauges.length)-1;
		System.out.println(Langauges.length);
		//#########################################################################################
		for(int i=0;i<=Y;i++)
		{	
			if(ColleLang.contains(Langauges[i]))
			{
				Case=true;
				logger.info("log: Test 01 Passed");
				test.pass( "Test 01 pass" );	
			}else
			{
				Case=false;
				logger.info("log: Test 01 Failed");
				softassert.assertEquals(Case, true);		
			}
		}	
	}
	
	@Test(enabled=true,testName="Test02", priority=02, description="Test case 02: Call us functionality" )
	public void HeaderVerificationCallUs() throws Exception
	 {
		ExtentTest test= extent.createTest("Test case 02").assignAuthor("Sagar").assignCategory("Functional");
		test.info("Call us functionality");
		driver.navigate().refresh();
		Thread.sleep(2000);
		PreloginHead.CallUsButton(driver).click();
		Thread.sleep(2000);
		String CallUs = PreloginHead.CallUsData(driver).getText();
		
		if(CallUs.contains("Enquiry: +91 9555114444"))  //Enquiry: +91 9555114444
		{
			Case=true;
			logger.info("log: Test case 02 Pass");
			test.pass( "Test case 02 Pass" );
		}

		if (CallUs.contains("Test-Taker Support: +91-8047189190")) //Test-Taker Support: +91-8047189190
		{
			Case=true;
			logger.info("log: Test case 02 pass");
		} else 
		{
			test.fail( "Test case 02 Pass" );
			Case=false;
			logger.info("log: Test case 02 Fail");
		}
		System.out.println(CallUs);
		Assert.assertEquals(true, Case);
	 }
	
	@Test(enabled=true,testName="Test03",priority=03, description="Test case 03: Contact Us Page Verification")
	public void ContactUs()
	{
		ExtentTest test= extent.createTest("Test case 03").assignAuthor("Sagar").assignCategory("Functional");
		test.info("Contact Us Page Verification");
		driver.navigate().refresh();
		PreloginHead.ContactUs(driver).click();
		if(driver.getTitle().contains("Mettl - Contact us for Sales, Business and customer support queries"))            //Mettl - Contact us for Sales, Business and customer support queries
		{
			Case=true;
			test.pass( "Test case 03 Pass" );
			logger.info("log: Test case 03 Passed");
		}else 
		{
			test.fail( "Test case 02 Pass" );
			Case=false;
			logger.info("log: Test case 03 Failed");
		}
		softassert.assertEquals(true, Case);
		driver.close();	
	}
	
	@Test(enabled=true,testName="Test04",priority=04, description="Test case 4: Login button verification")
	public void LoginButton() throws Exception
	{   
		ExtentTest test= extent.createTest("Test case 04").assignAuthor("Sagar").assignCategory("Functional");
		test.info("Login button verification");
		LaunchURL();
		PreloginHead.LoginButton(driver).click();
		String title=driver.getTitle();
		System.out.println(title);
		if(driver.getTitle().contains("Login to conduct online tests for recruitments, trainings, contests, exams"))
		{
			Case=true;
			test.pass( "Test case 04 Pass" );
			logger.info("log: Test case 04 Passed");
		}
		else 
		{
			Case=false;
			test.fail( "Test case 04 fail" );
			logger.info("log: Test case 04 Failed");
		}
		driver.navigate().back();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium css-1wesk6d']")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		test.pass("Test 4.1 Pass");
		
		driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeLarge MuiButton-containedSizeLarge css-2on639']")).click();
		Thread.sleep(2000);

		
	}
	
	@Test(enabled=true, priority=05, description="Multiple_DropDown_Box")
	public void Multiple_DropDown_Box() throws Exception
	{
		driver.navigate().back();
		Thread.sleep(2000);
		ExtentTest test= extent.createTest("Test case 05").assignAuthor("Sagar").assignCategory("Functional");
		test.info("Multiple_DropDown_Box");
		
		driver.findElement(By.xpath("//span[text()='ONLINE EXAMINATIONS']")).click();
		Thread.sleep(3000);
		
		if(driver.findElement(By.xpath("//span[text()='Online Certification Platform '][1]")).isDisplayed())
		{
			test.pass("test case 5.1 pass");
			logger.info("log: Test case 05.1 Passed");
			Case=true;
		}else 
		{
			test.fail("test case 5.1 fail");
			Case=false;
		}
		
		Assert.assertEquals(true, Case);
		
		driver.findElement(By.xpath("//span[text()='HIRING AND L&D']")).click();
		Thread.sleep(3000);
		
		if(driver.findElement(By.xpath("//span[text()='Find The Right Talent'][1]")).isDisplayed())
		{
			test.pass("test case 5.2 pass");
			logger.info("log: Test case 5.2 Passed");
			Case=true;
		}else 
		{
			test.fail("test case 5.2 fail");
			logger.info("Test case 5.2 fail");
			Case=false;
		}
		Assert.assertEquals(true, Case);
		
		driver.findElement(By.xpath("//span[text()='Test Library'][1]")).click();
		Thread.sleep(2000);
		System.out.println("Test lib title:"+driver.getTitle());

		if(driver.getTitle().equals("Mercer | Mettl Test Library | Recruitment Tests for Job roles, Industries & Disciplines"))
		{
			test.pass("Test case 5.3 pass");
			logger.info("Test case 5.3 Pass ");
			Case=true;
		}else 
		{
			test.fail("Test case 5.3 fail");
			logger.info("Test case 5.3 failed");
			Case=false;
			System.out.println("Test library case:"+Case);
		}
		Assert.assertEquals(true, Case);
		driver.navigate().back();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='PRICING']")).click();
		Thread.sleep(2000);
		System.out.println("Pricing title:"+driver.getTitle());
		
		if(driver.getTitle().equals("Pricing for Mettl's Assessments, HR Solutions and Assessment Delivery technologies"))
		{
			test.pass("Test case 5.4 pass");
			logger.info("Test case 5.4 Pass");
			Case=true;
		}else 
		{
			test.fail("Test case 5.4 fail");
			logger.info("Test case 5.4 failed");
			Case=false;
		}
		
		Assert.assertEquals(true, Case);
		driver.navigate().back();
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//span[text()='RESOURCES']")).click();
		Thread.sleep(2000);
		
		if(driver.findElement(By.xpath("//span[text()='EBooks'][1]")).isDisplayed())
		{
			test.pass("Test case 5.5 pass");
			logger.info("log: Test case 5.5 Passed");
			Case=true;
		}
		else 
		{
			test.fail("Test case 5.5 fail");
			logger.info("log: Test case 05.5 Passed");
			Case=false;
		}
		Assert.assertEquals(true, Case);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	@Test( priority=6, description="Holistic Online Assessment Tools for Academic Institutes and Corporates" ) 
	public  void OnlineAssessmentTools() throws Exception
	{
		ExtentTest test= extent.createTest("Test case 06").assignAuthor("Sagar").assignCategory("Functional");
		test.info("OnlineAssessmentTools");
		JavaScript_Scrolling_The_SCreen(1);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 greenbg css-1a5s842']")).click();
		Thread.sleep(1000);
		test.pass("Test 06.1 Pass");
		logger.info("log: Test case 06.1 Passed");
		
		driver.navigate().back();
		JavaScript_Scrolling_The_SCreen(1);
		driver.findElement(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 greenbg css-e9n3in']")).click();
		Thread.sleep(1000);
		
		driver.navigate().back();
		JavaScript_Scrolling_The_SCreen(1);
		test.pass("Test 06.2 Pass");
		logger.info("log: Test case 06.2 Passed");
		
		driver.findElement(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 greenbg css-1wxgqc1']")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		test.pass("Test 06.3 Pass");
		logger.info("log: Test case 06.3 Passed");
		
		JavaScript_Scrolling_The_SCreen(1);
		driver.findElement(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 greenbg css-1i2lvfo']")).click();
		Thread.sleep(2000);
		test.pass("Test 06.4 Pass");
		logger.info("log: Test case 06.4 Passed");
		
		/*
		driver.navigate().back();
		Thread.sleep(2000);
		
		JavaScript_Scrolling_The_SCreen(2);
		driver.findElement(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 bluebg css-quc8ql']")).click();
		Thread.sleep(4000);
		test.pass("Test 06.5 Pass");
		logger.info("log: Test case 06.5 Passed");
		
		driver.navigate().back();
		Thread.sleep(2000);
		JavaScript_Scrolling_The_SCreen(2);
		driver.findElement(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 bluebg css-1qvdr0l']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		test.pass("Test 6.6 pass");
		logger.info("log: Test case 06.6 Passed");
		
		JavaScript_Scrolling_The_SCreen(3);
		driver.findElement(By.xpath("//button[text()='EXPLORE OUR INFORMATION SECURITY FEATURES']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		test.pass("Test 6.7 Pass");
		logger.info("log: Test case 6.7 Passed");
		
		
		Thread.sleep(2000);
		JavaScript_Scrolling_The_SCreen(4);
		driver.findElement(By.xpath("//button[text()='Try for free']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1lo0txk']")).click();
		test.pass(" Test 6.8 Pass ");
		logger.info("log: Test case 6.8 Pass ");
		/*
		driver.navigate().refresh();
		Thread.sleep(2000);
		JavaScript_Scrolling_The_SCreen(5);
		driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeLarge MuiButton-containedSizeLarge css-1xj5dq9' and text()='TRY FOR FREE']")).click();
		Thread.sleep(2000);
		test.pass(" Test 6.9 Pass");
		logger.info("log: Test case 6.9 Pass");
		
		driver.navigate().back();
		
		Thread.sleep(1000);
		JavaScript_Scrolling_The_SCreen(5);
		driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-fullWidth MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-fullWidth css-1j7nz4p']")).click();
		Thread.sleep(2000);
		//driver.navigate().back();
		test.pass("Test 7.0 Pass");
		logger.info("log: Test case 7.0 Pass");
		*/
		
		}
	
	@AfterMethod()
	public void aftermethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Capturesceen(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".jpg");
		}
	}
	
	@AfterTest()
	public void AfterTestAllasserts()
	{
		softassert.assertAll();
	}
	
}
