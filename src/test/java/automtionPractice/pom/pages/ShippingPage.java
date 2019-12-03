package automtionPractice.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage {
    WebDriver driver;

    By checkboxAgree = By.id("cgv");
    By btnProceedToCheckoutShipping = By.xpath("//*[@id=\"form\"]/p/button/span");

    public ShippingPage(WebDriver driver){
    this.driver = driver;
    }

    public String getShippingPageTitle(){
        return driver.getTitle();
    }

    public void setCheckboxAgree(){
        driver.findElement(checkboxAgree).click();
    }

    public void setBtnProceedToCheckoutShipping(){
        driver.findElement(btnProceedToCheckoutShipping).click();
    }

    public void ContinueShipping(){
        this.setCheckboxAgree();
        this.setBtnProceedToCheckoutShipping();
    }

}
