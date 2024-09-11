package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.TestBaseClass;

public class TC002_verifyLogin extends TestBaseClass
{
	@Test
	public void verifyLogin()
	{
		logger.info("***** Staring TC002_verifyLOgin ******");
		try
		{
		//HomePage
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.click_myAcc();
		logger.info("clicked on Myacc");

		hp.click_Login();
		logger.info("clicked on login");
		
		//LoginPage
		LoginPage lg = new LoginPage(driver);
		
//		lg.setEmail("dadu123@gmail.com");
//		lg.setPassword("Dadu@123");
		
		lg.setEmail(p.getProperty("email"));
		lg.setPassword(p.getProperty("password"));
		lg.click_LoginBtn();
		logger.info("Set credentials and click login btn");
		
		//MyAccountPage
		MyAccountPage map= new MyAccountPage(driver);
		boolean targetpage = map.isMyAccPageExist();
		
		//Assert.assertEquals(targetpage, true, "Login failed");
		Assert.assertTrue(targetpage);
		logger.info("verify MyAccount text");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***** finished TC002_verifyLOgin ******");
	}

}
