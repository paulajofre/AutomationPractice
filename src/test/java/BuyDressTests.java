import AutomationPractice.BuyDress;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class BuyDressTests {
    public WebDriver driver;

    public BuyDressTests() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Franco\\Downloads\\Testing\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }
    @Test
    public void Testing() throws InterruptedException, IOException {
        BuyDress page = new BuyDress(this.driver);
        page.Navigate();
        page.AddDressToCart();
        page.ShoppingCartSummary();
        page.SignIn();
        page.Address();
        page.Shipping();
        page.Payment();
    }
}
