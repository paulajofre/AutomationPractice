import AutomationPractice.ContactForm;
import AutomationPractice.RecoverPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
        Assert.assertTrue(page.GetTitle("Contact us - My Store"));
        page.FillInContactForm("paulajofre91@gmail.com", "Webmaster", "ZHRFSSYER - 10/15/2019", "C:\\Users\\Franco\\Downloads\\badpundog.png", "Testing123");
        Thread.sleep(2000);
        page.SuccessMessage();
        Assert.assertTrue(page.GetText("Your message has been successfully sent to our team.", "//*[@id=\"center_column\"]/p"));
    }
}
