import AutomationPractice.LogIn;
import AutomationPractice.RecoverPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
        Assert.assertTrue(page.GetTitle("Login - My Store"));
        page.ClickRecoverPassword();
        Assert.assertTrue(page.GetTitle("Forgot your password - My Store"));
        page.EmailField("paulajofre91@gmail.com");
        page.ClickRetrievePassword();
        page.SuccessMessage();
        Assert.assertTrue(page.GetText("//*[@id=\"center_column\"]/div/p", "A confirmation email has been sent to your address:"));
        page.BackToLogIn();
        Assert.assertTrue(page.GetTitle("Login - My Store"));
    }
}
