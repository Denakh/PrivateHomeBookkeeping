package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginInPage {

    private WebDriver driver;

    @FindBy(name = "j_login")
    private WebElement loginField;

    @FindBy(name = "j_password")
    private WebElement passwordField;

    @FindBy(css = "input[type='submit']")
    private WebElement submitButton;

    public LoginInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeLoginField(String testUserName) {
        loginField.sendKeys(testUserName);
    }

    public void typePasswordField(String testUserPass) {
        passwordField.sendKeys(testUserPass);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

}
