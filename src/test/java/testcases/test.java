package testcases;

import java.io.IOException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.car_insurance;
import pages.health_insurance;
import pages.travel_insurance;
import pages.readpropertyfile;

public class test extends readpropertyfile
{
	@BeforeSuite(groups = "smoke")
	public void setup() throws IOException  
	{
		readpropertyfile.getbrowser();
	}
	//--------------------Travel Insurance----------------------------
	@Test(groups = "smoke", priority = 1)  
	public void clicktravel() throws IOException, InterruptedException   
	{
		travel_insurance.navigatetotravel();
	}
	@Test(groups = "smoke", priority = 2)
	public void clickcountry()     
	{
		travel_insurance.selectcountry();
	}
	@Test(groups = "smoke", priority = 3)
	public void travelinputclick()
	{
		travel_insurance.clicktravelinput();
	}
	@Test(groups = "Regression", priority = 4)
	public void ageselection()
	{
		travel_insurance.selectage();
	}
	@Test(groups = "smoke", priority = 5)
	public void clicknextbutton()
	{
		travel_insurance.clicknext();
	}
	@Test(groups = "smoke", priority = 6)
	public void clickdates()
	{
		travel_insurance.selectdates();
	}
	@Test(groups = "smoke", priority = 7)
	public void clickproceedbutton() throws IOException
	{
		travel_insurance.clickproceed();
	}
	@Test(groups = "smoke", priority = 8)
	public void clicksort() throws InterruptedException
	{
		travel_insurance.clicksortbox();
	}
	@Test(groups = "smoke", priority = 9)
	public void getnamesandrate()
	{
		travel_insurance.getnamesandprice();
	}
	
	//-----------------car insurance----------------------
	@Test(groups ="smoke",priority=10)
	public void openurl() throws IOException
	{
		readpropertyfile.getbrowser();	
	}
	@Test(groups = "smoke", priority = 11)
	public void clickcaricon()
	{
		car_insurance.naviagtetocar();
	}
	@Test(groups = "smoke", priority = 12)
	public void proceedbutton()
	{
		car_insurance.proceedbutton();
	}
	@Test(groups = "smoke", priority = 13)
	public void selectcity()
	{
		car_insurance.clickcity();
	}
	@Test(groups = "smoke", priority = 14)
	public void selectRTO()
	{
		car_insurance.clickRTO();
	}
	@Test(groups = "Regression", priority = 15)
	public void selectbrand()
	{
		car_insurance.selectcarbrand();
	}
	@Test(groups = "smoke", priority = 16)
	public void selectcarmodel()
	{
		car_insurance.selectmodel();
	}
	@Test(groups = "smoke", priority = 17)
	public void clickfuel()
	{
		car_insurance.selectfuel();
	}
	@Test(groups = "smoke", priority = 18)
	public void clickvariant()
	{
		car_insurance.selectvariant();
	}
	@Test(groups = "smoke", priority = 19)
	public void clickyear()
	{
		car_insurance.selectyear();
	}
	@Test(groups = "Regression",priority = 20)
	public void fillform() throws IOException
	{
		car_insurance.fillform_car();
	}
	@Test(groups = "smoke", priority = 21)
	public void fetcherror()
	{
		car_insurance.fetcherror_car();
	}
	
	//------------------health insurance------------------
	@Test(groups ="smoke",priority=22)
	public void openhealthurl() throws IOException
	{
		readpropertyfile.getbrowser();
	}
	@Test(groups = "smoke", priority = 23)
	public void mouseaction() throws IOException
	{
		health_insurance.mouseover();
	}
	@Test(groups = "smoke", priority = 24)
	public void menuitems()
	{
		health_insurance.listmenuitems();
	}  
	@AfterSuite(groups = "smoke")
	public void closebrowser()
	{
		driver.quit();
	}
}

