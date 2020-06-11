package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pom.CarRentals;
import pom.Cruise;
import pom.Destination;
import pom.Flights;
import pom.Hotels;
import pom.MercuryRegister;
import pom.vacations;
import utils.Common;


public class Login{
	
	
	Common common=new Common();
	WebDriver driver;
	  @BeforeSuite
	  public void beforeSuite() {
		  common.setup("chrome", "http://www.newtours.demoaut.com/");
		 driver= common.getDriver();
	  }

	  @AfterSuite
	  public void afterSuite() {
		  common.quitBrowser();
	  }

  @Test (priority=1)
  public void register()  {
	 MercuryRegister mercuryreg=new MercuryRegister(driver);
	 String s=mercuryreg.register();
	  assertTrue(s.contains("jakejennijaden"),"registration not done");  
	 
  }
  
  @Test (priority=2)
  public void flight()
  {
	  Flights flights =new Flights(driver);
	  Boolean s=flights.flightfunction();
	  assertTrue(s,"flight page broken"); 
  }
  
  @Test (priority=3)
  public void cruise()
  {
	  Cruise cruise =new Cruise(driver);
	  Boolean s=cruise.cruisefunction();
	  assertTrue(s,"Cruise page is broken"); 
  }
	
  
  @Test (priority=4)
  public void brokenpages()
  {
	  CarRentals car =new CarRentals(driver);
	  Boolean carpage=car.carrentalfunction();
	   assertTrue(carpage,"Car Rentals page not broken"); 
	  
	  Destination destn =new Destination(driver);
	  Boolean destnpage=destn.destinationfunction();
	  assertTrue(destnpage,"Destinations page not broken"); 
	  
	  Hotels hotel =new Hotels(driver);
	  Boolean hotelpage=hotel.hotelfunction();
	  assertTrue(hotelpage,"Hotels page not broken"); 
	  
	 vacations vac =new vacations(driver);
	 Boolean vacpage=vac.vacationsfunction();
	  assertTrue(vacpage,"Vacations page not broken"); 
	  
	  
  }
	

}
