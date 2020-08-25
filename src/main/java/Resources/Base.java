package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base 
{
	public WebDriver driver;
	public Properties pro ;
	public WebDriver initialize() throws IOException
	{
		pro = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\anike\\eclipse-workspace\\E2EProject\\src\\main\\java\\Resources\\data.properties");
		pro.load(fis);
		String browserName = pro.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\anike\\Downloads\\Softwares\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			//firefox code
		}
		else if(browserName.equals("IE"))
		{
			//IE code
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshotPath(String testCaseName,WebDriver driver) throws IOException 
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\";
		FileUtils.copyFile(source,new File(destinationFile));
	}

}
