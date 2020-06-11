package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hotels {
	static WebDriver driver;

	//elements
	
	@CacheLookup
	@FindBy(linkText="Hotels")
	WebElement hotelsbutton;
	
	@CacheLookup
	@FindBy(xpath="//img[@src='/images/masts/mast_construction.gif']")
	WebElement brokenpage;
	
	public Hotels(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	public Boolean hotelfunction() {
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(hotelsbutton));
		hotelsbutton.click();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(brokenpage));
		Boolean brokenElement =brokenpage.isDisplayed();
		return brokenElement;
}
}