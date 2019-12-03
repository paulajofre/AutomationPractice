package automtionPractice.pageFactory.tests;

import automtionPractice.pom.pages.ContactFormPage;
import automtionPractice.pom.pages.ContactFormSubmittedPage;
import automtionPractice.pom.pages.HomePage;
import automtionPractice.video.videoRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class ContactUsTest{
    public WebDriver driver;
    String expectedResult = null;
    String actualResult = null;
    ContactFormPage objContactForm;
    HomePage objHome;
    ContactFormSubmittedPage objSubmitted;
    videoRecorder vr = new videoRecorder();

    @BeforeTest
    public void setUp () throws IOException, AWTException {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\"+"chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        vr.startRecording(System.getProperty("user.dir") + "\\video\\");
        driver.get("http://automationpractice.com");
    }

    @AfterTest
    public void TearDown() throws IOException {
        driver.quit();
        vr.stopRecording();
    }

    @DataProvider(name="SearchProvider")
    public Object[][] Data(){
        return new Object[][] {
                {"paulajofre91@gmail.com", "Webmaster", "ZHRFSSYER - 10/15/2019", "C:\\Users\\Franco\\Downloads\\badpundog.png", "Testing123"},
        };
    }

    @Test(priority = 0)
    public void navigateToContactForm(){
        objHome = new HomePage(driver);

        expectedResult = "My Store";
        actualResult = objHome.getHomePageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objHome.goToContactUs();
    }

    @Test(dataProvider = "SearchProvider", priority = 1)
    public void sendMessage(String Email, String Subject, String Order, String Path, String Message) {
        objContactForm = new ContactFormPage(driver);

        expectedResult = "Contact us - My Store";
        actualResult = objContactForm.getContactFormPageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        System.out.println("User is on Contact Us Page.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        objContactForm.sendMessage(Email, Subject, Order, Path, Message);
    }

    @Test(priority = 2)
    public void clickHomeBtn(){
        objSubmitted = new ContactFormSubmittedPage(driver);

        expectedResult = "Contact us - My Store";
        actualResult = objSubmitted.getContactFormSubmittedTitle();
        Assert.assertEquals(actualResult, expectedResult);

        System.out.println("Contact form submitted.");

        objSubmitted.goBacktoHomePage();
    }

    @Test(priority = 3)
    public void VerifyUserGoToHomePage() {
        objHome = new HomePage(driver);

        expectedResult = "My Store";
        actualResult = objHome.getHomePageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        System.out.println("User went back to Home Page.");
    }
}
