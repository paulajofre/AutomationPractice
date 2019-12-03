package automtionPractice.pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessBuyPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a")
    WebElement btnGoBackToOrders;

    public SuccessBuyPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSuccessBuyPageTitle(){
        return driver.getTitle();
    }

    public void setBtnGoBackToOrders(){
        btnGoBackToOrders.click();
    }

    public void goBackToOrders(){
        this.setBtnGoBackToOrders();
    }
}
