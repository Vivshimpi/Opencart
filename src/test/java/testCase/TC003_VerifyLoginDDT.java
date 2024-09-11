package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.TestBaseClass;
import utilities.DataProviders;

public class TC003_VerifyLoginDDT extends TestBaseClass
{
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verifyLoginDDT(String email, String pwd, String exp)
	{
	logger.info("***** Staring TC003_verifyLoginDDT ******");
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

	
	lg.setEmail(email);
	lg.setPassword(pwd);
	lg.click_LoginBtn();
	logger.info("Set credentials and click login btn");
	
	
	
	
	//MyAccountPage
	MyAccountPage map= new MyAccountPage(driver);
	boolean targetpage = map.isMyAccPageExist();
	
	/*
	 * Data is valid = login success = test pass = logout 
	 *                 login failed = test failed 
	 * 
	 * Data is invalid = login success = test failed = logout 
	 *                   login failed = test pass 
	 * */
	logger.info("verify MyAccount text");

	if(exp.equalsIgnoreCase("Valid"))
	{
		if(targetpage==true)
		{
			map.click_Logout();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);

		}
	}	
	
	
	if(exp.equalsIgnoreCase("Invalid"))
	{
		if(targetpage==true)
		{
			map.click_Logout();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);

		}
		
	}	

	}
	catch(Exception e)
	{
		Assert.fail();
	}
	
	logger.info("***** finished TC003_verifyLoginDDT ******");
}
}
