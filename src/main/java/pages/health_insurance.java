package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class health_insurance extends readpropertyfile
{
	public static void mouseover() throws IOException  //mouse over to the insurance products
	{
		System.out.println("***********************Health Insurance*************************");
		try
		{
		    WebElement links=driver.findElement(By.xpath("//li[@class='ruby-menu-mega']/a"));
		    Actions action=new Actions(driver);
	        action.moveToElement(links).click().build().perform();
		    System.out.println("mouse hovered over to insurance products");
		}
		catch(Exception e)
		{
			System.out.println("mouse not hovered over to insurance products");
		}
	}
		
	public static void listmenuitems()      //getting menu items in list
	{
		System.out.println("--------------------------Health Insurance menu items----------------------");
		try
		{
		List<WebElement> companyname=driver.findElements(By.xpath("/html/body/cclink/div[4]/div[1]/div/ul/li[2]/div/div/div[2]/ul/li/a"));
		for(int i=0;i<9;i++)
		{
			System.out.println(companyname.get(i).getAttribute("href"));
		}
		System.out.println("Health insurance items fetched sucessfully");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		 //taking screenshot
  		TakesScreenshot ts=((TakesScreenshot)driver);
  		File srcfile=ts.getScreenshotAs(OutputType.FILE);
  		try
  		{
  			String path=System.getProperty("user.dir");
  			File dstfile=new File(path+"\\health_screenshot\\health.png");
  			FileHandler.copy(srcfile,dstfile);
  			System.out.println("------------------------------------------");
  			System.out.println("file screenshotted successfully");
  			System.out.println("**************************************************");
  		}
  		catch(Exception e)
  		{
  			System.out.println(e);
  		}
	
	}
}


