package automtionPractice.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    WebDriver driver;

    By btnProceedToCheckout = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public String getOrderPageTitle(){
        return driver.getTitle();
    }

    public void setBtnProceedToCheckout(){
        driver.findElement(btnProceedToCheckout).click();
    }

    public void ProceedToCheckout(){
        this.setBtnProceedToCheckout();
    }


}
