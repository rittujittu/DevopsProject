package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MercuryRegister {
	static WebDriver driver;

	//elements
	@CacheLookup
	@FindBy(linkText="REGISTER")
	WebElement registerbutton;

	@CacheLookup
	@FindBy(name="firstName")
	WebElement firstname;

	@CacheLookup
	@FindBy(name="lastName")
	WebElement lastname;
	
	@CacheLookup
	@FindBy(name="phone")
	WebElement phone;
	
	@CacheLookup
	@FindBy(id="userName")
	WebElement username;
	
	@CacheLookup
	@FindBy(name="address1")
	WebElement address1;
	
	@CacheLookup
	@FindBy(name="address2")
	WebElement address2;
	
	@CacheLookup
	@FindBy(name="city")
	WebElement city;
	
	@CacheLookup
	@FindBy(name="state")
	WebElement state;
	
	@CacheLookup
	@FindBy(name="postalCode")
	WebElement postalcode;
	
	@CacheLookup
	@FindBy(id="email")
	WebElement email;
	
	@CacheLookup
	@FindBy(name="password")
	WebElement password;
	
	@CacheLookup
	@FindBy(name="confirmPassword")
	WebElement confirmPassword;
	
	@CacheLookup
	@FindBy(name="register")
	WebElement register;
	
	@CacheLookup
	@FindBy(xpath="//font/b/following::b")
	WebElement confirmationmessage;
	
	
	
	
	
	public MercuryRegister(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	

	public String register()
	{

		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(registerbutton));
		registerbutton.click();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(firstname));
		firstname.sendKeys("Jake");
		lastname.sendKeys("Jittu");
		phone.sendKeys("12345689");
		username.sendKeys("jake1000@abc.com");
		address1.sendKeys("Jennifer Jittu");
		address2.sendKeys("Jaden Jittu");
		city.sendKeys("Kottayam");
		state.sendKeys("AP");
		postalcode.sendKeys("72712");
		email.sendKeys("jakejennijaden");
		password.sendKeys("edureka2020");
		confirmPassword.sendKeys("edureka2020");
		register.click();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(confirmationmessage));
		String s= confirmationmessage.getText();
		return s;
		
		
	}
}
