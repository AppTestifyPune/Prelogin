package listeneers;

import java.io.File;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import PreloginTestcases.PreloginBaseClass;

public class Listeners extends PreloginBaseClass implements ITestListener
{

	@Override
	public void onTestFailure(ITestResult result) 
	{
		Capturesceen(result.getMethod().getMethodName()+".jpg");
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
	}
}
	
	/*
	@Override
	public void onTestFailure(ITestResult result)
	{
		String testName=result.getName();
		System.out.println(testName+"Failed test case");
		WebDriver driver;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		aftermethod(testName);
		
		/*
		try {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			DateFormat format00 = new SimpleDateFormat("MM/dd/yyyy hh:MM:ss");
			Date date = new Date();
			String Format01 = format00.format(date).replace("/", "").replace(":", "").replace(" ", "");
			FileUtils.copyFile(src, new File("C:\\Users\\HP\\git\\Prelogin\\MercerMettlPrelogin_AppTest\\Screenshots" + Format01 + ".png"));
			System.out.println(Format01);
			System.out.println("Successfully captured a screenshot");
		} catch (Exception e) 
		{
			System.out.println("Exception");
		}
		*/
	
	 
	
	

