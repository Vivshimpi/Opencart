package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBaseClass
{
	 public WebDriver driver;
	 public Logger logger;
	 public Properties p;
	 
	 
	 
	  @BeforeClass
	  @Parameters({"os", "browser"})
	  public void setup(String os, String br) throws IOException
	  {
		  p = new Properties();

		  FileReader file = new FileReader("./src//test//resources//config.properties");
		  p.load(file);
		  
		  logger = LogManager.getLogger(this.getClass());
		  
		  switch(br.toLowerCase())
		  {
		  case "chrome" : driver = new ChromeDriver(); break;
		  case "edge" : driver = new EdgeDriver(); break;
		  case "firefox" : driver = new FirefoxDriver(); break;
		  default : System.out.println("Invalid browser");
		  return;
          }
		  
		  
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.get(p.getProperty("AppURL2"));
		  
		  
	  }
	  
	  @AfterClass
	  public void tearDown()
	  {
		  driver.quit();
	  }
	  
	  
	     public String randomString()
	      {
	    	  String generateString = RandomStringUtils.randomAlphabetic(5);
	    	  return generateString;
	      }
	  
	      public String randomNumber()
	      {
	    	  String generateNumber = RandomStringUtils.randomNumeric(10);
	    	  return generateNumber;
	      }
	  
	      public String randomAlphaNumeric()
	      {
	    	  String generateString = RandomStringUtils.randomAlphabetic(3);
	          String generateNumber = RandomStringUtils.randomNumeric(3);
	    	  return (generateString+"@"+generateNumber);
	      }
}