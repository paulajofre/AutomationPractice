import AutomationPractice.LogIn;
import AutomationPractice.RecoverPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RecoverPasswordTests {
    public WebDriver driver;

    public RecoverPasswordTests() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Franco\\Downloads\\Testing\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }
    @Test
    public void Testing() throws InterruptedException {
        RecoverPassword page = new RecoverPassword(this.driver);
        page.Navigate();
        page.NavigateToSignIn();
        page.ClickRecoverPassword();
        page.EmailField("paulajofre91@gmail.com");
        page.ClickRetrievePassword();
        page.SuccessMessage();
        page.BackToLogIn();
    }
}
