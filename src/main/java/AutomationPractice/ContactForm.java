package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;

public class ContactForm {
    private WebDriver driver;
    public ContactForm(WebDriver driver) {
        this.driver = driver;
    }

    public void Navigate() {
        this.driver.get("http://automationpractice.com/");
    }

    public boolean AssertTitle(String ExpectedTitle){
        String ActualTitle = driver.getTitle();
        boolean TextMatch = ActualTitle.equals(ExpectedTitle);
        Assert.assertTrue(TextMatch, "Title is incorrect.");
        System.out.println("Title is: " + ActualTitle);
        return true;
    }

    public boolean AssertText(String ExpectedText, String TextXpath){
        String ActualText = driver.findElement(By.xpath(TextXpath)).getText();
        boolean TextMatch = ActualText.equals(ExpectedText);
        Assert.assertTrue(TextMatch, "Text is " + ActualText);
        System.out.println("Title is: " + ActualText);
        return true;
    }

    public void AssertButtonIsEnabled(String ButtonXpath){
        boolean ButtonEnabled = driver.findElement(By.xpath(ButtonXpath)).isEnabled();
        Assert.assertTrue(ButtonEnabled, "Button is not enabled");
    }

    public void Click(String ButtonXpath ) throws InterruptedException {
        Thread.sleep(2000);
        this.AssertButtonIsEnabled(ButtonXpath);
        driver.findElement(By.xpath(ButtonXpath)).click();
    }

    public void ClickContactUs() throws InterruptedException {
        this.Click("//*[@id=\"contact-link\"]/a");
        this.AssertTitle("Contact us - My Store");
        System.out.println("System navigated to Contact page");
    }

    public void FillInContactForm() throws InterruptedException, IOException {
        Select SubjectHeadline = new Select(driver.findElement(By.id("id_contact")));
        SubjectHeadline.selectByValue("2");
        driver.findElement(By.id("email")).sendKeys("paulajofre91@gmail.com");
        driver.findElement(By.id("id_order")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"fileUpload\"]")).sendKeys("C:\\Users\\Franco\\Downloads\\badpundog.png");
        driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys("Testing123");
        this.Click("//*[@id=\"submitMessage\"]/span");
    }

    public void SuccessMessage(){
        this.AssertTitle("Contact us - My Store");
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).isDisplayed();
        System.out.println("Success message is displayed");
        this.AssertText("Your message has been successfully sent to our team.", "//*[@id=\"center_column\"]/p");
        System.out.println("The text on the message is correct.");
    }
}
