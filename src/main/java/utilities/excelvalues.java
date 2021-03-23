package utilities;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class excelvalues
{
	 
	static WebDriver driver;
	public static String[] data=new String[7];
public static String[] readexceldata() throws IOException
 {
	     try
			{
				FileInputStream fi=new FileInputStream("./excelfile/insurance_excel.xlsx");
				XSSFWorkbook wb=new XSSFWorkbook(fi);
				
				XSSFSheet xs=wb.getSheet("testdata");
				for(int i=0;i<7;i++)
				{
					data[i]=String.valueOf(xs.getRow(0).getCell(i));
					//System.out.println(data[i]);
				}
				
			}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return data;

}
}

