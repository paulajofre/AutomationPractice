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

    public boolean GetTitle(String ExpectedTitle){
        String ActualTitle = driver.getTitle();
        boolean TextMatch = ActualTitle.equals(ExpectedTitle);
        Assert.assertTrue(TextMatch, "Title is incorrect.");
        System.out.println("Title is: " + ActualTitle);
        return true;
    }

    public boolean GetText(String ExpectedText, String TextXpath){
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
    }

    public void FillInContactForm(String Email, String Subject, String Order, String Path, String Message) throws InterruptedException, IOException {
        Select SubjectHeadline = new Select(driver.findElement(By.id("id_contact")));
        SubjectHeadline.selectByVisibleText(Subject);
        driver.findElement(By.id("email")).sendKeys(Email);
        Select OrderReference = new Select(driver.findElement(By.name("id_order")));
        OrderReference.selectByVisibleText(Order);
        driver.findElement(By.xpath("//*[@id=\"fileUpload\"]")).sendKeys(Path);
        driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys(Message);
        this.Click("//*[@id=\"submitMessage\"]/span");
    }

    public void SuccessMessage(){
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).isDisplayed();
        System.out.println("Success message is displayed");
    }
}
