package Page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PackagePage {
  
	WebDriver driver;
	WebDriverWait wait;
	
	
	public PackagePage(WebDriver driver) {
		this.driver=driver;
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // ✅ initialize wait
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='searchTerm']") WebElement Search;
	@FindBy(xpath="//input[@id='offer']") WebElement Type;
	@FindBy(xpath="//select[@id='sort_order']") WebElement Sort;
	@FindBy(xpath="//button[@class='bg-slate-700 rounded-lg text-white p-3 uppercase hover:opacity-95']")WebElement SearchButton;

     public void clickPakages(String search) {
    	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    	 wait.until(ExpectedConditions.elementToBeClickable(Search));
 	    Search.sendKeys(search);
     }
     
     public void clickType() {
    	 Type.click();
     }
     
     public void selectSortOption(String option) {
    	    wait.until(ExpectedConditions.elementToBeClickable(Sort));
    	    
    	    Select select = new Select(Sort);
    	    select.selectByVisibleText(option);
    	}
     public void clickSearch() {
    	 SearchButton.click();
     }
}



