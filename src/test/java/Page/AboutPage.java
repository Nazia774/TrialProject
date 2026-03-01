package Page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutPage {
     WebDriver driver;
     WebDriverWait wait;
     
     
     public AboutPage(WebDriver driver) {
    	 this.driver=driver;
    	 this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	 PageFactory.initElements(driver,this);
     }
     
     @FindBy (xpath="//a[normalize-space()='Git-Hub']")
     WebElement github;
     
     @FindBy (xpath="//a[normalize-space()='LinkedIn']")
     WebElement linkdin;
     
     public void clickGithub() {
    	 github.click();
    	 
     }
     
     public void clickLinkdin() {
    	 linkdin.click();
     }
	
}
