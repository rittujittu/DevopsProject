package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flights {
	static WebDriver driver;

	//elements
	
	@CacheLookup
	@FindBy(linkText="Flights")
	WebElement flightbutton;
	
	@CacheLookup
	@FindBy(xpath="//img[@src='/images/masts/mast_flightfinder.gif']")
	WebElement flightpage;
	
	public Flights(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	public Boolean flightfunction() {
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(flightbutton));
		flightbutton.click();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(flightpage));
		Boolean pageElement =flightpage.isDisplayed();
		return pageElement;
	
	}
	

}
