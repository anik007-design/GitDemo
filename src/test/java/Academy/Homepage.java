package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class Homepage extends Base
{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initiate() throws IOException
	{
		driver=initialize();
	}
	
	@Test(dataProvider="getData")
	public void basepage(String Username,String Password,String text) throws IOException
	{
		driver.get(pro.getProperty("url"));
		LandingPage lol = new LandingPage(driver);
		lol.getLogin().click();
		
		LoginPage l = new LoginPage(driver);
		l.getEmail().sendKeys(Username);
		l.getPassword().sendKeys(Password);
		log.info(text);
		l.getSubmit().click();
	}
	@AfterTest
	public void shut()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//row stands for how many different data types test should run
		//column stands for how many values per each test
		Object[][] data = new Object[2][3];
		data[0][0] = "gsddgjg@gmail.com";
		data[0][1] = "12234";
		data[0][2] = "Restricted User";
		
		data[1][0] = "gsrtygjg@gmail.com";
		data[1][1] = "123456";
		data[1][2] = "Non-Restricted User";
		return data;
	}

}
