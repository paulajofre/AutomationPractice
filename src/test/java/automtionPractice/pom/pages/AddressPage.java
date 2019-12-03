package automtionPractice.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage {
    WebDriver driver;

    By getBtnProceedToCheckoutAddress = By.xpath("//*[@id=\"center_column\"]/form/p/button/span");

    public AddressPage(WebDriver driver){
        this.driver = driver;
    }

    public String getOrderAddressPageTitle(){
        return driver.getTitle();
    }

    public void setGetBtnProceedToCheckoutAddress(){
        driver.findElement(getBtnProceedToCheckoutAddress).click();
    }

    public void clickProceedOnAddress(){
        this.setGetBtnProceedToCheckoutAddress();
    }

}
