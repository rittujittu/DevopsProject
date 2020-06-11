package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cruise {
	static WebDriver driver;

	//elements
	
	@CacheLookup
	@FindBy(linkText="Cruises")
	WebElement cruisebutton;
	
	@CacheLookup
	@FindBy(xpath="//img[@src='/images/masts/cruise_special.gif']")
	WebElement cruisepage;
	
	public Cruise(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	public Boolean cruisefunction() {
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(cruisebutton));
		cruisebutton.click();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(cruisepage));
		Boolean cruiseElement =cruisepage.isDisplayed();
		return cruiseElement;
	
	}
	

}
