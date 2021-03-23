package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class driversetup extends readpropertyfile   {
	
	public static WebDriver getchromedriver()
	{
	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	driver=new ChromeDriver();
	return driver;
	}
	public static WebDriver getfirefox()
	{
		System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
	     driver=new FirefoxDriver();
	 	return driver;
	}
	public static WebDriver getIE()
	{
		System.setProperty("webdriver.ie.driver","./new drivers/IEDriverServer.exe");
		  driver=new InternetExplorerDriver();
		  return driver;
	}

}
