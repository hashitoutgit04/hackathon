package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import utilities.excelvalues;

public class car_insurance extends readpropertyfile
{
		
	public static void naviagtetocar()    //clicking on car insurance icon
	{
		System.out.println("*********************Car Insurance***********************");
		WebElement icon=driver.findElement(By.xpath("/html/body/cclink/main/div[2]/section/div[4]/a/div[1]"));
	
		if(icon.isDisplayed())
		{
			icon.click();
		}
		else
		{
		     System.out.println("Car insurance icon is not displayed and not clicked");	
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	public static void proceedbutton()  	//clicking on proceed without a car number
	{ 	
	
		WebElement proceed=driver.findElement(By.xpath("//*[@id='before-tp']/div[2]/a"));
		if(proceed.isEnabled())
		{
		     proceed.click();
		}
		else
		{
		   	System.out.println("proceed without car number is not enable and not clicked");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void clickcity()   //clicking on bangalore location
	{
		
		WebElement city=driver.findElement(By.id("spn3"));
		if(city.isDisplayed())
		{
		    city.click();
		}
		else
		{
		    System.out.println("city is not selected");	
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void clickRTO()   //clickin on kA02
	{
		
		WebElement rto=driver.findElement(By.xpath("//*[@id='section2']/ul/li[2]"));
		if(rto.isDisplayed())
		{
		    rto.click();
		}
		else
		{
		   System.out.println("rto number is not displayed and not clicked");	
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void selectcarbrand()   //clicking on volkswagen
	{
		
		WebElement car=driver.findElement(By.xpath("//*[@id='dvMake']/div/ul/div/li[12]/span"));
		if(car.isDisplayed())
		{
		    car.click();
		}
		else
		{ 
			System.out.println("car brand is not displayed and not selected");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void selectmodel()  //clicking on POLO GT
	{
		WebElement model=driver.findElement(By.xpath("//*[@id='modelScroll']/li[6]/span"));
		if(model.isDisplayed())
		{
		   model.click();
		}
		else
		{ 
			System.out.println("model is not displayed and not clicked");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void selectfuel()     //clicking on diesel
	{
		
		WebElement fuel=driver.findElement(By.xpath("//*[@id='Diesel']"));
		if(fuel.isDisplayed())
		{
		      fuel.click();
		}
		else
		{
			System.out.println("fuel is not displayed and not selected");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void selectvariant()    //clicking on 1.5 TDI
	{
		
		 WebElement variant=driver.findElement(By.xpath("//*[@id='variantScroll']/li[1]/span/b"));
		 if(variant.isDisplayed())
		 {
		       variant.click();
		 }
		 else
		 {
			 System.out.println("variant is not selected and not selected");
		 }
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void selectyear()    //clicking on 2018 year
	{
		
		WebElement year=driver.findElement(By.xpath("//*[@id='dvRegYear']/ul/div/li[4]/span"));
		if(year.isDisplayed())
		{
		      year.click();
		}
		else
		{
			System.out.println("year is not displayed and not selected");
		}
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void fillform_car() throws IOException  //filling form with invalid data
	{
		String c[]=excelvalues.readexceldata();
		//entering name in name textfield
		try
		{
		driver.findElement(By.id("name")).sendKeys(c[1]);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		//entering email
		 driver.findElement(By.id("email")).sendKeys(c[2]);
		//entering phone nnumber
	     driver.findElement(By.id("mobileNo")).sendKeys(c[3]);
	     
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     
	     //clicking on view prices button
	     driver.findElement(By.id("btnLeadDetails")).click();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		
	}
	public static void fetcherror_car()   //fetching errors
	{
	    try
	    {
		List<WebElement> errmsg=driver.findElements(By.xpath(readpropertyfile.geterrors()));
		int size=errmsg.size();
		for(int i=0;i<size;i++)
		{
			System.out.println(errmsg.get(i).getText());
		}
		System.out.println("*********************Erros fetched successfully!!*********************");
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Erros not fetched");
	    }
	    
	  //taking screenshot
	  		TakesScreenshot ts=((TakesScreenshot)driver);
	  		File srcfile=ts.getScreenshotAs(OutputType.FILE);
	  		try
	  		{
	  			String path=System.getProperty("user.dir");
	  			File dstfile=new File(path+"\\car_screenshot\\car.png");
	  			FileHandler.copy(srcfile,dstfile);
	  			System.out.println("file screenshotted successfully");
	  			System.out.println("----------------------------------------------------------------");
	  		}
	  		catch(Exception e)
	  		{
	  			System.out.println(e);
	  		}
		
	}
}

