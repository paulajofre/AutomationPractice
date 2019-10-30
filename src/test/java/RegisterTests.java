import AutomationPractice.HomePage;
import AutomationPractice.Register;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTests {
    public WebDriver driver;

    public RegisterTests() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Franco\\Downloads\\Testing\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }
    @Test
    public void Testing() throws InterruptedException {
        Register page = new Register(this.driver);
        page.Navigate();
        page.ClickSignIn();
        Assert.assertTrue(page.GetTitle("Login - My Store"));
        page.CreateAccount();
        Thread.sleep(2000);
        page.RegisterForm("Paula", "Jofre", "Password1", "2", "4", "1991", "Company Name", "606 Lace Ave", "Chicago", "13", "60600", "1111111111");
        Assert.assertTrue(page.GetTitle("My Account - My Store"));
    }


}
