import AutomationPractice.BuyDress;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.zip.Adler32;

public class BuyDressTests {
    public WebDriver driver;

    public BuyDressTests() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Franco\\Downloads\\Testing\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }
    @Test
    public void Testing() throws InterruptedException, IOException {
        BuyDress page = new BuyDress(this.driver);
        page.Navigate();
        Assert.assertTrue(page.GetTitle("My Store"));
        page.ClickDresses();
        Assert.assertTrue(page.GetTitle("Dresses - My Store"));
        page.SelectEveningDresses();
        Assert.assertTrue(page.GetTitle("Evening Dresses - My Store"));
        page.ClickMore();
        Assert.assertTrue(page.GetTitle("Printed Dress - My Store"));
        Assert.assertTrue(page.GetText("Printed evening dress with straight sleeves", "//*[@id=\"short_description_content\"]/p"));
        page.SelectAmount(3);
        page.SelectSize("M");
        page.SelectColor();
        page.ClickAddToCart();
        Thread.sleep(2000);
        Assert.assertTrue(page.GetText("Product successfully added to your shopping cart", "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"));
        page.ClickProceedToCheckout();
        Assert.assertTrue(page.GetTitle("Order - My Store"));
        Assert.assertTrue(page.GetText("In stock", "//*[@id=\"product_4_44_0_0\"]/td[3]/span"));
        page.ClickToContinue();
        page.SignIn("paulajofre91@gmail.com", "Password1!");
        page.Address();
        page.Shipping();
        Assert.assertTrue(page.GetText("You must agree to the terms of service before continuing.", "//*[@id=\"order\"]/div[2]/div/div/div/div/p"));
        page.AcceptTerms();
        page.Shipping();
        Assert.assertTrue(page.GetTitle("Order - My Store"));
        page.SelectPaymentMethod();
        Assert.assertTrue(page.GetTitle("My Store"));
        Assert.assertTrue(page.GetText("CHECK PAYMENT", "//*[@id=\"center_column\"]/form/div/h3"));
        page.ConfirmOrder();
        Assert.assertTrue(page.GetTitle("Order confirmation - My Store"));
        Assert.assertTrue(page.GetText("Your order on My Store is complete.", "//*[@id=\"center_column\"]/p[1]"));

    }
}
