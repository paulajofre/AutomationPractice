package automtionPractice.pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
    WebElement getBtnProceedToCheckoutAddress;

    public AddressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getOrderAddressPageTitle(){
        return driver.getTitle();
    }

    public void setGetBtnProceedToCheckoutAddress(){
        getBtnProceedToCheckoutAddress.click();
    }

    public void clickProceedOnAddress(){
        this.setGetBtnProceedToCheckoutAddress();
    }

}
