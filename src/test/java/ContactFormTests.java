import AutomationPractice.ContactForm;
import AutomationPractice.RecoverPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContactFormTests {
    public WebDriver driver;

    public ContactFormTests() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Franco\\Downloads\\Testing\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }
    @Test
    public void Testing() throws InterruptedException, IOException {
        ContactForm page = new ContactForm(this.driver);
        page.Navigate();
        page.ClickContactUs();
        Thread.sleep(1000);
        page.FillInContactForm();
        Thread.sleep(2000);
        page.SuccessMessage();
    }
}
