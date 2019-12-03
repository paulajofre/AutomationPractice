package automtionPractice.pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span")
    WebElement btnConfirm;

    public OrderConfirmationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String gerOrderConfirmationPageTitle(){
        return driver.getTitle();
    }

    public void setBtnConfirm(){
        btnConfirm.click();
    }

    public void clickConfirm(){
        this.setBtnConfirm();
    }
}
