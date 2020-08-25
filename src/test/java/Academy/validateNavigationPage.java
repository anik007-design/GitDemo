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

	public class validateNavigationPage extends Base
	{		
		public static Logger log = LogManager.getLogger(Base.class.getName());
			@BeforeTest
			public void initiate() throws IOException
			{
				driver=initialize();
				driver.get(pro.getProperty("url"));
				return;
			}
			@Test
			public void basepage() throws IOException
			{
				
				LandingPage lol = new LandingPage(driver);
				Assert.assertTrue(lol.getContact().isDisplayed());
				log.info("Navigation Bar is successfully validated");
			}
			
			@AfterTest
			public void shut()
			{
				driver.close();
			}
	}
