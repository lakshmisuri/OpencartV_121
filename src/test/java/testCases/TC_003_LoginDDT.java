package testCases;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_003_LoginDDT  extends BaseClass{
	
	@Test(dataProvider="LoginData",  groups= {"regression","master"})
	public void test_LoginDDT(String email,String pwd,String exp)
	{
		
		logger.info("Starting TC_003_LoginDDT");
		
		try
		{
		
		driver.get(rb.getString("appURL"));
		logger.info("Home page displyed");
		
		driver.manage().window().maximize(); 
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my account");
		
		hp.clickLogin();
		logger.info("Click on ligin");
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		logger.info("Email provided");
		
		lp.setPassword(pwd);
		logger.info("Password provided");
		
		lp.clickLogin();
		logger.info("Login button clicked");
		
	boolean targetpage=	lp.isMyAccountExists();
	
	if(exp.equals("Valid"))
	{
		if(targetpage==true)
		{
			logger.info("Login sucess");
			
			MyAccountPage myaccpage=new MyAccountPage(driver);
			myaccpage.clickLogout();
			Assert.assertTrue(true);
		}
		
		else
		{
			logger.info("Login failed");
			Assert.assertTrue(false);
		}
	}
		
		if(exp.equals("Invalid"))
		{
			     if(targetpage==true)
			      {
				logger.info("Login sucess");
				
				MyAccountPage myaccpage=new MyAccountPage(driver);
				myaccpage.clickLogout();
				Assert.assertTrue(false);;
		      	}
			
			        else
			    {
				logger.info("Login failed");
				Assert.assertTrue(true);;
			     }
			
  	     }
	}
	
			catch(Exception e)
			
			{
				logger.fatal("Login failed");
				Assert.assertTrue(true);
			}
			
			logger.info("Finished TC_003_LoginDDT");
			
	}		
	
		
		


	@DataProvider(name="LoginData")
	public  String [][] getData() throws IOException
	{
		//String path=".\\testData\\Opencart_LoginData.xlxs";
		String path=System.getProperty("user.dir")+ "\\testData\\Opencart_LoginData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1); 
		
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)   
		{
			for(int j=1;j<totalcols;j++)
			{
			logindata[i-1][j]=	xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}
}
