import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginInTests {

    private static final String testUserName = "user";
    private static final String testUserPass = "password";
    private static WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/login");
    }

    @Test
    public void verifyLoginInError() {
        String expectedErrorMessagePart = "Wrong login or password";
        String actualErrorMessage;
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        WebElement errorMessageP = driver.findElement(By.xpath("//form/p"));
        actualErrorMessage = errorMessageP.getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessagePart));
    }

    @Test
    public void verifyLoginInCorrect() {
        String expectedCorrectMessagePart = "Your login is: user";
        String actualCorrectMessage;
        driver.findElement(By.name("j_login")).sendKeys(testUserName);
        driver.findElement(By.name("j_password")).sendKeys(testUserPass);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        WebElement mainCustomPage = driver.findElement(By.cssSelector("div[class='head']"));
        actualCorrectMessage = mainCustomPage.getText();
        Assert.assertTrue(actualCorrectMessage.contains(expectedCorrectMessagePart));
    }

    @After
    public void finish() {
        driver.close();
    }

}
