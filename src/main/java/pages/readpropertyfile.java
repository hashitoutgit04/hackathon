package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;


public class readpropertyfile
{
	static String url;
    protected static WebDriver driver;
	static String browser;
	static Properties prop=new Properties();
	//static String list=prop.getProperty("HealthInsuranceListElements");
	  
	public static  WebDriver getbrowser() throws IOException
	{
		String userDir=System.getProperty("user.dir");
		//System.out.println(userDir+"\\config.properties");
		FileInputStream ip= new FileInputStream(userDir+"\\config.properties");
	    prop.load(ip);
		browser=prop.getProperty("browser");
		 url = prop.getProperty("url");
		 if(browser.equalsIgnoreCase("chrome"))
		  {
			driver=driversetup.getchromedriver();
			driver.manage().window().maximize();
			
			 driver.navigate().to(url);
			 System.out.println("browser opened and navigated to website Successfully");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  }
		  else if(browser.equalsIgnoreCase("firefox"))
		  {
			  driver=driversetup.getfirefox();
			  driver.manage().window().maximize();
			  driver.navigate().to(url);
			   System.out.println("browser opened and navigated to website Successfully");
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   }
		  else if(browser.equalsIgnoreCase("internetexplorer"))
		  {
			  
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  }
		  else
		  {
			  System.out.println("driver not found");
		  }
		return driver;
	}	

		
	public static String getApplicationUrl() 
	{
			 String url = prop.getProperty("url");
			 driver.navigate().to(url);
			 System.out.println("browser opened and navigated to website Successfully");
			return url;
	}
	public static String geterrors()
	{
		String errmsg=prop.getProperty("errors");
		if(errmsg!=null) return errmsg;
		else throw new RuntimeException("error msg xpath is not correct");
	}
		
		
}



