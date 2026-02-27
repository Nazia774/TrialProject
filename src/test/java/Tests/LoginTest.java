package Tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Page.HomePage;
import Page.LoginPage;

public class LoginTest extends BaseClass {
	
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://mern-travel-tourism-app.onrender.com");
    }
		
	
    @Test(priority = 1)
    public void TC_01_validlogin() {
    	HomePage home = new HomePage(driver);
        home.clickLogin(); 
        
        LoginPage l=new LoginPage(driver);
        l.enterEmail("annu123@gmail.com");
        l.enterPassword("annu@123");
        l.clickLoginBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
    
//    Logger log = LogManager.getLogger(LoginTest.class);
//
//    log.info("Login Successful");
    	
    }
    
    
    @Test(priority = 2)
    public void TC_01_invalidgmaillogin() {
    	HomePage home = new HomePage(driver);
        home.clickLogin(); 
        
        LoginPage l=new LoginPage(driver);
        l.enterEmail("annu12398@gmail.com");
        l.enterPassword("a123");
        l.clickLoginBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
    }
    
    
    
    @Test(priority = 3)
    public void TC_01_invalidpasswordlogin() {
    	HomePage home = new HomePage(driver);
        home.clickLogin(); 
        
        LoginPage l=new LoginPage(driver);
        l.enterEmail("annu@gmail.com");
        l.enterPassword("a3");
        l.clickLoginBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
    }
    @AfterMethod
    public void teardown() {
    	driver.quit();
    }
        
}
