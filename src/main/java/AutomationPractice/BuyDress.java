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

    public boolean AssertTitle(String ExpectedTitle){
        String ActualTitle = driver.getTitle();
        boolean TextMatch = ActualTitle.equals(ExpectedTitle);
        Assert.assertTrue(TextMatch, "Title is incorrect.");
        System.out.println("Title is: " + ActualTitle);
        return true;
    }

    public boolean AssertText(String ExpectedText, String TextXpath){
        String ActualText = driver.findElement(By.xpath(TextXpath)).getText();
        boolean TextMatch = ActualText.contains(ExpectedText);
        System.out.println("Actual text: "+ ActualText);
        Assert.assertTrue(TextMatch, "Text is  not correct.");
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

    public void AddDressToCart() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        this.Click("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
        this.AssertTitle("Dresses - My Store");
        this.Click("//*[@id=\"categories_block_left\"]/div/ul/li[2]/a");
        this.AssertTitle("Evening Dresses - My Store");
        js.executeScript("window.scrollBy(0, 600)");
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div"));
        action.moveToElement(we).build().perform();
        Thread.sleep(2000);
        this.Click("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]");
        this.AssertText("Printed Dress", "//*[@id=\"center_column\"]/div/div/div[3]/h1");
        this.AssertText("Printed evening dress with straight sleeves ", "//*[@id=\"short_description_content\"]/p");
        driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).sendKeys("3");
        Select Size = new Select(driver.findElement(By.xpath("//*[@id=\"group_1\"]")));
        Size.selectByVisibleText("M");
        this.Click("//*[@id=\"color_24\"]");
        this.Click("//*[@id=\"add_to_cart\"]/button/span");
        driver.switchTo().activeElement();
        Thread.sleep(2000);
        this.AssertText("Product successfully added to your shopping cart", "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2");
        System.out.println("Item added to the cart.");
        this.Click("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
    }

    public void ShoppingCartSummary() throws InterruptedException {
        this.AssertTitle("Order - My Store");
        this.AssertText("In stock", "//*[@id=\"product_4_44_0_0\"]/td[3]/span");
        this.Click("//*[@id=\"center_column\"]/p[2]/a[1]/span");
    }

    public void SignIn() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("paulajofre91@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("Password1!");
        this.Click("//*[@id=\"SubmitLogin\"]/span");
    }

    public void Address() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"ordermsg\"]/textarea")).sendKeys("Test message");
        this.Click("//*[@id=\"center_column\"]/form/p/button/span");
    }

    public void Shipping() throws InterruptedException {
        this.Click("//*[@id=\"form\"]/p/button/span");
        driver.switchTo().activeElement();
        this.AssertText("You must agree to the terms of service before continuing.", "//*[@id=\"order\"]/div[2]/div/div/div/div/p");
        this.Click("//*[@id=\"order\"]/div[2]/div/div/a");
        this.Click("//*[@id=\"cgv\"]");
        this.Click("//*[@id=\"form\"]/p/button/span");
    }

    public void Payment() throws InterruptedException {
        this.Click("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a");
        this.AssertText("CHECK PAYMENT", "//*[@id=\"center_column\"]/form/div/h3");
        this.Click("//*[@id=\"cart_navigation\"]/button/span");
        this.AssertTitle("Order confirmation - My Store");
        this.AssertText("Your order on My Store is complete.", "//*[@id=\"center_column\"]/p[1]");
    }
}
