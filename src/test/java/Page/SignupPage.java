package Page;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignupPage {

    WebDriver driver;
    WebDriverWait wait;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id="username")
    WebElement username;

    @FindBy(id="email")
    WebElement email;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="address")
    WebElement address;

    @FindBy(id="phone")
    WebElement phone;

    @FindBy(xpath="//button[contains(text(),'Signup')]")
    WebElement signupBtn;

    // Actions

    public void enterUsername(String user) {
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(user);
    }

    public void enterEmail(String eml) {
        email.sendKeys(eml);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void enterAddress(String addr) {
        address.sendKeys(addr);
    }

    public void enterPhone(String phn) {
        phone.sendKeys(phn);
    }

    public void clickSignup() {
        signupBtn.click();
    }
}