package Tests;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Page.AboutPage;
import Page.HomePage;

public class AboutSectionTest extends BaseClass{
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://mern-travel-tourism-app.onrender.com");
    }
	
	
	
  @Test
  public void TC_01_openGithub() {
	  HomePage home = new HomePage(driver);
      home.clickAbout();
      
      AboutPage a=new AboutPage(driver);
      a.clickGithub();
  }
  
  @Test
  public void TC_02_openLinkdin() {
	  HomePage home = new HomePage(driver);
      home.clickAbout();
      
      AboutPage a=new AboutPage(driver);
      a.clickLinkdin();
  }
  
  @AfterMethod
  public void teardown() {
  	driver.quit();
  }
    
}
