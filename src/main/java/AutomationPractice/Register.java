package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Register {
    private WebDriver driver;
    public Register(WebDriver driver) {
        this.driver = driver;
    }

    public void Navigate() {
        this.driver.get("http://automationpractice.com/");
    }

    public void GetTitle(String ExpectedTitle){
        String ActualTitle = driver.getTitle();
        boolean TextMatch = ActualTitle.equals(ExpectedTitle);
        Assert.assertTrue(TextMatch, "Title is incorrect.");
        System.out.println("Title is: " + ActualTitle);
    }

    public void GetText(String TextXpath, String ExpectedText) {
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

    public void ClickSignIn() throws InterruptedException {
        this.Click("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
    }

    public void CreateAccount(){
        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("testpaula3@testpaula.com");
        this.AssertButtonIsEnabled("//*[@id=\"SubmitCreate\"]");
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
    }

    public void RegisterForm(String FirstName, String LastName, String Password, String Day, String Month, String Year, String Company, String Address, String City, String State, String PostalCode, String Phone) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        this.GetText("//*[@id=\"noSlide\"]/h1", "CREATE AN ACCOUNT");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"uniform-id_gender2\"]")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(FirstName);
        driver.findElement(By.id("customer_lastname")).sendKeys(LastName);
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(2000);
        driver.findElement(By.id("passwd")).sendKeys(Password);
        driver.findElement(By.id("days")).click();
        Select Days = new Select(driver.findElement(By.name("days")));
        Days.selectByValue(String.valueOf(Day));
        Thread.sleep(1000);
        Select Months = new Select(driver.findElement(By.name("months")));
        Months.selectByValue(String.valueOf(Month));
        Thread.sleep(1000);
        Select Years = new Select(driver.findElement(By.name("years")));
        Years.selectByValue(String.valueOf(Year));
        driver.findElement(By.id("company")).sendKeys(Company);
        driver.findElement(By.id("address1")).sendKeys(Address);
        driver.findElement(By.id("city")).sendKeys(City);
        Select States = new Select(driver.findElement(By.name("id_state")));
        States.selectByValue(String.valueOf(State));
        driver.findElement(By.id("postcode")).sendKeys(PostalCode);
        driver.findElement(By.id("phone")).sendKeys(Phone);
        this.Click("//*[@id=\"submitAccount\"]");
        Thread.sleep(3000);
    }
}
