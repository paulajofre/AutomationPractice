package automtionPractice.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
    WebDriver driver;

    By btnConfirm = By.xpath("//*[@id=\"cart_navigation\"]/button/span");

    public OrderConfirmationPage(WebDriver driver){
        this.driver = driver;
    }

    public String gerOrderConfirmationPageTitle(){
        return driver.getTitle();
    }

    public void setBtnConfirm(){
        driver.findElement(btnConfirm).click();
    }

    public void clickConfirm(){
        this.setBtnConfirm();
    }
}
