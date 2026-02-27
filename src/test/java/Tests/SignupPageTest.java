package Tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Page.HomePage;
import Page.LoginPage;
import Page.SignupPage;

public class SignupPageTest extends BaseClass {

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://mern-travel-tourism-app.onrender.com");
    }

    
    @Test
    public void TC_01_ValidSignup() {

        HomePage home = new HomePage(driver);
        home.clickLogin();  
        
        // login page open
        LoginPage l=new LoginPage(driver);
        l.clickSignup();       // signup page open

        SignupPage s = new SignupPage(driver);
        s.enterUsername("Anushka");
        s.enterEmail("annu123@gmail.com");
        s.enterPassword("annu@123");
        s.enterAddress("Bhopal");
        s.enterPhone("8638734876");
        s.clickSignup();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
        
    }
    
    @Test
    public void TC_02_InalidSignup() {

        HomePage home = new HomePage(driver);
        home.clickLogin();  
        
        // login page open
        LoginPage l=new LoginPage(driver);
        l.clickSignup();       // signup page open

        SignupPage s = new SignupPage(driver);
        s.enterUsername("Anushka");
        s.enterEmail("");
        s.enterPassword("annu@123");
        s.enterAddress("Bhopal");
        s.enterPhone("8638734876");
        s.clickSignup();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
         Assert.assertTrue(driver.getPageSource().contains("Login"));
    }
    
    
    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

}