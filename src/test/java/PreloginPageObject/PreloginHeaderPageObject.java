package PreloginPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PreloginHeaderPageObject 
{
	
	public WebElement LangaugeDropDown(WebDriver driver )
	{
		WebElement element=driver.findElement(By.xpath("//span[@class='MuiTypography-root MuiTypography-button css-1ii3jfb']"));
		return element;	
	}
	
	public WebElement AllLanguages(WebDriver driver)
	{
		
		WebElement element=driver.findElement(By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']"));
		return element;
		
	}
	
	public WebElement CallUsButton(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//span[text()='Call us']"));
		return element;
	}
	
	public WebElement CallUsData(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']"));
		return element;
		
	}
	
	public WebElement ContactUs(WebDriver driver)
	{
		WebElement element = driver.findElement(By.xpath("//span[text()='Contact us'][1]"));
		return element;	
	}

	public WebElement LoginButton(WebDriver driver)
	{
		WebElement element = driver.findElement(By.xpath("//span[text()='Login']"));
		return element;	
	}
	
	
	
}
