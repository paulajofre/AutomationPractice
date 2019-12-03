package automtionPractice.pom.tests;

import automtionPractice.pom.pages.HomePage;
import automtionPractice.pom.pages.RecoverPasswordPage;
import automtionPractice.pom.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import automtionPractice.pom.pages.RecoverPasswordSuccessPage;

public class RecoverPasswordTests {
    WebDriver driver;
    String expectedResult = null;
    String actualResult = null;
    HomePage objHome;
    SignInPage objSignIn;
    RecoverPasswordPage objRecoverPass;
    RecoverPasswordSuccessPage objRecoverSuccess;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Franco\\Downloads\\Testing\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("http://automationpractice.com");
        this.driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void navigateToSignIn(){
        objHome = new HomePage(driver);

        expectedResult = "My Store";
        actualResult = objHome.getHomePageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objHome.goToSignIn();
    }

    @Test(priority = 1)
    public void clickRecoverPassword(){
        objSignIn = new SignInPage(driver);

        expectedResult = "Login - My Store";
        actualResult = objHome.getHomePageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objSignIn.clickRecoverPass();
    }

    @Test(priority = 2)
    public void retrievePassword(){
        objRecoverPass = new RecoverPasswordPage(driver);

        expectedResult = "Forgot your password - My Store";
        actualResult = objHome.getHomePageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objRecoverPass.retrievePassword("paulajofre91@gmail.com");
    }

    @Test(priority = 3)
    public void goBackToLogIn(){
        objRecoverSuccess = new RecoverPasswordSuccessPage(driver);

        expectedResult = "Forgot your password - My Store";
        actualResult = objRecoverSuccess.getRecoverPasswordSuccessTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objRecoverSuccess.goBackToLogIn();
    }

}
