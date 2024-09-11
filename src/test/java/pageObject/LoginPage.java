package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;

	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}

	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}

	public void click_LoginBtn()
	{
		btnLogin.click();
	}




}
