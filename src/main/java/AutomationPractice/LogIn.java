package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LogIn {
    private WebDriver driver;
    public LogIn(WebDriver driver) {
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

    public void AssertButtonIsEnabled(String ButtonXpath){
        boolean ButtonEnabled = driver.findElement(By.xpath(ButtonXpath)).isEnabled();
        Assert.assertTrue(ButtonEnabled, "Button is not enabled");
    }

    public void Click(String ButtonXpath ) throws InterruptedException {
        Thread.sleep(2000);
        this.AssertButtonIsEnabled(ButtonXpath);
        driver.findElement(By.xpath(ButtonXpath)).click();
    }

    public void NavigateToSignIn() throws InterruptedException {
        this.Click("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
        this.AssertTitle("Login - My Store");
        System.out.println("Title is correct");
    }

    public void FillInFields(String Email, String Password){
        driver.findElement(By.id("email")).sendKeys(Email);
        driver.findElement(By.id("passwd")).sendKeys(Password);
    }

    public void ClickSignIn() throws InterruptedException {
        this.Click("//*[@id=\"SubmitLogin\"]");
        boolean LogIn = AssertTitle("My account - My Store");
        if (LogIn){
            System.out.println("Successful login");
        }
        else {
            System.out.println("Incorrect user or password");
        }
    }
}
