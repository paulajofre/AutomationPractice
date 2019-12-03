package automtionPractice.pageFactory.tests;

import automtionPractice.driverFactory.BrowserType;
import automtionPractice.driverFactory.DriverFactory;
import automtionPractice.pom.pages.HomePage;
import automtionPractice.pom.pages.RecoverPasswordPage;
import automtionPractice.pom.pages.RecoverPasswordSuccessPage;
import automtionPractice.pom.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RecoverPasswordTests {
    WebDriver driver;
    WebDriverWait waitElement;
    String expectedResult = null;
    String actualResult = null;
    HomePage objHome;
    SignInPage objSignIn;
    RecoverPasswordPage objRecoverPass;
    RecoverPasswordSuccessPage objRecoverSuccess;

    @BeforeTest
    public void setUp() {
        DriverFactory.getInstance().setDriver(BrowserType.CHROME);
        driver = DriverFactory.getInstance().getDriver();
        this.driver.get("http://automationpractice.com");
        waitElement = new WebDriverWait(driver, 15);
    }

    @AfterSuite
    public void tearDown(){
        DriverFactory.getInstance().removeDriver();
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
