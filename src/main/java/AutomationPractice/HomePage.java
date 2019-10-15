package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void Navigate() {
        this.driver.get("http://automationpractice.com/");
    }

    public void AssertTitle(String ExpectedTitle){
        String ActualTitle = driver.getTitle();
        boolean TextMatch = ActualTitle.equals(ExpectedTitle);
        Assert.assertTrue(TextMatch, "Title is incorrect.");
        System.out.println("Title is: " + ActualTitle);
    }

    public void AssertText(String TextXpath, String ExpectedText) {
        String ActualText = driver.findElement(By.xpath(TextXpath)).getText();
        boolean TitlesMatch = ActualText.equals(ExpectedText);
        Assert.assertTrue(TitlesMatch, "Titles is not expected");
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

    public void VerifyPageTitle(){
        this.AssertTitle("My Store");
        System.out.println("Title is correct.");
    }

    public void VerifyHorizontalBar() throws InterruptedException {
        this.AssertText("//*[@id=\"header\"]/div[2]/div/div/nav/span", "Call us now: 0123-456-789");
        this.AssertText("//*[@id=\"contact-link\"]/a", "Contact us");
        this.AssertText("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a", "Sign in");
        System.out.println("The text on the horizontal bar is correct.");
        this.Click("//*[@id=\"contact-link\"]/a");
        this.AssertTitle("Contact us - My Store");
        Thread.sleep(2000);
        System.out.println("System navigates to Contact Us section.");
        driver.navigate().back();
        this.AssertTitle("My Store");
        Thread.sleep(2000);
        System.out.println("System navigated to Home Page again.");
        this.Click("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
        this.AssertTitle("Login - My Store");
        Thread.sleep(2000);
        System.out.println("System navigates to Contact Us section.");
        driver.navigate().back();
        this.AssertTitle("My Store");
        System.out.println("System navigated to Home Page again.");
    }

    public void SearchTextField() throws InterruptedException {
       boolean searchFieldEnabled = driver.findElement(By.id("search_query_top")).isEnabled();
       if (searchFieldEnabled){
           driver.findElement(By.id("search_query_top")).sendKeys("Dresses");
           driver.findElement(By.name("submit_search")).click();
       }
       Thread.sleep(2000);
       driver.navigate().back();
       System.out.println("Search text field is working.");
    }

    public void GoToCart() throws InterruptedException {
        this.Click("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a");
        this.AssertTitle("Order - My Store");
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println("User was redirected to shopping cart and back to home page.");
    }

    public void HorizontalMenu() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
        action.moveToElement(we).build().perform();
        Thread.sleep(2000);
        this.Click("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a");
        System.out.println("System navigated to Blouses page");
        Thread.sleep(2000);
        driver.navigate().back();
    }

    public void Banners() throws InterruptedException {
        this.Click("//*[@id=\"homepage-slider\"]/div/div[1]");
        this.AssertTitle("Create and develop your business with PrestaShop");
        System.out.println("System navigated to the expected page");
        driver.navigate().back();
        System.out.println("System navigated back to home page.");
        this.Click("//*[@id=\"htmlcontent_top\"]/ul/li[1]/a/img");
        this.AssertTitle("Create and develop your business with PrestaShop");
        System.out.println("System navigated to the expected page");
        driver.navigate().back();
        System.out.println("System navigated back to home page.");
    }

    public void Toggle() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300)");
        this.Click("//*[@id=\"home-page-tabs\"]/li[2]/a");
    }

    public void AddToCart() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//*[@id=\"blockbestsellers\"]/li[2]/div"));
        action.moveToElement(we).build().perform();
        Thread.sleep(2000);
        this.Click("//*[@id=\"blockbestsellers\"]/li[2]/div/div[2]/div[2]/a[1]");
        driver.switchTo().activeElement();
        Thread.sleep(2000);
                this.AssertText("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2", "Product successfully added to your shopping cart");
                        this.AssertText("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span", "Continue shopping");
                        this.Click("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span");
        this.AssertText("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]", "1");
        WebElement we2 = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
        action.moveToElement(we2).build().perform();
        Thread.sleep(2000);
        this.AssertText("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt/div/div[1]/a", "Faded Shor...");
        System.out.println("The item has been successfully added to your cart.");
    }

}
