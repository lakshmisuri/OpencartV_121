package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import testBase.BaseClass;

public class TC2_002_Login extends BaseClass {
	 
	@Test(groups= {"sanity" , "master"})
		public void  test_Login() throws IOException
	{
		logger.info("Started executing TC_02_Login Test case");
		
		try
		{
		
		//application url  getting from properties file
		driver.get(rb.getString("appURL"));
		logger.info("Home page displyed");
		
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on my account");
		
		hp.clickLogin();
		logger.info("Clicked  on my login");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(rb.getString("email"));
		logger.info("provided email address");
		
		lp.setPassword(rb.getString("password"));
		logger.info("Provided the password");
		
		lp.clickLogin();
		logger.info("Clicked on login button");

		boolean targetpage=lp.isMyAccountExists();
		
		if(targetpage)
		{
			logger.info("Login page sucessfull");
			Assert.assertTrue(true);
		}
		
		else
		{
			logger.info("Login failed");
			captureScreen(driver,"test_Login");//capturing screen shot
			Assert.assertTrue(false);
		}
	}
		catch(Exception e)
		{
			logger.info("Login failed");
			Assert.fail();
		}
		
		logger.info("Finished  TC2_002_Login");
		
	}
}
