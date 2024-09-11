package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BaseClass
{
  public MyAccountPage(WebDriver driver)
  {
	  super(driver);
  }
  
  @FindBy(xpath="//h2[text()='My Account']")
  WebElement msgHeading;
  
  @FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
  WebElement btnLogout;
  
  public boolean isMyAccPageExist()
  {
	  try
	  {
	  return(msgHeading.isDisplayed());
	  }
	  catch(Exception e)
	  {
		  return false;
	  }
  }
  
  public void click_Logout()
  {
	  btnLogout.click();
  }
  
}
