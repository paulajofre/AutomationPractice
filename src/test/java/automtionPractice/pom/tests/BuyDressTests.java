package automtionPractice.pom.tests;

import automtionPractice.pom.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class BuyDressTests {
    public WebDriver driver;
    String expectedResult = null;
    String actualResult = null;
    HomePage objHome;
    DressesPage objDresses;
    EveningDressesPage objEvening;
    PrintedDressPage objPrinted;
    OrderPage objOrder;
    SignInPage objSignIn;
    RegisterFormPage objRegister;
    AddressPage objAddress;
    ShippingPage objShipping;
    PaymentPage objPayment;
    OrderConfirmationPage objConfirm;
    SuccessBuyPage objSuccess;


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\"+"chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("http://automationpractice.com");
        this.driver.manage().window().maximize();
    }

//    @AfterTest
//    public void TearDown(){
//        driver.quit();
//    }

    @Test(priority = 0)
    public void goToDresses() throws InterruptedException {
        objHome = new HomePage(driver);

        expectedResult = "My Store";
        actualResult = objHome.getHomePageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objHome.goToDresses();
    }

    @Test(priority = 1)
    public void goToEveningDresses() throws InterruptedException {
        objDresses = new DressesPage(driver);

        expectedResult = "Dresses - My Store";
        actualResult = objDresses.getDressesPageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objDresses.GoToEveningDresses();
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void clickMore() throws InterruptedException {
        objEvening = new EveningDressesPage(driver);

        expectedResult = "Evening Dresses - My Store";
        actualResult = objEvening.getEveningDressesPageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objEvening.clickMoreBtn();
    }

    @Test(priority = 3)
    public void addDressToCart() throws InterruptedException {
        objPrinted = new PrintedDressPage(driver);

        expectedResult = "Printed Dress - My Store";
        actualResult = objPrinted.getPrintedPageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objPrinted.addDressToCart("2");
    }

    @Test(priority = 4)
    public void proceedToCheckout(){
        objOrder = new OrderPage(driver);

        expectedResult = "Order - My Store";
        actualResult = objOrder.getOrderPageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objOrder.ProceedToCheckout();
    }

    @Test (priority = 5)
    public void setAccount() throws InterruptedException {
        objSignIn = new SignInPage(driver);

        expectedResult = "Login - My Store";
        actualResult = objSignIn.getSignInPageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objSignIn.setTxtEmailCreate("paulajofre" + new Random().nextInt() + "@gmail.com");
        objSignIn.clickCreateAccount();
        Thread.sleep(3000);
    }

    @Test (priority = 6)
    public void registerUser() {
        objRegister = new RegisterFormPage(driver);

        expectedResult = "Login - My Store";
        actualResult = objRegister.getContactFormPageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objRegister.completeContactForm("Paula", "Jofre", "Password1!", "2", "4", "1991", "Paula", "Jofre", "606 LAcy Ave", "City", "9", "60600", "21", "1234567890");
    }

    @Test(priority = 7)
    public void proceedOnAddress(){
        objAddress = new AddressPage(driver);

        expectedResult = "Order - My Store";
        actualResult = objAddress.getOrderAddressPageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objAddress.clickProceedOnAddress();
    }

    @Test(priority = 8)
    public void proceedOnShipping(){
        objShipping = new ShippingPage(driver);

        expectedResult = "Order - My Store";
        actualResult = objShipping.getShippingPageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objShipping.ContinueShipping();
    }

    @Test(priority = 9)
    public void selectPaymentMethod(){
        objPayment = new PaymentPage(driver);

        expectedResult = "Order - My Store";
        actualResult = objPayment.getPaymentPageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objPayment.selectPaymentMethod();
    }

    @Test(priority = 10)
    public void confirmOrder(){
        objConfirm = new OrderConfirmationPage(driver);

        expectedResult = "My Store";
        actualResult = objConfirm.gerOrderConfirmationPageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objConfirm.clickConfirm();
    }

    @Test(priority = 11)
    public void OrderConfirmation(){
        objSuccess = new SuccessBuyPage(driver);

        expectedResult = "Order confirmation - My Store";
        actualResult = objSuccess.getSuccessBuyPageTitle();
        Assert.assertEquals(actualResult, expectedResult);

        objSuccess.goBackToOrders();
    }
}
