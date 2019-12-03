package automtionPractice.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessBuyPage {
    WebDriver driver;

    By btnGoBackToOrders = By.xpath("//*[@id=\"center_column\"]/p[2]/a");

    public SuccessBuyPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSuccessBuyPageTitle(){
        return driver.getTitle();
    }

    public void setBtnGoBackToOrders(){
        driver.findElement(btnGoBackToOrders).click();
    }

    public void goBackToOrders(){
        this.setBtnGoBackToOrders();
    }
}
