package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LandingPage;

public class validateTitle extends Base
{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initiate() throws IOException
	{
		driver=initialize();
		log.info("Driver is initialized");
		driver.get(pro.getProperty("url"));
		log.info("Navigated to Homepage");
		return;
	}
	
		@Test
		public void basepage() throws IOException
		{
			LandingPage lol = new LandingPage(driver);
			Assert.assertEquals(lol.getTitle().getText(), "FEATURED COURSES");
			log.info("successfully validated");
		}
		
		@AfterTest
		public void shut()
		{
			driver.close();
		}
}


