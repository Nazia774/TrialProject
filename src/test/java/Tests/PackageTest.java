package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Page.PackagePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PackageTest  {
	
                 
    PackagePage packagePage; 
    WebDriver driver;


 
	@BeforeClass
	 public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mern-travel-tourism-app.onrender.com/search");
		
		 
		}
	
	   @Test
	    public void verifySearchPackage() {
		   packagePage = new PackagePage(driver);
	        packagePage.clickPakages("Goa");
	        packagePage.clickSearch();
	    }
	   
	   @Test
	    public void verifySelectType() {
		   packagePage = new PackagePage(driver);
	        packagePage.clickType();
	    }
	   
	   
	   @Test
	    public void verifySortOption() {
		   packagePage = new PackagePage(driver);
	        packagePage.selectSortOption("Price: Low to High");
	    }
	   
	   @Test
	    public void verifyCompletePackageFlow() {
		   packagePage = new PackagePage(driver);

	        packagePage.clickPakages("Kerala");
	        packagePage.clickType();
	        packagePage.selectSortOption("Price: High to Low");
	        packagePage.clickSearch();
	    }

	   
	   @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
}
