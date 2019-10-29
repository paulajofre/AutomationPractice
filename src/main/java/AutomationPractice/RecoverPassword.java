package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RecoverPassword {
    private WebDriver driver;
    public RecoverPassword(WebDriver driver) {
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

    public boolean GetText(String Xpath, String ExpectedText){
        String ActualText = driver.findElement(By.xpath(Xpath)).getText();
        boolean TextMatch = ActualText.contains(ExpectedText);
        Assert.assertTrue(TextMatch, "Title is incorrect.");
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

    public void NavigateToSignIn() throws InterruptedException {
        this.Click("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
    }

    public void ClickRetrievePassword() throws InterruptedException {
        this.Click("//*[@id=\"form_forgotpassword\"]/fieldset/p/button/span");
    }

    public void ClickRecoverPassword() throws InterruptedException {
        this.Click("//*[@id=\"login_form\"]/div/p[1]/a");
    }

    public void EmailField(String Email){
        driver.findElement(By.id("email")).sendKeys(Email);
    }

    public void SuccessMessage() {
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p")).isDisplayed();
        System.out.println("The successfully sent message is displayed");
    }

    public void BackToLogIn() throws InterruptedException {
        this.Click("//*[@id=\"center_column\"]/ul/li/a/span");
    }
}
