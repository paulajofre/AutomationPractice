import AutomationPractice.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTests {
    public WebDriver driver;

    public HomePageTests() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Franco\\Downloads\\Testing\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    public void Testing() throws InterruptedException {
        HomePage page = new HomePage(this.driver);
        page.Navigate();
        Thread.sleep(2000);
        page.VerifyPageTitle();
        page.VerifyHorizontalBar();
        page.SearchTextField();
        page.GoToCart();
        page.HorizontalMenu();
        page.Banners();
        page.Toggle();
        page.AddToCart();
    }

}

