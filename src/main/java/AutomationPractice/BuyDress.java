package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BuyDress {
    private WebDriver driver;
    public BuyDress(WebDriver driver) {
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
        boolean TextMatch = ActualText.contains(ExpectedText);
        System.out.println("Actual text: "+ ActualText);
        Assert.assertTrue(TextMatch, "Text is  not correct.");
        System.out.println("The text is: " + ActualText);
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

    public void ClickDresses() throws InterruptedException {
        this.Click("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
    }

    public void SelectEveningDresses() throws InterruptedException {
        this.Click("//*[@id=\"categories_block_left\"]/div/ul/li[2]/a");
    }

    public void ClickMore() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)");
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div"));
        action.moveToElement(we).build().perform();
        Thread.sleep(2000);
        this.Click("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]");
    }

    public void SelectAmount(Integer Amount){
        driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).sendKeys("Amount");
    }

    public void SelectSize(String Size){
        Select size = new Select(driver.findElement(By.xpath("//*[@id=\"group_1\"]")));
        size.selectByVisibleText("Size");
    }

    public void SelectColor() throws InterruptedException {
        this.Click("//*[@id=\"color_24\"]");
    }

    public void ClickAddToCart() throws InterruptedException {
        this.Click("//*[@id=\"add_to_cart\"]/button/span");
        driver.switchTo().activeElement();
    }

    public void ClickProceedToCheckout() throws InterruptedException {
        this.Click("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
    }

    public void ClickToContinue() throws InterruptedException {
            this.Click("//*[@id=\"center_column\"]/p[2]/a[1]/span");
    }

    public void SignIn(String Email, String Password) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(Email);
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(Password);
        this.Click("//*[@id=\"SubmitLogin\"]/span");
    }

    public void Address() throws InterruptedException {
        this.Click("//*[@id=\"center_column\"]/form/p/button/span");
    }

    public void Shipping() throws InterruptedException {
        this.Click("//*[@id=\"form\"]/p/button/span");
        driver.switchTo().activeElement();
    }

    public void AcceptTerms() throws InterruptedException {
        this.Click("//*[@id=\"order\"]/div[2]/div/div/a");
        this.Click("//*[@id=\"cgv\"]");
    }

    public void SelectPaymentMethod() throws InterruptedException {
        this.Click("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a");
    }

    public void ConfirmOrder() throws InterruptedException {
        this.Click("//*[@id=\"cart_navigation\"]/button/span");
    }

}
