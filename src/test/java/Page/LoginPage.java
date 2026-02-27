package Page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
  WebDriver driver;
  WebDriverWait wait;
  
  public LoginPage(WebDriver driver) {
	  this.driver=driver;
	  this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // ✅ initialize wait
	  PageFactory.initElements( driver,this);
  }
  @FindBy(xpath = "//input[@id='email']") WebElement Email;
	@FindBy(xpath = "//input[@id='password']") WebElement Password;
	@FindBy(xpath = "//button[@class='p-3 text-white bg-slate-700 rounded hover:opacity-95']") WebElement loginBtn;
	@FindBy(xpath = "//a[normalize-space()='Dont have an account? Signup']") WebElement signupBtn;
	
	public void enterEmail(String s) {
		Email.sendKeys(s);
	}

	
	public void enterPassword(String pwd) {
		Password.sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public void clickSignup() {
		signupBtn.click();
	}
}



