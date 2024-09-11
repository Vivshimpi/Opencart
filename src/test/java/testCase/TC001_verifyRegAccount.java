package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.RegisterPage;
import testBase.TestBaseClass;


public class TC001_verifyRegAccount extends TestBaseClass
{
 
  @Test
  public void verifyRegAccount()
  {
	  logger.info("***** Starting TC001_verifyRegAccount *****");
	  try
	  {
	  HomePage hp = new HomePage(driver);
	  

	  
	  
	  
	  hp.click_myAcc();
	  logger.info("clicked on my acc");

	  hp.click_Register();
	  logger.info("clicked on register");

	  RegisterPage rp = new RegisterPage(driver);
			  
	 

	  rp.setFirstName(randomString().toUpperCase());
	  rp.setLastName(randomString().toUpperCase());
	  rp.setEmail(randomString()+"@gmail.com");
	  rp.setPhone(randomNumber());
	  
	  String pass = randomAlphaNumeric();
	  rp.setPassword(pass);
	  rp.setCPassword(pass);
	  logger.info("set all required data");
	  
	  rp.clickChkPolicy();
	  logger.info("clicked on checkPolicy");
	  
	  rp.clickbtnContinue();
	  logger.info("clicked on continue button");
	 
	  
	  logger.info("verify msg confirmation");
	  String actual = rp.getMsgConfirmation();
	  
	  Assert.assertEquals(actual, "Your Account Has Been Created!", actual);
	  }
	  catch(Exception e)
	  {
		  logger.debug("debug log");
	      logger.error("test failed");
		  Assert.fail();
	  }
	  logger.info("***** Finished TC001_verifyRegAccount *****");
      
  }
  
 
  
  
	
}
