package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccoutRegistrationPage {

	WebDriver driver;
	
	//constructor
	public AccoutRegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(name="lastname")
	WebElement txtLastName;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="telephone")
	WebElement txtTelephone;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(name="agree")
	WebElement txtchkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConformation;
	
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		
		txtLastName.sendKeys(lname);
		
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephole(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cnfpwd)
	{
		txtConfirmPassword.sendKeys(cnfpwd);
	}
	
	public void setPrivacyPolicy()
	{
		txtchkdPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConformationMsg()
	{
		try
		{
		return(msgConformation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
}
