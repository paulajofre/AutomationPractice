package automtionPractice.pageFactory.tests;

import automtionPractice.pom.pages.HomePage;
import automtionPractice.pom.pages.SignInPage;
import automtionPractice.reports.reports.BaseClass;
import automtionPractice.reports.reports.JyperionListener;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

@Listeners(JyperionListener.class)
public class LogInTests extends BaseClass {
    public WebDriver driver;

    String expectedResult = null;
    String actualResult = null;
    HomePage objHome;
    SignInPage objSignIn;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\"+"chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("http://automationpractice.com/");
        this.driver.manage().window().maximize();
    }

    @AfterTest
    public void TearDown(){
        driver.quit();
    }

    @DataProvider(name = "SearchProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                { "paulajofre91@gmail.com", "Passwordq1!" }
        };
    }

    @Test(priority = 0)
    public void navigateToSignIn(){
        objHome = new HomePage(driver);

        expectedResult = "My Store";
        actualResult = objHome.getHomePageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objHome.clickSignIn();
    }

    @Test(dataProvider = "SearchProvider")
    public void signInUser(String Email, String Password) throws IOException {
        objSignIn = new SignInPage(driver);

        expectedResult = "Login - My Store";
        actualResult = objSignIn.getSignInPageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objSignIn.setTxtEmail(Email);
        objSignIn.setTxtPassword(Password);
        objSignIn.clickSubmit();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\Franco\\Downloads\\Testing\\testScreenShot.jpg"));

    }

    @AfterSuite
    public void sendEmail(){
        sendPDFReportByGMail("paulajofre91@gmail.com", "Khloe1207", "paulajofre91@gmail.com", "PDF Report", "Report Automation Practice");
        System.out.println("The report was sent.");
    }
}
