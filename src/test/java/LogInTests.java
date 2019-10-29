import AutomationPractice.LogIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTests {
    public WebDriver driver;

    public LogInTests() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Franco\\Downloads\\Testing\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }
    @Test
    public void Testing() throws InterruptedException {
    LogIn page = new LogIn(this.driver);
    page.Navigate();
    page.NavigateToSignIn();
    Assert.assertTrue(page.GetTitle("Login - My Store"));
    page.FillInFields("paulajofre91@gmail.com", "Password1!");
    page.ClickSignIn();
    }
}
