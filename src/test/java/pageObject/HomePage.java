package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass 
{
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement lnkMyAcc;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement lnkLogin;
	
	public void click_myAcc()
	{
		lnkMyAcc.click();
	}
	
	public void click_Register()
	{
		lnkRegister.click();
	}
	
	public void click_Login()
	{
		lnkLogin.click();
	}

  
}
