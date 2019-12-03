package automtionPractice.pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
    WebElement btnPayment;

    public PaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPaymentPageTitle(){
        return driver.getTitle();
    }

    public void setBtnPayment(){
        btnPayment.click();
    }

    public void selectPaymentMethod(){
        this.setBtnPayment();
    }
}
