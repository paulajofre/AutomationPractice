package automtionPractice.pageFactory.tests;

import automtionPractice.pom.pages.HomePage;
import automtionPractice.pom.pages.RegisterFormPage;
import automtionPractice.pom.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RegisterUserTest {

    public WebDriver driver;
    String baseURL = "http://automationpractice.com";

    String expectedResult = null;
    String actualResult = null;
    HomePage objHome;
    SignInPage objSignIn;
    RegisterFormPage objRegister;

    private void setProperties(String prop, String driverName){
        System.setProperty("webdriver." + prop + ".driver", System.getProperty("user.dir")+"\\driver\\"+driverName+".exe");
    }

    @BeforeTest
    @Parameters("browser")
    public void launchBrowser (String browser) throws Exception {
        switch (browser.toLowerCase()){
            case "chrome":
                 setProperties("chrome", "chromedriver");
                 driver = new ChromeDriver();
                 break;
            case "firefox":
                setProperties("gecko", "geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                throw new Exception("Incorrect browser");

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @AfterTest
    public void TearDown(){
        driver.quit();
    }

    @Test(priority = 0)
    public void goToSignIn() throws InterruptedException {
        objHome = new HomePage(driver);

        expectedResult = "My Store";
        actualResult = objHome.getHomePageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objHome.goToSignIn();
        Thread.sleep(3000);
    }

    @Test (priority = 1)
    public void setAccount() throws InterruptedException {
        objSignIn = new SignInPage(driver);

        expectedResult = "Login - My Store";
        actualResult = objSignIn.getSignInPageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objSignIn.setTxtEmailCreate("paulajofre" + new Random().nextInt() + "@gmail.com");
        objSignIn.clickCreateAccount();
        Thread.sleep(3000);
    }

    @Test (priority = 2)
    public void registerUser() {
        objRegister = new RegisterFormPage(driver);

        expectedResult = "Login - My Store";
        actualResult = objRegister.getContactFormPageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objRegister.completeContactForm("Paula", "Jofre", "Password1!", "2", "4", "1991", "Paula", "Jofre", "606 LAcy Ave", "City", "9", "60600", "21", "1234567890");
    }
}