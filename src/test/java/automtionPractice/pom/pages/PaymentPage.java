package automtionPractice.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    WebDriver driver;

    By btnPayment = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a");

    public PaymentPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPaymentPageTitle(){
        return driver.getTitle();
    }

    public void setBtnPayment(){
        driver.findElement(btnPayment).click();
    }

    public void selectPaymentMethod(){
        this.setBtnPayment();
    }
}
