package testCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AccoutRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {
	
	

	@Test(groups= {"regression","master"})
	public void test_account_Registration() throws IOException
		{
		logger.info("  Started executing TC_001_AccountRegistration extends BaseClass");
		
		try
		{
			
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
		logger.info("Home page displyed");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on RegistationAccount");
		
		hp.clickRegister();
		logger.info("Clicked on Click Registration link");
	     		
		AccoutRegistrationPage regpage=new AccoutRegistrationPage(driver);
		
		regpage.setFirstName("Lakshmi");
		logger.info("Provided first name");
		
		regpage.setLastName("Suri");
		logger.info("Provided last name");
		
		regpage.setEmail(randomstring()+"@gmail.com");
		logger.info("Provided  email adddress");
		
		regpage.setTelephole("5345363363");	
		logger.info("Provided phone number");
		
		regpage.setPassword("asdfgf");
		logger.info("Provided password");
		
		regpage.setConfirmPassword("asdfgf");
		logger.info("Provided  conform password");
		
		regpage.setPrivacyPolicy();
		logger.info("set privacy policy");
		
		regpage.clickContinue();
		logger.info("clicked on continue");
		
		String confmsg=regpage.getConformationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Account registration sucessfull");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Account registration failed");
			 captureScreen(driver,"test_account_Registration");
			//captureScreen(driver,"test_account_Registration");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e)
		{
			logger.fatal("Account registration failed");
			captureScreen(driver,"test_account_Registration");
			Assert.fail();
		}
		
		logger.info(" Finished TC_001_AccountRegistration extends BaseClass");
		
	}
	

}
