package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import utilities.excelvalues;

public class travel_insurance extends readpropertyfile
{
	
	public static void navigatetotravel() throws IOException , InterruptedException    //clicking on travelinsurance icon
	{    
		
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,250)","");
		
		
		WebElement icon=driver.findElement(By.xpath("/html/body/cclink/main/div[2]/section/div[13]/a/div[1]"));
		if(icon.isDisplayed())
		{
		    JavascriptExecutor executor = ((JavascriptExecutor)driver);
		    executor.executeScript("arguments[0].click();",icon);
		}
		else
		{
			System.out.println("Travel insurance is not displayed and clicked");
		}
	}
	public static void selectcountry()    //clicking on germany 
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("myText")).click();
		WebElement country=driver.findElement(By.xpath("//*[@id='input-outside-click']/div[1]/div[1]/div/div[2]/div[1]/ul/li[1]/div"));
        if(country.isDisplayed())
        {
			country.click();
        }
        else
        {
        	System.out.println("country not displayed and not selected");
        }
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void clicktravelinput()    //clicking travel inputfield
	{
		
		
		WebElement travelfield=driver.findElement(By.xpath("//*[@id='input-outside-click']/div[1]/div[2]/p/label"));
		if(travelfield.isDisplayed())
		{
		      travelfield.click();
		}
		else
		{
			System.out.println("Travel input field is not clicked");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void selectage()   //selecting age group(22,21)
	{
		//selecting age
		WebElement slider=driver.findElement(By.id("Traveller_0"));
		Actions action= new Actions(driver);
		action.clickAndHold(slider);
        action.moveByOffset(0, 50).build().perform();
        action.perform();
        Select age=new Select(slider);
		age.selectByValue("22");
		
		//clicking on add traveller button
		driver.findElement(By.xpath("//*[@id=\"addTraveller\"]/div[3]/div/div[1]/button")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//selecting age
		WebElement slider2=driver.findElement(By.id("Traveller_1"));
		Actions action2= new Actions(driver);
		action2.clickAndHold(slider2);
        action2.moveByOffset(0, 50).build().perform();
        action2.perform();
        Select age2=new Select(slider2);
		age2.selectByValue("21");
	}
	public static void clicknext()    //clickin on next button
	{
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		  WebElement next=driver.findElement(By.xpath("//*[@id='addTraveller']/div[3]/div/div[2]/div/button"));
		  if(next.isEnabled())
		  {
		      next.click();
		  }
		  else
		  {
			  System.out.println("next button not enabled and clicked");
		  }
	}
	public static void selectdates()  //clicking on 24 and 31st march dates
	{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement calender=driver.findElement(By.xpath("//*[@id='input-outside-click']/div[1]/div[3]/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]"));
		WebElement date1=driver.findElement(By.xpath("//*[@id='input-outside-click']/div[1]/div[3]/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr[4]/td[4]"));
		WebElement date2=driver.findElement(By.xpath("//*[@id='input-outside-click']/div[1]/div[3]/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr[5]/td[4]"));
		if(calender.isDisplayed())
		{
			date1.click();
			date2.click();
		}
		else
		{
			System.out.println("start date is not selected");
			System.out.println("end date is not selected");
		}
	}
	public static void clickproceed() throws IOException
	{
			//reading data from excelvalues
			String d[]=excelvalues.readexceldata();
		try
		{
		//clikcing on proceed button
		driver.findElement(By.xpath("//*[@id='GetQuoteButton']")).click();
		
		//sending values to mobile number
		driver.findElement(By.xpath("//*[@id='txtMobileNo']")).sendKeys(d[0]);
		
		//clicking on view plans button
		driver.findElement(By.id("GetQuoteButton")).click();
		}
		catch(Exception e)
		{
		    //finally clicking on view plans button
		    driver.findElement(By.id("GetQuoteButton")).click();
		}
	}
	
	
	public static void clicksortbox() throws InterruptedException   //clicking on sortby
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		
		driver.findElement(By.xpath("//*[@id='root']/main/div/div[2]/div/div[1]/div[4]/ul/li[5]/div/select")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//selecting low to high sortlist
		WebElement sort=driver.findElement(By.xpath("//*[@id='root']/main/div/div[2]/div/div[1]/div[4]/ul/li[5]/div/select"));
		if(sort.isDisplayed())
		{
		Select sortby=new Select(sort);
		sortby.selectByValue("1");
		driver.findElement(By.xpath("//*[@id='root']/main/div/div[2]/div/div[1]/div[4]/ul/li[5]/div/select")).click();
		}
		else
		{
		    System.out.println("Sortby is not displayed and selected");	
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
		
	public static void getnamesandprice()   //retrieving names and price of insurance company
	{
		System.out.println("**********************Travel Insurance*****************");
		
		//retreiving name and price
	List<WebElement> prices=driver.findElements(By.xpath("//div[@class='col-md-3 cta desktop']"));
	List<WebElement> names=driver.findElements(By.xpath("//div[@class='desktop leftLogo']/div"));
	System.out.println("*********************INSURANCE PROVIDER NAME AND PRICE************************");
		for(int i=0;i<3;i++)
		{
		         String text=names.get(i).getAttribute("class");
                 System.out.println("Insurance company name:"+text.replace("Logo", ""));
                 String rate=prices.get(i).getText();
                 System.out.println("Price:"+rate.replace("Product Details", "").replace("₹",""));
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		
		
		
		//taking screenshot
		TakesScreenshot ts=((TakesScreenshot)driver);
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		try
		{
			String path=System.getProperty("user.dir");
			//System.out.println(path);
			File dstfile=new File(path+"\\travel_screenshot\\travel.png");
			FileHandler.copy(srcfile,dstfile);
			System.out.println("file screenshotted successfully");
			System.out.println("**************************************************");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	 }	
}

