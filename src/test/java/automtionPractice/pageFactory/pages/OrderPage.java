package automtionPractice.pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    WebElement btnProceedToCheckout;

    public OrderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getOrderPageTitle(){
        return driver.getTitle();
    }

    public void setBtnProceedToCheckout(){
        btnProceedToCheckout.click();
    }

    public void ProceedToCheckout(){
        this.setBtnProceedToCheckout();
    }


}
